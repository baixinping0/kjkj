package com.bxp.kjkj.auth.action;

import com.bxp.kjkj.auth.entity.DepModel;
import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.auth.entity.EmpQueryModel;
import com.bxp.kjkj.auth.service.ResEbi;
import com.bxp.kjkj.auth.entity.ResModel;
import com.bxp.kjkj.auth.service.RoleEbi;
import com.bxp.kjkj.auth.entity.RoleModel;
import com.bxp.kjkj.auth.service.DepEbi;
import com.bxp.kjkj.auth.service.EmpEbi;
import com.bxp.kjkj.util.exception.AppException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EmpAction extends ActionSupport {
	public Integer pageNum = 1;
	public Integer pageCount = 1;
	// 最大页码值
	public Integer maxPageNum;
	// 数据总量
	public Integer dataTotal;
	public EmpModel emp = new EmpModel();
	public EmpQueryModel empq = new EmpQueryModel();
	public String newPwd;
	
	public Long[] roleUuids;

	private EmpEbi empEbi;
	private DepEbi depEbi;
	private RoleEbi roleEbi;
	private ResEbi resEbi;
	
	public void setResEbi(ResEbi resEbi) {
		this.resEbi = resEbi;
	}


	public void setRoleEbi(RoleEbi roleEbi) {
		this.roleEbi = roleEbi;
	}


	public void setDepEbi(DepEbi depEbi) {
		this.depEbi = depEbi;
	}
	
	public void setEmpEbi(EmpEbi empEbi) {
		this.empEbi = empEbi;
	}

	/*
	 * 在此方法中通过判断emp是否有uuid来判断进行保存操作还是进行更新操作。
	 */
	public String save() {
		
		if (emp.getUuid() == null)
			empEbi.save(emp, roleUuids);
		else
			empEbi.update(emp, roleUuids);
		return "doList";
	}
	
	public String delete(){
		empEbi.delete(emp);
		return "doList";
	}

	public String input() {
		//获取所有角色的列表
		List<RoleModel> roleList = roleEbi.getAll();
		ActionContext.getContext().put("roleList", roleList);
		// 获取所有的部门列表
		List<DepModel> depList = depEbi.getAll();
		ActionContext.getContext().put("depList", depList);
		/*
		 * 先进性判断是否有uuid，如果有，则是修改数据的操作。则查询数据并回显。 如果没有，则是录入操作。
		 */
		if (emp.getUuid() != null){
			emp = empEbi.get(emp.getUuid());
			
			roleUuids = new Long[emp.getRoles().size()];
			int i = 0;
			for(RoleModel role : emp.getRoles()){
				roleUuids[i] = role.getUuid();
				i ++;
			}
		}
		System.out.println("姓名" + emp.getName());
		return "input";
	}

	// 获取用户列表
	public String list() {

		// 获取条目总数
		dataTotal = empEbi.getCount(empq);
		// 通过总条目计算最大页码值
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;

		// 获取所有的部门列表
		List<DepModel> depList = depEbi.getAll();
		ActionContext.getContext().put("depList", depList);
		
		System.out.println("empq值" + empq);
		// 获取用户列表
		List<EmpModel> empList = empEbi.getAll(empq, pageNum, pageCount);
//		List<EmpModel> empList = empEbi.getAll();
		ActionContext.getContext().put("empList", empList);
		return "list";
	}

	// 登录的方法
	public String login() {
		//获取登录IP
		HttpServletRequest request = ServletActionContext.getRequest();
		String loginIp = request.getHeader("x-forwarded-for"); 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getHeader("Proxy-Client-IP"); 
		} 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getRemoteAddr(); 
		}
		/*
		 * 页面收集用户名，密码信息。 将数据传递到业务层 业务层转调数据层 数据层进行查询将结果返回
		 */
		EmpModel loginEmp = empEbi.login(emp.getUserName(), emp.getPwd(), loginIp);
		// 判断查询结果，如果查询到，登录成功，否则登录失败
		if (loginEmp == null) {
			// 登录失败
			// 添加错误信息
			this.addActionError("对不起，用户名或密码错误");
			return "loginFile";
		} else {
			// 登录成功
			
			//获取当前用户的可操作资源
			
			List<ResModel> resList = resEbi.getAllByEmp(loginEmp.getUuid());
			loginEmp.setResList(resList);
			ActionContext.getContext().getSession()
					.put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, loginEmp);
			return "loginSuccess";
		}
	}
	public String logout(){
		//1、将session中的数据remove
		//2、将session中的数据置为null(常用)
		ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, null);
		return "logout";
	}
	public String toChangePwd(){
		return "toChangePwd";
	}
	
	public String changePwd(){
		//获取当前用户
		EmpModel currentEmp = (EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
		boolean succeed = empEbi.changePed(currentEmp.getUserName(), emp.getPwd(), newPwd);
		if(succeed){
			//修改密码成功
			return logout();
		}else{
			//修改密码失败
//			this.addActionError("对不起，原始密码错误");
//			return toChangePwd();
			throw new AppException("INFO_EMP_USERNAME_EMPTY");
		}
	}
	

}

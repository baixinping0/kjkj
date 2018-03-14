package com.bxp.kjkj.util.interceptor;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.auth.entity.ResModel;
import com.bxp.kjkj.util.exception.AppException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor{

	/*
	 * 如果导入了struts-spring-plugin.jar包，则由struts创建
	 * 的对象会自动对其中的属性进行装配。而装配是根据set的名称来进行装配。
	 * 所以resEbi对象会被自动装配。
	 */
//	private ResEbi resEbi;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取当前的操作
		String actionName = invocation.getProxy().getAction().getClass().getName();
		String methodName = invocation.getProxy().getMethod();
		String allName = actionName + "." + methodName;
		
		//获取所有的资源
		List<ResModel> resList = (List<ResModel>) ServletActionContext.getServletContext().getAttribute("resList");
		for(ResModel res : resList){
			if(allName.equals(res.getUrl())){
				//获取当前用户
				EmpModel emp = (EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
				//判断用户是否登录
				if(emp == null){
					//1如果没有登录，则拦截操作。
					return "noLogin";
				}
				//3、获取当前登录人具有的操作资源
				List<ResModel> cresList = emp.getResList();
				for(ResModel cres : cresList){
//					如果具有操作资源的权限则放行。
					if(allName.equals(cres.getUrl()))
						return invocation.invoke();
				}
				throw new AppException("对不起，您没有操作该资源的权限");
			}
		}
		return invocation.invoke();
	}
//	public void setResEbi(ResEbi resEbi) {
//		this.resEbi = resEbi;
//	}
//	

}

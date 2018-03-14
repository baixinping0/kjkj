package com.bxp.kjkj.auth.action;

import java.util.List;

import com.bxp.kjkj.auth.service.DepEbi;
import com.bxp.kjkj.auth.entity.DepModel;
import com.bxp.kjkj.auth.entity.DepQueryModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DepAction extends ActionSupport{
	public DepModel dep = new DepModel();
	public DepQueryModel depq = new DepQueryModel();
	private DepEbi depEbi;
	
	//当前是第几页，默认从第一页开始，之后从页面获取
	public Integer pageNum = 1;
	//每页显示多少条数据
	public Integer pageCount = 2;
	//最大页码值
	public Integer maxPageNum;
	//数据总量
	public Integer dataTotal;

	public void setDepEbi(DepEbi depEbi) {
		this.depEbi = depEbi;
	}
	
	//跳转到部门列表页面
	public String list(){
		//获取条目总数
		dataTotal = depEbi.getCount(depq);
		//通过总条目计算最大页码值
		maxPageNum = (dataTotal + pageCount - 1)/pageCount;
		
		//从数据库中获取部门的数据，将数据存储在指定的域中，从域中取出数据，显示
		List<DepModel> depList = depEbi.getAll(depq, pageNum, pageCount);
		ActionContext.getContext().put("depList", depList);
		return "list"; 
	}
	
	
	//跳转到添加部门，或者部门修改页面
	public String input(){
		/*
		 * 先进行判断dep中是否有uuid
		 * 如果有uuid，则是进行修改部门信息，则进行查询操作，然后跳转到input页面，此时会数据回显。
		 * 
		 * 如果没有uuid，则是增加部门信息。则直接跳转到input页面。
		 */
		if(dep.getUuid() != null){
			dep = depEbi.findByUuid(dep.getUuid());
		}
		return "input";
	}
	
	//添加部门
	public String save(){
		/*
		 * 在此方法中通过是否有uuid进行判断是执行添加功能还是执行保存功能
		 */
		if(dep.getUuid() == null)
			depEbi.save(dep);
		else
			depEbi.update(dep);
		return "doList";
	}
	
	//删除部门
	public String delete(){
		depEbi.delete(dep);
		return "doList";
	}
	
}































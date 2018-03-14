package com.bxp.kjkj.util.interceptor;

import com.bxp.kjkj.auth.entity.EmpModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation invocation) throws Exception {
		/*
		 *执行任意操作之前，做登录校验(除了登录操作)
		 */
		
		//获取当前操作的信息
		//获取action名称
		String actionName = invocation.getProxy().getAction().getClass().getName();
		//获取调用的方法名称
		String method = invocation.getProxy().getMethod();
		String allName = actionName + "." + method;
		
		//如果是跳转登录界面则放行
		String operName = invocation.getProxy().getActionName();		//page_login
		if("page_login".equals(operName)){
			return invocation.invoke();
		}
		//如果是登录操作，放行
		if("com.bxp.kjkj.auth.action.EmpAction.login".equals(allName)){
			return invocation.invoke();
		}
		//获取当前登录人信息
		EmpModel loginEmp = (EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
		
		if(loginEmp == null){
			//如果没有登录，跳转到登录界面
			return "noLogin";
		}
		return invocation.invoke();
	}
}

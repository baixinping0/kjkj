package com.bxp.kjkj.util.interceptor;

import com.bxp.kjkj.util.exception.AppException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExceptionInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		try{
			invocation.invoke();
		}catch(AppException ex){
			//将错误信息存入日志
			//发送错误信息到邮箱
			//警报
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			ex.printStackTrace();
			//将异常信息添加
			actionSupport.addActionError(actionSupport.getText(ex.getMessage()));
//			actionSupport.addActionError(ex.getMessage());
		}catch(Exception ex){
			//将错误信息存入日志
			//发送错误信息到邮箱
			//警报
			ex.printStackTrace();
		}
		//跳到错误信息显示页面对错误信息进行显示
		return "error";
	}
}

package com.bxp.kjkj.util.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bxp.kjkj.auth.entity.ResModel;
import com.bxp.kjkj.auth.service.ResEbi;
import com.bxp.kjkj.auth.service.impl.ResEbo;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class AllResLoadListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(context);
		ResEbi resEbi = (ResEbi) wac.getBean("resEbi");
//		ResEbi resEbi = new ResEbo();
		List<ResModel> resList = resEbi.getAll();
		context.setAttribute("resList", resList);
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
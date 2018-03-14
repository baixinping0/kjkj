package com.bxp.kjkj.auth.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import org.apache.struts2.ServletActionContext;

import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.auth.service.MenuEbi;
import com.bxp.kjkj.auth.entity.MenuModel;
import com.bxp.kjkj.auth.entity.MenuQueryModel;
import com.bxp.kjkj.auth.service.RoleEbi;
import com.bxp.kjkj.auth.entity.RoleModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletResponse;

public class MenuAction extends ActionSupport {
	private MenuEbi menuEbi;
	private RoleEbi roleEbi;

	public Long[] roleUuids;

	public Integer pageNum = 1;
	public Integer pageCount = 1;
	// 最大页码值
	public Integer maxPageNum;
	// 数据总量
	public Integer dataTotal;

	public String list() {

		// 获取条目总数
		dataTotal = menuEbi.getCount();
		// 通过总条目计算最大页码值
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;

		// 获取所有的一级菜单
		List<MenuModel> oneLevelMenuList = menuEbi.getALlOneLevel();
		ActionContext.getContext().put("oneLevelMenuList", oneLevelMenuList);
		// 获取所有的菜单
		List<MenuModel> menuList = menuEbi.getALl(menuq,pageNum, pageCount);
		ActionContext.getContext().put("menuList", menuList);
		return "list";
	}

	public void setRoleEbi(RoleEbi roleEbi) {
		this.roleEbi = roleEbi;
	}

	public MenuModel menu = new MenuModel();
	public MenuQueryModel menuq = new MenuQueryModel();

	public void setMenuEbi(MenuEbi menuEbi) {
		this.menuEbi = menuEbi;
	}

	public void showMenu() throws IOException {
		/*
		 * text:文本 hasChildren:是否有孩子 expanded：是否展开 classes:样式 id
		 */
		StringBuilder json = new StringBuilder();
		json.append("[");

		// 获取所有的当前用户可操作的一级菜单加载
		// 获取当前用户
		EmpModel loginEmp = (EmpModel) ActionContext.getContext().getSession()
				.get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);

		/*
		 * 第一次进入时候，调用showMenu()方法，传入的root参数的值是“source”，此时应当获取一级菜单并返回显示
		 * 
		 * 当点击一级菜单的时候，调用showMenu()方法，传入的root参数的值是点击的一级菜单的id值
		 * 此时通过一级菜单的id获取对应的二级菜单并返回显示
		 */

		String root = ServletActionContext.getRequest().getParameter("root");
		if ("source".equals(root)) {
			// 一级菜单
			List<MenuModel> menus = menuEbi.getAllOneLevelByEmp(loginEmp
					.getUuid());
			for (MenuModel menu : menus) {
				json.append("{\"text\" : \"");
				json.append(menu.getName());
				json.append("\", \"id\" : \"");
				json.append(menu.getUuid());
				json.append("\", \"hasChildren\" : \"true\",  \"classes\" : \"folder\"},");
			}
		} else {
			// 二级菜单项
			List<MenuModel> menus = menuEbi.getAllTwoLevelByEmpAndOneLevel(
					loginEmp.getUuid(), new Long(root));
			for (MenuModel menu : menus) {
				json.append("{\"text\" : \"");
				json.append("<a class='hei' target='main' href=");
				json.append(menu.getUrl());
				json.append(">&nbsp;&nbsp;&nbsp;&nbsp;");
				json.append(menu.getName());
				json.append("</a>");
				json.append("\",  \"classes\" : \"file\"},");
			}
		}

		json.deleteCharAt(json.length() - 1);
		json.append("]");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");

		PrintWriter writer = response.getWriter();

		writer.write(json.toString());
		writer.flush();
	}

	public String input() {
		if (menu.getUuid() != null) {
			menu = menuEbi.get(menu.getUuid());

			roleUuids = new Long[menu.getRoles().size()];
			int j = 0;
			for (RoleModel role : menu.getRoles()) {
				roleUuids[j] = role.getUuid();
				j++;
			}
		}
		// 获取所有的一级菜单
		List<MenuModel> oneLevelMenuList = menuEbi.getALlOneLevel();
		ActionContext.getContext().put("oneLevelMenuList", oneLevelMenuList);

		// 获取所有的角色
		List<RoleModel> roleList = roleEbi.getAll();
		ActionContext.getContext().put("roleList", roleList);

		return "input";
	}

	public String save() {
		if (menu.getUuid() == null)
			menuEbi.save(menu, roleUuids);
		else
			menuEbi.update(menu, roleUuids);
		return "doList";
	}

	public String delete() {
		menuEbi.delete(menu);
		return "doList";
	}

}

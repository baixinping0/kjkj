package com.bxp.kjkj.auth.entity;

import java.util.Set;

public class MenuModel {
	
	public static final Long MENU_ONE_LEVEL_MENU = 1l; 
	
	private Long uuid;
	private String name;
	private String url;
	
	//菜单到菜单的多对一
	private MenuModel parent;
	
	private Set<MenuModel> childs;
	
	
	public Set<MenuModel> getChilds() {
		return childs;
	}
	public void setChilds(Set<MenuModel> childs) {
		this.childs = childs;
	}
	//对角色的多对多
	private Set<RoleModel> roles;
	
	public Set<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}
	public MenuModel getParent() {
		return parent;
	}
	public void setParent(MenuModel parent) {
		this.parent = parent;
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}

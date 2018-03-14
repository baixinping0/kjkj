package com.bxp.kjkj.auth.entity;

import java.util.Set;

import com.bxp.kjkj.auth.entity.MenuModel;
import com.bxp.kjkj.auth.entity.ResModel;

public class RoleModel {
	private Long uuid;
	private String name;
	private String code;
	private Set<ResModel> ress;
	private Set<MenuModel> menus;
	
	
	
	public Set<MenuModel> getMenus() {
		return menus;
	}
	public void setMenus(Set<MenuModel> menus) {
		this.menus = menus;
	}
	public Long getUuid() {
		return uuid;
	}
	public Set<ResModel> getRess() {
		return ress;
	}
	public void setRess(Set<ResModel> ress) {
		this.ress = ress;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}

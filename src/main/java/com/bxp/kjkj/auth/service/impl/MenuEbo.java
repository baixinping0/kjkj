package com.bxp.kjkj.auth.service.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bxp.kjkj.auth.service.MenuEbi;
import com.bxp.kjkj.auth.dao.MenuDao;
import com.bxp.kjkj.auth.entity.MenuModel;
import com.bxp.kjkj.auth.entity.MenuQueryModel;
import com.bxp.kjkj.auth.entity.RoleModel;

public class MenuEbo implements MenuEbi{
	private MenuDao menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<MenuModel> getALlOneLevel() {
		
		return this.menuDao.getALlParentIsOneOrZero();
	}

	@Override
	public void save(MenuModel menu) {
		menuDao.save(menu);
	}

	@Override
	public List<MenuModel> getAll() {
		return menuDao.getAll();
	}

	@Override
	public MenuModel get(Long uuid) {
		return menuDao.getMenuByUuid(uuid);
	}

	@Override
	public void update(MenuModel menu) {
		//使用快照更新，不更新所属父菜单
		//获取菜单。
		MenuModel dmenu = menuDao.getMenuByUuid(menu.getUuid());
		dmenu.setName(menu.getName());
		dmenu.setUrl(menu.getUrl());
		dmenu.setRoles(menu.getRoles());
	}

	@Override
	public void delete(MenuModel menu) {
		menuDao.delete(menu);
	}

	@Override
	public List<MenuModel> getALl(MenuQueryModel menuq) {
		return menuDao.getAll(menuq);
	}

	@Override
	public void save(MenuModel menu, Long[] roleUuids) {
		Set<RoleModel> roles = new HashSet<RoleModel>();
		for(Long roleUUid : roleUuids){
			RoleModel role = new RoleModel();
			role.setUuid(roleUUid);
			roles.add(role);
		}
		menu.setRoles(roles );
		save(menu);
	}

	@Override
	public void update(MenuModel menu, Long[] roleUuids) {
		Set<RoleModel> roles = new HashSet<RoleModel>();
		for(Long roleUUid : roleUuids){
			RoleModel role = new RoleModel();
			role.setUuid(roleUUid);
			roles.add(role);
		}
		menu.setRoles(roles );
		update(menu);
	}

	@Override
	public List<MenuModel> getAllOneLevelByEmp(Long uuid) {
		return menuDao.getAllOneLevelByEmpUuid(uuid);
	}

	@Override
	public List<MenuModel> getAllTwoLevelByEmpAndOneLevel(Long uuid, Long menuUuid) {
		return menuDao.getAllTwoLevelByEmpAndOneLevel(uuid, menuUuid);
	}

	@Override
	public Integer getCount() {
		return menuDao.getCount();
	}

	@Override
	public List<MenuModel> getALl(MenuQueryModel menuq, Integer pageNum,
			Integer pageCount) {
		return menuDao.getALl(menuq, pageNum, pageCount);
	}
	
	
}

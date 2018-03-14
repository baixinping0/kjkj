package com.bxp.kjkj.auth.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bxp.kjkj.auth.entity.MenuModel;
import com.bxp.kjkj.auth.entity.ResModel;
import com.bxp.kjkj.auth.service.RoleEbi;
import com.bxp.kjkj.auth.dao.RoleDao;
import com.bxp.kjkj.auth.entity.RoleModel;
import com.bxp.kjkj.auth.entity.RoleQueryModel;

public class RoleEbo implements RoleEbi{
	private RoleDao roleDao;
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@Override
	public void save(RoleModel role) {
		roleDao.save(role);
	}
	@Override
	public List<RoleModel> getAll() {
		return roleDao.getAll();
	}
	@Override
	public void delete(RoleModel role) {
		roleDao.delete(role);
	}
	@Override
	public RoleModel get(Long uuid) {
		
		return roleDao.get(uuid);
	}
	@Override
	public void update(RoleModel role) {
		
		RoleModel rolem = roleDao.get(role.getUuid());
		rolem.setName(role.getName());
		rolem.setCode(role.getCode());
		rolem.setRess(role.getRess());
		rolem.setMenus(role.getMenus());
	}
	@Override
	public List<RoleModel> getAll(RoleQueryModel roleq, Integer pageNum, Integer pageCount) {
		return roleDao.getAll(roleq, pageNum, pageCount);
	}
	@Override
	public void save(RoleModel role, Long[] resUuids , Long[] menuUuids) {
		Set<ResModel> ress = new HashSet<ResModel>();
		for(Long uuid : resUuids){
			ResModel res = new ResModel();
			res.setUuid(uuid);;
			ress.add(res);
		}
		
		Set<MenuModel> menus = new HashSet<MenuModel>();
		for(Long uuid : menuUuids){
			MenuModel menu = new MenuModel();
			menu.setUuid(uuid);;
			menus.add(menu);
		}
		
		role.setMenus(menus);
		role.setRess(ress);
		save(role);
	}
	@Override
	public void update(RoleModel role, Long[] resUuids, Long[] menuUuids) {
		Set<ResModel> ress = new HashSet<ResModel>();
		for(Long uuid : resUuids){
			ResModel res = new ResModel();
			res.setUuid(uuid);;
			ress.add(res);
		}
		
		Set<MenuModel> menus = new HashSet<MenuModel>();
		for(Long uuid : menuUuids){
			MenuModel menu = new MenuModel();
			menu.setUuid(uuid);;
			menus.add(menu);
		}
		
		role.setMenus(menus);
		role.setRess(ress);
		update(role);
	}

	@Override
	public Integer getCount(RoleQueryModel roleq) {
		return roleDao.getCount(roleq);
	}
}

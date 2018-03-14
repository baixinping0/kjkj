package com.bxp.kjkj.auth.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bxp.kjkj.auth.entity.MenuModel;
import com.bxp.kjkj.auth.entity.MenuQueryModel;

@Transactional
public interface MenuEbi {

	public List<MenuModel> getALlOneLevel();

	public void save(MenuModel menu);

	public List<MenuModel> getAll();

	public MenuModel get(Long uuid);

	public void update(MenuModel menu);

	public void delete(MenuModel menu);

	public List<MenuModel> getALl(MenuQueryModel menuq);

	public void save(MenuModel menu, Long[] roleUuids);

	public void update(MenuModel menu, Long[] roleUuids);

	public List<MenuModel> getAllOneLevelByEmp(Long uuid);

	public List<MenuModel> getAllTwoLevelByEmpAndOneLevel(Long uuid, Long menuUuid);

	public Integer getCount();

	public List<MenuModel> getALl(MenuQueryModel menuq, Integer pageNum,
                                  Integer pageCount);

}

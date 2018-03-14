package com.bxp.kjkj.auth.dao;

import java.util.List;

import com.bxp.kjkj.auth.entity.RoleModel;
import com.bxp.kjkj.auth.entity.RoleQueryModel;

public interface RoleDao{

	public void save(RoleModel role);

	public List<RoleModel> getAll(RoleQueryModel roleq, Integer pageNum, Integer pageCount);

	public void delete(RoleModel role);

	public RoleModel get(Long uuid);

	public void update(RoleModel role);

	public List<RoleModel> getAll();

	public Integer getCount(RoleQueryModel roleq);
}

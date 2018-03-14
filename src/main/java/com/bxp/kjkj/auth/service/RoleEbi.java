package com.bxp.kjkj.auth.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bxp.kjkj.auth.entity.RoleModel;
import com.bxp.kjkj.auth.entity.RoleQueryModel;

@Transactional
public interface RoleEbi {

	public void save(RoleModel role);

	public List<RoleModel> getAll();

	public void delete(RoleModel role);

	public RoleModel get(Long uuid);

	public void update(RoleModel role);

//	public List<RoleModel> getAll(RoleQueryModel roleq);

	List<RoleModel> getAll(RoleQueryModel roleq, Integer pageNum, Integer pageCount);

	public void save(RoleModel role, Long[] resUuids, Long[] menuUuids);

	public void update(RoleModel role, Long[] resUuids, Long[] menuUuids);

    public Integer getCount(RoleQueryModel roleq);
}

package com.bxp.kjkj.auth.dao;

import java.util.List;

import com.bxp.kjkj.auth.entity.ResModel;
import com.bxp.kjkj.auth.entity.ResQueryModel;

public interface ResDao {

	public void save(ResModel res);

	public List<ResModel> getAll();

	public void delete(ResModel res);

	public ResModel get(Long uuid);

	public void update(ResModel res);

	public List<ResModel> getAll(ResQueryModel resq, Integer pageNum, Integer pageCount);

	public List<ResModel> getAllByEmpId(Long uuid);

	public Integer getCount(ResQueryModel resq);
}

package com.bxp.kjkj.auth.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bxp.kjkj.auth.entity.ResModel;
import com.bxp.kjkj.auth.entity.ResQueryModel;

@Transactional
public interface ResEbi {

	public void save(ResModel res);

	public List<ResModel> getAll();

	public void delete(ResModel res);

	public ResModel get(Long uuid);

	public void update(ResModel res);

	public List<ResModel> getAll(ResQueryModel resq, Integer pageNum, Integer pageCount);

	public List<ResModel> getAllByEmp(Long uuid);

    public Integer getCount(ResQueryModel resq);
}

package com.bxp.kjkj.auth.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bxp.kjkj.auth.entity.DepModel;
import com.bxp.kjkj.auth.entity.DepQueryModel;

@Transactional
public interface DepEbi {

	public void save(DepModel dep);

	public List<DepModel> getAll(DepQueryModel depq);

	public DepModel findByUuid(Long uuid);

	public void update(DepModel dep);

	public void delete(DepModel dep);

	public List<DepModel> getAll(DepQueryModel depq, Integer pageNum,
                                 Integer pageCount);

	public Integer getCount(DepQueryModel depq);

	public List<DepModel> getAll();


}

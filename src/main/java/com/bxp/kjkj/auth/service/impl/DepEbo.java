package com.bxp.kjkj.auth.service.impl;

import java.util.List;

import com.bxp.kjkj.auth.service.DepEbi;
import com.bxp.kjkj.auth.dao.DepDao;
import com.bxp.kjkj.auth.entity.DepModel;
import com.bxp.kjkj.auth.entity.DepQueryModel;

public class DepEbo implements DepEbi{
	private DepDao depDao;

	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
	}

	@Override
	public void save(DepModel dep) {
		depDao.save(dep);
		
	}

	@Override
	public List<DepModel> getAll(DepQueryModel depq) {
		return depDao.getAll(depq);
	}

	@Override
	public DepModel findByUuid(Long uuid) {
		
		return depDao.findByUuid(uuid);
	}

	@Override
	public void update(DepModel dep) {
		// TODO Auto-generated method stub
		depDao.update(dep);
	}

	@Override
	public void delete(DepModel dep) {
		depDao.delete(dep);
	}

	@Override
	public List<DepModel> getAll(DepQueryModel depq, Integer pageNum,
			Integer pageCount) {
		return depDao.getAll(depq, pageNum, pageCount);
	}

	@Override
	public Integer getCount(DepQueryModel depq) {
		return depDao.getCount(depq);
	}

	@Override
	public List<DepModel> getAll() {

		return depDao.getAll();
	}

}

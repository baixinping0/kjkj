package com.bxp.kjkj.auth.service.impl;

import java.util.List;

import com.bxp.kjkj.auth.service.ResEbi;
import com.bxp.kjkj.auth.dao.ResDao;
import com.bxp.kjkj.auth.entity.ResModel;
import com.bxp.kjkj.auth.entity.ResQueryModel;

public class ResEbo implements ResEbi{
	private ResDao resDao;
	
	public void setResDao(ResDao resDao) {
		this.resDao = resDao;
	}

	@Override
	public void save(ResModel res) {
		resDao.save(res);
	}

	@Override
	public List<ResModel> getAll() {
		return resDao.getAll();
	}

	@Override
	public void delete(ResModel res) {
		resDao.delete(res);
	}

	@Override
	public ResModel get(Long uuid) {
		return resDao.get(uuid);
	}

	@Override
	public void update(ResModel res) {
		resDao.update(res);
	}

	@Override
	public List<ResModel> getAll(ResQueryModel resq, Integer pageNum, Integer pageCount) {
		return resDao.getAll(resq, pageNum, pageCount);
	}

	@Override
	public List<ResModel> getAllByEmp(Long uuid) {

		return resDao.getAllByEmpId(uuid);
	}

	@Override
	public Integer getCount(ResQueryModel resq) {
		return resDao.getCount(resq);
	}
}

package com.bxp.kjkj.auth.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.auth.entity.EmpQueryModel;

@Transactional
public interface EmpEbi {
	//业务层方法一定要加注释
	/**
	 * 根据用户名密码登录
	 * @param userName  用户名
	 * @param pwd		密码
	 * @param loginIp 登录ip
	 */

	public EmpModel login(String userName, String pwd, String loginIp);

	public void save(EmpModel emp);

	public List<EmpModel> getAll(EmpQueryModel empq, Integer pageNum, Integer pageCount);

	public EmpModel get(Long uuid);

	public void update(EmpModel emp);

	public void delete(EmpModel emp);

	public List<EmpModel> getAll();

	public boolean changePed(String userName, String pwd, String newPwd);

	public void save(EmpModel emp, Long[] roleUuids);

	public void update(EmpModel emp, Long[] roleUuids);

	public List<EmpModel> getEmpByDep(Long uuid);

    public Integer getCount(EmpQueryModel empq);
}

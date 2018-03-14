package com.bxp.kjkj.auth.dao;

import java.util.List;

import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.auth.entity.EmpQueryModel;

public interface EmpDao {

	public EmpModel getByNameAndPwd(String userName, String pwd);

	public void save(EmpModel emp);

	public List<EmpModel> getAll(EmpQueryModel empq, Integer pageNum, Integer pageCount);

	public EmpModel get(Long uuid);

	public void update(EmpModel emp);

	public void delete(EmpModel emp);

	public List<EmpModel> getAll();

	public boolean updatePwdByPwnAndUsername(String userName, String pwd,
                                             String newPwd);

	public List<EmpModel> getEmpByDep(Long depUuid);


    public Integer getCount(EmpQueryModel empq);
}

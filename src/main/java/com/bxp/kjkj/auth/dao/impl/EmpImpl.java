package com.bxp.kjkj.auth.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bxp.kjkj.auth.dao.EmpDao;
import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.auth.entity.EmpQueryModel;
import com.bxp.kjkj.util.exception.AppException;

public class EmpImpl extends HibernateDaoSupport implements EmpDao {

	@Override
	public EmpModel getByNameAndPwd(String userName, String pwd) {

		String hql = "from EmpModel where userName = ? and pwd = ?";
		List<EmpModel> temp = this.getHibernateTemplate().find(hql, userName,
				pwd);
		return temp.size() > 0 ? temp.get(0) : null;
	}

	@Override
	public void save(EmpModel emp) {
		try{
			this.getHibernateTemplate().save(emp);	
		}catch(Exception ex){
			throw new AppException(ex);
		}
	}


	@Override
	public List<EmpModel> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(EmpModel.class);
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public EmpModel get(Long uuid) {
		return this.getHibernateTemplate().get(EmpModel.class, uuid);
	}

	@Override
	public void update(EmpModel emp) {
		this.getHibernateTemplate().update(emp);
	}

	@Override
	public void delete(EmpModel emp) {
		this.getHibernateTemplate().delete(emp);
	}

	@Override
	public List<EmpModel> getAll(EmpQueryModel empq, Integer pageNum, Integer pageCount) {
		DetachedCriteria criteria = DetachedCriteria.forClass(EmpModel.class);

		addCondition(criteria, empq);

		return this.getHibernateTemplate().findByCriteria(criteria, (pageNum-1) * pageCount, pageCount);
	}

	@Override
	public boolean updatePwdByPwnAndUsername(String userName, String pwd,
			String newPwd) {
		String hql = "update EmpModel set pwd = ? where userName = ? and pwd = ?";
		int row = this.getHibernateTemplate().bulkUpdate(hql, newPwd, userName,
				pwd);
		return row > 0;
	}

	@Override
	public List<EmpModel> getEmpByDep(Long depUuid) {
		String hql = "from EmpModel where dep.uuid = ?";
		return this.getHibernateTemplate().find(hql, depUuid);
	}

	@Override
	public Integer getCount(EmpQueryModel empq) {
		DetachedCriteria criteria = DetachedCriteria.forClass(EmpModel.class);

		addCondition(criteria, empq);

		criteria.setProjection(Projections.rowCount());
		List<Long> count = this.getHibernateTemplate().findByCriteria(criteria);
		return count.get(0).intValue();
	}
	private void addCondition(DetachedCriteria criteria, EmpQueryModel empq){
		if (empq.getUserName() != null
				&& empq.getUserName().trim().length() > 0)
			criteria.add(Restrictions.eq("userName", empq.getUserName().trim()));
		if (empq.getName() != null && empq.getName().trim().length() > 0)
			criteria.add(Restrictions.like("name", "%" + empq.getName().trim()
					+ "%"));
		if (empq.getTele() != null && empq.getTele().trim().length() > 0)
			criteria.add(Restrictions.like("tele", "%" + empq.getTele().trim()
					+ "%"));
		if (empq.getGender() != null && empq.getGender() != -1)
			criteria.add(Restrictions.eq("gender", empq.getGender()));
		if (empq.getEmail() != null && empq.getEmail().trim().length() > 0)
			criteria.add(Restrictions.like("email", "%"
					+ empq.getEmail().trim() + "%"));
		if (empq.getDep() != null && empq.getDep().getUuid() != null
				&& empq.getDep().getUuid() != -1) {
			/*
			 * 通过uuid进行查询的时候，匹配有两种方式
			 */
			// 1、直接使用对象进行查询，此时默认比较的是对象的uuid(推荐使用)
			criteria.add(Restrictions.eq("dep", empq.getDep()));
			// 2、使用uuid进行查询，匹配使用 dep.uuid,此种方式仅限对id进行匹配
			// criteria.add(Restrictions.eq("dep.uuid",
			// empq.getDep().getUuid()));
		}
		if (empq.getBirthday() != null) {
			criteria.add(Restrictions.ge("birthday", empq.getBirthday()));
		}
		if (empq.getBirthday2() != null) {
			criteria.add(Restrictions.le("birthday", empq.getBirthday2() + 24
					* 60 * 60 * 1000 - 1));
		}
	}

}

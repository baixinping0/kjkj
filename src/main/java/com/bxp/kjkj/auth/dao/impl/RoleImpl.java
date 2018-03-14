package com.bxp.kjkj.auth.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bxp.kjkj.auth.dao.RoleDao;
import com.bxp.kjkj.auth.entity.RoleModel;
import com.bxp.kjkj.auth.entity.RoleQueryModel;

public class RoleImpl extends HibernateDaoSupport implements RoleDao {

	@Override
	public void save(RoleModel role) {
		this.getHibernateTemplate().save(role);
	}

	@Override
	public List<RoleModel> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(RoleModel.class);

		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public void delete(RoleModel role) {
		this.getHibernateTemplate().delete(role);
	}

	@Override
	public RoleModel get(Long uuid) {
		return this.getHibernateTemplate().get(RoleModel.class, uuid);
	}

	@Override
	public void update(RoleModel role) {
		this.getHibernateTemplate().update(role);
	}

	@Override
	public List<RoleModel> getAll(RoleQueryModel roleq , Integer pageNum, Integer pageCount) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RoleModel.class);

		addCondition(criteria, roleq);

		return this.getHibernateTemplate().findByCriteria(criteria, (pageNum-1) * pageCount, pageCount);
	}

	@Override
	public Integer getCount(RoleQueryModel roleq) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RoleModel.class);

		addCondition(criteria, roleq);

		criteria.setProjection(Projections.rowCount());
		List<Long> count = this.getHibernateTemplate().findByCriteria(criteria);
		return count.get(0).intValue();
	}
	private void addCondition(DetachedCriteria criteria, RoleQueryModel roleq) {
		if (roleq.getName() != null && roleq.getName().trim().length() > 0)
			criteria.add(Restrictions.like("name", "%" + roleq.getName().trim()
					+ "%"));
		if (roleq.getCode() != null && roleq.getCode().trim().length() > 0)
			criteria.add(Restrictions.like("code", "%" + roleq.getCode().trim()
					+ "%"));
	}
}

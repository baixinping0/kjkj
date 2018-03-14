package com.bxp.kjkj.auth.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bxp.kjkj.auth.dao.DepDao;
import com.bxp.kjkj.auth.entity.DepModel;
import com.bxp.kjkj.auth.entity.DepQueryModel;

public class DepImpl extends HibernateDaoSupport implements DepDao{

	public void save(DepModel dep) {
		this.getHibernateTemplate().save(dep);
		
	}

	@Override
	public List<DepModel> getAll(DepQueryModel depq) {
		
		
		DetachedCriteria criteria = DetachedCriteria.forClass(DepModel.class);
		if(depq.getName() != null && depq.getName().trim().length() > 0)
			criteria.add(Restrictions.like("name", "%" + depq.getName().trim() + "%"));
		if(depq.getTele() != null && depq.getTele().trim().length() > 0)
			criteria.add(Restrictions.like("tele", "%" + depq.getTele().trim() +"%"));
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public DepModel findByUuid(Long uuid) {
		return this.getHibernateTemplate().get(DepModel.class, uuid);
	}

	@Override
	public void update(DepModel dep) {
		this.getHibernateTemplate().update(dep);
	}

	@Override
	public void delete(DepModel dep) {
		this.getHibernateTemplate().delete(dep);
	}

	@Override
	public List<DepModel> getAll(DepQueryModel depq, Integer pageNum,
			Integer pageCount) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DepModel.class);
		if(depq.getName() != null && depq.getName().trim().length() > 0)
			criteria.add(Restrictions.like("name", "%" + depq.getName().trim() + "%"));
		if(depq.getTele() != null && depq.getTele().trim().length() > 0)
			criteria.add(Restrictions.like("tele", "%" + depq.getTele().trim() +"%"));
		return this.getHibernateTemplate().findByCriteria(criteria, (pageNum - 1) * pageCount, pageCount);
	}

	@Override
	public Integer getCount(DepQueryModel depq) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DepModel.class);
		criteria.setProjection(Projections.rowCount());
		if(depq.getName() != null && depq.getName().trim().length() > 0)
			criteria.add(Restrictions.like("name", "%" + depq.getName().trim() + "%"));
		if(depq.getTele() != null && depq.getTele().trim().length() > 0)
			criteria.add(Restrictions.like("tele", "%" + depq.getTele().trim() +"%"));
		List<Long> count = this.getHibernateTemplate().findByCriteria(criteria);
		return count.get(0).intValue();
	}

	@Override
	public List<DepModel> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DepModel.class);
		return this.getHibernateTemplate().findByCriteria(criteria);
	}


}

package com.bxp.kjkj.auth.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bxp.kjkj.auth.dao.MenuDao;
import com.bxp.kjkj.auth.entity.MenuModel;
import com.bxp.kjkj.auth.entity.MenuQueryModel;

public class MenuImpl extends HibernateDaoSupport implements MenuDao {

	@Override
	public List<MenuModel> getALlParentIsOneOrZero() {
		String hql = "from MenuModel where parent.id = ? or id = ?";
		return this.getHibernateTemplate().find(hql,
				MenuModel.MENU_ONE_LEVEL_MENU, MenuModel.MENU_ONE_LEVEL_MENU);
	}

	@Override
	public void save(MenuModel menu) {
		this.getHibernateTemplate().save(menu);
	}

	@Override
	public List<MenuModel> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(MenuModel.class);
		criteria.add(Restrictions.not(Restrictions.eq("uuid",
				MenuModel.MENU_ONE_LEVEL_MENU)));
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public MenuModel getMenuByUuid(Long uuid) {
		return this.getHibernateTemplate().get(MenuModel.class, uuid);
	}

	@Override
	public void delete(MenuModel menu) {
		MenuModel temp  = getMenuByUuid(menu.getUuid());
		this.getHibernateTemplate().delete(temp);
	}

	@Override
	public List<MenuModel> getAll(MenuQueryModel menuq) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MenuModel.class);
		criteria.add(Restrictions.not(Restrictions.eq("uuid",
				MenuModel.MENU_ONE_LEVEL_MENU)));
		if (menuq.getName() != null && menuq.getName().trim().length() > 0)
			criteria.add(Restrictions.like("name", "%" + menuq.getName().trim()
					+ "%"));
		if (menuq.getParent() != null && menuq.getParent().getUuid() != -1)
			criteria.add(Restrictions.eq("parent", menuq.getParent()));
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<MenuModel> getAllOneLevelByEmpUuid(Long uuid) {
		
		String hql = "select distinct menu from EmpModel emp join emp.roles role join role.menus menu where emp.uuid = ? and menu.parent.uuid = ? order by menu.uuid";
		return this.getHibernateTemplate().find(hql, uuid, MenuModel.MENU_ONE_LEVEL_MENU);
	}

	@Override
	public List<MenuModel> getAllTwoLevelByEmpAndOneLevel(Long uuid,
			Long menuUuid) {
		String hql = "select distinct menu from EmpModel emp join emp.roles role join role.menus menu where emp.uuid = ? and menu.parent.uuid = ? order by menu.uuid";
		return this.getHibernateTemplate().find(hql, uuid, menuUuid);
	}

	@Override
	public Integer getCount() {
		DetachedCriteria criteria = DetachedCriteria.forClass(MenuModel.class);
		criteria.add(Restrictions.not(Restrictions.eq("uuid",
				MenuModel.MENU_ONE_LEVEL_MENU)));
		criteria.setProjection(Projections.rowCount());
		List<Long> count = this.getHibernateTemplate().findByCriteria(criteria);
		return count.get(0).intValue();
	}

	@Override
	public List<MenuModel> getALl(MenuQueryModel menuq, Integer pageNum,
			Integer pageCount) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MenuModel.class);
		criteria.add(Restrictions.not(Restrictions.eq("uuid",
				MenuModel.MENU_ONE_LEVEL_MENU)));
		return this.getHibernateTemplate().findByCriteria(criteria, (pageNum-1) * pageCount, pageCount);
	}
}

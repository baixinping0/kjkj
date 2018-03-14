package com.bxp.kjkj.data.dao.impl;

import com.bxp.kjkj.data.dao.Data848Dao;
import com.bxp.kjkj.data.entity.Data848Model;
import com.bxp.kjkj.data.entity.Data848QueryModel;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class Data848Impl extends HibernateDaoSupport implements Data848Dao{
    @Override
    public List<Data848Model> getAll(Data848QueryModel data848q, Long reporterUuid, Integer pageNum, Integer pageCount) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Data848Model.class);

        addCondition(criteria, data848q, reporterUuid);

        return this.getHibernateTemplate().findByCriteria(criteria, (pageNum-1) * pageCount, pageCount);
    }

    private void addCondition(DetachedCriteria criteria, Data848QueryModel data848q, Long reporterUuid){

        if (data848q.getErrorFrame() != null) {
            criteria.add(Restrictions.ge("errorFrame", data848q.getErrorFrame()));
        }
        if (data848q.getErrorFrame2() != null) {
            criteria.add(Restrictions.le("errorFrame", data848q.getErrorFrame2()));
        }

        if (data848q.getCorrectCode() != null && data848q.getCorrectCode().trim().length() > 0)
            criteria.add(Restrictions.like("correctCode", "%"
                    + data848q.getCorrectCode().trim() + "%"));
        if (data848q.getActualCode() != null && data848q.getActualCode().trim().length() > 0)
            criteria.add(Restrictions.like("actualCode", "%"
                    + data848q.getActualCode().trim() + "%"));
        if (data848q.getProduceTime() != null) {
            criteria.add(Restrictions.ge("produceTime", data848q.getProduceTime()));
        }
        if (data848q.getProduceTime2() != null) {
            criteria.add(Restrictions.le("produceTime", data848q.getProduceTime2()));
        }
        if (data848q.getInputTime() != null) {
            criteria.add(Restrictions.ge("inputTime", data848q.getInputTime()));
        }
        if (data848q.getInputTime2() != null) {
            criteria.add(Restrictions.le("inputTime", data848q.getInputTime2()));
        }
        if (reporterUuid != null && reporterUuid != -1) {
            criteria.add(Restrictions.eq("reporter.uuid",
                    reporterUuid));
        }
    }

    @Override
    public Integer getCount(Data848QueryModel data848q, Long reporterUuid) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Data848Model.class);

        addCondition(criteria, data848q, reporterUuid);

        criteria.setProjection(Projections.rowCount());
        List<Long> count = this.getHibernateTemplate().findByCriteria(criteria);
        return count.get(0).intValue();
    }
}

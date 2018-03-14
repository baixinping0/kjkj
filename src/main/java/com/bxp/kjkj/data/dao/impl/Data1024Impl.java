package com.bxp.kjkj.data.dao.impl;

import com.bxp.kjkj.data.dao.Data1024Dao;
import com.bxp.kjkj.data.entity.Data1024Model;
import com.bxp.kjkj.data.entity.Data1024QueryModel;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class Data1024Impl extends HibernateDaoSupport implements Data1024Dao{

    @Override
    public List<Data1024Model> getAll(Data1024QueryModel data1024q, Long reporterUuid, Integer pageNum, Integer pageCount) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Data1024Model.class);

        addCondition(criteria, data1024q, reporterUuid);

        return this.getHibernateTemplate().findByCriteria(criteria, (pageNum-1) * pageCount, pageCount);
    }

    private void addCondition(DetachedCriteria criteria, Data1024QueryModel data1024q,
                              Long reporterUuid){
        if (data1024q.getChanel() != null) {
            criteria.add(Restrictions.ge("chanel", data1024q.getChanel()));
        }
        if (data1024q.getChanel2() != null) {
            criteria.add(Restrictions.le("chanel", data1024q.getChanel2()));
        }
        if (data1024q.getDataType() != null && data1024q.getDataType() != -1) {
            criteria.add(Restrictions.eq("dataType", data1024q.getDataType()));
        }
        if (data1024q.getErrorType() != null && data1024q.getErrorType() != -1) {
            criteria.add(Restrictions.eq("errorType", data1024q.getErrorType()));
        }
        if (data1024q.getErrorRow() != null) {
            criteria.add(Restrictions.ge("errorRow", data1024q.getErrorRow()));
        }
        if (data1024q.getErrorRow2() != null) {
            criteria.add(Restrictions.le("errorRow", data1024q.getErrorRow2()));
        }
        if (data1024q.getCurrentCount() != null) {
            criteria.add(Restrictions.ge("currentCount", data1024q.getCurrentCount()));
        }
        if (data1024q.getCurrentCount2() != null) {
            criteria.add(Restrictions.le("currentCount", data1024q.getCurrentCount2()));
        }
        if (data1024q.getNextCount() != null) {
            criteria.add(Restrictions.ge("nextCount", data1024q.getNextCount()));
        }
        if (data1024q.getNextCount2() != null) {
            criteria.add(Restrictions.le("nextCount", data1024q.getNextCount2()));
        }
        if (data1024q.getProduceTime() != null) {
            criteria.add(Restrictions.ge("produceTime", data1024q.getProduceTime()));
        }
        if (data1024q.getProduceTime2() != null) {
            criteria.add(Restrictions.le("produceTime", data1024q.getProduceTime2()));
        }
        if (data1024q.getInputTime() != null) {
            criteria.add(Restrictions.ge("inputTime", data1024q.getInputTime()));
        }
        if (data1024q.getInputTime2() != null) {
            criteria.add(Restrictions.le("inputTime", data1024q.getInputTime2()));
        }
        if (reporterUuid != null && reporterUuid != -1) {
            criteria.add(Restrictions.eq("reporter.uuid",
                    reporterUuid));
        }
    }

    @Override
    public Integer getCount(Data1024QueryModel data1024q, Long reporterUuid) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Data1024Model.class);

        addCondition(criteria, data1024q, reporterUuid);

        criteria.setProjection(Projections.rowCount());
        List<Long> count = this.getHibernateTemplate().findByCriteria(criteria);
        return count.get(0).intValue();
    }


}

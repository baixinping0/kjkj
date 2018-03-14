package com.bxp.kjkj.data.service.impl;

import com.bxp.kjkj.data.dao.Data848Dao;
import com.bxp.kjkj.data.entity.Data848Model;
import com.bxp.kjkj.data.entity.Data848QueryModel;
import com.bxp.kjkj.data.service.Data848Ebi;

import java.util.List;

public class Data848Ebo implements Data848Ebi{
    private Data848Dao data848Dao;

    public void setData848Dao(Data848Dao data848Dao) {
        this.data848Dao = data848Dao;
    }

    @Override
    public List<Data848Model> getAll(Data848QueryModel data848q, Long reporterUuid, Integer pageNum, Integer pageCount) {
        return data848Dao.getAll(data848q, reporterUuid,pageNum, pageCount);
    }

    @Override
    public Integer getCount(Data848QueryModel data848q, Long reporterUuid) {
        return data848Dao.getCount(data848q, reporterUuid);
    }
}

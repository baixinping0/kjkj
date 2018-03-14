package com.bxp.kjkj.data.service.impl;

import com.bxp.kjkj.data.dao.Data1024Dao;
import com.bxp.kjkj.data.entity.Data1024Model;
import com.bxp.kjkj.data.entity.Data1024QueryModel;
import com.bxp.kjkj.data.service.Data1024Ebi;

import java.util.List;

public class Data1024Ebo implements Data1024Ebi {
    private Data1024Dao data1024Dao;

    public void setData1024Dao(Data1024Dao data1024Dao) {
        this.data1024Dao = data1024Dao;
    }

    @Override
    public List<Data1024Model> getAll(Data1024QueryModel data1024q, Long reporterUuid, Integer pageNum, Integer pageCount) {
        return data1024Dao.getAll(data1024q, reporterUuid, pageNum, pageCount);
    }

    @Override
    public Integer getCount(Data1024QueryModel data1024q, Long reporterUuid) {
        return data1024Dao.getCount(data1024q, reporterUuid);
    }
}

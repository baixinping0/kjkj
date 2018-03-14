package com.bxp.kjkj.data.dao;

import com.bxp.kjkj.data.entity.Data1024Model;
import com.bxp.kjkj.data.entity.Data1024QueryModel;

import java.util.List;

public interface Data1024Dao {
    public List<Data1024Model> getAll(Data1024QueryModel data1024q, Long reporterUuid,Integer pageNum, Integer pageCount);

    public Integer getCount(Data1024QueryModel data1024q, Long reporterUuid);
}

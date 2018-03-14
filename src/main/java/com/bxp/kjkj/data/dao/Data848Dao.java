package com.bxp.kjkj.data.dao;

import com.bxp.kjkj.data.entity.Data848Model;
import com.bxp.kjkj.data.entity.Data848QueryModel;

import java.util.List;

public interface Data848Dao {
    public List<Data848Model> getAll(Data848QueryModel data848q, Long reporterUuid, Integer pageNum, Integer pageCount);

    public Integer getCount(Data848QueryModel data848q, Long reporterUuid);
}

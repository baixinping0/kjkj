package com.bxp.kjkj.data.service;

import com.bxp.kjkj.data.entity.Data848Model;
import com.bxp.kjkj.data.entity.Data848QueryModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface Data848Ebi {
    public List<Data848Model> getAll(Data848QueryModel data848q, Long reporterUuid, Integer pageNum, Integer pageCount);

    public Integer getCount(Data848QueryModel data848q, Long reporterUuid);
}

package com.bxp.kjkj.data.service;

import com.bxp.kjkj.data.entity.Data1024Model;
import com.bxp.kjkj.data.entity.Data1024QueryModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface Data1024Ebi {
    public List<Data1024Model> getAll(Data1024QueryModel data1024q, Long reporterUuid, Integer pageNum, Integer pageCount);

    public Integer getCount(Data1024QueryModel data1024q, Long reporterUuid);
}

package com.bxp.kjkj.data.action;

import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.auth.service.EmpEbi;
import com.bxp.kjkj.data.entity.Data848Model;
import com.bxp.kjkj.data.entity.Data848QueryModel;
import com.bxp.kjkj.data.service.Data848Ebi;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class Data848Action extends ActionSupport{

    public Integer pageNum = 1;
    public Integer pageCount = 1;
    // 最大页码值
    public Integer maxPageNum;
    // 数据总量
    public Integer dataTotal;

    public Data848QueryModel data848q = new Data848QueryModel();
    public Long reporterUuid = null;

    private Data848Ebi data848Ebi;
    private EmpEbi empEbi;

    public void setEmpEbi(EmpEbi empEbi) {
        this.empEbi = empEbi;
    }

    public void setData848Ebi(Data848Ebi data848Ebi) {
        this.data848Ebi = data848Ebi;
    }

    public String list(){

        // 获取条目总数
        dataTotal = data848Ebi.getCount(data848q, reporterUuid);
        // 通过总条目计算最大页码值
        maxPageNum = (dataTotal + pageCount - 1) / pageCount;

        List<Data848Model> data848List = data848Ebi.getAll(data848q, reporterUuid, pageNum, pageCount);
        ActionContext.getContext().put("data848List", data848List);

        List<EmpModel> empList = empEbi.getAll();
        ActionContext.getContext().put("empList", empList);

        return "list";
    }
}

package com.bxp.kjkj.data.action;

import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.auth.service.EmpEbi;
import com.bxp.kjkj.data.entity.Data1024Model;
import com.bxp.kjkj.data.entity.Data1024QueryModel;
import com.bxp.kjkj.data.service.Data1024Ebi;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class Data1024Action extends ActionSupport {

    public Integer pageNum = 1;
    public Integer pageCount = 1;
    // 最大页码值
    public Integer maxPageNum;
    // 数据总量
    public Integer dataTotal;

    public Data1024QueryModel data1024q = new Data1024QueryModel();
    public Long reporterUuid = null;


    private Data1024Ebi data1024Ebi;
    private EmpEbi empEbi;

    public void setReporterUuid(Long reporterUuid) {
        this.reporterUuid = reporterUuid;
    }

    public void setEmpEbi(EmpEbi empEbi) {
        this.empEbi = empEbi;
    }

    public void setData1024Ebi(Data1024Ebi data1024Ebi) {
        this.data1024Ebi = data1024Ebi;
    }

    public String list(){


        // 获取条目总数
        dataTotal = data1024Ebi.getCount(data1024q, reporterUuid);
        // 通过总条目计算最大页码值
        maxPageNum = (dataTotal + pageCount - 1) / pageCount;

        List<Data1024Model> data1024List = data1024Ebi.getAll(data1024q, reporterUuid, pageNum, pageCount);
        ActionContext.getContext().put("data1024List", data1024List);

        List<EmpModel> empList = empEbi.getAll();
        ActionContext.getContext().put("empList", empList);

        return "list";
    }
}

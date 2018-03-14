package com.bxp.kjkj.auth.action;

import java.util.List;

import com.bxp.kjkj.auth.service.ResEbi;
import com.bxp.kjkj.auth.entity.ResModel;
import com.bxp.kjkj.auth.entity.ResQueryModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ResAction extends ActionSupport {

	public Integer pageNum = 1;
	public Integer pageCount = 1;
	// 最大页码值
	public Integer maxPageNum;
	// 数据总量
	public Integer dataTotal;

	public ResModel res = new ResModel();
	public ResQueryModel resq = new ResQueryModel();
	private ResEbi resEbi;

	public void setResEbi(ResEbi resEbi) {
		this.resEbi = resEbi;
	}

	public String list() {

		// 获取条目总数
		dataTotal = resEbi.getCount(resq);
		// 通过总条目计算最大页码值
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;

		List<ResModel> resList = resEbi.getAll(resq, pageNum, pageCount);
		ActionContext.getContext().put("resList", resList);
		return "list";
	}

	public String input() {
		if (res.getUuid() != null)
			res = resEbi.get(res.getUuid());
		return "input";
	}

	public String save() {
		if (res.getUuid() == null)
			resEbi.save(res);
		else
			resEbi.update(res);
		return "doList";
	}

	public String delete() {
		resEbi.delete(res);
		return "doList";
	}
}

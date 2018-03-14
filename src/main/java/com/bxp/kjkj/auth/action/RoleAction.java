package com.bxp.kjkj.auth.action;

import java.util.List;

import com.bxp.kjkj.auth.service.MenuEbi;
import com.bxp.kjkj.auth.entity.MenuModel;
import com.bxp.kjkj.auth.service.ResEbi;
import com.bxp.kjkj.auth.entity.ResModel;
import com.bxp.kjkj.auth.service.RoleEbi;
import com.bxp.kjkj.auth.entity.RoleModel;
import com.bxp.kjkj.auth.entity.RoleQueryModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {

	public Integer pageNum = 1;
	public Integer pageCount = 1;
	// 最大页码值
	public Integer maxPageNum;
	// 数据总量
	public Integer dataTotal;

	public RoleModel role = new RoleModel();
	public RoleQueryModel roleq = new RoleQueryModel();
	public Long[] resUuids;
	private RoleEbi roleEbi;
	private ResEbi resEbi;
	private MenuEbi menuEbi;
	
	public Long[] menuUuids;
	public void setMenuEbi(MenuEbi menuEbi) {
		this.menuEbi = menuEbi;
	}

	public void setRoleEbi(RoleEbi roleEbi) {
		this.roleEbi = roleEbi; 
	}

	public void setResEbi(ResEbi resEbi) {
		this.resEbi = resEbi;
	}

	public String list() {

		// 获取条目总数
		dataTotal = roleEbi.getCount(roleq);
		// 通过总条目计算最大页码值
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;

		List<RoleModel> roleList = roleEbi.getAll(roleq, pageNum, pageCount);
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	public String input() {
		//获取资源列表
		List<ResModel> resList = resEbi.getAll();
		ActionContext.getContext().put("resList", resList);
		
		//获取所有的菜单
		List<MenuModel> menuList = menuEbi.getAll();
		ActionContext.getContext().put("menuList", menuList);
		
		if (role.getUuid() != null){
			role = roleEbi.get(role.getUuid());
			
			resUuids = new Long[role.getRess().size()];
			int i = 0;
			for(ResModel res : role.getRess()){
				resUuids[i] = res.getUuid();
				i++;
			}
			
			menuUuids = new Long[role.getMenus().size()];
			int j = 0;
			for(MenuModel menu : role.getMenus()){
				menuUuids[j] = menu.getUuid();
				j++;
			}
			
		}
		return "input";
	}

	public String save() {
		if (role.getUuid() == null)
			roleEbi.save(role, resUuids, menuUuids);
		else
			roleEbi.update(role, resUuids, menuUuids);
		return "doList";
	}

	public String delete() {
		roleEbi.delete(role);
		return "doList";
	}
}

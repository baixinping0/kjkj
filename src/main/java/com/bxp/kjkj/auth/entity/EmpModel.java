package com.bxp.kjkj.auth.entity;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bxp.kjkj.util.format.FormatUtil;

public class EmpModel {
	public static final String EMP_LOGIN_USER_OBJECT_NAME = "loginEmp";

	private Long uuid;
	private String userName;
	private String pwd;
	private String name;
	private String email;
	private String tele;
	private String address;
	private Integer gender;
	private Long birthday;
	private Long lastLoginTime;
	private String lastLoginIp;
	private Integer loginTimes;

	//员工到部门的一对一
	private DepModel dep;
	//员工到角色的多对多
	private Set<RoleModel> roles;
	
	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}
	public static final Integer GENDER_MAN_VALUE = 1;
	public static final Integer GENDER_WOMAN_VALUE = 0;
	
	public static final String GENDER_MAN_VALUE_VIEW = "男";
	public static final String GENDER_WOMAN_VALUE_VIEW = "女";
	
	public static Map<Integer, String> genderMap = new HashMap<Integer, String>();
	
	static{
		genderMap.put(GENDER_MAN_VALUE, GENDER_MAN_VALUE_VIEW);
		genderMap.put(GENDER_WOMAN_VALUE, GENDER_WOMAN_VALUE_VIEW);
	}
	
	/*
	 * 视图值：当数据库中取出的数据不利用与显示的时候，使用视图值进行显示 视图值服务于真实值 对视图值提供get方法
	 * 在真实值的set方法中对视图值进行初始化
	 */ 
	private String birthdayView;
	private String genderView;
	private String lastLoginTimeView;
	
	/*
	 * 辅助值：此值不参与显示
	 */
	List<ResModel> resList;
	
	
	public List<ResModel> getResList() {
		return resList;
	}

	public void setResList(List<ResModel> resList) {
		this.resList = resList;
	}

	public String getLastLoginTimeView() {
		return lastLoginTimeView;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		this.lastLoginTimeView = FormatUtil.formatDate(lastLoginTime);
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Integer getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	public String getGenderView() {
		return genderView;
	}

	public String getBirthdayView() {
		return birthdayView;
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		if(gender != null)
			this.genderView = genderMap.get(gender);
		else
			this.genderView = "";
		this.gender = gender;
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long birthday) {
		if (birthday != null)
			this.birthdayView = FormatUtil.formatDate(birthday);
		else
			this.birthdayView = "";
		this.birthday = birthday;
	}

	public DepModel getDep() {
		return dep;
	}

	public void setDep(DepModel dep) {
		this.dep = dep;
	}

}

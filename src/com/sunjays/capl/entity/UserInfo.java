package com.sunjays.capl.entity;

import java.io.Serializable;

public class UserInfo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8872698748974963974L;

	private Integer userid;

    private String username;

    private String password;

    private Integer userunitid;

    private Integer roleid;

    private String turename;

    private String department;

    private String post;

    private String uuid;

    private String mac;

    private String adress;

    private String telephone;

    private String remark1;

    private String remark2;
    
    private UserUnit userUnit;
    
    private AuthRole authRole;
    
    

    public AuthRole getAuthRole() {
		return authRole;
	}

	public void setAuthRole(AuthRole authRole) {
		this.authRole = authRole;
	}

	public UserUnit getUserUnit() {
		return userUnit;
	}

	public void setUserUnit(UserUnit userUnit) {
		this.userUnit = userUnit;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserunitid() {
        return userunitid;
    }

    public void setUserunitid(Integer userunitid) {
        this.userunitid = userunitid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getTurename() {
        return turename;
    }

    public void setTurename(String turename) {
        this.turename = turename;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}
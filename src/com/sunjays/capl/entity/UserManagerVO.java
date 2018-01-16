package com.sunjays.capl.entity;

import java.io.Serializable;


public class UserManagerVO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3098924297915042068L;
	private Long id;
	private String loginName;

    private Integer departmentId;
    private String departmentName;
    private Integer jobId;
    private String jobName;
    private String mainPri;
    private String basePri;
	private String token;
    public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getMainPri() {
		return mainPri;
	}
	public void setMainPri(String mainPri) {
		this.mainPri = mainPri;
	}
	public String getBasePri() {
		return basePri;
	}
	public void setBasePri(String basePri) {
		this.basePri = basePri;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    
    
    
}

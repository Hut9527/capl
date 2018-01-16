package com.sunjays.capl.entity;

public class PersonsVo {
	
	private String name;
	private String starttime;
	private String overtime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	@Override
	public String toString() {
		return "PersonsVo [name=" + name + ", starttime=" + starttime + ", overtime=" + overtime + "]";
	}
	
	

}

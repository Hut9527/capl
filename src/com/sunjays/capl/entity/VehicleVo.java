package com.sunjays.capl.entity;

public class VehicleVo {
	
	private String starttime;
	private String overtime;
	private String vehicle;
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
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String devid) {
		this.vehicle = devid;
	}
	@Override
	public String toString() {
		return "VehicleVo [starttime=" + starttime + ", overtime=" + overtime + ", vehicle=" + vehicle + "]";
	}
	
	

}

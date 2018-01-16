package com.sunjays.capl.entity.attendancetable;

public class Cartable1 {
	
	private String vehicle;//车牌号
	private String vehcurvetime;//车_日期
	private String vehattendance;//车_考勤
	private String vehworktime;//车_工作时间
	private String vehworkkm;//工作里程
	private String vehremark;//车_备注
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getVehcurvetime() {
		return vehcurvetime;
	}
	public void setVehcurvetime(String vehcurvetime) {
		this.vehcurvetime = vehcurvetime;
	}
	public String getVehattendance() {
		return vehattendance;
	}
	public void setVehattendance(String vehattendance) {
		this.vehattendance = vehattendance;
	}
	public String getVehworktime() {
		return vehworktime;
	}
	public void setVehworktime(String vehworktime) {
		this.vehworktime = vehworktime;
	}
	public String getVehworkkm() {
		return vehworkkm;
	}
	public void setVehworkkm(String vehworkkm) {
		this.vehworkkm = vehworkkm;
	}
	public String getVehremark() {
		return vehremark;
	}
	public void setVehremark(String vehremark) {
		this.vehremark = vehremark;
	}
	@Override
	public String toString() {
		return "Cartable1 [vehicle=" + vehicle + ", vehcurvetime=" + vehcurvetime + ", vehattendance=" + vehattendance
				+ ", vehworktime=" + vehworktime + ", vehworkkm=" + vehworkkm + ", vehremark=" + vehremark + "]";
	}
	
	

}

package com.sunjays.capl.entity.attendancetable;

public class Usertable2 {
	
	private String peojobnumber;//人_工号
	private String peoname;//人_姓名
	private String peocompany;//人_单位
	private String peocurvetime;//人_日期
	private String peoattendance;//人_考勤
	private String peoworktime;//人_工作时间
	public String getPeojobnumber() {
		return peojobnumber;
	}
	public void setPeojobnumber(String peojobnumber) {
		this.peojobnumber = peojobnumber;
	}
	public String getPeoname() {
		return peoname;
	}
	public void setPeoname(String peoname) {
		this.peoname = peoname;
	}
	public String getPeocompany() {
		return peocompany;
	}
	public void setPeocompany(String peocompany) {
		this.peocompany = peocompany;
	}
	public String getPeocurvetime() {
		return peocurvetime;
	}
	public void setPeocurvetime(String peocurvetime) {
		this.peocurvetime = peocurvetime;
	}
	public String getPeoattendance() {
		return peoattendance;
	}
	public void setPeoattendance(String peoattendance) {
		this.peoattendance = peoattendance;
	}
	public String getPeoworktime() {
		return peoworktime;
	}
	public void setPeoworktime(String peoworktime) {
		this.peoworktime = peoworktime;
	}
	@Override
	public String toString() {
		return "Usertable2 [peojobnumber=" + peojobnumber + ", peoname=" + peoname + ", peocompany=" + peocompany
				+ ", peocurvetime=" + peocurvetime + ", peoattendance=" + peoattendance + ", peoworktime=" + peoworktime
				+ "]";
	}
	
	

}

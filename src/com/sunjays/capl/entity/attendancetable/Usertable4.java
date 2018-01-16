package com.sunjays.capl.entity.attendancetable;

public class Usertable4 {
	
	private String peoviolatname;//人_违章人名称
	private String peoviolatcompany;//人_违章人单位
	private String peoviolatdata;//人_违章类型
	private String peoviolattime;//人_违章时间
	
	
	public String getPeoviolattime() {
		return peoviolattime;
	}
	public void setPeoviolattime(String peoviolattime) {
		this.peoviolattime = peoviolattime;
	}
	public String getPeoviolatname() {
		return peoviolatname;
	}
	public void setPeoviolatname(String peoviolatname) {
		this.peoviolatname = peoviolatname;
	}
	public String getPeoviolatcompany() {
		return peoviolatcompany;
	}
	public void setPeoviolatcompany(String peoviolatcompany) {
		this.peoviolatcompany = peoviolatcompany;
	}
	public String getPeoviolatdata() {
		return peoviolatdata;
	}
	public void setPeoviolatdata(String peoviolatdata) {
		this.peoviolatdata = peoviolatdata;
	}
	@Override
	public String toString() {
		return "Usertable4 [peoviolatname=" + peoviolatname + ", peoviolatcompany=" + peoviolatcompany
				+ ", peoviolatdata=" + peoviolatdata + "]";
	}
	
	

}

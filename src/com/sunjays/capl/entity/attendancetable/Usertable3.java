package com.sunjays.capl.entity.attendancetable;

public class Usertable3 {
	
	private int peoallpeo;//人_登记出勤人数
	private int peofactpeo;//人_实际出勤人数
	private String peoalllabor;//人_总工时
	private String peofactlabor;//人_实际工时
	private int peoviolatnumber;//人_违章人数
	private String peoviolattime;//人_违章时段(重复最高)
	private String peoviolatrepeatdata;//人_违章类型(重复最高)
	public int getPeoallpeo() {
		return peoallpeo;
	}
	public void setPeoallpeo(int peoallpeo) {
		this.peoallpeo = peoallpeo;
	}
	public int getPeofactpeo() {
		return peofactpeo;
	}
	public void setPeofactpeo(int peofactpeo) {
		this.peofactpeo = peofactpeo;
	}
	public String getPeoalllabor() {
		return peoalllabor;
	}
	public void setPeoalllabor(String peoalllabor) {
		this.peoalllabor = peoalllabor;
	}
	public String getPeofactlabor() {
		return peofactlabor;
	}
	public void setPeofactlabor(String peofactlabor) {
		this.peofactlabor = peofactlabor;
	}
	public int getPeoviolatnumber() {
		return peoviolatnumber;
	}
	public void setPeoviolatnumber(int peoviolatnumber) {
		this.peoviolatnumber = peoviolatnumber;
	}
	public String getPeoviolattime() {
		return peoviolattime;
	}
	public void setPeoviolattime(String peoviolattime) {
		this.peoviolattime = peoviolattime;
	}
	public String getPeoviolatrepeatdata() {
		return peoviolatrepeatdata;
	}
	public void setPeoviolatrepeatdata(String peoviolatrepeatdata) {
		this.peoviolatrepeatdata = peoviolatrepeatdata;
	}
	@Override
	public String toString() {
		return "Usertable3 [peoallpeo=" + peoallpeo + ", peofactpeo=" + peofactpeo + ", peoalllabor=" + peoalllabor
				+ ", peofactlabor=" + peofactlabor + ", peoviolatnumber=" + peoviolatnumber + ", peoviolattime="
				+ peoviolattime + ", peoviolatrepeatdata=" + peoviolatrepeatdata + "]";
	}
	
	
	

}

package com.sunjays.capl.entity;

public class AttendanceTimeVo {
	
	private String starttime;
	
	private String stoptime;
	
	private String year;
	
	private String monthly;
	
	private String qoq;
	
	private String m1;
	
	private String m2;
	
	private String m3;
	
	private String yearmonthly;
	
	private String violattime;
	
	private String company;
	
	

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getStoptime() {
		return stoptime;
	}

	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonthly() {
		return monthly;
	}

	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}

	public String getQoq() {
		return qoq;
	}

	public void setQoq(String qoq) {
		this.qoq = qoq;
	}

	public String getM1() {
		return m1;
	}

	public void setM1(String m1) {
		this.m1 = m1;
	}

	public String getM2() {
		return m2;
	}

	public void setM2(String m2) {
		this.m2 = m2;
	}

	public String getM3() {
		return m3;
	}

	public void setM3(String m3) {
		this.m3 = m3;
	}

	public String getYearmonthly() {
		return yearmonthly;
	}

	public void setYearmonthly(String yearmonthly) {
		this.yearmonthly = yearmonthly;
	}

	public String getViolattime() {
		return violattime;
	}

	public void setViolattime(String violattime) {
		this.violattime = violattime;
	}

	@Override
	public String toString() {
		return "AttendanceTimeVo [starttime=" + starttime + ", stoptime=" + stoptime + ", year=" + year + ", monthly="
				+ monthly + ", qoq=" + qoq + ", m1=" + m1 + ", m2=" + m2 + ", m3=" + m3 + ", yearmonthly=" + yearmonthly
				+ ", violattime=" + violattime + "]";
	}

	
}

package com.sunjays.capl.entity.attendancetable;

public class Cartable5 {
	
	private int vehallveh;//车_登记出勤
	private int vehfactveh;//车_实际出勤
	private String vehalllabor;//车_总工时
	private String vehfactlabor;//车_实际工时
	private int vehviolatnumber;//车_违章次数
	private String vehviolattime;//车_违章时段(重复最高)
	private String vehviolatrepeatdata;//车_违章类型(重复最高)
	private String vehmeanlicheng;//车_平均里程
	private String vehidlerate;//车_闲置率
	public int getVehallveh() {
		return vehallveh;
	}
	public void setVehallveh(int vehallveh) {
		this.vehallveh = vehallveh;
	}
	public int getVehfactveh() {
		return vehfactveh;
	}
	public void setVehfactveh(int vehfactveh) {
		this.vehfactveh = vehfactveh;
	}
	public String getVehalllabor() {
		return vehalllabor;
	}
	public void setVehalllabor(String vehalllabor) {
		this.vehalllabor = vehalllabor;
	}
	public String getVehfactlabor() {
		return vehfactlabor;
	}
	public void setVehfactlabor(String vehfactlabor) {
		this.vehfactlabor = vehfactlabor;
	}
	public int getVehviolatnumber() {
		return vehviolatnumber;
	}
	public void setVehviolatnumber(int vehviolatnumber) {
		this.vehviolatnumber = vehviolatnumber;
	}
	public String getVehviolattime() {
		return vehviolattime;
	}
	public void setVehviolattime(String vehviolattime) {
		this.vehviolattime = vehviolattime;
	}
	public String getVehviolatrepeatdata() {
		return vehviolatrepeatdata;
	}
	public void setVehviolatrepeatdata(String vehviolatrepeatdata) {
		this.vehviolatrepeatdata = vehviolatrepeatdata;
	}
	public String getVehmeanlicheng() {
		return vehmeanlicheng;
	}
	public void setVehmeanlicheng(String vehmeanlicheng) {
		this.vehmeanlicheng = vehmeanlicheng;
	}
	public String getVehidlerate() {
		return vehidlerate;
	}
	public void setVehidlerate(String vehidlerate) {
		this.vehidlerate = vehidlerate;
	}
	@Override
	public String toString() {
		return "Cartable5 [vehallveh=" + vehallveh + ", vehfactveh=" + vehfactveh + ", vehalllabor=" + vehalllabor
				+ ", vehfactlabor=" + vehfactlabor + ", vehviolatnumber=" + vehviolatnumber + ", vehviolattime="
				+ vehviolattime + ", vehviolatrepeatdata=" + vehviolatrepeatdata + ", vehmeanlicheng=" + vehmeanlicheng
				+ ", vehidlerate=" + vehidlerate + "]";
	}
	
	
	

}

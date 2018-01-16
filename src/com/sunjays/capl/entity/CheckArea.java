package com.sunjays.capl.entity;

import java.util.Date;

public class CheckArea {
    private Integer wkid;

    private String unitpart;

    private Date creattime;

    private String gps1;

    private String gps2;

    private String gps3;

    private String gps4;

    private String remark;//备注

    private String remark1;//备用

    private Integer flag;

    public Integer getWkid() {
        return wkid;
    }

    public void setWkid(Integer wkid) {
        this.wkid = wkid;
    }

    public String getUnitpart() {
        return unitpart;
    }

    public void setUnitpart(String unitpart) {
        this.unitpart = unitpart;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getGps1() {
        return gps1;
    }

    public void setGps1(String gps1) {
        this.gps1 = gps1;
    }

    public String getGps2() {
        return gps2;
    }

    public void setGps2(String gps2) {
        this.gps2 = gps2;
    }

    public String getGps3() {
        return gps3;
    }

    public void setGps3(String gps3) {
        this.gps3 = gps3;
    }

    public String getGps4() {
        return gps4;
    }

    public void setGps4(String gps4) {
        this.gps4 = gps4;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

	@Override
	public String toString() {
		return "CheckArea [wkid=" + wkid + ", unitpart=" + unitpart + ", creattime=" + creattime + ", gps1=" + gps1
				+ ", gps2=" + gps2 + ", gps3=" + gps3 + ", gps4=" + gps4 + ", remark=" + remark + ", remark1=" + remark1
				+ ", flag=" + flag + "]";
	}
    
}
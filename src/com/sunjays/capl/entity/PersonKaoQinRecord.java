package com.sunjays.capl.entity;

import java.util.Date;

public class PersonKaoQinRecord {
    private Long pkqid;

    private Integer personid;

    private Float shijiWorktime;

    private Date kqTime;

    private String remark1;

    private String remark2;

    private String flag;
    
    private PersonsInfo personsInfo;
    
    private ZoneInfo zoneInfo;
    
    

    public ZoneInfo getZoneInfo() {
		return zoneInfo;
	}

	public void setZoneInfo(ZoneInfo zoneInfo) {
		this.zoneInfo = zoneInfo;
	}

	public PersonsInfo getPersonsInfo() {
		return personsInfo;
	}

	public void setPersonsInfo(PersonsInfo personsInfo) {
		this.personsInfo = personsInfo;
	}

	public Long getPkqid() {
        return pkqid;
    }

    public void setPkqid(Long pkqid) {
        this.pkqid = pkqid;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public Float getShijiWorktime() {
        return shijiWorktime;
    }

    public void setShijiWorktime(Float shijiWorktime) {
        this.shijiWorktime = shijiWorktime;
    }

    public Date getKqTime() {
        return kqTime;
    }

    public void setKqTime(Date kqTime) {
        this.kqTime = kqTime;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
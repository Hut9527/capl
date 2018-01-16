package com.sunjays.capl.entity;

public class ZUClink {
    private Integer id;

    private Integer zId;

    private Integer uId;

    private Integer cId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getzId() {
        return zId;
    }

    public void setzId(Integer zId) {
        this.zId = zId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

	@Override
	public String toString() {
		return "ZUClink [id=" + id + ", zId=" + zId + ", uId=" + uId + ", cId=" + cId + "]";
	}
    
    
}
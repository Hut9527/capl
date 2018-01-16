package com.sunjays.capl.entity;

import java.util.List;

public class MonVo {
	
	private List<VehicleRawData> car;
	private List<PersonsRawData> peo;
	public List<VehicleRawData> getCar() {
		return car;
	}
	public void setCar(List<VehicleRawData> car) {
		this.car = car;
	}
	public List<PersonsRawData> getPeo() {
		return peo;
	}
	public void setPeo(List<PersonsRawData> peo) {
		this.peo = peo;
	}
	
	

}

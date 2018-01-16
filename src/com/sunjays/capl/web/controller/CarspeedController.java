package com.sunjays.capl.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunjays.capl.entity.UserUnit;
import com.sunjays.capl.entity.UserUnitExample;
import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.entity.VehicleInfoExample;
import com.sunjays.capl.entity.VehicleRawData;
import com.sunjays.capl.entity.VehicleVo;
import com.sunjays.capl.service.UserUnitService;
import com.sunjays.capl.service.VehicleInfoService;
import com.sunjays.capl.service.VehicleRawDataService;

@Controller
@RequestMapping("carspeed")
public class CarspeedController {
	
	@Autowired
	private VehicleInfoService vehicleInfoService;
	@Autowired
	private VehicleRawDataService vehicleRawDataService;
	@Autowired
	private UserUnitService userUnitService;
	
	//跳转到车辆轨迹回放页面
	@RequestMapping("/goCarspeed.do")
	public String goCarspeed() {
		return "carspeed";
	}
	
	//获取所有单位名称
	@RequestMapping("/getCompany.do")
	@ResponseBody
	public List<UserUnit> getCompany(){
		
		//调用业务方法获取数据
		List<UserUnit> list = userUnitService.selectByExample(new UserUnitExample());
		
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	
	//通过单位查询出相应的设备代码
	@RequestMapping("/getVehicle.do")
	@ResponseBody
	public List<VehicleInfo> getDevId(VehicleInfo veh){
		
		//通过example查询相应数据
		VehicleInfoExample ve = new VehicleInfoExample();
		ve.or().andCompanyEqualTo(veh.getCompany());
		
		List<VehicleInfo> list = vehicleInfoService.selectByExample(ve);
		
		if(list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	
	//通过条件查询相应坐标
	@RequestMapping("/getCoord.do")
	@ResponseBody
	public List<VehicleRawData> getCoord(VehicleVo vo){
		
		//调用业务逻辑查询
		List<VehicleRawData> list = vehicleRawDataService.selectByVo(vo);
		
		if(list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

}

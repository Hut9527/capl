package com.sunjays.capl.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunjays.capl.entity.LatLng;
import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.PersonsInfoExample;
import com.sunjays.capl.entity.PersonsRawData;
import com.sunjays.capl.entity.PersonsVo;
import com.sunjays.capl.entity.UserUnit;
import com.sunjays.capl.entity.UserUnitExample;
import com.sunjays.capl.service.PersonsInfoService;
import com.sunjays.capl.service.PersonsRawDataService;
import com.sunjays.capl.service.UserUnitService;
import com.sunjays.capl.utils.GaodePointUtils;

@Controller
@RequestMapping("peoplespeed")
public class PeoplespeedController {
	
	@Autowired
	private UserUnitService userUnitService;
	@Autowired
	private PersonsInfoService personsInfoService;
	@Autowired
	private PersonsRawDataService personsRawDataService;
	
	//跳转到人员轨迹回放页面
	@RequestMapping("/goPeoplespeed.do")
	public String goPeoplespeed() {
		return "peoplespeed";
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
	
	//根据单位名称获取姓名
	@RequestMapping("/getName.do")
	@ResponseBody
	public List<PersonsInfo> getName(PersonsInfo personsInfo){
		
		//通过example查询相应数据
		PersonsInfoExample pe = new PersonsInfoExample();
		pe.or().andCompanyEqualTo(personsInfo.getCompany());
		
		List<PersonsInfo> list = personsInfoService.selectByExample(pe);
		
		if(list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	
	//通过条件查询相应坐标
	@RequestMapping("/getCoord.do")
	@ResponseBody
	public List<PersonsRawData> getCoord(PersonsVo vo){
		//调用业务逻辑查询
		List<PersonsRawData> list = personsRawDataService.selectByVo(vo);
		/*for (PersonsRawData personsRawData : list) {
			LatLng latLng = new LatLng(personsRawData.getLatitude().doubleValue(),personsRawData.getLongitude().doubleValue());
			LatLng transLatLng = GaodePointUtils.transformFromWGSToGCJ(latLng);
			//System.out.println(personsRawData.getLongitude()+","+personsRawData.getLatitude());
			//System.out.println("lineArr.push(["+transLatLng.getLongitude()+","+transLatLng.getLatitude()+"]);");
		}*/
		if(list.size() > 0) {
			
			return list;
		} else {
			return null;
		}
	}
	
}

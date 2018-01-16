package com.sunjays.capl.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunjays.capl.entity.MonVo;
import com.sunjays.capl.entity.PersonsRawData;
import com.sunjays.capl.entity.VehicleRawData;
import com.sunjays.capl.service.PersonsRawDataService;
import com.sunjays.capl.service.VehicleRawDataService;

@Controller
@RequestMapping("carpeomon")
public class CarPeoMonController {
	
	@Autowired
	private VehicleRawDataService vehicleRawDataService;
	@Autowired
	private PersonsRawDataService personsRawDataService;
	
	//跳转主页面
	@RequestMapping("/main.do")
	public String main() {
		return "carpeomon";
	}
	
	//获取所有数据
	@RequestMapping("/getAll.do")
	@ResponseBody
	public MonVo getAll() {
		MonVo monVo = new MonVo();
		
		//获取当前系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(new Date());
		
		//查詢出每人最新坐標放入集合中
		List<PersonsRawData> list = personsRawDataService.selectAll(format);
		//每最后一个坐标
		List<PersonsRawData> list2 = personsRawDataService.selectByLastTime();
		
		//判断是否有最新数据
		if(list.size() == 0) {
			for (int i = 0; i < list2.size(); i++) {
				list2.get(i).setRemark("离线");
			}
			monVo.setPeo(list2);
		} else {
			
			int s = list2.size() - list.size();
			if(s == 0) {
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setRemark("在线");
				}
				monVo.setPeo(list);
			} else {
				
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setRemark("在线");
				}
				
				//找出相同的Devid
				ArrayList<String> l1 = new ArrayList<String>();
				ArrayList<String> l2 = new ArrayList<String>();
				for (PersonsRawData personsRawData : list) {
					l1.add(personsRawData.getDevid());
				}
				for (PersonsRawData personsRawData : list2) {
					l2.add(personsRawData.getDevid());
				}
				//清除并把剩余不同的放入集合中
				l2.removeAll(l1);
				for (String string : l2) {
					for (PersonsRawData personsRawData : list2) {
						if(personsRawData.getDevid().equals(string)) {
							personsRawData.setRemark("离线");
							list.add(personsRawData);
						}
					}
				}
				
				monVo.setPeo(list);
			}
		}
		
		//每辆车最新坐标
		List<VehicleRawData> list3 = vehicleRawDataService.selectAll(format);
		//每辆车最后一个坐标
		List<VehicleRawData> list4 = vehicleRawDataService.selectByLastTime();
		
		//判断是否有最新数据
		if(list.size() == 0) {
			for (int i = 0; i < list2.size(); i++) {
				list2.get(i).setRemark("离线");
			}
			monVo.setCar(list4);
		} else {
			
			int s = list2.size() - list.size();
			if(s == 0) {
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setRemark("在线");
				}
				monVo.setCar(list3);
			} else {
				
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setRemark("在线");
				}
				
				//找出相同的Devid
				ArrayList<String> l1 = new ArrayList<String>();
				ArrayList<String> l2 = new ArrayList<String>();
				for (VehicleRawData vehicleRawData : list3) {
					l1.add(vehicleRawData.getDevid());
				}
				for (VehicleRawData vehicleRawData : list4) {
					l2.add(vehicleRawData.getDevid());
				}
				//清除并把剩余不同的放入集合中
				l2.removeAll(l1);
				for (String string : l2) {
					for (VehicleRawData vehicleRawData : list4) {
						if(vehicleRawData.getDevid().equals(string)) {
							vehicleRawData.setRemark("离线");
							list3.add(vehicleRawData);
						}
					}
				}
				
				monVo.setCar(list3);
			}
		}
		
		return monVo;
	}

}

package com.sunjays.capl.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.entity.VehicleInfoExample;
import com.sunjays.capl.entity.VehicleRawData;
import com.sunjays.capl.service.VehicleInfoService;
import com.sunjays.capl.service.VehicleRawDataService;

@Controller
@RequestMapping("carmon")
public class CarmonController {
	
	@Autowired
	private VehicleRawDataService vehicleRawDataService;
	@Autowired
	private VehicleInfoService vehicleInfoService;
	
	//跳转到车辆监控页面
	@RequestMapping("/vehcileMap.do")
	public String vehcileMap(){
		return "carmon";
	}
	
	//异步获取坐标数据返回到页面
	@RequestMapping("/getAll.do")
	@ResponseBody
	public List<VehicleRawData> getAll(){
		
		//获取当前系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(new Date());
		
		//每辆车最新坐标
		List<VehicleRawData> list = vehicleRawDataService.selectAll(format);
		//每辆车最后一个坐标
		List<VehicleRawData> list2 = vehicleRawDataService.selectByLastTime();
		
		//判断是否有最新数据
		if(list.size() == 0) {
			for (int i = 0; i < list2.size(); i++) {
				//查询车辆id放入集合
				VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(list2.get(i).getDevid());
				list2.get(i).setId(selectByDevid.getId());
				list2.get(i).setRemark("离线");
			}
			return list2;
		} else {
			
			int s = list2.size() - list.size();
			if(s == 0) {
				for (int i = 0; i < list.size(); i++) {
					//查询车辆id放入集合
					VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(list.get(i).getDevid());
					list.get(i).setId(selectByDevid.getId());
					list.get(i).setRemark("在线");
				}
				return list;
			} else {
				
				for (int i = 0; i < list.size(); i++) {
					//查询车辆id放入集合
					VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(list.get(i).getDevid());
					list.get(i).setId(selectByDevid.getId());
					list.get(i).setRemark("在线");
				}
				
				//找出相同的Devid
				ArrayList<String> l1 = new ArrayList<String>();
				ArrayList<String> l2 = new ArrayList<String>();
				for (VehicleRawData vehicleRawData : list) {
					l1.add(vehicleRawData.getDevid());
				}
				for (VehicleRawData vehicleRawData : list2) {
					l2.add(vehicleRawData.getDevid());
				}
				//清除并把剩余不同的放入集合中
				l2.removeAll(l1);
				for (String string : l2) {
					for (VehicleRawData vehicleRawData : list2) {
						if(vehicleRawData.getDevid().equals(string)) {
							VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(vehicleRawData.getDevid());
							vehicleRawData.setId(selectByDevid.getId());
							vehicleRawData.setRemark("离线");
							list.add(vehicleRawData);
						}
					}
				}
				
				return list;
			}
		}
		
	}
	
	//异步获取所有车辆信息
	@RequestMapping("/getVehinfo.do")
	@ResponseBody
	public List<VehicleInfo> getVehicleinfo(){
		//查询所有
		List<VehicleInfo> list3 = vehicleInfoService.selectByExample(new VehicleInfoExample());
		
		//获取当前系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(new Date());
		//每辆车最新坐标
		List<VehicleRawData> list = vehicleRawDataService.selectAll(format);
		
		//判断是否有最新数据
		if(list.size() == 0) {
			for (int i = 0; i < list3.size(); i++) {
				list3.get(i).setRemark("离线");
			}
			return list3;
		} else {
			for (int i = 0; i < list.size(); i++) {
				String devid = list.get(i).getDevid();
				for (int j = 0;j < list3.size();j++) {
					if(devid.equals(list3.get(j).getDevid())) {
						list3.get(j).setRemark("在线");
					}
				}
			}
			for (int j = 0;j < list3.size();j++) {
				if(!"在线".equals(list3.get(j).getRemark())) {
					list3.get(j).setRemark("离线");
				}
			}
			return list3;
		}
	}
	
	//根据车牌号查询信息
	@RequestMapping("/getVeh.do")
	@ResponseBody
	public List<VehicleRawData> getVeh(VehicleInfo vehicleInfo){
		
		//定义一个集合存放信息
		List<VehicleRawData> list = new ArrayList<VehicleRawData>();
		if(vehicleInfo.getVehicle().length() > 1) {
			String[] split = vehicleInfo.getVehicle().split(",");
			
			for (String string : split) {
				vehicleInfo.setGettime(new Date());
				vehicleInfo.setVehicle(string);
				VehicleRawData selectByVeh = vehicleRawDataService.selectByVeh(vehicleInfo);
			
				
				if(selectByVeh != null) {
					VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(selectByVeh.getDevid());
					selectByVeh.setId(selectByDevid.getId());
					selectByVeh.setRemark("在线");
					list.add(selectByVeh);
				} else {
					//没有最新数据就查询最后一个
					VehicleRawData selectByLastVeh = vehicleRawDataService.selectByLastVeh(string);
					VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(selectByLastVeh.getDevid());
					selectByLastVeh.setId(selectByDevid.getId());
					selectByLastVeh.setRemark("离线");
					list.add(selectByLastVeh);
				}
			}
		}
		
		if(list.size() > 0) {
			return list;
		} else {
			VehicleRawData vehicleRawData = new VehicleRawData();
			vehicleRawData.setId(0);
			list.add(vehicleRawData);
			return list;	
		}
	}
	
	//根据模糊信息查询
	@RequestMapping("/getVCSZ.do")
	@ResponseBody
	public List<VehicleRawData> getVCSZ(VehicleInfo vehicleInfo){
		
		//当前时间
		vehicleInfo.setGettime(new Date());
		
		//模糊查询最新坐标
		List<VehicleRawData> list = vehicleRawDataService.selectByLike(vehicleInfo);
		//模糊查询最后一个坐标
		List<VehicleRawData> list2 = vehicleRawDataService.selectByLastLike(vehicleInfo);
		
		//判断是否有最新数据
		if(list.size() == 0) {
			for (int i = 0; i < list2.size(); i++) {
				//查询车辆id放入集合
				VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(list2.get(i).getDevid());
				list2.get(i).setId(selectByDevid.getId());
				list2.get(i).setRemark("离线");
			}
			return list2;
		} else {
			
			int s = list2.size() - list.size();
			if(s == 0) {
				for (int i = 0; i < list.size(); i++) {
					//查询车辆id放入集合
					VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(list.get(i).getDevid());
					list.get(i).setId(selectByDevid.getId());
					list.get(i).setRemark("在线");
				}
				return list;
			} else {
				
				for (int i = 0; i < list.size(); i++) {
					//查询车辆id放入集合
					VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(list.get(i).getDevid());
					list.get(i).setId(selectByDevid.getId());
					list.get(i).setRemark("在线");
				}
				
				//找出相同的Devid
				ArrayList<String> l1 = new ArrayList<String>();
				ArrayList<String> l2 = new ArrayList<String>();
				for (VehicleRawData vehicleRawData : list) {
					l1.add(vehicleRawData.getDevid());
				}
				for (VehicleRawData vehicleRawData : list2) {
					l2.add(vehicleRawData.getDevid());
				}
				//清除并把剩余不同的放入集合中
				l2.removeAll(l1);
				for (String string : l2) {
					for (VehicleRawData vehicleRawData : list2) {
						if(vehicleRawData.getDevid().equals(string)) {
							VehicleInfo selectByDevid = vehicleInfoService.selectByDevid(vehicleRawData.getDevid());
							vehicleRawData.setId(selectByDevid.getId());
							vehicleRawData.setRemark("离线");
							list.add(vehicleRawData);
						}
					}
				}
				
				return list;
			}
		}
	}
	
}

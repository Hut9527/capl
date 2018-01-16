package com.sunjays.capl.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.PersonsInfoExample;
import com.sunjays.capl.entity.PersonsRawData;
import com.sunjays.capl.service.PersonsInfoService;
import com.sunjays.capl.service.PersonsRawDataService;

@Controller
@RequestMapping("peoplemon")
public class PeoplemonController {
	
	@Autowired
	private PersonsRawDataService personsRawDataService;
	@Autowired
	private PersonsInfoService personsInfoService;
	
	//跳转到人员定位
	@RequestMapping("/personMap.do")
	public String personMap(){
		return "peoplemon";
	}
	
	//异步获取坐标数据返回到页面
	@RequestMapping("/getAll.do")
	@ResponseBody
	public List<PersonsRawData> getAll(){
		
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
				PersonsInfoExample personsInfoExample = new PersonsInfoExample();
				personsInfoExample.or().andDevidEqualTo(list2.get(i).getDevid());
				List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
				list2.get(i).setId(selectByExample.get(0).getId());
				list2.get(i).setRemark("离线");
			}
			return list2;
		} else {
			
			int s = list2.size() - list.size();
			if(s == 0) {
				for (int i = 0; i < list.size(); i++) {
					PersonsInfoExample personsInfoExample = new PersonsInfoExample();
					personsInfoExample.or().andDevidEqualTo(list.get(i).getDevid());
					List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
					list.get(i).setId(selectByExample.get(0).getId());
					list.get(i).setRemark("在线");
				}
				return list;
			} else {
				
				for (int i = 0; i < list.size(); i++) {
					PersonsInfoExample personsInfoExample = new PersonsInfoExample();
					personsInfoExample.or().andDevidEqualTo(list.get(i).getDevid());
					List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
					list.get(i).setId(selectByExample.get(0).getId());
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
							PersonsInfoExample personsInfoExample = new PersonsInfoExample();
							personsInfoExample.or().andDevidEqualTo(personsRawData.getDevid());
							List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
							personsRawData.setId(selectByExample.get(0).getId());
							personsRawData.setRemark("离线");
							list.add(personsRawData);
						}
					}
				}
				
				return list;
			}
		}
	}
	
	//异步获取所有人员信息
	@RequestMapping("/getPeoinfo.do")
	@ResponseBody
	public List<PersonsInfo> getPeoinfo(){
		//查询所有
		List<PersonsInfo> list3 = personsInfoService.selectByExample(new PersonsInfoExample());
		
		//获取当前系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(new Date());
		
		//查詢出每人最新坐標
		List<PersonsRawData> list = personsRawDataService.selectAll(format);
		
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
	
	//checkbox根据手机号查询
	@RequestMapping("/getPhone.do")
	@ResponseBody
	public List<PersonsRawData> getPhone(PersonsInfo personsInfo){
		//定义一个集合存放返回信息
		List<PersonsRawData> list = new ArrayList<PersonsRawData>();
		if(personsInfo.getPhone().length() > 1) {
			String[] split = personsInfo.getPhone().split(",");
			
			for (String string : split) {
				personsInfo.setGettime(new Date());
				personsInfo.setPhone(string);
				PersonsRawData selectByPhone = personsRawDataService.selectByPhone(personsInfo);
				
				if(selectByPhone != null) {
					PersonsInfoExample personsInfoExample = new PersonsInfoExample();
					personsInfoExample.or().andDevidEqualTo(selectByPhone.getDevid());
					List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
					selectByPhone.setId(selectByExample.get(0).getId());
					selectByPhone.setRemark("在线");
					list.add(selectByPhone);
				} else {
					//没有最新数据就查询最后一个
					PersonsRawData selectByLastPhone = personsRawDataService.selectByLastPhone(string);
					PersonsInfoExample personsInfoExample = new PersonsInfoExample();
					personsInfoExample.or().andDevidEqualTo(selectByLastPhone.getDevid());
					List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
					selectByLastPhone.setId(selectByExample.get(0).getId());
					selectByLastPhone.setRemark("离线");
					list.add(selectByLastPhone);
				}
				
			}
		}
		
		if(list.size() > 0) {
			return list;
		} else {
			PersonsRawData personsRawData = new PersonsRawData();
			personsRawData.setId(0);
			list.add(personsRawData);
			return list;	
		}
	}
	
	
	//根据模糊信息查询
	@RequestMapping("/getNSJCZ.do")
	@ResponseBody
	public List<PersonsRawData> getNamSim(PersonsInfo personsInfo){
		//当前时间
		personsInfo.setGettime(new Date());
		
		//查询最新坐标
		List<PersonsRawData> list = personsRawDataService.selectByLike(personsInfo);
		//查询最后一个坐标
		List<PersonsRawData> list2 = personsRawDataService.selectByLastLike(personsInfo);
		
		//判断是否有最新数据
		if(list.size() == 0) {
			for (int i = 0; i < list2.size(); i++) {
				PersonsInfoExample personsInfoExample = new PersonsInfoExample();
				personsInfoExample.or().andDevidEqualTo(list2.get(i).getDevid());
				List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
				list2.get(i).setId(selectByExample.get(0).getId());
				list2.get(i).setRemark("离线");
			}
			return list2;
		} else {
			
			int s = list2.size() - list.size();
			if(s == 0) {
				for (int i = 0; i < list.size(); i++) {
					PersonsInfoExample personsInfoExample = new PersonsInfoExample();
					personsInfoExample.or().andDevidEqualTo(list.get(i).getDevid());
					List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
					list.get(i).setId(selectByExample.get(0).getId());
					list.get(i).setRemark("在线");
				}
				return list;
			} else {
				
				for (int i = 0; i < list.size(); i++) {
					PersonsInfoExample personsInfoExample = new PersonsInfoExample();
					personsInfoExample.or().andDevidEqualTo(list.get(i).getDevid());
					List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
					list.get(i).setId(selectByExample.get(0).getId());
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
							PersonsInfoExample personsInfoExample = new PersonsInfoExample();
							personsInfoExample.or().andDevidEqualTo(personsRawData.getDevid());
							List<PersonsInfo> selectByExample = personsInfoService.selectByExample(personsInfoExample);
							personsRawData.setId(selectByExample.get(0).getId());
							personsRawData.setRemark("离线");
							list.add(personsRawData);
						}
					}
				}
				
				return list;
			}
		}
	}
}

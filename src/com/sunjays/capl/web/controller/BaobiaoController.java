package com.sunjays.capl.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.CarAttendance;
import com.sunjays.capl.entity.UserAttendance;
import com.sunjays.capl.entity.UserCarAttendanceVo;
import com.sunjays.capl.entity.UserUnit;
import com.sunjays.capl.entity.UserUnitExample;
import com.sunjays.capl.service.CarAttendanceService;
import com.sunjays.capl.service.UserAttendanceService;
import com.sunjays.capl.service.UserUnitService;
import com.sunjays.capl.service.VehicleRawDataService;
import com.sunjays.capl.utils.AttendanceUtils;

@Controller
@RequestMapping("baobiao")
public class BaobiaoController {
	
	@Autowired
	private UserAttendanceService userService;
	@Autowired
	private CarAttendanceService carService;
	@Autowired
	private UserUnitService unitService;
	@Autowired
	private VehicleRawDataService vehicleService;//为了查询最早时间
	
	//跳转到周报表页面
	@RequestMapping("/goBaobiao.do")
	public String goWeekly(){
		return "weeklyReport";
	}
	
	@RequestMapping("/selectByTime.do")
	@ResponseBody
	public UserCarAttendanceVo selectByTime(AttendanceTimeVo time) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		int days = 0;
		//计算天数
		if(!time.getStarttime().equals("") && 
				!time.getStoptime().equals("")) {
			try {
				Date parse = sdf1.parse(time.getStoptime());
				Date parse2 = sdf1.parse(time.getStarttime());
				
				long diff = parse.getTime() - parse2.getTime();
				days = (int)(diff / (1000 * 60 * 60 * 24)); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(time.getStarttime().equals(""))	{
			try {
				Date parse = sdf1.parse(time.getStoptime());
				Date parse2 = vehicleService.selectByLastGetTime();
				
				long diff = parse.getTime() - parse2.getTime();
				days = (int)(diff / (1000 * 60 * 60 * 24)); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(time.getStoptime().equals(""))	{
			try {
				Date parse = new Date();
				Date parse2 = sdf1.parse(time.getStarttime());
				
				long diff = parse.getTime() - parse2.getTime();
				days = (int)(diff / (1000 * 60 * 60 * 24)); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//获取数据
		List<CarAttendance> car = carService.selectByTime(time);
		List<UserAttendance> user = userService.selectByTime(time);
		
		/* 人员违章  */
		//违章时段重复(1)
		UserAttendance selectByViolat1 = userService.selectByViolat1(time);
		if(selectByViolat1 != null) {
			time.setViolattime(selectByViolat1.getCurvetime());
		}
		//违章时段重复(2)
		List<UserAttendance> violatTime = userService.selectByViolat2(time);
		//违章类型重复(人员)
		String violatdate = userService.selectByViolatdate(time);
		
		/* 车辆违章  */
		//违章时段重复(1)
		CarAttendance selectByViolat12 = carService.selectByViolat1(time);
		if(selectByViolat12 != null) {
			time.setViolattime(selectByViolat12.getCurvetime());
		}
		//违章时段重复(2)
		List<CarAttendance> violatTime2 = carService.selectByViolat2(time);
		//违章类型重复(车辆)
		String violatdate2 = carService.selectByViolatdate(time);
		
		//计算整理数据
		UserCarAttendanceVo count = AttendanceUtils.count(car, user,days,
				violatTime,violatdate,violatTime2,violatdate2);
		
		return count;
	}
	
	//异步加载获取单位信息
	@RequestMapping("/getCompany.do")
	@ResponseBody
	public List<UserUnit> getCompany(){
		
		List<UserUnit> list = unitService.selectByExample(new UserUnitExample());
		
		if(list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
		
		
		
}

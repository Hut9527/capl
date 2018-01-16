package com.sunjays.capl.web.controller.baobiao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.CarAttendance;
import com.sunjays.capl.entity.UserAttendance;
import com.sunjays.capl.entity.UserCarAttendanceVo;
import com.sunjays.capl.service.CarAttendanceService;
import com.sunjays.capl.service.UserAttendanceService;
import com.sunjays.capl.utils.AttendanceUtils;

@Controller
@RequestMapping("quarter")
public class QuarterController {
	
	@Autowired
	private UserAttendanceService userService;
	@Autowired
	private CarAttendanceService carService;
	
	@RequestMapping("/goQuarter.do")
	public String goQuarter() {
		return "quarterReport";
	}
	
	@RequestMapping("/selectByTime.do")
	@ResponseBody
	public UserCarAttendanceVo selectByTime(AttendanceTimeVo time) {
		
		String qoq = time.getQoq();
		String year = time.getYear();
		if(qoq.equals("1")) {
			time.setM1(year + ".01");
			time.setM2(year + ".02");
			time.setM3(year + ".03");
		} else if (qoq.equals("2")) {
			time.setM1(year + ".04");
			time.setM2(year + ".05");
			time.setM3(year + ".06");
		} else if (qoq.equals("3")) {
			time.setM1(year + ".07");
			time.setM2(year + ".08");
			time.setM3(year + ".09");
		} else {
			time.setM1(year + ".10");
			time.setM2(year + ".11");
			time.setM3(year + ".12");
		}
		time.setYear("");
		
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
		UserCarAttendanceVo count = AttendanceUtils.count(car, user,90,
				violatTime,violatdate,violatTime2,violatdate2);
		
		return count;
	}
	

}

package com.sunjays.capl.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sunjays.capl.entity.CarAttendance;
import com.sunjays.capl.entity.UserAttendance;
import com.sunjays.capl.entity.UserCarAttendanceVo;
import com.sunjays.capl.entity.attendancetable.Cartable1;
import com.sunjays.capl.entity.attendancetable.Cartable5;
import com.sunjays.capl.entity.attendancetable.Cartable6;
import com.sunjays.capl.entity.attendancetable.Cartable7;
import com.sunjays.capl.entity.attendancetable.Summarytable8;
import com.sunjays.capl.entity.attendancetable.Usertable2;
import com.sunjays.capl.entity.attendancetable.Usertable3;
import com.sunjays.capl.entity.attendancetable.Usertable4;

public class AttendanceUtils {
	
	
	//计算考勤表
	public static UserCarAttendanceVo count(List<CarAttendance> car,
			List<UserAttendance> user,int a,List<UserAttendance> violatTime,
			String violatdate,List<CarAttendance> violatTime2,String violatdate2) {
		
		int factpeo = 0;
		int zongpeo = user.size();
		int zongcar = car.size();
		double zonglicheng = 0.0;
		int factcar = 0;
		double factLabor = 0.0;
		double factLabor2 = 0.0;
		int idlenumber = 0;
		//创建所有表对象
		UserCarAttendanceVo userCarAttendanceVo = new UserCarAttendanceVo();
		Usertable3 usertable3 = new Usertable3();
		Cartable5 cartable5 = new Cartable5();
		Summarytable8 summarytable8 = new Summarytable8();
		//需要的集合
		List<Cartable1> tab1 = new ArrayList<Cartable1>();
		List<Usertable2> tab2 = new ArrayList<Usertable2>();
		List<Usertable4> tab4 = new ArrayList<Usertable4>();
		List<Cartable6> tab6 = new ArrayList<Cartable6>();
		List<Cartable7> tab7 = new ArrayList<Cartable7>();
		
		
		/*table1  车辆考勤*/
		for (CarAttendance carA : car) {
			
			//判断是否null
			if(carA != null) {
				
				Cartable1 cartable1 = new Cartable1();
				cartable1.setVehicle(carA.getVehicle());
				cartable1.setVehcurvetime(carA.getCurvetime());
				cartable1.setVehattendance(carA.getAttendance());
				cartable1.setVehworktime(carA.getWorktime());
				cartable1.setVehworkkm(carA.getWorkkm());
				cartable1.setVehremark(carA.getRemark());
				tab1.add(cartable1);
				
				//实际出勤工时
				factLabor2 += Double.parseDouble(carA.getRemark2());
				//总里程
				double licheng = Double.parseDouble(carA.getWorkkm());
				zonglicheng += licheng;
				
				//判断是否闲置
				if(licheng > 40) {
					idlenumber += 1;
					
					/*table7 闲置车辆统计 */
					Cartable7 cartable7 = new Cartable7();
					cartable7.setVehidlevehicle(carA.getVehicle());
					cartable7.setVehidlecompany(carA.getCompany());
					cartable7.setVehidletime(carA.getCurvetime());
					if (carA.getAttendance().equals("正常")) {
						cartable7.setVehidledata("未完成任务");
					} else {
						cartable7.setVehidledata(carA.getAttendance());
					}
					
					tab7.add(cartable7);
				}
				
				//判断是否违章
				if (!carA.getAttendance().equals("正常")) {
					
					/*table6  违章车辆统计*/
					Cartable6 cartable6 = new Cartable6();
					cartable6.setVehviolatvehicle(carA.getVehicle());
					cartable6.setVehviolatcompany(carA.getCompany());
					cartable6.setVehviolatdata(carA.getAttendance());
					cartable6.setVehviolattime(carA.getCurvetime());
					tab6.add(cartable6);
				}
				
				//判断是否正常出勤
				if (carA.getAttendance().equals("正常") ||
						carA.getAttendance().equals("迟到")) {
					factcar+=1;
				}
			}
			
		}
		
		
		/*table2  人员考勤*/
		for (UserAttendance userA : user) {
			
			//判断是否是null
			if(userA != null) {
				
				Usertable2 usertable2 = new Usertable2();
				usertable2.setPeojobnumber(userA.getJobnumber());
				usertable2.setPeoname(userA.getName());
				usertable2.setPeocompany(userA.getCompany());
				usertable2.setPeocurvetime(userA.getCurvetime());
				usertable2.setPeoattendance(userA.getAttendance());
				usertable2.setPeoworktime(userA.getWorktime());
				tab2.add(usertable2);
				
				//实际出勤工时
				factLabor += Double.parseDouble(userA.getRemark());
				
				//判断是否违章
				if (!userA.getAttendance().equals("正常")) {
					
					/*table4  违章人员统计*/
					Usertable4 usertable4 = new Usertable4();
					usertable4.setPeoviolatname(userA.getName());
					usertable4.setPeoviolatcompany(userA.getCompany());
					usertable4.setPeoviolatdata(userA.getAttendance());
					usertable4.setPeoviolattime(userA.getCurvetime());
					tab4.add(usertable4);
				}
				
				//判断是否正常出勤
				if (userA.getAttendance().equals("正常") ||
						userA.getAttendance().equals("迟到")) {
					factpeo+=1;
				}
				
			}
			
		}
		
		
		/*table3  人员统计*/
		usertable3.setPeoallpeo(zongpeo);//登记出勤人数
		usertable3.setPeofactpeo(factpeo);//实际出勤人数
		//总工时
		String alllabor = zongpeo*a*9 + "";
		usertable3.setPeoalllabor(alllabor);
		//实际工时
		String factlabor = factLabor + "";
		usertable3.setPeofactlabor(factlabor);
		usertable3.setPeoviolatnumber(zongpeo - factpeo);//违章人员数
		//违章重复最高时段
		String vTime = "";
		if(violatTime.size() > 0) {
			String vTime1 = violatTime.get(0).getCurvetime().substring(0, 10);
			String vTime2 = violatTime.get(0).getWorktime().substring(0, 2);
			String vTime3 = violatTime.get(violatTime.size()-1).getCurvetime().substring(11, 21);
			String vTime4 = violatTime.get(violatTime.size()-1).getWorktime().substring(9, 11);
			vTime = vTime1 + " " + vTime2 + "时  至  " + vTime3 + " " + vTime4 + "时";
		}
		usertable3.setPeoviolattime(vTime);
		//违章重复最高类型
		usertable3.setPeoviolatrepeatdata(violatdate);
		
		
		/*table5  车辆统计表*/
		cartable5.setVehallveh(zongcar);//登记出勤车
		cartable5.setVehfactveh(factcar);//实际出勤车
		//总工时
		String alllabor2 = zongcar*a*9 + "";
		cartable5.setVehalllabor(alllabor2);
		//实际工时
		String factlabor2 = factLabor2 + "";
		cartable5.setVehfactlabor(factlabor2);
		cartable5.setVehviolatnumber(zongcar - factcar);//违章车数
		//违章重复最高时段
		String cTime = "";
		if(violatTime2.size() > 0) {
			String cTime1 = violatTime2.get(0).getCurvetime().substring(0, 10);
			String cTime2 = violatTime2.get(0).getWorktime().substring(0, 2);
			String cTime3 = violatTime2.get(violatTime2.size()-1).getCurvetime().substring(11, 21);
			String cTime4 = violatTime2.get(violatTime2.size()-1).getWorktime().substring(9, 11);
			cTime = cTime1 + " " + cTime2 + "时  至  " + cTime3 + " " + cTime4 + "时";
		}
		cartable5.setVehviolattime(cTime);
		//违章重复最高类型
		cartable5.setVehviolatrepeatdata(violatdate2);
		//平均里程
		String meanlicheng = "";
		try {
			if(zonglicheng != 0.0 && factLabor2 != 0.0) {
				meanlicheng = new BigDecimal(zonglicheng/factLabor2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		cartable5.setVehmeanlicheng(meanlicheng);
		//闲置率
		String idlerate = "0";
		try {
			if(idlenumber != 0 && zongcar != 0) {
				idlerate = new BigDecimal((double)idlenumber/(double)zongcar).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()*100 + "";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		cartable5.setVehidlerate(idlerate);
		
		
		/* table8  总结段落  */
		//总人员
		summarytable8.setPeoallpeo(zongpeo);
		//实际出勤人员
		summarytable8.setPeofactpeo(factpeo);
		//出勤率
		String peoattend = "0";
		try {
			if(factpeo != 0 && zongpeo != 0) {
				peoattend = new BigDecimal((double)factpeo/(double)zongpeo).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()*100 + "";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		summarytable8.setPeoattendancerate(peoattend);
		//出勤人员易发生违章时间段
		summarytable8.setPeoviolattime(vTime);
		//人员违章类型
		summarytable8.setPeoviolatrepeatdata(violatdate);
		
		//总车辆
		summarytable8.setVehallveh(zongcar);
		//出勤车辆
		summarytable8.setVehfactveh(factcar);
		//出勤率
		String vehattend = "0";
		try {
			if(factcar != 0 && zongcar != 0) {
				vehattend =  new BigDecimal((double)factcar/(double)zongcar).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()*100 + "";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		summarytable8.setVehattendancerate(vehattend);
		
		//违章时段
		summarytable8.setVehviolattime(cTime);
		//违章类型
		summarytable8.setVehviolatrepeatdata(violatdate2);
		//车闲置率
		summarytable8.setVehidlerate(idlerate);
		
		//放入总类
		userCarAttendanceVo.setCartable1(tab1);
		userCarAttendanceVo.setUsertable2(tab2);
		userCarAttendanceVo.setUsertable3(usertable3);
		userCarAttendanceVo.setUsertable4(tab4);
		userCarAttendanceVo.setCartable5(cartable5);
		userCarAttendanceVo.setCartable6(tab6);
		userCarAttendanceVo.setCartable7(tab7);
		userCarAttendanceVo.setSummarytable8(summarytable8);
		return userCarAttendanceVo;
	}
	

}

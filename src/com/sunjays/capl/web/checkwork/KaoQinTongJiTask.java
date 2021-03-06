package com.sunjays.capl.web.checkwork;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sunjays.capl.dao.CarKaoQinRecordMapper;
import com.sunjays.capl.dao.PersonKaoQinRecordMapper;
import com.sunjays.capl.dao.PersonsInfoMapper;
import com.sunjays.capl.dao.PersonsRawDataMapper;
import com.sunjays.capl.dao.VehicleInfoMapper;
import com.sunjays.capl.dao.VehicleRawDataMapper;
import com.sunjays.capl.entity.Area;
import com.sunjays.capl.entity.CarAttendance;
import com.sunjays.capl.entity.CarKaoQinRecord;
import com.sunjays.capl.entity.PersonKaoQinRecord;
import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.PersonsInfoExample;
import com.sunjays.capl.entity.PersonsRawData;
import com.sunjays.capl.entity.UserAttendance;
import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.entity.VehicleInfoExample;
import com.sunjays.capl.entity.VehicleRawData;
import com.sunjays.capl.entity.ZoneInfo;
import com.sunjays.capl.service.CarAttendanceService;
import com.sunjays.capl.service.UserAttendanceService;
import com.sunjays.capl.service.ZoneInfoService;
import com.sunjays.capl.utils.HttpClientUtil;
import com.sunjays.capl.utils.PointUtils;

import net.sf.json.JSONObject;

@Component 
public class KaoQinTongJiTask {
	
	@Resource
	private VehicleInfoMapper vehicleInfoMapper;
	
	@Resource
	private PersonsInfoMapper personsInfoMapper;
	@Resource
	private PersonsRawDataMapper personsRawDataMapper;
	@Resource
	private VehicleRawDataMapper vehicleRawDataMapper;
	@Resource
	private CarKaoQinRecordMapper carKaoQinRecordMapper;
	@Resource
	private PersonKaoQinRecordMapper personKaoQinRecordMapper;
	@Autowired
	private ZoneInfoService zoneService;
	@Autowired
	private UserAttendanceService userService;
	@Autowired
	private CarAttendanceService carService;
	
	@Scheduled(cron="0 0 0 * * ? ") //每天晚上12点
	public void taskCycle() throws ParseException{ 
		Calendar c = Calendar.getInstance();
		String time = c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+(c.get(Calendar.DATE)-1);
		String starttime = time+" "+"00:00:00";
		String endtime = time+" "+"59:59:59";
		
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currenttime = sDateFormat.parse(time);
		Map<String, Object> sqlmap = new HashMap<>();
		
		//从rawdata数据库查找,根据设备编号,开始结束时间,状态(正常)       车辆
		List<VehicleInfo> carDevids = vehicleInfoMapper.selectAllCarDevid();
		List<VehicleRawData> carKaoQinByMap = null;
		CarKaoQinRecord carKaoQinRecord = new CarKaoQinRecord();
		for (int i = 0; i < carDevids.size(); i++) {
			VehicleInfo veh = carDevids.get(i);
			
			sqlmap.put("starttime", "2018-01-05 00:00:00");
			sqlmap.put("endtime", "2018-01-05 23:59:59");
			sqlmap.put("devid", veh.getDevid());
			sqlmap.put("remark", "正常");
			carKaoQinByMap = vehicleRawDataMapper.recordCarKaoQinByMap(sqlmap);
			if (carKaoQinByMap.size()>0) {
				carKaoQinRecord.setCarid(veh.getId());
				float seconds=carKaoQinByMap.size();
				float hour=seconds/(60*60);//换成天,精确到     .0
		        BigDecimal bg = new BigDecimal(hour);
		        float shijiWorktime = bg.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
		        carKaoQinRecord.setShijiWorktime(shijiWorktime);
				carKaoQinRecord.setCarid(veh.getId());
				carKaoQinRecord.setKqTime(currenttime);
				carKaoQinRecord.setRemark1("");
				carKaoQinRecord.setRemark2("");
				carKaoQinRecord.setFlag("");
				carKaoQinRecordMapper.insert(carKaoQinRecord);
			}
		}
		
		//从rawdata数据库查找,根据设备编号,开始结束时间,状态(正常)       人员
		List<PersonsInfo> personDevids = personsInfoMapper.selectAllPersonDevid();
		List<PersonsRawData> personKaoQinByMap = null;
		PersonKaoQinRecord perKaoQinRecord = new PersonKaoQinRecord();
		for (int i = 0; i < personDevids.size(); i++) {
			PersonsInfo peo = personDevids.get(i);
			sqlmap.put("starttime", "2018-01-05 00:00:00");
			sqlmap.put("endtime", "2018-01-05 23:59:59");
			sqlmap.put("devid", peo.getDevid());
			sqlmap.put("remark", "正常");
			personKaoQinByMap = personsRawDataMapper.recordPersonKaoQinByMap(sqlmap);
			if (personKaoQinByMap.size()>0) {
				perKaoQinRecord.setPersonid(peo.getId());
				float seconds=personKaoQinByMap.size();
				float hour=seconds/(60*60);//换成小时,精确到     .0
		        BigDecimal bg = new BigDecimal(hour);
		        float shijiWorktime = bg.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
		        perKaoQinRecord.setShijiWorktime(shijiWorktime);
		        perKaoQinRecord.setPersonid(peo.getId());
		        perKaoQinRecord.setKqTime(currenttime);
		        perKaoQinRecord.setRemark1("");
		        perKaoQinRecord.setRemark2("");
		        perKaoQinRecord.setFlag("");
				carKaoQinRecordMapper.insert(carKaoQinRecord);
			}
		}
		
	} 
	
	/**
	 * 报表统计
	 */
	@Scheduled(cron="0 0 0 * * ? ")
	public void baobiao() {
		//查询需要统计的车辆与人员数据
		List<PersonsInfo> allpeo = personsInfoMapper.selectByExample(new PersonsInfoExample());
		List<VehicleInfo> allveh = vehicleInfoMapper.selectByExample(new VehicleInfoExample());
		PersonsRawData peo = new PersonsRawData();
		VehicleRawData veh = new VehicleRawData();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		for (PersonsInfo pi : allpeo) {
			peo.setName(pi.getName());
			peo.setGettime(new Date());
			List<PersonsRawData> pf = personsRawDataMapper.selectByFlag(peo);
			//有数据的话就放入考勤表
			if(pf.size() > 0) {
				Date time = pf.get(0).getGettime();
				Date time2 = pf.get(pf.size()-1).getGettime();
				
				int on = time.getHours();
				int off = time2.getHours();
				int ontime = Integer.valueOf(pi.getOntime().substring(0, 2));
				int offtime = Integer.valueOf(pi.getOfftime().substring(0, 2));
				
				if(on > ontime || off < offtime) {
					//迟到
					UserAttendance userAttendance = new UserAttendance();
					userAttendance.setAttendance("迟到");
					userAttendance.setUid(pi.getId());
					userAttendance.setCurvetime(sdf1.format(time)+"-"+
					sdf1.format(time2));
					userAttendance.setWorktime(sdf2.format(time)+"-"+
					sdf2.format(time2));
					String remark = "0";
					try {
						remark = new BigDecimal((double)pf.size()/3600.0).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
					} catch (Exception e) {
						// TODO: handle exception
					}
					userAttendance.setRemark(remark);
					
					userService.insertSelective(userAttendance);
				} else {
					//正常
					UserAttendance userAttendance = new UserAttendance();
					userAttendance.setAttendance("正常");
					userAttendance.setUid(pi.getId());
					userAttendance.setCurvetime(sdf1.format(time)+"-"+
					sdf1.format(time2));
					userAttendance.setWorktime(sdf2.format(time)+"-"+
					sdf2.format(time2));
					String remark = "0";
					try {
						remark = new BigDecimal((double)pf.size()/3600.0).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
					} catch (Exception e) {
						// TODO: handle exception
					}
					userAttendance.setRemark(remark);
					
					userService.insertSelective(userAttendance);
				}
			} else {
				//缺勤
				UserAttendance userAttendance = new UserAttendance();
				userAttendance.setAttendance("缺勤");
				userAttendance.setUid(pi.getId());
				userAttendance.setWorktime("09:00:00-18:00:00");
				userAttendance.setCurvetime(sdf1.format(new Date())+"-"+
				sdf1.format(new Date()));
				userAttendance.setRemark("0");
				userService.insertSelective(userAttendance);
			}
			
			//统计完成后添加标识
			personsRawDataMapper.updateFlag(pi.getName());
		}
		for (VehicleInfo vi : allveh) {
			veh.setGettime(new Date());
			veh.setVehicle(vi.getVehicle());
			List<VehicleRawData> vf = vehicleRawDataMapper.selectByFlag(veh);
			//有数据的话就放入考勤表
			if(vf.size() > 0) {
				Date time = vf.get(0).getGettime();
				Date time2 = vf.get(vf.size()-1).getGettime();
				
				int on = time.getHours();
				int off = time2.getHours();
				int ontime = Integer.valueOf(vi.getOntime().substring(0, 2));
				int offtime = Integer.valueOf(vi.getOfftime().substring(0, 2));
				
				
				//计算工作里程
				double licheng = 0.0;
				for (int i = 0; i < vf.size()-1; i++) {
					double lng1 = vf.get(i).getLongitude().doubleValue();
					double lat1 = vf.get(i).getLatitude().doubleValue();
					double lng2 = vf.get(i+1).getLongitude().doubleValue();
					double lat2 = vf.get(i+1).getLatitude().doubleValue();
					licheng+=PointUtils.Distance(lng1, lat1, lng2, lat2);
				}
				
				if(on > ontime || off < offtime) {
					//迟到
					CarAttendance carAttendance = new CarAttendance();
					carAttendance.setCid(vi.getId());
					carAttendance.setAttendance("迟到");
					carAttendance.setCurvetime(sdf1.format(time)+"-"+
					sdf1.format(time2));
					carAttendance.setWorktime(sdf2.format(time)+"-"+
					sdf2.format(time2));
					String remark2 = "0";
					try {
						remark2 = new BigDecimal((double)vf.size()/3600.0).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
					} catch (Exception e) {
						// TODO: handle exception
					}
					carAttendance.setRemark2(remark2);
					carAttendance.setWorkkm(licheng/1000+"");
					
					carService.insertSelective(carAttendance);	
				} else {
					//正常
					CarAttendance carAttendance = new CarAttendance();
					carAttendance.setCid(vi.getId());
					carAttendance.setAttendance("正常");
					carAttendance.setCurvetime(sdf1.format(time)+"-"+
					sdf1.format(time2));
					carAttendance.setWorktime(sdf2.format(time)+"-"+
					sdf2.format(time2));
					String remark2 = "0";
					try {
						remark2 = new BigDecimal((double)vf.size()/3600.0).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
					} catch (Exception e) {
						// TODO: handle exception
					}
					carAttendance.setRemark2(remark2);
					carAttendance.setWorkkm(licheng/1000+"");
					
					carService.insertSelective(carAttendance);
					
				}
			} else {
				//缺勤
				CarAttendance carAttendance = new CarAttendance();
				carAttendance.setCid(vi.getId());
				carAttendance.setAttendance("缺勤");
				carAttendance.setWorktime("09:00:00-18:00:00");
				carAttendance.setCurvetime(sdf1.format(new Date())+"-"+
				sdf1.format(new Date()));
				carAttendance.setRemark("0");
				carAttendance.setWorkkm("0");
				carService.insertSelective(carAttendance);
			}
			
			//统计完成后添加标识
			vehicleRawDataMapper.updateFlag(vi.getVehicle());
		}
		
	}
	
	/**
	 * 测试:
	 *  调用接口向数据库传递坐标
	 * @param info
	 * @return
	 */
	@Scheduled(cron="59/60 * * * * ? ")
	public void setRawData() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Map<String, String> param = new HashMap<>();
		param.put("veh_list", "[1592]");
		String json1=HttpClientUtil.doPost("http://121.41.129.49/api/Server/position/Veh_data/get_last_veh_data", param);
		
		if(json1.length() > 20) {
			JSONObject jsonObject = JSONObject.fromObject(json1); 
			JSONObject jsonObject2 = jsonObject.getJSONObject("1592");
			String lat = jsonObject2.getString("lat");
			String lng = jsonObject2.getString("lng");
			String gettime = jsonObject2.getString("gps_time");
			String devid = jsonObject2.getString("plate");
			
			//创建对象存入查询到的数据放入数据库
			PersonsRawData peo = new PersonsRawData();
			peo.setDevid(devid);
			peo.setName("乔伟力");
			peo.setLongitude(new BigDecimal(lng));
			peo.setLatitude(new BigDecimal(lat));
			Date time = null;
			try {
				time = sdf.parse(gettime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			peo.setGettime(time);
			peo.setSimnumber("18966555245");
			peo.setPhone("18939333086");
			
			//当前状态
			ZoneInfo selectByName = zoneService.selectByName("乔伟力");
			List<Area> zone = zone(selectByName);
			
			Area area = new Area(Double.valueOf(lng),
					Double.valueOf(lat));
			Boolean bo = PointUtils.isPointInPolygon(area, zone);
			
			if(bo) {
				peo.setRemark("正常");
			} else {
				peo.setRemark("工作区域之外");
			}
			
			personsRawDataMapper.insertSelective(peo);
		}
	}
	
	public List<Area> zone(ZoneInfo info){
		
		List<Area> areaList = new ArrayList<Area>();
		
		if (info != null) {
			String[] gps1 = info.getGps1().split(",");
			String[] gps2 = info.getGps2().split(",");
			String[] gps3 = info.getGps3().split(",");
			String[] gps4 = info.getGps4().split(",");
			String[] gps5 = info.getGps5().split(",");
			String[] gps6 = info.getGps6().split(",");
			
			if(gps1.length > 1) {
				double g1 = Double.parseDouble(gps1[0]);
				double g2 = Double.parseDouble(gps1[1]);
				areaList.add(new Area(g1,g2));
			}
			if(gps2.length > 1) {
				double g1 = Double.parseDouble(gps2[0]);
				double g2 = Double.parseDouble(gps2[1]);
				areaList.add(new Area(g1,g2));
			}
			if(gps3.length > 1) {
				double g1 = Double.parseDouble(gps3[0]);
				double g2 = Double.parseDouble(gps3[1]);
				areaList.add(new Area(g1,g2));
			}
			if(gps4.length > 1) {
				double g1 = Double.parseDouble(gps4[0]);
				double g2 = Double.parseDouble(gps4[1]);
				areaList.add(new Area(g1,g2));
			}
			if(gps5.length > 1) {
				double g1 = Double.parseDouble(gps5[0]);
				double g2 = Double.parseDouble(gps5[1]);
				areaList.add(new Area(g1,g2));
			}
			if(gps6.length > 1) {
				double g1 = Double.parseDouble(gps6[0]);
				double g2 = Double.parseDouble(gps6[1]);
				areaList.add(new Area(g1,g2));
			}
		}
		
		return areaList;
	}
}

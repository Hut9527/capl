package com.sunjays.capl.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunjays.capl.converter.Date2StringConverter;
import com.sunjays.capl.entity.CarKaoQinRecord;
import com.sunjays.capl.entity.CheckArea;
import com.sunjays.capl.entity.GpsVo;
import com.sunjays.capl.entity.PersonKaoQinRecord;
import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.UserCarMa;
import com.sunjays.capl.entity.UserCarMaExample;
import com.sunjays.capl.entity.UserUnit;
import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.service.CarKaoQinRecordService;
import com.sunjays.capl.service.CheckAreaService;
import com.sunjays.capl.service.PersonKaoQinRecordService;
import com.sunjays.capl.service.PersonsInfoService;
import com.sunjays.capl.service.UserCarMaService;
import com.sunjays.capl.service.UserUnitService;
import com.sunjays.capl.service.VehicleInfoService;
import com.sunjays.capl.utils.PageUtil;
import com.sunjays.capl.web.common.BaseController;

@Controller
@RequestMapping("/kaoqin")
public class KaoQinController extends BaseController{
	@Resource
	private CheckAreaService checkAreaService;
	@Resource
	private UserUnitService userunitService;
	@Resource
	private VehicleInfoService vehicleInfoService;
	@Resource
	private PersonsInfoService personsInfoService;
	@Resource
	private PersonKaoQinRecordService personKaoQinRecordService;
	@Resource
	private CarKaoQinRecordService carKaoQinRecordService;
	/**
	 * 去人员及车辆位置页面
	 * @return
	 */
	@RequestMapping("/toPcstation.do")
	public String toPcstation(Model model,HttpServletRequest request){
		//2,加载用户组列表
		List<UserUnit> unitList = userunitService.selectRoleList();
		model.addAttribute("unitList", unitList);
		//3,加载用户信息列表,分页加载
		pageParameter(request);
		PageHelper.orderBy("wkid desc");// 排序
		Page<CheckArea> page = PageHelper.startPage(pageNum,pageSize);
		List<CheckArea> list = checkAreaService.selectAllCheckAreaFenye();
				
		model.addAttribute("list",list);
		
		PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());
		model.addAttribute("page",pageutils);
		
		return "pcstation";
	}
	
	//保存gps坐标
	@RequestMapping("/saveGps.do")
	public String saveGps(GpsVo vo,CheckArea checkArea){
		String gps1 = vo.getLng1() + "," + vo.getLat1();
		String gps2 = vo.getLng2() + "," + vo.getLat2();
		String gps3 = vo.getLng3() + "," + vo.getLat3();
		String gps4 = vo.getLng4() + "," + vo.getLat4();
		
		checkArea.setGps1(gps1);
		checkArea.setGps2(gps2);
		checkArea.setGps3(gps3);
		checkArea.setGps4(gps4);
		checkArea.setFlag(0);
		
		checkAreaService.insertSelective(checkArea);
		return "redirect:toPcstation.do";
	}
	
	//删除gps数据
	@RequestMapping("/deleteGps.do")
	public String deleteGps(String wkid){
		String[] split = wkid.split(",");
		for (int i = 0; i < split.length; i++) {
			int parseInt = Integer.parseInt(split[i]);
			checkAreaService.deleteByPrimaryKey(parseInt);
		}
		
		return "redirect:toPcstation.do";
	}
	
	//修改前回显数据,根据id查询
	@RequestMapping("/selectById.do")
	@ResponseBody
	public CheckArea selectById(Integer wkid){
		
		CheckArea selectByPrimaryKey = checkAreaService.selectByPrimaryKey(wkid);
		
		return selectByPrimaryKey;
	}
	
	//启用的状态
	@RequestMapping("/flag.do")
	public String flag(CheckArea area){
		
		checkAreaService.updateByPrimaryKeySelective(area);
		return "redirect:toPcstation.do";
	}
	
	
	//修改数据
	@RequestMapping("/updateGps.do")
	public String updateGps(CheckArea area,GpsVo vo){
		String gps1 = vo.getLng1() + "," + vo.getLat1();
		String gps2 = vo.getLng2() + "," + vo.getLat2();
		String gps3 = vo.getLng3() + "," + vo.getLat3();
		String gps4 = vo.getLng4() + "," + vo.getLat4();
		
		area.setGps1(gps1);
		area.setGps2(gps2);
		area.setGps3(gps3);
		area.setGps4(gps4);
		
		checkAreaService.updateByPrimaryKeySelective(area);
		
		return "redirect:toPcstation.do";
	}
	
	//-----------------------------------------------施工考勤---------------------------------
	/**
	 * 加载人员及车辆数据
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/selectDanweiAndPersonsAndCars.do")
	@ResponseBody
	public Map<String, Object> selectDanweiAndPersonsAndCars(HttpServletRequest request) throws Exception{

		Map<String, Object> result = new HashMap<>();
		//加载所有单位信息(下拉框)
		List<UserUnit> unitList = userunitService.selectRoleList();
		//加载所有车辆和人员信息(下拉框)
		List<VehicleInfo> vehicleInfos = vehicleInfoService.selectAll();
		List<PersonsInfo> personsInfos = personsInfoService.selectRyxxAll();

		result.put("uList", unitList);
		result.put("cars", vehicleInfos);
		result.put("persons", personsInfos);
		return result;
	}
	//加载人员或者车辆考勤信息
	@RequestMapping("/selectAllCarOrPersonData.do")
	@ResponseBody
	public Map<String, Object> selectAllCarData(HttpServletRequest request,
			String carinfoOrperinfoname,String carOrpertime,String zdanweiname,Integer pageNum,String flag) throws Exception{
		//carinfoOrperinfoname   车牌号或者人员名字
		//carOrpertime     查询时间
		//zdanweiname     单位信息
		Map<String,Object> resultMap = new HashMap<>();
		if (flag.equals("perauto")) {
			Map<String, Object> sqlMap = new HashMap<>();
			sqlMap.put("perinfoname", carinfoOrperinfoname);
			sqlMap.put("company", zdanweiname);
			sqlMap.put("kqtime", carOrpertime);
			pageParameter(request);
			PageHelper.orderBy("pk.pkqid desc");// 排序
			Page<PersonKaoQinRecord> page = PageHelper.startPage(pageNum,10);
			List<PersonKaoQinRecord> perRecords = personKaoQinRecordService.selectPersonRecordByMap(sqlMap);
			PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());

			resultMap.put("page", pageutils);
			resultMap.put("LIST",perRecords);
			resultMap.put("flag",flag);
		} else {
			Map<String, Object> sqlMap = new HashMap<>();
			sqlMap.put("carinfoname", carinfoOrperinfoname);   //车牌号为主
			sqlMap.put("company", zdanweiname);
			sqlMap.put("kqtime", carOrpertime);
			pageParameter(request);
			PageHelper.orderBy("c.ckqid desc");// 排序
			Page<CarKaoQinRecord> page = PageHelper.startPage(pageNum,10);
			List<CarKaoQinRecord> carRecords = carKaoQinRecordService.selectPersonRecordByMap(sqlMap);
			PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());

			resultMap.put("page", pageutils);
			resultMap.put("LIST",carRecords);
			resultMap.put("flag",flag);
		}

		return resultMap;
	}
	
	
	
	
	//-----------------------------------------------去人员及车辆位置报表页面---------------------------------
	/**
	 * 去人员及车辆位置报表页面
	 * @return
	 */
	@RequestMapping("/toAutoreport.do")
	public String toAutoreport(){
		
		
		
		return "autoreport";
	}
	
	//-----------------------------------------------去人员及车辆数据管理页面---------------------------------
	/**
	 * 加载人员及车辆数据
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/toPcinform.do",method = RequestMethod.GET)
	public String toPcinform(HttpServletRequest request) throws Exception{
		return "pcinform3";
	}
	
	//加载人员或者车辆考勤信息
	@RequestMapping(value="/export.do",method = RequestMethod.GET)
	public void export(HttpServletRequest request,HttpServletResponse response,
			String carinfoOrperinfoname,String carOrpertime,String zdanweiname,String flag) throws Exception{
		//carinfoOrperinfoname   车牌号或者人员名字
		//carOrpertime     查询时间
		//zdanweiname     单位信息
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		if (flag.equals("perauto")) {
			Map<String, Object> sqlMap = new HashMap<>();
			sqlMap.put("perinfoname", carinfoOrperinfoname);
			sqlMap.put("company", zdanweiname);
			sqlMap.put("kqtime", carOrpertime);
			List<PersonKaoQinRecord> perRecords = personKaoQinRecordService.selectPersonRecordByMap(sqlMap);
			
			
			//HSSFWorkbook workbook = new HSSFWorkbook();
			/*XSSFWorkbook workbook = new XSSFWorkbook();*/ 
			XSSFSheet sheet = workbook.createSheet("人员及车辆数据管理");
			XSSFRow headRow = sheet.createRow(0);
			headRow.createCell(0).setCellValue("工号");
			headRow.createCell(1).setCellValue("姓名");
			headRow.createCell(2).setCellValue("所属单位");
			headRow.createCell(3).setCellValue("上班时间");
			headRow.createCell(4).setCellValue("下班时间");
			headRow.createCell(5).setCellValue("实际工时");
			headRow.createCell(6).setCellValue("工作区域");
			headRow.createCell(7).setCellValue("备注1");
			headRow.createCell(8).setCellValue("备注2");
			for (PersonKaoQinRecord rawData : perRecords) {
				XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
				dataRow.createCell(0).setCellValue(rawData.getPersonsInfo().getJobnumber());
				dataRow.createCell(1).setCellValue(rawData.getPersonsInfo().getName());
				dataRow.createCell(2).setCellValue(rawData.getPersonsInfo().getCompany());
				dataRow.createCell(3).setCellValue(rawData.getPersonsInfo().getOntime());
				dataRow.createCell(4).setCellValue(rawData.getPersonsInfo().getOfftime());
				dataRow.createCell(5).setCellValue(rawData.getShijiWorktime());
				dataRow.createCell(6).setCellValue(rawData.getZoneInfo().getRemark());
				dataRow.createCell(7).setCellValue(rawData.getRemark1());
				dataRow.createCell(8).setCellValue(rawData.getRemark2());
			}

		} else {
			Map<String, Object> sqlMap = new HashMap<>();
			sqlMap.put("carinfoname", carinfoOrperinfoname);   //车牌号为主
			sqlMap.put("company", zdanweiname);
			sqlMap.put("kqtime", carOrpertime);
			List<CarKaoQinRecord> carRecords = carKaoQinRecordService.selectPersonRecordByMap(sqlMap);
			
			XSSFSheet sheet = workbook.createSheet("人员及车辆数据管理");
			XSSFRow headRow = sheet.createRow(0);
			headRow.createCell(0).setCellValue("车辆信息");
			headRow.createCell(1).setCellValue("所属单位");
			headRow.createCell(2).setCellValue("上班时间");
			headRow.createCell(3).setCellValue("下班时间");
			headRow.createCell(4).setCellValue("实际工时");
			headRow.createCell(5).setCellValue("工作区域");
			headRow.createCell(6).setCellValue("备注1");
			headRow.createCell(7).setCellValue("备注2");
			for (CarKaoQinRecord rawData : carRecords) {
				XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
				dataRow.createCell(0).setCellValue(rawData.getVehicleInfo().getVehicle());
				dataRow.createCell(1).setCellValue(rawData.getVehicleInfo().getCompany());
				dataRow.createCell(2).setCellValue(rawData.getVehicleInfo().getOntime());
				dataRow.createCell(3).setCellValue(rawData.getVehicleInfo().getOfftime());
				dataRow.createCell(4).setCellValue(rawData.getShijiWorktime());
				dataRow.createCell(5).setCellValue(rawData.getZoneInfo().getRemark());
				dataRow.createCell(6).setCellValue(rawData.getRemark1());
				dataRow.createCell(7).setCellValue(rawData.getRemark2());
			}
		}
		//文件下载一个流两个头
		ServletOutputStream out= response.getOutputStream();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String fileName = sdf.format(date)+".xls";
		response.reset();  
		response.setContentType("application/msexcel");
		response.setHeader("Content-disposition", "attachment; filename="+fileName);  
		workbook.write(out);
		out.close();

	}
}

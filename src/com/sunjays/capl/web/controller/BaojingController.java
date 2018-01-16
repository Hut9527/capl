package com.sunjays.capl.web.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunjays.capl.entity.AttendanceTimeVo;
import com.sunjays.capl.entity.PersonsRawData;
import com.sunjays.capl.entity.VehicleRawData;
import com.sunjays.capl.service.PersonsRawDataService;
import com.sunjays.capl.service.VehicleRawDataService;
import com.sunjays.capl.utils.PageUtil;
import com.sunjays.capl.web.common.BaseController;

@Controller
@RequestMapping("baojing")
public class BaojingController extends BaseController{
	
	@Autowired
	private VehicleRawDataService vehicleService;
	@Autowired
	private PersonsRawDataService personsService;
	
	//跳转到报警页面
	@RequestMapping("/main.do")
	public String main() {
		return "baojing";
	}
	
	//获取车辆或人员信息
	@RequestMapping("/getWarnInfo.do")
	@ResponseBody
	public Map<String, Object> getWarnInfo(HttpServletRequest request,
			AttendanceTimeVo time,String flag,Integer pageNum) throws Exception{
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(flag.equals("li01")) {
			pageParameter(request);
			PageHelper.orderBy("Id desc");// 排序
			Page<PersonsRawData> page = PageHelper.startPage(pageNum,pageSize);
			List<PersonsRawData> list = personsService.selectByWarnTime(time);
			PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());
			
			result.put("page", pageutils);
			result.put("list", list);
			result.put("flag", flag);
		} else {
			pageParameter(request);
			PageHelper.orderBy("Id desc");// 排序
			Page<VehicleRawData> page = PageHelper.startPage(pageNum,pageSize);
			List<VehicleRawData> list = vehicleService.selectByWarnTime(time);
			PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());
			
			result.put("page", pageutils);
			result.put("list", list);
			result.put("flag", flag);
		}
		
		return result;
	}
	
	@RequestMapping("/export.do")
	public void export(String flag,AttendanceTimeVo time,HttpServletResponse response) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		XSSFWorkbook workbook = new XSSFWorkbook();
		if(flag.endsWith("li01")) {
			List<PersonsRawData> selectByWarnTime = personsService.selectByWarnTime(time);
		
			XSSFSheet sheet = workbook.createSheet("人员及车辆报警管理");
			XSSFRow headRow = sheet.createRow(0);
			headRow.createCell(0).setCellValue("编号");
			headRow.createCell(1).setCellValue("姓名");
			headRow.createCell(2).setCellValue("报警内容");
			headRow.createCell(3).setCellValue("报警时间");
			int i = 1;
			for (PersonsRawData rawData : selectByWarnTime) {
				XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
				dataRow.createCell(0).setCellValue(i++);
				dataRow.createCell(1).setCellValue(rawData.getName());
				dataRow.createCell(2).setCellValue(rawData.getRemark());
				dataRow.createCell(3).setCellValue(sdf.format(rawData.getGettime()));
			}

		} else {
			List<VehicleRawData> selectByWarnTime = vehicleService.selectByWarnTime(time);
		
			XSSFSheet sheet = workbook.createSheet("人员及车辆报警管理");
			XSSFRow headRow = sheet.createRow(0);
			headRow.createCell(0).setCellValue("编号");
			headRow.createCell(1).setCellValue("车牌号");
			headRow.createCell(2).setCellValue("报警内容");
			headRow.createCell(3).setCellValue("报警时间");
			int i = 1;
			for (VehicleRawData rawData : selectByWarnTime) {
				XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
				dataRow.createCell(0).setCellValue(i++);
				dataRow.createCell(1).setCellValue(rawData.getVehicle());
				dataRow.createCell(2).setCellValue(rawData.getRemark());
				dataRow.createCell(3).setCellValue(sdf.format(rawData.getGettime()));
			}
		}
		
		//文件下载一个流两个头
		ServletOutputStream out= response.getOutputStream();
		Date date = new Date();
		String fileName = sdf1.format(date)+".xls";
		response.reset();  
		response.setContentType("application/msexcel");
		response.setHeader("Content-disposition", "attachment; filename="+fileName);  
		workbook.write(out);
		out.close();
		
	}
	
}

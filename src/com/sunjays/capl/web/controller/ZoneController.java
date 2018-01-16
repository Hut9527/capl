package com.sunjays.capl.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunjays.capl.entity.GpsVo;
import com.sunjays.capl.entity.ZoneInfo;
import com.sunjays.capl.entity.ZoneInfoExample;
import com.sunjays.capl.entity.ZoneName;
import com.sunjays.capl.entity.ZoneNameExample;
import com.sunjays.capl.entity.ZoneVo;
import com.sunjays.capl.service.ZoneInfoService;
import com.sunjays.capl.service.ZoneNameService;
import com.sunjays.capl.utils.PageUtil;
import com.sunjays.capl.web.common.BaseController;

@Controller
@RequestMapping("zone")
public class ZoneController extends BaseController{
	
	@Autowired 
	private ZoneInfoService zoneInfoService;
	@Autowired
	private ZoneNameService zoneNameService;
	
	//信息页面
	@RequestMapping("/goZone.do")
	public String goZone (Model model,HttpServletRequest request) {
		
		//查询所有区域类型名称
		List<ZoneName> selectByExample = zoneNameService.selectByExample(new ZoneNameExample());
		//加载用户信息列表,分页加载
		pageParameter(request);
		PageHelper.orderBy("id desc");// 排序
		Page<ZoneVo> page = PageHelper.startPage(pageNum,pageSize);
		//查询所有区域数据
		List<ZoneVo> selectByExample2 = zoneInfoService.selectAll();
		model.addAttribute("listInfo", selectByExample2);
		
		PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());
		model.addAttribute("page",pageutils);
		
		model.addAttribute("listName", selectByExample);
		return "zoneenter";
	}
	
	//添加
	@RequestMapping("/saveZone.do")
	public String saveZone(GpsVo vo,ZoneInfo zoneInfo){
		String gps1 = vo.getLng1() + "," + vo.getLat1();
		String gps2 = vo.getLng2() + "," + vo.getLat2();
		String gps3 = vo.getLng3() + "," + vo.getLat3();
		String gps4 = vo.getLng4() + "," + vo.getLat4();
		String gps5 = vo.getLng5() + "," + vo.getLat5();
		String gps6 = vo.getLng6() + "," + vo.getLat6();
		
		zoneInfo.setGps1(gps1);
		zoneInfo.setGps2(gps2);
		zoneInfo.setGps3(gps3);
		zoneInfo.setGps4(gps4);
		zoneInfo.setGps5(gps5);
		zoneInfo.setGps6(gps6);
		zoneInfo.setFlag(0);
		
		zoneInfoService.insertSelective(zoneInfo);
		return "redirect:goZone.do";
	}
	
	//删除
	@RequestMapping("/deleteZone.do")
	public String deleteZone(String id){
		String[] split = id.split(",");
		for (int i = 0; i < split.length; i++) {
			int parseInt = Integer.parseInt(split[i]);
			zoneInfoService.deleteByPrimaryKey(parseInt);
		}
		return "redirect:goZone.do";
	}
	
	//启用的状态
	@RequestMapping("/flag.do")
	public String flag(ZoneInfo zoneInfo){
		zoneInfoService.updateByPrimaryKeySelective(zoneInfo);
		return "redirect:goZone.do";
	}
	
	//修改前回显数据,根据id查询
	@RequestMapping("/selectById.do")
	@ResponseBody
	public ZoneInfo selectById(Integer id){
		
		ZoneInfo selectByPrimaryKey = zoneInfoService.selectByPrimaryKey(id);
		
		return selectByPrimaryKey;
	}
	
	//修改数据
	@RequestMapping("/updateZone.do")
	public String updateZone(ZoneInfo zoneInfo,GpsVo vo){
		String gps1 = vo.getLng1() + "," + vo.getLat1();
		String gps2 = vo.getLng2() + "," + vo.getLat2();
		String gps3 = vo.getLng3() + "," + vo.getLat3();
		String gps4 = vo.getLng4() + "," + vo.getLat4();
		String gps5 = vo.getLng5() + "," + vo.getLat5();
		String gps6 = vo.getLng6() + "," + vo.getLat6();
		
		zoneInfo.setGps1(gps1);
		zoneInfo.setGps2(gps2);
		zoneInfo.setGps3(gps3);
		zoneInfo.setGps4(gps4);
		zoneInfo.setGps5(gps5);
		zoneInfo.setGps6(gps6);
		
		zoneInfoService.updateByPrimaryKeySelective(zoneInfo);
		return "redirect:goZone.do";
	}
	
	//异步获取活动区域
	@RequestMapping("/getZone.do")
	@ResponseBody
	public List<ZoneVo> getZone(){
		//查询所有区域数据
		List<ZoneVo> selectByExample2 = zoneInfoService.selectAll();
		
		return selectByExample2;
	}
	
}

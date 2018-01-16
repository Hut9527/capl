package com.sunjays.capl.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunjays.capl.entity.UserInfo;
import com.sunjays.capl.entity.UserUnit;
import com.sunjays.capl.entity.UserUnitExample;
import com.sunjays.capl.entity.VehicleType;
import com.sunjays.capl.entity.VehicleTypeExample;
import com.sunjays.capl.entity.ZUClink;
import com.sunjays.capl.entity.ZUClinkExample;
import com.sunjays.capl.entity.VehicleInfo;
import com.sunjays.capl.service.UserUnitService;
import com.sunjays.capl.service.VehicleTypeService;
import com.sunjays.capl.service.ZUClinkService;
import com.sunjays.capl.service.VehicleInfoService;
import com.sunjays.capl.utils.PageUtil;
import com.sunjays.capl.web.common.BaseController;
@Controller
@RequestMapping("/luru")
public class VehicleInfoController extends BaseController{
	@Autowired
	private VehicleInfoService vehicleinfoService;
	@Autowired
	private VehicleTypeService vehicleTypeService;
	@Autowired
	private UserUnitService userUnitService;
	@Autowired
	private ZUClinkService zuclinkService;
	
	//查询全部信息分页
	@RequestMapping("/selectAll.do")
	public String selectAll( Model model,HttpServletRequest request){
		pageParameter(request);
		PageHelper.orderBy("v.id desc");// 排序
		Page<VehicleInfo> page = PageHelper.startPage(pageNum,pageSize);
		List<VehicleInfo> list = vehicleinfoService.selectAll();
		PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());
		model.addAttribute("list",list);
		model.addAttribute("page",pageutils);
		return "carenter";
	} 
	
	/*//添加车辆信息
	@RequestMapping("/insertVehicleinfo.do")
	public String insertVehicleinfo(VehicleInfo vehicleinfo){
		vehicleinfoService.insertSelective(vehicleinfo);
		return "redirect:selectAll.do";
	}
	*/
	
	/*@RequestMapping("/enterpeople.do")
	public String enterpeople(Vehicleinfo vehicleinfo){
		
		return "carenter";
	}*/
	
	/*//修改录入车辆信息
	@RequestMapping("/updateVehicleById.do")
	public void updateVehicleById(String id,HttpServletResponse response) throws IOException{
	VehicleInfo info = 	vehicleinfoService.selectVehicleById(id);
	Integer id2 = info.getId();
	String devid = info.getDevid();
	String vehicle = info.getVehicle();
	String simnumber = info.getSimnumber();	
	String vehicletype = info.getVehicletype();	
	String company = info.getCompany();	
	String responsibility = info.getResponsibility();	
	String liabilityphone = info.getLiabilityphone();	
	JSONObject jo = new JSONObject();
	jo.put("id", id2);
	jo.put("devid", devid);
	jo.put("vehicle", vehicle);
	jo.put("simnumber", simnumber);
	jo.put("vehicletype",vehicletype);
	jo.put("company",company);
	jo.put("responsibility",responsibility);
	jo.put("liabilityphone",liabilityphone);
	
	//数据回调
	response.setContentType("application/json;charset=UTF-8");
	response.getWriter().write(jo.toString());	
		
		
	}*/
	
	//通过id查询车辆信息
	@RequestMapping("/selectVehicleById.do")
	@ResponseBody
	public VehicleInfo selectVehicleById(VehicleInfo info){
	VehicleInfo vehicel = vehicleinfoService.selectVehicleById(info);
	return vehicel;
	}
	
	//添加车辆信息
	@RequestMapping(value="/addOrupdateVehicleinfo.do")
	public String addOrupdateVehicleinfo(VehicleInfo info,Model model,RedirectAttributes redirectAttributes){
		
		try {
			vehicleinfoService.addOrUpdateUser(info);
			
			//关联活动区域
			Integer valueOf = Integer.valueOf(info.getZone());
			ZUClink zuClink = new ZUClink();
			zuClink.setcId(info.getId());
			zuClink.setzId(valueOf);
			zuclinkService.insertSelective(zuClink);
			
			/*if (info.getId()==null) {
				redirectAttributes.addFlashAttribute("MSG", "添加成功");
			}else{
				redirectAttributes.addFlashAttribute("MSG", "修改成功");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("MSG", "操作失败");
		}
		return "redirect:selectAll.do";
	} 
	
	//修改车辆信息
	@RequestMapping("/updateinfo.do")
	public String updateinfo(VehicleInfo info) {
		
		ZUClink zuClink = new ZUClink();
		zuClink.setzId(Integer.valueOf(info.getZone()));
		zuClink.setcId(info.getId());
		//级联更新
		zuclinkService.updateByPrimaryKeySelective(zuClink);

		vehicleinfoService.updateByPrimaryKeySelective(info);
		
		return "redirect:selectAll.do";
	}
		
	//车辆录入信息删除
	@RequestMapping("/deleteVehicleById.do")
	public String deleteVehicleById(String arr,RedirectAttributes redirectAttributes){
		String[] sids = arr.split(",");
		for(int i = 0; i < sids.length;i++){
			String id = sids[i];
			
			//级联删除
			Integer cid = Integer.valueOf(id);
			ZUClinkExample zuClinkExample = new ZUClinkExample();
			zuClinkExample.or().andCIdEqualTo(cid);
			zuclinkService.deleteByExample(zuClinkExample);
			
			int flag = vehicleinfoService.deleteVehicleById(id);
			/*if(flag>0){
				redirectAttributes.addFlashAttribute("MSG", "删除成功");
			}else{
				redirectAttributes.addFlashAttribute("MSG", "删除失败");
		}*/
				
	}
		
		
		return "redirect:selectAll.do";
	}
	
	
	//异步查询车辆类型返回json数据回显到前台页面下拉框
		@RequestMapping("/findAll.do")
		@ResponseBody
		public List<VehicleType> findAll(VehicleTypeExample example){
			List<VehicleType> list = vehicleTypeService.selectByExample(example);
			
			return list;
		}
		
		//异步查询所属单位返回json数据回显到前台下拉框
		@RequestMapping("/selectDanwei.do")
		@ResponseBody
		public List<UserUnit> selectDanwei(UserUnitExample example){
			
			List<UserUnit> list = userUnitService.selectByExample(example);
			
			return list;
		}
		
		//表单验证devid是否重复
		@RequestMapping("/selectByDevid.do")
		@ResponseBody
		public String selectByDevid(Integer id,String devid){
			devid=devid.replaceAll(" ", "");
			if(id!=null&&!id.equals("")){
				
				VehicleInfo ui = new VehicleInfo();
				ui.setId(id);
				VehicleInfo Info=vehicleinfoService.selectDevidById(ui);
				if(devid.equals(Info.getDevid())){
					return "true";
				}
			}
			VehicleInfo Info=vehicleinfoService.selectByDevid(devid);
			if(Info!=null){
				return "false";
			}
			return "true";
		}
		
	//表单验证车牌号是否重复
		@RequestMapping("/selectByVehicle.do")
		@ResponseBody
		public String selectByVehicle(Integer id,String vehicle){
			vehicle=vehicle.replaceAll(" ", "");
		if(id!=null&&!id.equals("")){
						VehicleInfo ui = new VehicleInfo();
						ui.setId(id);
						VehicleInfo Info=vehicleinfoService.selectVehicleByIds(ui);
						if(vehicle.equals(Info.getVehicle())){
							return "true";
						}
					}
		VehicleInfo Info=vehicleinfoService.selectByVehicle(vehicle);
		if(Info!=null){
			return "false";
		}
		return "true";
	}
	//表单验证SIM卡号是否重复	
	@RequestMapping("/selectBySimnumber.do")
	@ResponseBody
	public String selectBySimnumber(Integer id,String simnumber){
		simnumber=simnumber.replaceAll(" ", "");
		if(id!=null&&!id.equals("")){
			VehicleInfo ui = new VehicleInfo();
			ui.setId(id);
			VehicleInfo Info=vehicleinfoService.selectSimnumberById(ui);
			if(simnumber.equals(Info.getSimnumber())){
				return "true";
			}
		}
		VehicleInfo Info=vehicleinfoService.selectBySimnumber(simnumber);
		if(Info!=null){
			return "false";
		}
		return "true";

		
	}
			
}

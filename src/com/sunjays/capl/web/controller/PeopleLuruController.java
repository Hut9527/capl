package com.sunjays.capl.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunjays.capl.entity.PersonsInfo;
import com.sunjays.capl.entity.UserUnit;
import com.sunjays.capl.entity.UserUnitExample;
import com.sunjays.capl.entity.ZUClink;
import com.sunjays.capl.entity.ZUClinkExample;
import com.sunjays.capl.service.PersonsInfoService;
import com.sunjays.capl.service.UserUnitService;
import com.sunjays.capl.service.ZUClinkService;
import com.sunjays.capl.utils.PageUtil;
import com.sunjays.capl.web.common.BaseController;
@Controller
@RequestMapping("/ryluru")
public class PeopleLuruController extends BaseController {
	@Autowired
	private UserUnitService userUnitService;
	@Autowired
	private PersonsInfoService persons;
	@Autowired
	private ZUClinkService zuclinkService;
	
	
	
	@RequestMapping("/selectRyxxAll.do")
	//查询全部的人员信息分页
	public String selectRyxxAll( Model model,HttpServletRequest request){
		pageParameter(request);
		PageHelper.orderBy("p.id desc");// 排序
		Page<PersonsInfo> page = PageHelper.startPage(pageNum,pageSize);
		List<PersonsInfo> list = persons.selectRyxxAll();
		PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());
		model.addAttribute("list",list);
		model.addAttribute("page",pageutils);
		
		return "peopleenter";
	}
	
	
	
	/*//添加人员信息
	@RequestMapping("/insertpeople.do")
	public String insertpeople(PersonsInfo personsInfo){
		persons.insertSelective(personsInfo);
		return "redirect:selectRyxxAll.do";
	}*/
	
	/*//修改录入车辆信息
		@RequestMapping("/updatePeopleById.do")
		public void updatePeopleById(String id,HttpServletResponse response) throws IOException{
		PersonsInfo info = 	persons.selectVehicleById(id);
		Integer id2 = info.getId();
		String name = info.getName();
		String sex = info.getSex();	
		Integer age = info.getAge();	
		String address = info.getAddress();
		String company = info.getCompany();	
		String phone = info.getPhone();	
		JSONObject jo = new JSONObject();
		jo.put("id", id2);
		jo.put("name", name);
		jo.put("sex", sex);
		jo.put("address", address);
		jo.put("company",company);
		jo.put("phone",phone);
		
		//数据回调
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jo.toString());	
		
		}
	
	*/
	
	//通过id查询人员信息
		@RequestMapping("/selectPersonById.do")
		@ResponseBody
		public PersonsInfo selectVehicleById(PersonsInfo info){
		PersonsInfo in =  persons.selectVehicleById(info);
			return in;
		}
		
		//添加人员信息
		@RequestMapping(value="/addOrupdatepeople.do")
		public String addOrupdatepeople(PersonsInfo info,Model model,RedirectAttributes redirectAttributes){
			
			try {
				persons.addOrupdatepeople(info);
				
				//关联活动区域
				ZUClink zuClink = new ZUClink();
				zuClink.setuId(info.getId());
				zuClink.setzId(Integer.valueOf(info.getZone()));
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
			return "redirect:selectRyxxAll.do";
		} 	
		
		//修改人员信息
		@RequestMapping("/updateinfo.do")
		public String updateinfo(PersonsInfo info) {
			
			ZUClink zuClink = new ZUClink();
			zuClink.setzId(Integer.valueOf(info.getZone()));
			zuClink.setuId(info.getId());
			//级联更新
			zuclinkService.updateByPrimaryKeySelective(zuClink);
			
			persons.updateByPrimaryKeySelective(info);
			
			return "redirect:selectRyxxAll.do";
		}
		
		
		//人员录入信息删除
		@RequestMapping("/deletePersonById.do")
		public String deleteVehicleById(String arr,RedirectAttributes redirectAttributes){
			String[] sids = arr.split(",");
			for(int i = 0; i < sids.length;i++){
				String id = sids[i];
				
				//级联删除
				Integer uid = Integer.valueOf(id);
				ZUClinkExample zuClinkExample = new ZUClinkExample();
				zuClinkExample.or().andUIdEqualTo(uid);
				zuclinkService.deleteByExample(zuClinkExample);
				
				/*if(flag>0){
					redirectAttributes.addFlashAttribute("MSG", "删除成功");
				}else{
					redirectAttributes.addFlashAttribute("MSG", "删除失败");
			}*/
					
		}
			
			return "redirect:selectRyxxAll.do";
	}
		
		
	//异步查询所属单位返回json数据回显到前台下拉框
	@RequestMapping("/selectDanwei.do")
	@ResponseBody
	public List<UserUnit> selectDanwei(UserUnitExample example){
				
	List<UserUnit> list = userUnitService.selectByExample(example);
				
	return list;
	}
	//表单校验SIM卡号是否重复
	@RequestMapping("/selectBySimnumber.do")
	@ResponseBody
	public String selectBySimnumber(Integer id,String simnumber){
		simnumber=simnumber.replaceAll(" ", "");
		if(id!=null&&!id.equals("")){
			PersonsInfo ui = new PersonsInfo();
			ui.setId(id);
			PersonsInfo Info=persons.selectSimnumberById(ui);
			if(simnumber.equals(Info.getSimnumber())){
				return "true";
			}
		}
		PersonsInfo Info=persons.selectBySimnumber(simnumber);
		if(Info!=null){
			return "false";
		}
		return "true";
		
	}
	
	//根据工号查询人员信息
	@RequestMapping("/selectPersonByJobNumber.do")
	@ResponseBody
	public PersonsInfo selectPersonByJobNumber(String jobnumber){
		PersonsInfo info =  persons.selectPersonByJobNumber(jobnumber);
		
			return info;
		
		
	}
	
	
}




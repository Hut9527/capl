package com.sunjays.capl.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import com.sunjays.capl.annotation.Log;
import com.sunjays.capl.entity.AuthFunction;
import com.sunjays.capl.entity.AuthRole;
import com.sunjays.capl.entity.RoleFunctionKey;
import com.sunjays.capl.entity.UnitType;
import com.sunjays.capl.entity.UserInfo;
import com.sunjays.capl.entity.UserUnit;
import com.sunjays.capl.service.AuthFunctionService;
import com.sunjays.capl.service.AuthRoleService;
import com.sunjays.capl.service.UnitTypeService;
import com.sunjays.capl.service.UserInfoService;
import com.sunjays.capl.service.UserUnitService;
import com.sunjays.capl.web.common.BaseController;
import com.sunjays.capl.utils.PageUtil;
@Controller
@RequestMapping("/yonghu")
public class UserController extends BaseController{
	
	@Resource
	private UnitTypeService unitTypeService;
	@Resource
	private UserUnitService userunitService;
	@Resource
	private AuthFunctionService authFunctionService;
	@Resource
	private AuthRoleService authRoleService;
	@Resource
	private UserInfoService userInfoService;
	//---------------------------------用户信息管理-----------------------
	/**
	 * 点击用户信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/xinxi.do")
	public String toXinxi(Model model,HttpServletRequest request){
		//1,加载角色列表
		List<AuthRole> roleList = authRoleService.selectRoleList();
		model.addAttribute("roleList", roleList);
		//2,加载用户组列表
		List<UserUnit> unitList = userunitService.selectRoleList();
		model.addAttribute("unitList", unitList);
		//3,加载用户信息列表,分页加载
		pageParameter(request);
		PageHelper.orderBy("userId desc");// 排序
		Page<UserInfo> page = PageHelper.startPage(pageNum,pageSize);
		List<UserInfo> list = userInfoService.selectUserInfoFenye();
		
		model.addAttribute("list",list);
		
		PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());
		model.addAttribute("page",pageutils);
		return "user-info";
	}
	/**
	 * 点击用户信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectUserByUserId")
	@ResponseBody
	public UserInfo selectUserByUserId(UserInfo ui){
		UserInfo uii = userInfoService.selectUserByUserId(ui);
		return uii;
	}
	/**
	 * 添加/修改用户信息
	 * @param model
	 * @return
	 */
	//@RequiresPermissions("xiugai")
	@RequestMapping(value="/addOrUpdateUser.do")
	public String addOrUpdateUser(UserInfo ui,Model model,RedirectAttributes redirectAttributes){
		
		try {
			userInfoService.addOrUpdateUser(ui);
			if (ui.getUserid()==null) {
				redirectAttributes.addFlashAttribute("MSG", "添加成功");
			}else{
				redirectAttributes.addFlashAttribute("MSG", "修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("MSG", "操作失败");
		}
		return "redirect:xinxi.do";
	}
	/**
	 * 删除用户信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteUserInfo.do")
	public String deleteUserInfo(Integer userid,Model model,RedirectAttributes redirectAttributes){
		
		try {
			userInfoService.deleteUserInfoById(userid);
			redirectAttributes.addFlashAttribute("MSG", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("MSG", "操作失败");
		}
		return "redirect:xinxi.do";
	}
	
	/**
	 * 表单验证根据用户名称
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectByAdminName.do")
	@ResponseBody
	public String selectByAdminName(Integer userid,String username){
		username=username.replaceAll(" ", "");
		
		if(userid!=null&&!userid.equals("")){
			
			UserInfo ui = new UserInfo();
			ui.setUserid(userid);
			UserInfo userInfo=userInfoService.selectUserByUserId(ui);
			if(username.equals(userInfo.getUsername())){
				return "true";
			}
		}
		UserInfo userInfo=userInfoService.selectByAdminName(username);
		if(userInfo!=null){
			return "false";
		}
		return "true";
	}
	//----------------------用户组管理--------------------------------------
	/**
	 * 点击用户组管理,加载用户组类型信息,用户组信息列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/zuguanli.do")
	@Log(operationName="去用户组管理主页")
	public String toZuGuanli(Model model,HttpServletRequest request){
		//加载用户类型信息
		List<UnitType> utList = unitTypeService.selectAllUtit();
		model.addAttribute("utList", utList);
		//分页加载具体用户组信息列表
		pageParameter(request);
		PageHelper.orderBy("UuId desc");// 排序
		Page<UserUnit> page = PageHelper.startPage(pageNum,pageSize);
		List<UserUnit> list = userunitService.selectFenye();
		
		model.addAttribute("list",list);
		
		PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());
		model.addAttribute("page",pageutils);
		return "usergroup";
	}
	
	/**
	 * 保存/修改用户组
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/adddanwei.do")
	public String addZu(UserUnit unit,RedirectAttributes redirectAttributes) throws IOException{
		try {
			userunitService.adddanwei(unit);
			if (unit.getUuid()==null) {
				redirectAttributes.addFlashAttribute("MSG", "添加成功");
			} else {
				redirectAttributes.addFlashAttribute("MSG", "修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("MSG", "操作失败");
		}
		return "redirect:zuguanli.do";
	}
	
	/**
	 * 根据组id加载组信息
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/selectZuById.do")
	@ResponseBody
	public UserUnit selectZu(Integer id,RedirectAttributes redirectAttributes) throws IOException{
		UserUnit userUnit = userunitService.selectZuById(id);
		return userUnit;
	}
	
	/**
	 * 根据组id删除组信息
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deleteUserGroup.do")
	public String deleteUserGroup(Integer ugid,RedirectAttributes redirectAttributes){
		try {
			userunitService.deleteUserGroupById(ugid);
			redirectAttributes.addFlashAttribute("MSG", "删除成功");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("MSG", "操作失败");
			e.printStackTrace();
		}
		
		return "redirect:zuguanli.do";
	}
	

	/**
	 * 表单校验
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/selectGroupByName.do")
	@ResponseBody
	public String selectGroupByName(Integer id,String name){
		name=name.replaceAll(" ", "");
		
		if(id!=null&&!id.equals("")){
			
			UserUnit userUnit=userunitService.selectUserByUserId(id);
			if(name.equals(userUnit.getUuname())){
				return "true";
			}
		}
		UserUnit userUnit=userunitService.selectByGroupName(name);
		if(userUnit!=null){
			return "false";
		}
		return "true";
	}
	//-------------------------------角色管理--------------------
	/**
	 * 点击角色管理
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/jueseguanli.do")
	public String toJueSe(Model model,HttpServletRequest request){
		//加载左侧菜单目录
		List<AuthFunction> menuFunction = authFunctionService.selectMenuFunction();
		model.addAttribute("flist", menuFunction);
		//加载角色数据展示列表
		pageParameter(request);
		PageHelper.orderBy("roleid desc");// 排序
		Page<AuthRole> page = PageHelper.startPage(pageNum,pageSize);
		List<AuthRole> roleList = authRoleService.selectRoleList();
		model.addAttribute("roleList",roleList);
		
		PageUtil pageutils= new PageUtil(page.getPageNum(), page.getPageSize(), (int) page.getTotal());
		model.addAttribute("page",pageutils);
		
		return "role-info";
		
	}
	/**
	 * 根据parentId查找对应的菜单名字
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/getMenusByParentId.do")
	@ResponseBody
	public List<AuthFunction> selectMenusByParentId(AuthFunction af){
		List<AuthFunction> menuFunction = authFunctionService.selectMenuByParentId(af);
		return menuFunction;
	}
	/**
	 * 添加/修改角色
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/insertOrUpdateRole.do")
	public String insertOrUpdateRole(AuthRole ar,String menuIds,RedirectAttributes redirectAttributes){
		try {
			authRoleService.insertOrUpdateRole(ar,menuIds);
			if (ar.getRoleid()==null) {
				redirectAttributes.addFlashAttribute("MSG", "添加成功");
			}else {
				redirectAttributes.addFlashAttribute("MSG", "修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("MSG", "操作失败");
		}
		return "redirect:jueseguanli.do";
	}
	/**
	 * 根据parentId查找对应的菜单名字
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/updateRole.do")
	@ResponseBody
	public Map<String, Object> updateRole(String roleId){
		AuthRole ar = authRoleService.selectRoleByRoleId(Integer.parseInt(roleId));
		List<RoleFunctionKey> rfList = authRoleService.selectFunctionIdByRoleId(Integer.parseInt(roleId));
		Map<String, Object> result = Maps.newHashMap();
   		result.put("ROLE",ar);
   		result.put("LISTROLEMENUS",rfList);
        return result;
	}
	/**
	 * 根据角色id删除对应角色
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deleteJueSe.do")
	public String deleteJueSeById(Integer roleid,RedirectAttributes redirectAttributes){
		try {
			authRoleService.deleteRoleById(roleid);
			redirectAttributes.addFlashAttribute("MSG", "删除成功");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("MSG", "操作失败");
			e.printStackTrace();
		}
		return "redirect:jueseguanli.do";
	}
	
	/**
	 * 根据角色id判断拥有该角色的用户的数量
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/isdeleteJueSe.do")
	@ResponseBody
	public String isDeleteJueSeById(Integer roleid,RedirectAttributes redirectAttributes){
		int i  = userInfoService.selectYongHuByRoleId(roleid);
		if(i>0){
			return "1";
		}
		return "0";
	}
	
	/**
	 * 表单验证角色名是否存在
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/selectByRoleName.do")
	@ResponseBody
	public String selectByRoleName(String rolename,String roleid){
		rolename=rolename.replaceAll(" ", "");
		
		if(roleid!=null&&!roleid.equals("")){
			AuthRole userRole=authRoleService.selectRoleByRoleId(Integer.parseInt(roleid));
			if(rolename.equals(userRole.getRolename())){
				return "true";
			}
		}
		AuthRole role=authRoleService.selectByRoleName(rolename);
		if(role!=null){
			return "false";
		}
		return "true";
	}
}

package com.sunjays.capl.web.common;

import java.io.Serializable;

/**
 * 常量
 */
public class Constants implements Serializable{

	private static final long serialVersionUID = -2087804150399520300L;
	/**当前系统的权限id*/
	public static final String PRIVILEGE_ID="6";
	/**当前系统的权限名称*/
	public static final String PRIVILEGE_NAME="renyuan:main";
	/**登陆系统基础的路径*/
	public static final String LOGIN_URL_BASE="http://localhost:8080/entrance";
	//public static final String LOGIN_URL_BASE="http://123.57.177.188:9972/entrance";
	/**获得所有项目menu的路径*/
	public static final String ALLPROJECT_URL=LOGIN_URL_BASE+"/WS/selectAllMenu";
	
	/**获得用户信息的路径*/
	public static final String LOGIN_URL_ISLOGIN=LOGIN_URL_BASE+"/isLogin";
	/**登陆路径*/
	public static final String LOGIN_URL=LOGIN_URL_BASE+"/login.action";
	/**退出路径*/
	public static final String LOGOUT_URL=LOGIN_URL_BASE+"/logout";
	/**首页路径*/
	public static final String INDEX_URL=LOGIN_URL_BASE+"/toIndex";
	/**根据id获得用户路径*/
	public static final String GETUSERBYID_URL=LOGIN_URL_BASE+"/WS/getUserById";
	/**获得所有部门路径*/
	public static final String ALLDEPARTMENT_URL=LOGIN_URL_BASE+"/WS/selectAllDepart";
	/**根据部门id获取岗位路径*/
	public static final String JOBBYDEPARTMENTID_URL=LOGIN_URL_BASE+"/WS/selectByDepartmentId";
	
	/**大坝智能温控地址*/
	public static final String YHJW_BASE_URL = "http://123.57.177.188:8180/yhjw-yuancheng";
	/**大坝智能温控地址-获取所有八段地址*/
	public static final String YHJW_ALLDAM_URL = YHJW_BASE_URL+"/WSSection/getAllDam";
	/**大坝智能温控地址-获取所有仓位地址*/
	public static final String YHJW_ALLCABINS_URL = YHJW_BASE_URL+"/WSCabin/getgetAllCabins";
	/**大坝智能温控地址-获取仓位信息主要要包括开仓时间*/
	public static final String YHJW_CABININFO_URL = YHJW_BASE_URL+"/WSCabin/getCabinById";
	/**以上为地址专用区域***************************************************/
	/**liupenghui-area-开始*/
	
	
	/**liupenghui-area-结束*/
	/**************************************************************************/
	/**我是分割线*********************************************************************/
	/**************************************************************************/
	/**liuqixiang-area-开始*/
	/**浇筑计划流程-开始*/
	/**第一个审核角色*/
	public static final String POURING_PLAN_1 = "计划审核角色1";
	public static final String POURING_PLAN_2 = "计划审核角色2";
	public static final String POURING_PLAN_LAST_NUM = "2";
	/**浇筑计划流程-结束*/
	
	/**施工人员计划流程-开始*/
	/**第一个审核角色*/
	public static final String PERSON_PLAN_1 = "计划审核角色1";
	public static final String PERSON_PLAN_2 = "计划审核角色2";
	public static final String PERSON_PLAN_LAST_NUM = "2";
	/**施工人员计划流程-结束*/
	/**liuqixiang-area-结束*/
}

package com.sunjays.capl.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.sunjays.capl.entity.UserManagerVO;
import com.sunjays.capl.utils.HttpClientUtil;
import com.sunjays.capl.utils.JsonUtils;
import com.sunjays.capl.web.common.Constants;


@Service
public class UserService {


	public UserManagerVO getUserByToken(String token) {
		//判断用户是否登录
		//调用sso系统的服务，根据token取用户信息
		Map<String,String> searchMap=Maps.newHashMap();
		searchMap.put("token", token);
		searchMap.put("parentId", Constants.PRIVILEGE_ID);
		String json = HttpClientUtil.doPost(Constants.LOGIN_URL_ISLOGIN,searchMap);
		if(json!=null&&!json.equals("")){
			//把json转换成TaotaoREsult
			System.out.println(json);
			UserManagerVO userVO = JsonUtils.jsonToPojo(json, UserManagerVO.class);
			return userVO;
		}
		return null;
	}
}

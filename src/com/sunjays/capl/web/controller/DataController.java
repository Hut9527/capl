package com.sunjays.capl.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunjays.capl.utils.PrintImageUtils;
import com.sunjays.capl.web.common.Constants;
import com.sunjays.capl.utils.HttpClientUtil;
import com.sunjays.capl.utils.JsonUtils;


@Controller
public class DataController {
	
	
	@RequestMapping("/index.do")
	public String sel(){
		return "index";
	}
	
	@RequestMapping("/dd.do")
	public String s(){
		return "carmon";
	}
	
	@RequestMapping("/cc.do")
	public String cc(){
		return "vension";
	}
	@RequestMapping("/toIndex.do")
	public String dd(Model model){
		String json=HttpClientUtil.doPost(Constants.ALLPROJECT_URL);
		List<Map<String,String>> list=JsonUtils.jsonToListMap(json);
		model.addAttribute("menuList", list);
		return "index";
	}
}

package com.sunjays.capl.filter;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.sunjays.capl.entity.SystemLog;
import com.sunjays.capl.entity.UserInfo;
import com.sunjays.capl.service.SystemLogService;
import com.sunjays.capl.service.UserInfoService;
import com.sunjays.capl.utils.HostIpUtils;
/**
 * 用户登出系统过滤器处理
 * @author admin
 *
 */

public class LogoutFillter extends LogoutFilter {
	@Resource
	private UserInfoService userInfoService;
	@Resource
	private SystemLogService systemLogService;  
	
	@Override
	protected boolean preHandle(ServletRequest req, ServletResponse resp) throws Exception {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		UserInfo userInfo = (UserInfo)SecurityUtils.getSubject().getPrincipal();
		if(userInfo!=null){
			// 请求的IP
			String ip = null;
			try {
				ip = HostIpUtils.getIpAddr(request);
			} catch (Exception e1) {
				ip = "0.0.0.0";
			}
			 SystemLog log = new SystemLog(); 
			 log.setCreateBy(userInfo.getUsername());
			 log.setRequestIp(ip);
			 log.setRemarker("退出系统");
			 log.setCreateDate(new Date());
			// 保存数据库
			 systemLogService.insert(log);
		}
		request.getSession();
		String loginInfo ="";
		Cookie	cookie = new Cookie("loginInfo", loginInfo);
		cookie.setMaxAge(30 * 24 * 60 * 60);
		response.addCookie(cookie);        //用户登出系统操作，缓存设置为空
		return super.preHandle(request, response);
	}
}

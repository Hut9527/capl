package com.sunjays.capl.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
//防止没登录进入系统 到登录页面  点击登陆后进入上一个页面  有此方法登录后进入登录页面
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		WebUtils.getAndClearSavedRequest(request);
		//subject.getSession().setAttribute("redirect", redirect);
		WebUtils.redirectToSavedRequest(request, response, "/toIndex.do");
		return false;
	}
}

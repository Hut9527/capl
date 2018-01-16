package com.sunjays.capl.intercepter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sunjays.capl.entity.UserManagerVO;
import com.sunjays.capl.service.UserService;
import com.sunjays.capl.utils.CookieUtils;
import com.sunjays.capl.web.common.Constants;


public class LoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private UserService userService;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//在Handler执行之前处理
				//根据token换取用户信息，调用sso系统的接口。
		String token = CookieUtils.getCookieValue(request, "SJ_TOKEN");	
		UserManagerVO userVO = userService.getUserByToken(token);
				//取不到用户信息
				if (null == userVO) {
					//跳转到登录页面，把用户请求的url作为参数传递给登录页面。
					response.sendRedirect(Constants.LOGIN_URL);
					//返回false
					return false;
				}
				//取到用户信息，放行
				if(userVO.getMainPri()!=null&&userVO.getMainPri().contains(Constants.PRIVILEGE_NAME)){
					//把用户信息放入Request
					request.setAttribute("user", userVO);
					//返回值决定handler是否执行。true：执行，false：不执行。
					return true; 
				}else{
					//跳转到登录页面，把用户请求的url作为参数传递给登录页面。
					response.sendRedirect(Constants.LOGIN_URL);
					//返回false
					return false;
				}
	}


	
	
}

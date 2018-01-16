<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN"  class="bg-login">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--为了兼容IE-->
<meta name="renderer" content="webkit">
<!--国产浏览器默认采用高速模式渲染页面-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!--禁止屏幕缩放-->
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<link rel="shortcut icon" href="${path }/static/img/prolog.ico"/>
<title>登录</title>
<link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
<!-- font Awesome -->
<link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<!-- Theme style -->
 <link href="${ctx}/static/css/AdminLTE.css" rel="stylesheet" type="text/css" /> 
 	<script type="text/javascript" src="${ctx}/static/js/jquery-1.7.2.min.js"></script>
<style>
	html{height: 100%;width: 100%;}
	body{background: none;height: 100%;width: 100%;}
	.login-hzt{overflow: hidden;position: absolute;left: 50%;top:50%; width: 1354px;margin-left:-677px; }
	.login-hx1,.login-hx2{height: 1px;width: 500px;float: left;background:#0063ba;margin-top:15px; }
	.login-hxspan{display: block;font-size: 22px;color:#0063ba; float: left;width: 350px;text-align: center;}
</style>
<script type="text/javascript">
	//防止session超时登陆嵌套
	if (top != window)
		top.location.href = window.location.href;
	
	var height=window.innerHeight;
	var pageSize=Math.floor((window.innerHeight-300)/38);
	//alert(height);
	//alert(pageSize);
	//session.setAttribute("pageSize",pageSize);
	document.cookie="pageSize="+pageSize+"; path=/";
</script>
</head>
<body>
<header class="login-head">
	<img src="${ctx}/static/img/login_logo.png" alt="引汉济渭" style="margin-left: -302px">
	<div class="login-hzt">
		<div class="login-hx1"></div>
		<span class="login-hxspan">施工车辆及人员跟踪定位管理</span>
		<div class="login-hx2"></div>
	</div>
</header>
<%
		String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
   		String content = "";
		if (error != null) {
			if (error.contains("DisabledAccountException")) {
				content = "用户已失效，请联系管理员";
			} else {
				content = "用户名或密码错误，请重新输入";
			}
		}
	%>
<section class="login-section">
	<div class="loginbg">
		<div class="form-box" id="login-box">
			<div class="header">用户登录</div>
			<form action="${ctx}/login/userLogin.do" class="form-login" method="post" id="form1">
				<div class="body">
					<div class="form-group">
						<input type="text" name="username" id="username" class="form-control" placeholder="用户名"/>
					</div>
					<div style="color: red" align="center">${msggs}</div>
					<div class="form-group">
						<input type="password" name="password" id="password" class="form-control" placeholder="密码"/>
					</div>
					<div style="height:20px;">
								<%
								if (!"".equals(content)) {
								%>
							<span for="username" class="error" style="color: red; "><%=content%></span>
							<%
								}
							%>
					</div>
					<div class="form-group" style="margin-bottom: 0;margin-left: 2px;">
					<input type="checkbox" name="rememberMe"/> 记住我
					</div>
				</div>
				<div class="footer text-center loginbtn">
					<button type="submit" class="btn bg-loginbtn form-control">登录</button>
				</div>
			</form>
		</div>
	</div>
</section>
<footer class="login-foot"><div class="copyright"><img src="${ctx}/static/img/logo2.png" alt="logo">COPYRIGHT @ 2006-2016 SUNJAYS TECHNOLOGIES INCORPORATED.ALL RIGHTS RESERVED</div></footer>

	<!-- jQuery 2.0.2 -->
	<script src="${ctx}/static/js/jquery.min.js"></script> 
	<!-- Bootstrap -->
	<script src="${ctx}/static/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/static/jquery-validation/1.11.1/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/jquery-validation/1.11.1/messages_bs_zh.js"></script>
	<script type="text/javascript" src="${ctx}/static/jquery-validation/1.11.1/jquery.validate.extend.js"></script>
	 <script type="text/javascript" src="${ctx}/static/layer/layer.js"></script>
	<%-- <script type="text/javascript" src="${ctx}/static/js/AdminLTE/app.js"></script> --%>
	
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("#form1").validate({
			onsubmit:true,// 是否在提交是验证  
			onfocusout:false,// 是否在获取焦点时验证  
			onkeyup :false,// 是否在敲击键盘时验证
		rules:{
			username: {
				required : true
			},
			password: {
				required : true
			}
		},
		messages:{
		username:"用户名不能为空",
		password:"密码不能为空",
		},
		/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
		   errorPlacement: function (error, element) {
			   layer.tips(error.html(), '#'+element[0].id, {
	 			  tips: [2, "#78BA32"],
	 			  tipsMore: true
	 			}); 
	     }
		});
	});
</script>
</body>
</html>
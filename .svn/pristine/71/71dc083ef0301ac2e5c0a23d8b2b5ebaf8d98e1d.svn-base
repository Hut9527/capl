<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link rel="shortcut icon" href="${path }/static/img/prolog.ico"/>
    <!-- bootstrap 3.0.2 -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="${path}/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${path}/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <link href="${path}/static/css/query.css" rel="stylesheet" type="text/css" />
    <link href="${path}/static/css/pning.css" rel="stylesheet" type="text/css" />
    <!-- jQuery 2.0.2 -->
	<script type="text/javascript" src="${path}/static/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${path }/static/js/form.js"></script>
    <script type="text/javascript" src="${path }/static/layer/layer.js"></script>
    <script type="text/javascript" src="${path }/static/validation/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${path }/static/validation/messages_zh.js"></script>
<style>
        .skin-blue .navbar{
            background:#ef9c00;
        }
        .skin-blue .logo{
            background:#d08800;
        }
        .box{
            border-top: 2px solid #d08800;
        }
    </style>
</head>
<body class="skin-blue">
<div class="wrapper row-offcanvas row-offcanvas-left">
    <section class="content-header">
        <h5>
            用户信息
        </h5>
        <ol class="breadcrumb">
            <li>用户管理</li>
            <li class="active">用户信息</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
    <form action="${path }/yonghu/xinxi.do" method="post"></form>
        <div class="row">
            <div class="col-xs-12">
                <div class="condition">
                    <ul class="col-xs-6 elect pull-left">
                        <button id="insert" type="button" class="btn btn-success btn-lg"><i class="fa fa-fw fa-plus"></i> 添 加</button>
                        <button id="modify" type="button" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-pencil"></i> 修 改</button>
                        <button id="delete" type="button" class="btn btn btn-danger btn-lg"><i class="fa fa-fw fa-trash-o"></i> 删 除</button>
                    </ul>
                </div>
                <div class="box">
                    <div class="box-header">
                    </div><!-- /.box-header -->
                    <div class="box-body table-responsive">
                        <table id="example2" class="table table-bordered table-hover text-center">
                            <thead>
	                            <tr>
	                                <th>登录名</th>
	                                <th>姓名</th>
	                                <th>用户角色</th>
	                                <th>单位名称</th>
	                                <th>部门</th>
	                                <th>职位</th>
	                                <th>电话</th>
	                                <th>Mac地址</th>
	                                <th>备注</th>
	                            </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${list }" var="ui">
	                            <tr>
	                            	<input type="hidden" name="userid" value="${ui.userid }">
	                                <td>${ui.username }</td>
	                                <td>${ui.turename }</td>
	                                <td>${ui.authRole.rolename }</td>
	                                <td>${ui.userUnit.uuname }</td>
	                                <td>${ui.department }</td>
	                                <td>${ui.post }</td>
	                                <td>${ui.telephone }</td>
	                                <td>${ui.mac }</td>
	                                <td>${ui.remark1 }</td>
	                            </tr>
	                            </c:forEach>
                            </tbody>
                        </table>
                    </div><!-- /.box-body -->
                    <div>
                        <div>
                            <%@ include file="/static/fenye/fenye3.jsp"%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section><!-- /.content -->
</div><!-- ./wrapper -->
<!--遮罩层-->
<div id="dialogBg"></div>

<div id="dialog">
    <h4 id="mesg"></h4>
    <div class="row">
        <div class="col-xs-12">
            <div class="condition">
                <form action="${path }/yonghu/addOrUpdateUser.do" method="post" id="adduser">
                    <div class="col-xs-6 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>登录账号</span></div>
                            <input id="username" type="text" name="username" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <div class="col-xs-6 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>登陆密码</span></div>
                            <input id="password" type="password" name="password" placeholder="请输入..." class="form-control"><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <div class="col-xs-6 choice">
                        <div class="input-group">
                            <div class="input-group-btn seltit"><span>所属用户组</span></div>
                            <div class="selectpicker" data-clear="true">
                                <select name="userunitid" id="userunitid">
                                	<option value="">请选择</option>
                                	<c:forEach items="${unitList}" var="unit">
                                		<option value="${unit.uuid }">${unit.uuname }</option>
                                	</c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-6 choice">
                        <div class="input-group">
                            <div class="input-group-btn seltit"><span>所属角色</span></div>
                            <select name="roleid" id="roleid">
									 <option value="">--请选择--</option>
									 <c:forEach items="${roleList}" var="role">
                                		<option value="${role.roleid }">${role.rolename }</option>
                                	</c:forEach>
							</select>
                        </div>
                    </div>
                    <div class="col-xs-6 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>真实姓名</span></div>
                            <input id="turename" type="text" name="turename" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <div class="col-xs-6 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>部门名称</span></div>
                            <input id="department" type="text" name="department" placeholder="请输入..." class="form-control"><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <div class="col-xs-6 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>职位</span></div>
                            <input id="post" type="text" name="post" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    
                    <div class="col-xs-6 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>电话</span></div>
                            <input id="telephone" type="text" name="telephone" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    
                    <div class="col-xs-6 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>Mac</span></div>
                            <input id="mac" type="text" name="mac" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <div class="col-xs-6 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>备注</span></div>
                            <input id="remark" type="text" name="remark1" placeholder="请输入..." class="form-control"><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    
                    <ul class="col-xs-12 eletcadd">
                    	<input type="hidden" name="userid" id="userid">
                        <button type="submit" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-check-square"></i> 提 交</button>
                        <button id="cancel" type="button" class="btn btn-danger btn-lg"><i class="fa fa-fw fa-times"></i> 取 消</button>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div><!-- ./dialog-->

<!-- Bootstrap -->
<script type="text/javascript" src="${path}/static/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="${path}/static/js/bootstrap-select.js" ></script>
<%-- <script type="text/javascript" src="${path}/static/js/header.js"></script> --%>
<!-- AdminLTE App -->
<script type="text/javascript" src="${path}/static/js/AdminLTE/app.js" ></script>
<!--天气-->
<script type="text/javascript" src="${path}/static/js/jquery.leoweather.min.js"></script>
<!--日期-->
<script type="text/javascript" src="${path}/static/js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	var MSG='${MSG}';
	if(MSG!=null&&MSG!=''){
		layer.msg(MSG);
		//alert(MSG);
	}
	//点击添加按钮
	$("#insert").on('click',function(){
		 $("#mesg").html("<b>添加用户信息</b>");
		 $('#username').val("");
		 $('#password').val("");
		 $('#post').val("");
		 $('#turename').val("");
		 $('#department').val("");
		 $('#uuid').val("");
		 $('#telephone').val("");
		 $('#mac').val("");
		 $('#remark').val("");
		 $('#dialogBg').fadeIn(300);
	     $("#dialog").center().show();
	     $("#userunitid option:selected").attr("selected",false);
	     $("#roleid option:selected").attr("selected",false);
	 });
	//点击修改按钮
	$("#modify").on("click",function (){
	    if($("#example2 tr").hasClass("pitch")){
	        $("#dialog").center().show();
	        $("#mesg").html("<b>修改用户信息</b>");
	        var id=$('.pitch input').val();
	        $.ajax({
	      	   type: "POST",
	      	   url: "${path}/yonghu/selectUserByUserId.do",
	      	   data: {userid:id},
	      	   dataType:"json",
	      	   success: function(msg){
	      	   		
	 				$('#username').val(msg.username);
	 				$('#password').val(msg.password);
	 				$('#post').val(msg.post);
	 				$('#turename').val(msg.turename);
	 				$('#department').val(msg.department);
	 				$('#uuid').val(msg.uuid);
	 				$('#telephone').val(msg.telephone);
	 				$('#mac').val(msg.mac);
	 				$('#remark').val(msg.remark1);
	 				$('#userid').val(msg.userid);
	 				 $("#userunitid option:selected").attr("selected",false);
	 			     $("#roleid option:selected").attr("selected",false);
	 				$('#userunitid option').each(function() {
						var value = $(this).val();
						if (msg.userunitid == value) {
							$(this).prop('selected', 'selected');
						}
					})
					$('#roleid option').each(function() {
						var value = $(this).val();
						if (msg.roleid == value) {
							$(this).prop('selected', 'selected');
						}
					})
	 				
	      	   }
	      	}); 
	    }
	    else{
	        confirm("请选择一行");
	    }
	})
	//删除
	$('#delete').click(function () {
        if($("#example2 tr").hasClass("pitch")){
	        if(confirm("确定删除吗？")){
	        	var id=$('.pitch input').val();
	        	var roleid = $("#roleid option:selected").val();
	        	window.location.href="${path}/yonghu/deleteUserInfo.do?userid="+id; 
	            }
	        }
        else{
            confirm("请选择一行");
        }

    })
    
    window.onload=function(){
	//form表单验证
	$("#adduser").validate({
		onfocusout: function(element){
	        
	    },
	    onkeyup: false,
		rules : {
			username : {
				required : true,
				maxlength : 50,
				remote : {
					url : "${path}/yonghu/selectByAdminName.do",
					type : "post",
					dataType : "json",
					data : {
						username : function() {
							return $('#username').val();
						},
						userid : function() {
							return $('#userid').val();
						}
					}
				}
			},
			password:{
				required : true,
				rangelength:[6,16]
			},
			 roleid:{
				required : true
			},
			userunitid:{
				required : true
			},
			truename:{
				required : true
			}
		},
		messages : {
			username : {
				required : "登录账号不能为空",
				maxlength:"长度必须小于50",
				remote : "登录账号已存在"
			},
			password:{
				required : "登陆密码不能为空",
				rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
			},
			 roleid:{
				required : "用户角色不能为空"
			}, 
			userunitid:{
				required : "所属单位不能为空"
			},
			turename:{
				required : "真实姓名不能为空"
			}
		},
		/*  重写错误显示消息方法,以alert方式弹出错误消息   */
		   errorPlacement: function (error, element) {
			   layer.tips(error.html(), '#'+element[0].id, {
	    			  tips: [2, "#78BA32"],
	    			  tipsMore: true
	    			}); 
	        }
	}); 
} 
</script>
</body>
</html>
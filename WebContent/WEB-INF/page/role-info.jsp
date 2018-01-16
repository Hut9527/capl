<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色管理</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link rel="shortcut icon" href="${path }/static/img/prolog.ico"/>
    <!-- bootstrap 3.0.2 -->
    <link href="${path }/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="${path }/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->

    <link href="${path }/static/css/query.css" rel="stylesheet" type="text/css" />
    <link href="${path }/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <link href="${path }/static/css/pning.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${path }/static/js/jquery.min.js"></script>
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
<!-- header logo: style can be found in header.less -->
<!-- wrapper -->
<div class="wrapper row-offcanvas row-offcanvas-left">
    <section class="content-header">
        <h5>
            角色管理
        </h5>
        <ol class="breadcrumb">
            <li>用户管理</li>
            <li class="active">角色管理</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
        <form action="${path }/yonghu/jueseguanli.do" method="post"></form>
            <div class="col-xs-12">
                <div class="condition">
                    <ul class="col-xs-6 elect pull-left">
                        	<button id="insert" class="btn btn-success btn-lg"><i class="fa fa-fw fa-plus"></i> 添 加</button>
                        	<button id="modify" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-pencil"></i> 修 改</button>
                        	<button id="delete" class="btn btn btn-danger btn-lg"><i class="fa fa-fw fa-trash-o"></i> 删 除</button>
                    </ul>
                </div>
                <div class="box">
                    <div class="box-header">
                    </div><!-- /.box-header -->
                    <div class="box-body table-responsive">
                        <table id="example2" class="table table-bordered table-hover text-center">
                            <thead>
                            <tr>
                                <th>角色ID</th>
                                <th>角色名称</th>
                                <th>角色描述</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${roleList }" var="role">
                            <tr>
                                <td>${role.roleid }</td>
                                <td>${role.rolename }</td>
                                <td>${role.roledescription }</td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div><!-- /.box-body -->
                    <div  class="box-footer clearfix text-center">
                        <div class="Pager">
                             <%@ include file="/static/fenye/fenye3.jsp"%>
                        </div>
                    </div><!-- /.box-fotter -->
                </div><!-- /.box -->
            </div>
        </div>
    </section><!-- /.content -->
</div><!-- ./wrapper -->
<!--遮罩层-->
<div id="dialogBg"></div>
<!--dialog-->
<div id="dialog" style="width: 900px;">
    <h4 id ="mesg"></h4>
    <div class="row">
        <div class="col-xs-12">
            <div class="condition">
                <form action="${path}/yonghu/insertOrUpdateRole.do" method="post" id="addRole">
                    <div class="col-xs-4 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>角色名称</span></div>
                            <input id="rolename" name="rolename" type="text" placeholder="请输入..." class="form-control"/><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <div class="col-xs-4 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>角色描述</span></div>
                            <input id="describe" name="roledescription" type="text" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <div class="col-xs-4 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>备注</span></div>
                            <input id="remark" name="rolecode" type="text" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <table class="table table-bordered table-hover text-center" id="first">
                            <thead>
                            <tr>
                                <th>全选</th>
                                <th>一级菜单</th>
                            </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${flist }" var="mfun">
                            		<tr>
            						<td><input type="checkbox" value="${mfun.id }" name="menuId" onclick="docheck(this)" id="${mfun.id}Str"></td>
            						<td>${mfun.name}</td>
            						</tr>
            						</c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-xs-3">
                        <table class="table table-bordered table-hover text-center" id="second">
                            <thead>
                            <tr>
                                <th>全选</th>
                                <th>二级菜单</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                    <div class="col-xs-3">
                        <table class="table table-bordered table-hover text-center" id="three">
                            <thead>
                            <tr>
                                <th>全选</th>
                                <th>三级菜单</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                    <div class="col-xs-3">
                        <table class="table table-bordered table-hover text-center" id="four">
                            <thead>
                            <tr>
                                <th>全选</th>
                                <th>四级菜单</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                    <ul class="col-xs-12 eletcadd">
                    	<input type="hidden" name="menuIds" id="menuIds">
                    	<input type="hidden" name="roleid" id="roleid">
                        <button type="button" onclick="doSubmit()" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-check-square"></i> 提 交</button>
                        <button id="cancel" type="button" class="btn btn-danger btn-lg"><i class="fa fa-fw fa-times"></i> 取 消</button>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div><!-- ./dialog-->

<!-- jQuery 2.0.2 -->

<!-- Bootstrap -->
<script type="text/javascript" src="${path }/static/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="${path }/static/js/header.js"></script>

<!-- AdminLTE App -->
<script type="text/javascript" src="${path }/static/js/AdminLTE/app.js" ></script>
<!--天气-->
<script type="text/javascript" src="${path }/static/js/jquery.leoweather.min.js"></script>
<!--日期-->
<script type="text/javascript" src="${path }/static/js/DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	//打印添加修改信息
	var MSG='${MSG}';
	if(MSG!=null&&MSG!=''){
		layer.msg(MSG);
	}
    $(function () {
            $("#second tbody").html("");
            $("#three tbody").html("");
            $("#four tbody").html("");
    })
    var menuIds=new Array();
	//显示弹框
    $("#insert").on('click',function(){
       $('#dialogBg').fadeIn(300);
        $("#dialog").center().show();
        
        $("#mesg").html("<b>新增角色信息</b>");
        $('#rolename').val('');
		$('#describe').val('');
		$('#remark').val('');
		$('input[name="roleid"]').val('');
		$('#roleid').val('');
		$('input[type="checkbox"]').attr("checked",false);
    });
    //清除二,三,四级菜单信息
    function clear() {
        $("#second tbody").html("");
        $("#three tbody").html("");
        $("#four tbody").html("");
    }
    //点击一级菜单,加载对应二级菜单
    $("#first tbody tr").bind("click",function() {
        clear();
        var val=$(this).find('input[name="menuId"]').val();
        //alert(val);
        $.ajax({
      	   type: "POST",
      	   url: "${path}/yonghu/getMenusByParentId.do",
      	   data: {parentid:val},
      	   dataType:"json",
      	   success: function(msg){
      	   	   //alert(menuIds);
      		   var secondStr="";
      		   if (msg.length>0) {
	      		   for(var i=0;i<msg.length;i++){
	          			 if($.inArray(msg[i].id.toString(), menuIds)>=0){
	          			   secondStr+='<tr onclick=second(this)><td><input type="checkbox" name="menuID" value="'+msg[i].id+'" onclick="docheck(this)" checked="true"></td><td>'+
	          			 				msg[i].name+'</td> </tr>';
	          			 }else{
	          				secondStr+='<tr onclick=second(this)><td><input type="checkbox" name="menuID" value="'+msg[i].id+'" onclick="docheck(this)"></td><td>'+
				 				msg[i].name+'</td> </tr>';
	          			 }
	      	   		}
      		 	$("#second tbody").html(secondStr);
      		   }
      		/* $("input:checkbox[name=menuID]").attr("checked",true) */
      	   }
      	});
    })
    //点击二级菜单加载三级菜单
    var second=function(a){
	$("#three tbody").html("");
    $("#four tbody").html("");
    var $a=$(a);
    var val=$a.find('input[name="menuID"]').val();
    //alert(val);
    $.ajax({
    	   type: "POST",
    	   url: "${path}/yonghu/getMenusByParentId.do",
    	   data: {parentid:val},
    	   dataType:"json",
    	   success: function(msg){
    	   		var threeStr="";
    	   		if (msg.length>0) {
    	   			for(var i=0;i<msg.length;i++){
    	    			   if($.inArray(msg[i].id.toString(), menuIds)>=0){
    	    			   		threeStr+='<tr onclick=three(this)><td><input type="checkbox" name="menuID" value="'+msg[i].id+'" onclick="docheck(this)" checked="true"></td><td>'+
    	    			 					msg[i].name+'</td> </tr>';
    	    			   }else{
    	    				   threeStr+='<tr onclick=three(this)><td><input type="checkbox" name="menuID" value="'+msg[i].id+'" onclick="docheck(this)"></td><td>'+
    		 					msg[i].name+'</td> </tr>';
    	    			   }
    	    	   		}
    	    		 $("#three tbody").html(threeStr);
				}
    	   }
    	});
	}
    //监测点击后的选项是否选中
    var docheck=function(a){
	var $a=$(a);
    var val=$a.val();
	    if($a.is(':checked')){
	    	if($.inArray(val, menuIds)<0){
	    		menuIds.push(val);
	    	}  
	    }else{
	    	menuIds.splice(jQuery.inArray(val,menuIds),1);
	    }
	}
    var doSubmit=function(){
    	//alert(menuIds.toString()+"+++"+menuIds.join())
    	$('#menuIds').val(menuIds.toString());
    	$('#addRole').submit();
    }
    //-------------------------------------------------修改---------------------
    //点击修改按钮弹出
    $("#modify").on("click",function (){
        if($("#example2 tr").hasClass("pitch")){
            $("#dialog").center().show();
            $("#mesg").html("<b>修改角色信息</b>");
            var roleId=$('.pitch td:eq(0)').text();
            $('input[name="roleid"]').val(roleId);
          	//alert(roleId);
            menuIds=[];
            //alert(menuIds);
             $.ajax({
           	   type: "POST",
           	   url: "${path}/yonghu/updateRole.do",
           	   data: {'roleId':roleId},
           	   dataType:"json",
           	   success: function(msg){
           	   	 $('#rolename').val(msg.ROLE.rolename);
           	     $('#describe').val(msg.ROLE.roledescription);
           	     $('#remark').val(msg.ROLE.rolecode);
           	     for(var i=0;i<msg.LISTROLEMENUS.length;i++){
           	    	 var val=msg.LISTROLEMENUS[i].functionid;
           	    	 $('#'+val+'Str').attr("checked",true);
           	    	 menuIds.push(val.toString());
           	     }
           	   }
           	}); 
            
        }
        else{
            confirm("请选择一行");
        }
    })
  //删除角色
	$('#delete').click(function () {
        if($("#example2 tr").hasClass("pitch")){
	        if(confirm("确定删除吗？")){
	        	var id=$('.pitch td:eq(0)').text();
	        	$.ajax({
	         	   type: "POST",
	         	   url: "${path}/yonghu/isdeleteJueSe.do",
	         	   data: {roleid:id},
	         	   dataType:"json",
	         	   success: function(msg){
	         		   if(msg=='1'){
	         			   alert("请移除该角色下的所有人员方能删除！");
	         		   }else{
	         			 window.location.href="${path}/yonghu/deleteJueSe.do?roleid="+id;
	         		   }
	         	   }
	         	}); 
	        	
	            }
	        }
        else{
            confirm("请选择一行");
        }

    })
    
     window.onload=function(){
    	var layerFontColer="#78BA32";
		//form表单验证
		$("#addRole").validate({
			
			onfocusout: function(element){
		        
		    },
			rules : {
				rolename : {
					required : true,
					maxlength : 50,
					remote : {
						url : "${path}/yonghu/selectByRoleName.do",
						type : "post",
						dataType : "json",
						cache : false,
						async : false,
						data : {
							rolename : function() {
								return $('#rolename').val();
							},
							roleid : function() {
								return $('#addRole input[name="roleid"]').val();
							}
						}
					}
				}
			},
			messages : {
				rolename : {
					required : "角色名称不能为空",
					maxlength:"长度必须小于50",
					remote : "角色名称已存在"
				}
			},
			/* 重写错误显示消息方法,以alert方式弹出错误消息  */
			   errorPlacement: function (error, element) {
				   layer.tips(error.html(), '#'+element[0].id, {
		    			  tips: [2, layerFontColer],
		    			  tipsMore: true
		    			}); 
		        }
		});
    } 
</script>
</body>
</html>
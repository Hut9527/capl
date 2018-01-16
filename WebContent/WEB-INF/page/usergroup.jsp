<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户组管理</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link rel="shortcut icon" href="${path }/static/img/prolog.ico"/>
    <!-- bootstrap 3.0.2 -->
    <link href="${path }/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="${path }/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${path }/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <link href="${path }/static/css/query.css" rel="stylesheet" type="text/css" />
    <link href="${path }/static/css/pning.css" rel="stylesheet" type="text/css" />
    <script src="${path}/static/js/jquery-1.7.2.min.js"></script>
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
            用户组管理
        </h5>
        <ol class="breadcrumb">
            <li>用户管理</li>
            <li class="active"  onclick="doclick();">用户组管理</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
    <form action="${path }/yonghu/zuguanli.do" method="post"></form>
        <div class="row">
            <div class="col-xs-12">
                <div class="condition">
                    <ul class="col-xs-6 elect pull-left">
                        <button id="insert" class="btn btn-success btn-lg"><i class="fa fa-fw fa-plus"></i> 添 加</button>
                        <button id="modify" onclick="doclick();" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-pencil"></i> 修 改</button>
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
                                <th>单位名称</th>
                                <th>单位类型</th>
                                <th>备注</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list }" var="uu">
                            <tr>
                               <input type="hidden" value="${uu.uuid }">
                                <td>${uu.uuname }</td>
                                <td>${uu.unitType.utname }</td>
                                <td>${uu.uumemo }</td>
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
<div id="dialog" style="width: 328px;">
    <h4 id="mesg"></h4>
    <div class="row">
        <div class="col-xs-12">
            <div class="condition">
                <form action="${path}/yonghu/adddanwei.do" method="post" id="addform">
                    <div class="col-xs-12 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>单位名称</span></div>
                            <input id="uuname" name="uuname" type="text" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <div class="col-xs-12 choice">
                        <div class="input-group">
                            <div class="input-group-btn seltit"><span>单位类型</span></div>
                            <div class="selectpicker" data-clear="true">
                               <select name="unitypeid" id="unitypeid">
									 <option value="">--请选择--</option>
									 <c:forEach items="${utList }" var="ut">
									 	<option value="${ut.utid }">${ut.utname }</option>
									 </c:forEach>
							</select>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 choice">
                        <div class="input-group text">
                            <div class="input-group-btn seltit"><span>备注</span></div>
                            <input id="uumemo" name="uumemo" type="text" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
                        </div>
                    </div>
                    <ul class="col-xs-12 eletcadd">
                    	<input type="hidden" name="uuid" id="uuid">
                        <button type="submit" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-check-square"></i> 提 交</button>
                        <button id="cancel" type="button" class="btn btn-danger btn-lg"><i class="fa fa-fw fa-times"></i> 取 消</button>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div><!-- ./dialog-->

<!-- jQuery 2.0.2 -->
<script type="text/javascript" src="${path }/static/js/form.js"></script>
<!-- Bootstrap -->
<script type="text/javascript" src="${path }/static/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="${path }/static/js/bootstrap-select.js" ></script>
<script type="text/javascript" src="${path }/static/js/header.js"></script>
<!-- AdminLTE App -->
<script type="text/javascript" src="${path }/static/js/AdminLTE/app.js" ></script>
<!--天气-->
<script type="text/javascript" src="${path }/static/js/jquery.leoweather.min.js"></script>
<!--日期-->
<script type="text/javascript" src="${path }/static/js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	//显示操作信息
	var MSG='${MSG}';
	if(MSG!=null&&MSG!=''){
		layer.msg(MSG);
	}
	
	//点击添加
	$("#insert").on('click',function(){
			$("#mesg").html("<b>添加用户信息</b>");
			$('#uuid').val("");
  	   		$('#uumemo').val("");
  	   		$('#uuname').val("");
	       $('#dialogBg').fadeIn(300);
	        $("#dialog").center().show();
	        $("#unitypeid option:selected").attr("selected",false);
	        
	    });
	//修改用户组信息
	$("#modify").on("click",function (){
        if($("#example2 tr").hasClass("pitch")){
        	$("#mesg").html("<b>修改用户信息</b>");
            $("#dialog").center().show();
            var id=$('.pitch input').val();
            
            $.ajax({
          	   type: "POST",
          	   url: "${path}/yonghu/selectZuById.do",
          	   data: {id:id},
          	   dataType:"json",
          	   success: function(msg){
          	   		$('#uuid').val(msg.uuid);
          	   		$('#uumemo').val(msg.uumemo);
          	   		$('#uuname').val(msg.uuname);
          	   	 $("#unitypeid option:selected").attr("selected",false);
	          	   	$('#unitypeid option').each(function() {
						var value = $(this).val();
						if (msg.unitypeid == value) {
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
	        	window.location.href="${path}/yonghu/deleteUserGroup.do?ugid="+id; 
	            }
	        }
        else{
            confirm("请选择一行");
        }

    })
    
    
    window.onload=function(){
		var layerFontColer="#78BA32";
	//form表单验证
	$("#addform").validate({
		onfocusout: function(element){
	        
	    },
		rules : {
			uuname : {
				required : true,
				maxlength : 50,
				remote : {
					url : "${path}/yonghu/selectGroupByName.do",
					type : "post",
					dataType : "json",
					cache : false,
					async : false,
					data : {
						name : function() {
							return $('#uuname').val();
						},
						id : function() {
							return $('#uuid').val();
						}
					}
				}
			},
			unitypeid:{
				required : true
			}
		},
		messages : {
			uuname : {
				required : "用户组名称不能为空",
				maxlength:"长度必须小于50",
				remote : "用户组名称已存在"
			},
			unitypeid:{
				required : "单位类型不能为空"
			}
		},
		/* 重写错误显示消息方法,以alert方式弹出错误消息 */  
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
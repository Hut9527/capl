<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>考勤系统</title>
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<link rel="shortcut icon" href="${path }/static/img/prolog.ico"/>
	<!-- bootstrap 3.0.2 -->
	<link href="${path }/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<!-- font Awesome -->
	<link href="${path }/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<!-- Theme style -->
	<link href="${path }/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />
	<link type="text/css" rel="stylesheet" href="${path }/static/css/query.css" />
	<link type="text/css" rel="stylesheet" href="${path }/static/css/pning.css" />
	<link type="text/css" rel="stylesheet" href="${path }/static/css/honeySwitch.css" />
	<style>
		#dialog{width: 637px;}.seltit{width: 105px;}.text{width: 268px;}
        .box{
            border-top: 2px solid #d08800;
        }
         html, body{
            padding-top:25px;
        }
        .breadcrumb{
            float: right;
            background: transparent;
            margin-top: 0px;
            margin-bottom: 0;
            font-size: 12px;
            padding: 7px 5px;
            position: absolute;
            top: 15px;
            right: 10px;
            border-radius: 2px;
        }
        .content-header{
            background: #fbfbfb;
            box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
            position: relative;
            padding: 15px 15px 10px 20px;
        }
	</style>
</head>
<body class="skin-blue">
	<!-- header logo: style can be found in header.less -->
	<!-- <header class="header"></header> -->
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<!-- <aside class="left-side sidebar-offcanvas">
		</aside> -->
			<!-- Content Header (Page header) -->
		<section class="content-header">
			<h5>
				人员以及车辆数据管理
			</h5>
			<ol class="breadcrumb">
				<li>考勤系统</li>
				<li class="active">人员以及车辆数据管理</li>
			</ol>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<form action="">
                        <div class="condition">
                            <div class="col-lg-3 col-sm-4 col-xs-12 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>所属单位</span></div>
                                    <div class="select">
                                        <a href="###" class="clear"><span class="fa fa-times"></span><span class="sr-only"></span></a>
                                        <span class="caret"></span>
                                        <select name="uuname" id="uuname" class="sel" onchange="pcinfo()">
                                            <option value="">请选择</option>
                                            <c:forEach items="${unitList }" var="unit">
                                            <option value="${unit.uuname }">${unit.uuname }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-sm-6 col-xs-12 choice">
                                <div class="chaxun">
									<div class="chaxun-ren">
										<input type="radio"  name="lis" checked onclick="renyuan()">
										<span>人员信息</span>
									</div>
									<div class="chaxun-che">
										<input type="radio" name="lis" onclick="cheliang()">
										<span>车辆信息</span>
									</div>
									<div class="clear"></div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-4 col-xs-12 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>人员信息</span></div>
                                    <div class="select">
                                        <a href="###" class="clear"><span class="fa fa-times"></span><span class="sr-only"></span></a>
                                        <span class="caret"></span>
                                        <select name="userinfo" id="userinfo" class="sel">
                                            <option value="">请选择</option>
                                            <c:forEach items="${personsInfos }" var="person">
                                            <option value="${person.id }">${person.name }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-4 col-xs-12 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>车辆信息</span></div>
                                    <div class="select">
                                        <a href="###" class="clear"><span class="fa fa-times"></span><span class="sr-only"></span></a>
                                        <span class="caret"></span>
                                        <select name="carinfo" id="carinfo" class="sel" disabled="disabled">
                                            <option value="">请选择</option>
                                            <c:forEach items="${vehicleInfos }" var="car">
                                            <option value="${car.id }">${car.vehicle }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-4 col-xs-12 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>开始时间</span></div>
                                    <input id="starttime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker()">
                                </div>
                            </div>
                             <div class="col-lg-3 col-sm-4 col-xs-12 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>结束时间</span></div>
                                    <input id="starttime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker()">
                                </div>
                            </div>
                            <ul class="col-xs-6 elect pull-right">
                                <button id="search" class="btn btn-success btn-lg"><i class="fa fa-fw fa-search"></i> 搜 索</button>
                                <button id="all" class="btn btn btn-warning btn-lg"><i class="fa fa-fw fa-file-text-o"></i> 全 部</button>
                                <button id="export" class="btn btn-danger btn-lg"><i class="fa fa-fw fa-share-square-o"></i> 导 出</button>
                            </ul>
                        </div>
                    </form>
					<div class="box"  id="box1">
						<div class="box-header">
						</div><!-- /.box-header -->
						<div class="box-body table-responsive">
							<table id="example2" class="table table-bordered table-hover text-center">
								<thead>
									<tr>
										<th>人员信息</th>
										<th>所属单位</th>
										<th>录入时间</th>
										<th>点位坐标</th>
										<th>备注</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${carMa }" var="c">
									<tr>
										<td>${c.carnumber }</td>
										<td>${c.carnumber }</td>
										<td>${c.carnumber }</td>
										<td>${c.carnumber }</td>
										<td>${c.carnumber }</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div  class="box-footer clearfix text-center">
							<div>
	                            <%@ include file="/static/fenye/fenye3.jsp"%>
	                        </div>
						</div><!-- /.box-fotter -->
					</div><!-- /.box -->
				</div>
			</div>
		</section><!-- /.content -->
	</div>
	<!-- jQuery 2.0.2 -->
	<script src="${path }/static/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="${path }/static/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${path }/static/js/bootstrap-select.js"></script>
	<script type="text/javascript" src="${path }/static/js/header.js"></script>
	<!-- AdminLTE App -->
	<script type="text/javascript" src="${path }/static/js/AdminLTE/app.js" ></script>
	<!--天气-->
	<script type="text/javascript" src="${path }/static/js/jquery.leoweather.min.js"></script>
	<!--日期-->
	<script type="text/javascript" src="${path }/static/js/DatePicker/WdatePicker.js"></script>
	<!-- 开关 -->
	<script type="text/javascript" src="${path }/static/js/honeySwitch.js"></script>
</body>
<script type="text/javascript">
	//点击单选人员信息,禁用车辆信息下拉
	 function renyuan(){
		 $("#userinfo").prop("disabled", false);
		 $("#carinfo").prop("disabled", true);
		 $.ajax({
				type : 'post',
				url : '${path}/kaoqin/getAllUserInfo.do',
				async : true,
				data : {},
				datatype : 'json',
				success : function (data) {
					if (data != null) {
						//首先清除之前的数据
						
						$.each(data,function(n,v){
							$("#devid").append("<option value='"+v.devid+"'>"+v.devid+"</option>");
						});
					};
				}
			});
	}
	//点击单选车辆信息,禁用人员信息下拉
	function cheliang(){
		 $("#userinfo").prop("disabled", true);
		 $("#carinfo").prop("disabled", false);
		 $("#box2").show();
		 $("#box1").hidden();
		 $.ajax({
				type : 'post',
				url : '${path}/kaoqin/getAllCarInfo.do',
				async : true,
				data : {},
				datatype : 'json',
				success : function (data) {
					if (data != null) {
						//首先清除之前的数据
						//$("#devid").empty();
						
						console.log(data);
						/* $.each(data,function(n,v){
							$("#devid").append("<option value='"+v.devid+"'>"+v.devid+"</option>");
						}); */
					};
				}
			});
	} 
	//选择单位后列出相应的设备
	function pcinfo(){
		//获取当前选择的单位
		var company = $("#uuname").val();
		$.ajax({
			type : 'post',
			url : '${path}/kaoqin/getAllInfo.do',
			async : true,
			data : {"company" : company},
			datatype : 'json',
			success : function (data) {
				if (data != null) {
					//首先清除之前的数据
					$("#userinfo").empty();
					$("#carinfo").empty();
					$("#userinfo").append("<option value=''>请选择</option>");
					$("#carinfo").append("<option value=''>请选择</option>");
					console.log(data.persons)
					 $.each(data.persons,function(n,v){
						 $("#userinfo").append("<option value='"+v.id+"'>"+v.name+"</option>");
					});
					 $.each(data.vehicle,function(n,v){
						 $("#carinfo").append("<option value='"+v.id+"'>"+v.vehicle+"</option>");
					});
				};
			}
		});
	}
</script>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>车辆报表</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="${path }/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="${path }/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${path }/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <link href="${path }/static/css/query.css" rel="stylesheet" type="text/css" />
    <link href="${path }/static/css/pning.css" rel="stylesheet" type="text/css" />
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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-blue">
<!-- header logo: style can be found in header.less -->
<!-- wrapper -->
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <!-- Right side column. Contains the navbar and content of the page -->
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h5>
            报表管理
        </h5>
        <ol class="breadcrumb">
            <li>施工考勤</li>
            <li class="active">报表管理</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <!-- <div class="box"> -->
                    <!-- <div class="box-header">
                    </div> -->
                    <div class="condition">
                        <div class="col-lg-3 col-sm-3 col-xs-12 choice">
                            <div class="input-group">
                                <div class="input-group-btn seltit"><span>起始日期</span></div>
                                <input id="starttime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker()">
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-3 col-xs-12 choice">
                            <div class="input-group">
                                <div class="input-group-btn seltit"><span>截止日期</span></div>
                                <input id="starttime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker()">
                            </div>
                        </div>
                        <div class="col-xs-6 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>车牌号</span></div>
                                    <div class="select">
                                        <a href="###" class="clear"><span class="fa fa-times"></span><span class="sr-only"></span></a>
                                        <span class="caret"></span>
                                        <select name="vehicle" id="vehicleId" class="sel">
                                            <option value="">请选择</option>
                                            <c:forEach items="${car }" var="car">
                                            	<option value="${car.vehicle }">${car.vehicle }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        <ul class="col-xs-6 elect pull-right">
                            <button id="export" class="btn btn-danger btn-lg"><i class="fa fa-fw fa-share-square-o"></i> 导 出</button>
                            <button id="print" class="btn btn btn-warning btn-lg"><i class="fa fa-fw fa-file-text-o"></i> 打 印</button>
                        </ul>
                    </div>
                    <div style="height:300px;"></div>
                <!-- </div> -->
            </div>
        </div>
    </section><!-- /.content -->
</div><!-- ./wrapper -->


<!-- jQuery 2.0.2 -->
<script type="text/javascript" src="${path }/static/js/jquery.min.js"></script>
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
</body>
</html>
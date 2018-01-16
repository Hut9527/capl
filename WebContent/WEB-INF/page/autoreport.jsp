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
	<style>
		#dialog{width: 637px;}.seltit{width: 105px;}.text{width: 268px;}
        .box{
            border-top: 2px solid #d08800;
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
	<div class="wrapper row-offcanvas row-offcanvas-left">

		<section class="content-header">
			<h5>
				报表功能
			</h5>
			<ol class="breadcrumb">
				<li>施工考勤</li>
				<li class="active">报表功能</li>
			</ol>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<form action="">
                        <div class="condition">
                         	<div class="col-lg-3 col-sm-3 col-xs-12 choice">
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
                            <!-- <div class="col-lg-3 col-sm-4 col-xs-12 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>人员信息</span></div>
                                    <div class="select">
                                        <a href="###" class="clear"><span class="fa fa-times"></span><span class="sr-only"></span></a>
                                        <span class="caret"></span>
                                        <select name="bignumquery" id="bignum" class="sel">
                                            <option value="">请选择</option>
                                            <option value="">1</option>
                                            <option value="">2</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-sm-6 col-xs-12 choice">
                                <div class="chaxun">
									<div class="chaxun-ren">
										<input type="radio"  name="lis" checked>
										<span>人员信息</span>
									</div>
									<div class="chaxun-che">
										<input type="radio" name="lis">
										<span>车辆信息</span>
									</div>
									<div class="clear"></div>
                                </div>
                            </div> -->
                            <div class="col-xs-6 elect pull-right">
                                <button id="search" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-search"></i> 搜 索</button>
                                <button id="export" class="btn btn-danger btn-lg"><i class="fa fa-fw fa-share-square-o"></i> 导 出</button>                                            
                            </div>
                        </div>
                    </form>
					<!-- <div class="box">
						
					</div> -->
				</div>
			</div>
		</section><!-- /.content -->
	</div>
	<!-- ./wrapper -->
	<!-- jQuery 2.0.2 -->
	<script src="${path }/static/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="${path }/static/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${path }/static/js/bootstrap-select.js"></script>
	<script type="text/javascript" src="${path }/static/js/header.js"></script>
	<!-- AdminLTE App -->
	<%-- <script type="text/javascript" src="${path }/static/js/AdminLTE/app.js" ></script> --%>
	<!--天气-->
	<script type="text/javascript" src="${path }/static/js/jquery.leoweather.min.js"></script>
	<!--日期-->
	<script type="text/javascript" src="${path }/static/js/DatePicker/WdatePicker.js"></script>
	
	<script type="text/javascript">
	/* function daoru(){
		window.location.href="${path}/daoru/importExl.do";
		
	}
	 */
	
	
	</script>
</body>
</html>
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
	<!-- jQuery 2.0.2 -->
	<script src="${path }/static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path }/static/layer/layer.js"></script>
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
                                            <option value="${unit.uuname }" <c:if test='${unit.uuname ==company }'>selected='selected'</c:if>>${unit.uuname }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-sm-6 col-xs-12 choice">
                                <div class="chaxun">
									<div class="chaxun-ren">
										<input type="radio" id="renyuandanxuan" name="lis" value="renyuan" checked onclick="renyuan()">
										<span>人员信息</span>
									</div>
									<div class="chaxun-che">
										<input type="radio" id="cheliangdanxuan" name="lis" value="cheliang" onclick="cheliang()">
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
                                            	<option value="${person.name }" <c:if test='${person.name ==userinfoname }'>selected='selected'</c:if>>${person.name }</option>
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
                                            	<option value="${car.vehicle }">${car.vehicle }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-4 col-xs-12 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>开始时间</span></div>
                                    <input id="starttime" value="${starttime }" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                                </div>
                            </div>
                             <div class="col-lg-3 col-sm-4 col-xs-12 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>结束时间</span></div>
                                    <input id="endtime" value="${endtime }" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                                </div>
                            </div>
                            <ul class="col-xs-6 elect pull-right">
                                <button type="button" class="btn btn-success btn-lg" onclick="sousuo()"><i class="fa fa-fw fa-search"></i> 搜 索</button>
                                <button type="button" id="all" class="btn btn btn-warning btn-lg"><i class="fa fa-fw fa-file-text-o"></i> 全 部</button>
                                <button type="button" id="export" class="btn btn-danger btn-lg"><i class="fa fa-fw fa-share-square-o"></i> 导 出</button>
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
									<c:forEach items="${personMa }" var="p">
									<tr>
										<td>${p.personname }</td>
										<td>${p.company }</td>
										<td><fmt:formatDate value="${p.entertime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>${p.gpszb }</td>
										<td>${p.remark }</td>
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
					<div class="box"  id="box2" style="display: none;">
						<div class="box-header">
						</div><!-- /.box-header -->
						<div class="box-body table-responsive">
							<table id="example2" class="table table-bordered table-hover text-center">
								<thead>
									<tr>
										<th>车辆信息</th>
										<th>所属单位</th>
										<th>录入时间</th>
										<th>点位坐标</th>
										<th>备注</th>
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>
						</div>
						<div  class="box-footer clearfix text-center">
							  <div class="Pagerwc">
                                        <a class="Pager-one" href="javascript:void(0)" id="beginpage2">首页</a> 
                                        <a href='javascript:void(0)' id="SiloDataUp"  class="Pager-left">«</a>
                                    <p>共<span class="Pager-dij" id="pagecount2">${page.pageCount}</span>页，
									当前第<input type="text" id="currentpage2" class="Pager-ipt" value="${page.currentPage}">页</p>
									<a class="Pager-qw"  onclick="btnPageGo2()">前往</a>
                                        <a href='javascript:void(0)' class="Pager-left" id="SiloDataDown">»</a>
                                        <a class="Pager-zh" href="javascript:void(0)" id="endpage2">尾页</a>
                               </div>
						</div><!-- /.box-fotter -->
					</div><!-- /.box -->
				</div>
			</div>
		</section><!-- /.content -->
	</div>
	
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
	var MSG='${MSG}';
	if(MSG!=null&&MSG!=''){
		layer.msg(MSG);
	}
	//点击单选人员信息,禁用车辆信息下拉
	 function renyuan(){
		 $("#carinfo option:selected").removeProp("selected");
		 $("#userinfo").prop("disabled", false);
		 $("#carinfo").prop("disabled", true);
		 $("#starttime").val('');
		 $("#endtime").val('');
		 $("#box2").hide();
		 $("#box1").show();
		 $("#uuname option:first").attr("selected", "selected");
		 window.location.href="${path}/kaoqin/toPcinform.do";
		 
	}
	//点击单选车辆信息,禁用人员信息下拉，同时加载车辆信息
	function cheliang(){
		$("#userinfo option:selected").removeProp("selected");
		 $("#userinfo").prop("disabled", true);
		 $("#carinfo").prop("disabled", false);
		 $("#starttime").val('');
		 $("#endtime").val('');
		 $("#box2").show();
		 $("#box1").hide();
		 
		 $("#uuname option:first").attr("selected", "selected");
		 /* layer.msg('加载中', {
			  icon: 16,
			  shade: 0.01
			}); */
		 gotoCarPage(0);
	} 
	var gotoCarPage = function(pageNum) {
		$.ajax({
			type : "POST",
			url : "${path}/kaoqin/selectAllCarData.do",
			data : {
				"pageNum" : pageNum
			},
			dataType : "json",
			success : function(msg) {
				var tbody = '';
				if (msg.LIST.length>0) {
					for (var i = 0; i < msg.LIST.length; i++) {
						
						tbody += "<tr><td>" + msg.LIST[i].carnumber + "</td><td>"
								+ msg.LIST[i].company + "</td><td>"
								+ msg.LIST[i].entertime + "</td><td>"
								+ msg.LIST[i].gpszb + "</td><td>"
								+ msg.LIST[i].remark + "</td></tr>";
					}
				}
				$('#box2 tbody').empty();
				$('#box2 tbody').html(tbody);
				var ul = '';
				//alert(typeof (msg.page.currentPage));
				$('#beginpage2').attr(
						'href',
						'javascript:gotoCarPage('
								+ (msg.page.beginPageIndex) + ');');
				$('#endpage2').attr(
						'href',
						'javascript:gotoCarPage('
								+ (msg.page.endPageIndex) + ');');
				
				$('#SiloDataUp').attr(
						'href',
						'javascript:gotoCarPage('
								+ (msg.page.currentPage - 1) + ');');
				$('#SiloDataDown').attr(
						'href',
						'javascript:gotoCarPage('
								+ (msg.page.currentPage + 1) + ');');
				$("#pagecount2").html(msg.page.pageCount);
				$("#currentpage2").val(msg.page.currentPage);
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
	//搜索按钮事件
	function sousuo(){
		var company = $("#uuname option:selected").val();
		var radio = $("input[type='radio']:checked").val();
		var userinfoname = $("#userinfo option:selected").val();
		var carinfoname = $("#carinfo option:selected").val();
		
		var starttime = $("#starttime").val();
		var endtime = $("#endtime").val();
		if(endtime.length>0){
			if(starttime==null||starttime==''){
				layer.tips('请输入开始时间', '#starttime', {
		  			  tips: [2, "#78BA32"],
		  			  tipsMore: true
		  			});
				return;
			}
			
		}
		if(starttime.length>0&&endtime.length>0){
			if (starttime>endtime) {
				layer.tips('开始时间不能大于起始时间', '#starttime', {
		  			  tips: [2, "#78BA32"],
		  			  tipsMore: true
		  			});
					return;
			}
		}
		if (radio=="renyuan") {
			window.location.href="${path}/kaoqin/toPcinform.do?company="+company+
					"&userinfoname="+userinfoname+"&starttime="+starttime+"&endtime="+endtime+"&flag=2";
		}
		if (radio=="cheliang") {
			$.ajax({
				type : 'post',
				url : '${path}/kaoqin/selectAllCarData.do',
				async : true,
				data : {'company':company,'carinfoname':carinfoname,'starttime':starttime,'endtime':endtime,'flag':1},
				datatype : 'json',
				success : function (msg) {
					if (msg.LIST.length<=0) {
						layer.msg("没有相关数据",{
							time: 3000,
						});
					};
					var tbody = '';
					if (msg.LIST.length>0) {
						for (var i = 0; i < msg.LIST.length; i++) {
							
							tbody += "<tr><td>" + msg.LIST[i].carnumber + "</td><td>"
									+ msg.LIST[i].company + "</td><td>"
									+ msg.LIST[i].entertime + "</td><td>"
									+ msg.LIST[i].gpszb + "</td><td>"
									+ msg.LIST[i].remark + "</td></tr>";
						}
					}
					$('#box2 tbody').empty();
					$('#box2 tbody').html(tbody);
					var ul = '';
					//alert(typeof (msg.page.currentPage));
					$('#beginpage2').attr(
							'href',
							'javascript:gotoCarPage('
									+ (msg.page.beginPageIndex) + ');');
					$('#endpage2').attr(
							'href',
							'javascript:gotoCarPage('
									+ (msg.page.endPageIndex) + ');');
					$('#SiloDataUp').attr(
							'href',
							'javascript:gotoCarPage('
									+ (msg.page.currentPage - 1) + ');');
					$('#SiloDataDown').attr(
							'href',
							'javascript:gotoCarPage('
									+ (msg.page.currentPage + 1) + ');');
					$("#pagecount2").html(msg.page.pageCount);
					$("#currentpage2").val(msg.page.currentPage);
				}
			});
		
		}
	}
</script>
</html>
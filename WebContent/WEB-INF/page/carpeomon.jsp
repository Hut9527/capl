<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>施工区导航图</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.0.2 -->
<link href="${path }/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- font Awesome -->
<link href="${path }/static/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<!-- Theme style -->
<link href="${path }/static/css/AdminLTE.css" rel="stylesheet"
	type="text/css" />
<link href="${path }/static/css/query.css" rel="stylesheet"
	type="text/css" />
<link href="${path }/static/css/pning.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=bx488V75MS82pnMhvuLzgWLT1vRqmkA9"></script>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body, html {
	width: 100%;
	margin: 0;
	font-family: "微软雅黑";
	padding-bottom:0;
}

#allmap {
	width: 100%;
	height: 100%;
}

p {
	margin-left: 5px;
	font-size: 14px;
}

</style>
</head>
<body>
	<div class="wrapper">
		<section class="content-header">
			<h5>施工区导航图</h5>
			<ol class="breadcrumb">
				<li>监控管理</li>
				<li class="active">施工区导航图</li>
			</ol>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="wcfap">
						<div id="wcbox"
							style="position: relative; overflow: hidden;height:920px;">
							<div id="allmap"></div>
						</div>
						
					</div>
				</div>
			</div>
		</section>
	</div>
	<script type="text/javascript" src="${path }/static/js/pointtransfertools.js"></script>
	<!-- jQuery 2.0.2 -->
	<script type="text/javascript" src="${path }/static/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script type="text/javascript"
		src="${path }/static/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${path }/static/js/bootstrap-select.js"></script>
	<script type="text/javascript" src="${path }/static/js/header.js"></script>
	<!-- AdminLTE App -->
	<%-- <script type="text/javascript" src="${path }/static/js/AdminLTE/app.js"></script> --%>
	<!--天气-->
	<script type="text/javascript"
		src="${path }/static/js/jquery.leoweather.min.js"></script>
	

	<script type="text/javascript">
		//百度地图API功能
		var map = new BMap.Map("allmap");
		map.centerAndZoom(new BMap.Point(108.05336211131161,33.33467230174283), 16);
		// 添加带有定位的导航控件
		var navigationControl = new BMap.NavigationControl({
		// 靠左上角位置
		anchor : BMAP_ANCHOR_TOP_LEFT,
		// LARGE类型
		type : BMAP_NAVIGATION_CONTROL_LARGE,
		// 启用显示定位
		enableGeolocation : true
		});
		map.addControl(navigationControl);
		map.enableScrollWheelZoom();//启动鼠标滚轮缩放地图
		
		
		//页面加载完成执行
		$(function(){
			//每过两秒查询一次数据
			setInterval(getzuobiao,2000);
			function getzuobiao(){
				//获取车和人的数据
				$.ajax({
					type : 'post',
					url : '${path}/carpeomon/getAll.do',
					dataType : 'json',
					data : {},
					async : true,
					
					success : function (data){
						
						//首先清除之前地图的标注
						map.clearOverlays();
						if(data != null){
							//车
							$.each(data.car,function(n,v){
								//原来的gps坐标
								var points = new BMap.Point(v.longitude,v.latitude);
								//吧gps坐标转换成百度坐标
								var arr = [];
								arr.push(points);
								var a = GpsToBaiduPoints(arr);
								//map.centerAndZoom(a[0], 14);
								//console.log(a[0])
								//文本信息
								var label = new BMap.Label(v.vehicle+","+v.speed,{offset:new BMap.Size(-18,27)});
								//小车图标
								var myIcon = new BMap.Icon("${path}/static/img/car.png", new BMap.Size(35,27),{
									anchor: new BMap.Size(17, 25),
								    imageOffset: new BMap.Size(0-4, 0 - 0)
								});
								var marker2 = new BMap.Marker(a[0],{icon:myIcon});  // 创建标注
								marker2.setLabel(label);
								map.addOverlay(marker2);
								
							});
							
							//人
							$.each(data.peo,function(n,v){
								
								//原来的gps坐标
								var points = new BMap.Point(v.longitude,v.latitude);
								//吧gps坐标转换成百度坐标
								var arr = [];
								arr.push(points);
								var a = GpsToBaiduPoints(arr);
								//map.centerAndZoom(a[0], 14);
								//文本信息
								var label = new BMap.Label(v.name,{offset:new BMap.Size(-6,27)});
								//人员图标
								var myIcon = new BMap.Icon("${path}/static/img/peo.png", new BMap.Size(35,27),{
									anchor: new BMap.Size(17, 25),
								    imageOffset: new BMap.Size(0-4, 0 - 0)
								});
								var marker2 = new BMap.Marker(a[0],{icon:myIcon});  // 创建标注
								marker2.setLabel(label);
								map.addOverlay(marker2);
								
							});
						} else {
							map.clearOverlays();
						}
						
						
					}
					
				});
				
			}
			
			
		});
		
		
	</script>
</body>
</html>
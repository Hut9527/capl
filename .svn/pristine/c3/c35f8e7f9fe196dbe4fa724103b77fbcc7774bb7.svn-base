<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车辆监测</title>
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
	height: 100%;
	margin: 0;
	font-family: "微软雅黑";
}
.body{
	overflow:hidden;
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
<body class="skin-blue" style="height:920px;">
	<div>
		<section class="content-header">
			<h5>车辆监测</h5>
			<ol class="breadcrumb">
				<li>监控管理</li>
				<li class="active">车辆监测</li>
			</ol>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="wcfap">
						<div id="wcbox"
							style="height: 750px; margin-bottom: 20px; position: relative; overflow: hidden;">
							<div id="allmap"></div>
							<div class="wcfap-left">
								<div class="wcfap-left-top">
									<div class="wcfap-left-top-d1">
										<span>车牌号:</span><input type="text" id="carhao">
									</div>
									<div class="wcfap-left-top-d2">
										<span>联系方式:</span><input type="text" id="ipo">
									</div>
									<div class="wcfap-left-top-d2">
										<span>工作单位:</span><input type="text" id="company">
									</div>
									<div class="wcfap-left-top-d2">
										<span>工作区域:</span><input type="text" id="zone">
									</div>
									<div onclick="chaxun();qingchu()" class="wcfap-left-top-d3">查询</div>
								</div>
								<div class="wcfap-left-cont">
									<div class="wcfap-left-cont-le">
										<div class="wcfap-left-cont-d1"></div>
										<span>车辆信息</span>
										<div class="wcfap-left-cont-d2"></div>
									</div>
									<ul class="wcfap-left-cont-ul">
										<li id="but1">全选</li>
										<li id="but2">反选</li>
										<li onclick="shuaxin()">刷新</li>
									</ul>
									<div class="wcfap-left-cont-tab">
										<table id="car" class="table">
											<thead>
												<tr id="state_th">
													<th></th>
													<th>车牌号</th>
													<th>状态</th>
													<th>SIM号</th>
												</tr>
											</thead>
											<tbody>
												<!-- <tr>
													<td></td>
													<td>12</td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td></td>
													<td>12</td>
													<td></td>
													<td></td>
												</tr>
												<tr>
													<td></td>
													<td>12</td>
													<td></td>
													<td></td>
												</tr> -->
											</tbody>
										</table>
									</div>
								</div>
								<div class="wcfap-left-cebian">
									<div class="wcfap-left-cebian-d1">
										<img src="${path }/static/img/icon/left-02.png" alt="">
									</div>
									<div class="wcfap-left-cebian-d2" style="display: none;">
										<img src="${path }/static/img/icon/left-01.png" alt="">
									</div>
								</div>
							</div>
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
	<!--日期-->
	<script type="text/javascript"
		src="${path }/static/js/DatePicker/WdatePicker.js"></script>
	<script>
		$('.wcfap-left-cebian-d1').click(function() {
			$('.wcfap-left').animate({
				left : '-290px'
			}, 300, function() {
				$('.wcfap-left-cebian-d1').css({
					display : 'none'
				});
				$('.wcfap-left-cebian-d2').css({
					display : 'block'
				});
			})
		})
		$('.wcfap-left-cebian-d2').click(function() {
			$('.wcfap-left').animate({
				left : '0px'
			}, 300, function() {
				$('.wcfap-left-cebian-d2').css({
					display : 'none'
				});
				$('.wcfap-left-cebian-d1').css({
					display : 'block'
				});
			})
		})
		
	</script>

	<script type="text/javascript">
		
		/* 新加 */
		/* $('.wcfap-left-cont-tab table tbody tr').on('click',function(){
			$(this).css('background','lightgrey').siblings().css('background','none');
		}) */
		
	
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
		
		//定义一些变量来判断是自动还是手动
		var bo = true;
		var boChufa = false;
		var boChaxun = false;
		var carhao = "";
		var ipo = "";
		var company = "";
		var zone = "";
		
		//页面加载完成后执行
		$(function(){
			shuaxin();
		});
		
		function zhongzhuan(){
			
			//发送参数到后台获取相应的值
			$.ajax({
				type : 'post',
				async : true,
				url : '${path}/carmon/getVCSZ.do',
				data : {"vehicle":carhao,"simnumber":ipo,"company":company,
					"zone":zone},
				dataType : 'json',
				
				success : function(data){
					
					//首先清除之前地图的标注
					map.clearOverlays();
					
					if(data!=null){
						$.each(data,function(n,v){
							
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
							//状态放入td
							$("#"+v.id+"").html(v.remark);
							
							var check = document.getElementsByName("check");
							for (var i = 0 ; i < check.length ; i++) {
								if(v.vehicle == check[i].value){
									check[i].checked = true;
								}
							}
						});
					} else {
						map.clearOverlays();
					}
				}
			});
						
		}
		
		//把车辆信息放入table中
		function shuaxin(){
			//删除原表中所有数据
			$("#car tbody").empty();
			
			$.ajax({
				type : "post",
				async : false,
				data : {},
				dataType : "json",
				url : "${path}/carmon/getVehinfo.do",
				
				success : function(data){
					if(data!=null){
						
						$.each(data,function(n,v){
							
							var tab = $("#car");
							var $tdChecked = $("<td></td>");
							//把查询到的车牌号和SIM放入各种td中
							var veh = v.vehicle;
							$tdChecked.html("<input name='check' onclick='chufa()' value='"+veh+"' type='checkbox'></input>");
							
							var $tdVehicle = $("<td>"+v.vehicle+"</td>");
							var $tdZhuangtai = $("<td id='"+v.id+"'>"+v.remark+"</td>");
							var $tdSim = $("<td>"+v.simnumber+"</td>");
							 
							//创建一个tr
							var $tr = $("<tr id='"+v.vehicle+"' onclick=panto('"+v.vehicle+"')></tr>");
							//把各种td放入tr
							$tr.append($tdChecked);
							$tr.append($tdVehicle);
							$tr.append($tdZhuangtai);
							$tr.append($tdSim);
							//把tr放入table
							tab.append($tr);
							
						})
						
					}
					
				}
				
			});
			
		}
		
		//全选
		$("#but1").click(function(){ 
			$("input[name='check']").prop("checked",true);
			chufa();
		})
		
		//反选
		$("#but2").click(function(){ 
			$("input[name='check']").each(function () {  
	             $(this).prop("checked", !$(this).prop("checked"));  
	        });
			chufa();
		})
		
		//传入从checkbox活动的参数并查询
		function chufa(){
			bo = false;
			boChufa = true;
			boChaxun = false;
			
			//获取所有选中的值用句号分开
			var valArr = new Array;
			$("input[name='check']:checked").each(function(i){
				valArr[i] = $(this).val();
			})
			var veh = valArr.join(',');
			
			//发送参数到后台获取相应的值
			$.ajax({
				type : 'post',
				async : true,
				url : '${path}/carmon/getVeh.do',
				data : {"vehicle":veh},
				dataType : 'json',
				
				success : function(data){
					
					//首先清除之前地图的标注
					map.clearOverlays();
					
					if(data[0].id != 0){
						$.each(data,function(n,v){
						
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
							//状态放入td
							$("#"+v.id+"").html(v.remark);
						});
					} else {
						map.clearOverlays();
					}
				}
				
			});
		}
		
		//手动输入的查询
		function chaxun(){
			bo = false;
			boChaxun = true;
			boChufa = false;
			carhao = $("#carhao").val().trim();
			ipo = $("#ipo").val().trim();
			company = $("#company").val().trim();
			zone = $("#zone").val().trim();
		}
		
		//每过两秒查询一次数据
		setInterval(getzuobiao,2000);
		function getzuobiao(){
			//自动的时候
			if(bo){
				//自动从后台调取数据
				$.ajax({
					type : "post",
					url : "${path}/carmon/getAll.do",
					data : {
						
					},
					async : true,
					dataType : "json",
					
					success : function(data){
						//首先清除之前地图的标注
						map.clearOverlays();
						if(data!=null){
							$.each(data,function(n,v){
							
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
								//状态放入td
								$("#"+v.id+"").html(v.remark);
								
								var check = document.getElementsByName("check");
								for (var i = 0 ; i < check.length ; i++) {
									if(v.vehicle == check[i].value){
										check[i].checked = true;
									}
								}
							});
						} else {
							map.clearOverlays();
						}
					}
					
				});
			} else {
				
				//复选框事件
				if (boChufa) {
					chufa();
				}
				
				//查询事件
				if (boChaxun) {
					zhongzhuan();
				}
			}
			
		}
		
		//点击设置地图中心
		function panto(vehicle){
			
			$.ajax({
				type : 'post',
				url : '${path}/carmon/getVeh.do',
				dataType : 'json',
				data : {"vehicle":vehicle},
				async : false,
				
				success : function (data){
					
					var canter = new BMap.Point(data[0].longitude,data[0].latitude);
					map.panTo(canter)
				}
				
			})
			
			$("#"+vehicle+"").css('background','#ddf4ff').siblings().css('background','none');
		}
		
		function qingchu(){
			var check = document.getElementsByName("check");
			for (var i = 0 ; i < check.length ; i++) {
				check[i].checked = false;
			}
		}
	</script>
	<script type="text/javascript">
		var _hei=$(window).height();
		var _heile=$('.wcfap-left').height();
		$('#wcbox').height(_heile+25);
		
	</script>
</body>
</html>
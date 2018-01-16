<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车辆轨迹回放</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.0.2 -->
<link rel="shortcut icon" href="${path }/static/img/prolog.ico"/>
<link href="${path}/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- font Awesome -->
<link href="${path}/static/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<!-- Theme style -->
<link href="${path}/static/css/AdminLTE.css" rel="stylesheet"
	type="text/css" />
<link href="${path}/static/css/query.css" rel="stylesheet"
	type="text/css" />
<link href="${path}/static/css/pning.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" rel="stylesheet" href="${path }/static/css/honeySwitch.css" />
<link rel="stylesheet" type="text/css" href="${path}/static/css/default.css" />
<link rel="stylesheet" type="text/css" href="${path}/static/css/jquery-ui-slider-pips.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/static/css/jqueryui.min.css" />
<script src="${path }/static/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${path }/static/layer/layer.js"></script>
<script type="text/javascript" src="${path }/static/validation/jquery.validate.min.js"></script>
<style>
.skin-blue .navbar {
	background: #ef9c00;
}

.skin-blue .logo {
	background: #d08800;
}

.box {
	border-top: 2px solid #d08800;
}

#emoji-slider {
	height: 5px;
	margin-top: 0;
	top: 10px;
}

#emoji-slider .ui-slider-handle {
	top: -6px;
	height: 12px;
	width: 12px;
	transform: rotateZ(45deg);
}

#emoji-slider .ui-slider-pip {
	top: 6px;
	margin-left: -1.2em;
}

#emoji-slider .emoji {
	max-height: 2em;
	transform: scale(0.9);
	transition: transform 0.2s ease-out;
}

@media screen and (max-width: 950px) {
	#emoji-slider .emoji {
		transform: scale(0.7);
	}
}

#emoji-slider .ui-slider-pip-selected .emoji {
	transform: scale(1.3) translateY(-5px);
}

@media screen and (max-width: 950px) {
	#emoji-slider .ui-slider-pip-selected .emoji {
		transform: scale(1.1) translateY(-5px);
	}
}

#emoji-slider .ui-slider-line {
	display: none;
}

#speed_tit {
	float: left;
	/*margin-top: 100px;*/
}

#speed_kedu {
	float: left;
	height: 40px;
	margin-left: 30px;
}

.select01 {
	width: 140px;
	height: 34px;
	color: #333; 
	border: 1px solid #c8c8c8;
}

.playback {
	font-size: 14px;
}
select{font-size: 14px;}
</style>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
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
			<h5>车辆轨迹回放</h5>
			<ol class="breadcrumb">
				<li>轨迹查询</li>
				<li class="active">车辆轨迹回放</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row" >
				<div class="trajectory">
					<div class="trajectory-top">
						<ul class="trajectory-top-ul">
							<li><span>所属单位</span> <select name="" id="danwei" onchange="shebei()"><option value="">请选择</option>
							</select></li>
							<li><span>车牌号</span> <select name="" id="vehicle"></select></li>
							<li><span>开始时间</span> <input id="starttime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker()" style="display: inline;width:140px!important;"></li>
							<li><span>结束时间</span> <input id="overtime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker()" style="display: inline;width:140px!important;"></li>
						</ul>
						
						
						
					</div>
					<ul class="trajectory-ul">
						<li><span>采集点数</span> <input type="text" id="dianshu"></li>
						<li class="trajectory-ul-li03"><span>行驶公里</span> <input
							type="text" id="gongli"> <span>公里</span></li>
						<li class="trajectory-ul-li03"><span>总里程</span> <input
							type="text" id="zonglishu"> <span>公里</span></li>
						
						<li><span>切换地图</span> <select id="stylelist" class="select01" onchange="changeMapStyle(this.value)"></select></li>
						
					</ul>
					
					<ul class="trajectory-ul  trajectory-ul-sto" style="margin-top:0;">
						<li><span>位置</span> <input type="text" id="weizhi"></li>
						<li class="trajectory-ul-li02"><span>速度</span> <input
							type="text" id="sudu"> <span style="width:68px;">千米/小时</span></li>
						<li><span>时间</span> <input type="text" id="shijian"></li>
						<li><span>状态</span> <input id="zhuangtai" type="text"></li>
						<li>
							<ul class="trajectory-top-ul02" >
								<button class="trajectory-top-btn btn btn-success" id="play" type="button" onclick="chaxun()"><img alt="" src="${path}/static/img/bofang.png">播放</button>
								<button class="trajectory-top-btn btn btn-warning" id="pause" type="button" onclick="pause()"><img alt="" src="${path}/static/img/zanting.png">暂停</button>
								<button class="trajectory-top-btn btn btn-danger" id="reset" type="button" onclick="reset()"><img alt="" src="${path}/static/img/chongzhi.png">重置</button>
							</ul>
						</li>
						<li style="width:1000px;overflow: visible; margin-top:0;">
							
							<div class="playback" id="speed_tit">回放速度</div>
							<div style="width:500px;" id="speed_kedu">
								<div id="emoji-slider"></div>
							</div>
							<div class="trajectory-ul-gensui">
								<span class="trajectory-top-ul02-span" style="background:#199FDE;width:104px;">
									<input id="follow" type="checkbox">
										<span style="font-size:12px;width:70px;color:#fff;">画面跟随</span>
									</input>
								</span>
								
							</div>
							<div class="trajectory-top-db">
								<div class="trajectory-top-db-d1"  onclick="saveImg()">
									
									<img src="${path }/static/img/icon/xiazai.png" alt="">
									<span style="line-height:20px;">保存</span> 
								</div>
								<div class="trajectory-top-db-d2" onclick="printdiv()">
									
									<img src="${path }/static/img/icon/daying.png" alt=""> 
									<span >打印</span>
								</div>
							</div>
							
							
						</li>
					</ul>
				</div>
				<div id="wcbox" class="mmm" style="margin-bottom: 20px;">
					<div></div>
				</div>
			</div>
		</section>
		<!-- /.content -->
	</div>
	<!-- ./wrapper -->
	<script type="text/javascript" src="http://lbsyun.baidu.com/custom/stylelist.js"></script>
	<script type="text/javascript"
		src="http://api.map.baidu.com/api?v=2.0&ak=Xdttjo4Cj46nWu8cj9e8KqMYA7XzFmz4"></script>
	<script type="text/javascript" src="${path }/static/js/pointtransfertools.js"></script>
	<script type="text/javascript" src="${path}/static/js/LuShu_min.js"></script>
	<!-- jQuery 2.0.2 -->
	<script type="text/javascript" src="${path}/static/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script type="text/javascript" src="${path}/static/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${path}/static/js/bootstrap-select.js"></script>
	<script type="text/javascript" src="${path}/static/js/header.js"></script>
	<!-- AdminLTE App -->
	<%-- <script type="text/javascript" src="${path}/static/js/AdminLTE/app2.js"></script> --%>
	<!--天气-->
	<script type="text/javascript"
		src="${path}/static/js/jquery.leoweather.min.js"></script>
	<!--日期-->
	<script type="text/javascript"
		src="${path}/static/js/DatePicker/WdatePicker.js"></script>
	
	<script src="http://demo.htmleaf.com/1502/201502131638/js/jquery-plus-ui.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="http://demo.htmleaf.com/1502/201502131638/js/jquery-ui-slider-pips.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
	var emoji = ["x1", "x2", "x4", "x8", "x16", "x32"],
	mine = "x1";

	$("#emoji-slider").slider({
		max: 5,
		value: 0
	}).slider("pips", {
		rest: "label",
		labels: emoji
	}).on("slidechange", function(e, ui) {
		var v = ui.value;
		if (v == 0) {
			hfspeed = 320;
		}
		if (v == 1) {
			hfspeed = 160;
		}
		if (v == 2) {
			hfspeed = 80;
		}
		if (v == 3) {
			hfspeed = 40;
		}
		if (v == 4) {
			hfspeed = 20;
		}
		if (v == 5) {
			hfspeed = 10;
		}
		$(".emoji-slider-question")
			.css({
				opacity: 0
			});
		setTimeout(function() {
			$(".emoji-slider-question")
				.css({
					opacity: 1
				});
		}, 200);
	});
	
	
	//初始化模板选择的下拉框
	var sel = document.getElementById('stylelist');
	for(var key in mapstyles){
		var style = mapstyles[key];
		var item = new  Option(style.title,key);
		sel.options.add(item);
	}
	
	var wcbox = document.getElementById('wcbox');
	var map = new BMap.Map("wcbox"); // 创建地图实例  
	window.map = map;
	var point = new BMap.Point(113.57249459687654, 34.823529860982745); // 创建点坐标  
	map.centerAndZoom(point, 14); // 初始化地图，设置中心点坐标和地图级别 
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.GeolocationControl());
	map.addControl(new BMap.OverviewMapControl());
	map.enableScrollWheelZoom();//启动鼠标滚轮缩放地图
	map.addControl(new BMap.MapTypeControl());          //添加地图类型控件
	map.disable3DBuilding();
	
	changeMapStyle('normal')
	sel.value = 'normal';

	function changeMapStyle(style){
		map.setMapStyle({style:style});
		$('#desc').html(mapstyles[style].desc);
	}
	
	var output = "";
	var allpoints = []; //所有点的集合
	var allTime = []; 
	var allVehcile = [];
	var allSpeed = [];
	var allZT = [];
	var opts;
	var gongli = 0;
	var index = 0; //记录播放到第几个point
	var car; //汽车图标
	var timer; //定时器
	var label; //信息图鉴
	var allpolins = "";//折线
	var pabo = true;
	var hfspeed = 320;
	var centerPoint;
	var playBtn, pauseBtn, resetBtn, followChk;
	
		//查询（开始）
		function chaxun(){
			//获取当前查询条件数据
			var vehicle = $("#vehicle").val();
			var start = $("#starttime").val();
			var over = $("#overtime").val();
			
			if(start > over && over != "" && start != ""){
				layer.msg("开始时间不能大于结束时间！请重新选择。", {
		    		  offset:'40%',
		    		  shift: 6
		    		})
			} else if (vehicle == null){
				layer.msg("条件不完整！", {
		    		  offset:'40%',
		    		  shift: 6
		    		})
			} else {
				$.ajax({
					type : 'post',
					url : '${path}/carspeed/getCoord.do',
					async : true,
					data : {"starttime":start,"overtime":over,"vehicle":vehicle},
					datatype : 'json',
					success : function (data){
						if(data != null){
							//初始化信息
							allpoints = [];
							allTime = [];
							allVehcile = [];
							allSpeed = [];
							allZT = [];
							map.clearOverlays();
							allpolins = "";
							if(pabo){
								gongli = 0;
								$("#gongli").val(0);
							} else {
								pabo = true;
							}
							
							//遍历数据
							$.each(data,function(n,v){
								
								//date类型转换成字符串
								var date = new Date();
								date.setTime(v.gettime);
								var time = date.getFullYear() +"-"+ date.getMonth() + "-" + date.getDate() + " " +date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "." +date.getMilliseconds();
								//放入变量中
								allTime.push(time);
								allVehcile.push(v.vehicle);
								allSpeed.push(v.speed);
								allZT.push(v.remark);
								
								var point = new BMap.Point(v.longitude,v.latitude);
								//转换成百度坐标
								var arr = [];
								arr.push(point);
								var a = GpsToBaiduPoints(arr);
								allpolins += a[0].lng +","+ a[0].lat + ";";
								allpoints.push(a[0]);
								
							});
							
							var dian = allpoints.length;
							
							if(dian > 0){
								
								//通过DrivingRoute获取一条路线的point
								/* var driving = new BMap.DrivingRoute(map);
								driving.search(allpoints[0], allpoints[dian-1]);
								driving.setSearchCompleteCallback(function() { */
									//得到路线上的所有point
									//allpoints = driving.getResults().getPlan(0).getRoute(0).getPath();
									//画面移动到起点和终点的中间
									centerPoint = new BMap.Point((allpoints[0].lng + allpoints[allpoints.length - 1].lng) / 2, (allpoints[0].lat + allpoints[allpoints.length - 1].lat) / 2);
									map.panTo(centerPoint);
									//连接所有点
									map.addOverlay(new BMap.Polyline(allpoints, {strokeColor: "black", strokeWeight: 5, strokeOpacity: 1}));
									
									//显示小车子
									label = new BMap.Label("", {offset: new BMap.Size(-20, -20)});
									car = new BMap.Marker(allpoints[0], {icon: new BMap.Icon("${path}/static/img/car.png", new BMap.Size(35,27), {imageOffset: new BMap.Size(0, 0),anchor : new BMap.Size(10,30)})});
									car.setLabel(label);
									map.addOverlay(car);
									
									//点亮操作按钮
									playBtn.disabled = true;
									resetBtn.disabled = false;
									pauseBtn.disabled = false;
									starPlay();
								/* }); */
								
							} else {
								$("#zhuangtai").val("缺勤");
								layer.msg("查询没有数据", {
						    		  offset:'40%',
						    		  shift: 6
						    		})
							}
							
							//采集的点数
							$("#dianshu").val(dian);
						};
					}
				});
			}
		}
		
		//开始(2.0)
		function starPlay(){
			var point = allpoints[index];
			
			if(index > 0) {
				map.addOverlay(new BMap.Polyline([allpoints[index - 1], point], {strokeColor: "red", strokeWeight: 1, strokeOpacity: 1}));
			}
			label.setContent("经度: " + point.lng + "<br>纬度: " + point.lat);
			car.setPosition(point);
			index++;
			if(followChk.checked) {
				map.panTo(centerPoint);
			}
			if(index < allpoints.length) {
				timer = window.setTimeout("starPlay(" + index + ")", hfspeed);
			} else {
				playBtn.disabled = true;
				pauseBtn.disabled = true;
				map.panTo(point);
			}
			
			//把获取到的信息放入input框
			$("#sudu").val(allSpeed[index]);
			$("#shijian").val(allTime[index]);
			//总距离
			var zong = 0;
			for (var s = 0 ; s < (allpoints.length-1) ; s++) {
				zong  += map.getDistance(allpoints[s],allpoints[s+1]).toFixed(2)/1000;
			}
			
			$("#zonglishu").val(zong);
			//行驶里程
			if(index < allpoints.length && index != 0) {
				gongli += map.getDistance(allpoints[index -1],allpoints[index]).toFixed(2)/1000;
			}
			$("#gongli").val(gongli);
			//位置
			$("#weizhi").val(point.lng + "," + point.lat);
			//状态
			$("#zhuangtai").val(allZT[index]);
			
		}
		
		
		//页面加载完成后执行
		$(function(){
			followChk = document.getElementById("follow");
			playBtn = document.getElementById('play');
			pauseBtn = document.getElementById('pause');
			resetBtn = document.getElementById('reset');
			pauseBtn.disabled = true;
			followChk.checked = true;
			//获取单位
			 $.ajax({
				type : 'post',
				url : '${path}/carspeed/getCompany.do',
				async : false,
				data : {},
				datatype : 'json',
				success : function(data){
					if(data != null) {
						$.each(data,function(n,v){
							$("#danwei").append("<option>"+v.uuname+"</option>");
						});
					}
				}
			}); 
		
		});
		
		//选择单位后列出相应的设备
		function shebei(){
			//获取当前选择的单位
			var company = $("#danwei").val();
			$.ajax({
				type : 'post',
				url : '${path}/carspeed/getVehicle.do',
				async : true,
				data : {"company" : company},
				datatype : 'json',
				success : function (data) {
					if (data != null) {
						//首先清除之前的数据
						$("#vehicle").empty();
						$.each(data,function(n,v){
							$("#vehicle").append("<option value='"+v.vehicle+"'>"+v.vehicle+"</option>");
						});
					};
				}
			});
		}
		
		
		
		var x = window.screenLeft;//窗口x坐标
		var pmK = screen.width;//屏幕宽度
		var bsK = window.outerWidth;//浏览器宽度
		var pmG = screen.availHeight;//屏幕高度
		var bsG = $(window.parent.window).height();//浏览器高度
		
		var mapX = $("#wcbox").offset().top + (pmG - bsG);
		var mapY = 220;
		var mapG = pmG - mapX;
		var mapK = document.getElementById("wcbox").offsetWidth;
		
		//保存地图(全屏)
		function saveImg(){
			
			var filename = getTime()+".png";
			
			window.location.href = "${path}/img/saveStatic.do?center="+
					map.getCenter().lng+","+map.getCenter().lat
					+"&zoom="+map.getZoom()+"&allpolins="+allpolins
					+"&filename="+filename;
			
		}
		
		//打印
		function printdiv() {
			
			var filename = getTime()+".png";
			
			window.location.href = "${path}/img/printA.do?center="+
			map.getCenter().lng+","+map.getCenter().lat
			+"&zoom="+map.getZoom()+"&allpolins="+allpolins
			+"&filename="+filename;
		}
		
		
		//获取当前时间作filename
		function getTime(){
			var now = new Date();
		       
	        var year = now.getFullYear();       //年
	        var month = now.getMonth() + 1;     //月
	        var day = now.getDate();            //日
	       
	        var hh = now.getHours();            //时
	        var mm = now.getMinutes();          //分
	       	var ss = now.getSeconds();
	        var clock = year + "-";
	       
	        if(month < 10)
	            clock += "0";
	       
	        clock += month + "-";
	       
	        if(day < 10)
	            clock += "0";
	           
	        clock += day;
	       
	        if(hh < 10)
	            clock += "0";
	           
	        clock += hh;
	        if (mm < 10) clock += '0'; 
	        clock += mm; 
	  		if(ss<10)clock+='0';
	  		clock+=ss;
	  		
	        return(clock);
		}
		
	
	function pause() {
		pabo = false;
		playBtn.disabled = false;
		pauseBtn.disabled = true;
		
		if(timer) {
			window.clearTimeout(timer);
		}
	}
	
	function reset() {
		followChk.checked = false;
		playBtn.disabled = false;
		pauseBtn.disabled = true;
		pabo = true;
		if(timer) {
			window.clearTimeout(timer);
		}
		index = 0;
		car.setPosition(allpoints[0]);
		map.panTo(centerPoint);
		//重置信息框
		$("#dianshu").val('');
		$("#gongli").val('');
		$("#zonglishu").val('');
		$("#weizhi").val('');
		$("#sudu").val('');
		$("#shijian").val('');
		$("#zhuangtai").val('');
	}

		
	</script>
	
<script>
    window.onload=function(){
        var tra=$('.trajectory').height();
        /* var H=window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight; */
        /* 2018-01-09 修改 */
        var H=window.innerHeight-150||document.documentElement.clientHeight-150||document.body.clientHeight-150;
        $('#wcbox').height(H-tra);
    }
    
</script>
	
	
</body>
</html>
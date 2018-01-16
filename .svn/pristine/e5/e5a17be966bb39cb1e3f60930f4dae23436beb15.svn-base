<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<section class="sidebar">
    <!-- Sidebar user panel -->
<div class="user-panel">
    <div class="pull-left image">
    <img src="${path }/static/img/avatar3.png" class="img-circle" alt="User Image" />
    </div>
    <div class="pull-left info">
    <p>您好，${user.loginName}</p>
</div>
</div>
<!-- 天气预报 -->
<div class="weather">
    <div class="pull-left">
    <i id="date"></i>
    <i id="time"></i>
    <i id="week"></i>
    </div>
    <div class="pull-right windimg">
    <i id="icon"></i>
    <i id="weather"></i>
    <i id="wind"></i>
    </div>
</div>
<div class="location">
<i id="city" class="pull-left"></i>
<i id="warm" class="pull-right"></i>
</div>
<!-- ./天气预报 -->
<!-- sidebar menu: : style can be found in sidebar.less -->
<ul class="sidebar-menu">

	    <li class="treeview">
	    <a href="####">
	    <i class="fa"><img src="${path }/static/img/icon/run.png"></i>
	    <span>监控管理</span>
	    <i class="fa fa-angle-left pull-right"></i>
	    </a>
	    
	    <ul class="treeview-menu">

	    	
<li><a href="${path }/carpeomon/main.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>施工区导航图</a></li>
	    	<li><a href="${path }/carmon/vehcileMap.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>车辆实时位置显示</a></li>
	    	<li><a href="${path }/peoplemon/personMap.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>人员实时位置显示</a></li>
			
	    </ul>
	    </li>
    
     
    <li class="treeview">
    <a href="####">
    <i class="fa"><img src="${path }/static/img/icon/evaluate.png"></i>
    <span>信息录入</span>
    <i class="fa fa-angle-left pull-right"></i>
    </a>
    <ul class="treeview-menu">
    <li><a href="${path }/zone/goZone.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>活动区域</a></li>
    <li><a href="${path }/ryluru/selectRyxxAll.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>人员信息</a></li>
   	<li><a href="${path }/luru/selectAll.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>车辆信息</a></li>
    </ul>
    </li>
    
    
    <li class="treeview">
    <a href="####">
    <i class="fa"><img src="${path }/static/img/icon/data.png"></i>
    <span>轨迹查询</span>
    <i class="fa fa-angle-left pull-right"></i>
    </a>
    <ul class="treeview-menu">
    <li><a href="${path }/carspeed/goCarspeed.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>车辆轨迹回放</a></li>
    <li><a href="${path }/peoplespeed/goPeoplespeed.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>人员轨迹回放</a></li>
    </ul>
    </li>
    <%-- <li class="treeview">
    <a href="####">
    <i class="fa"><img src="${path }/static/img/icon/add.png"></i>
    <span>报表管理</span>
    <i class="fa fa-angle-left pull-right"></i>
    </a>
    <ul class="treeview-menu">
    <li><a href="${path }/weekly/goWeekly.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>周报表</a></li>
    <li><a href="${path }/monthly/goMonthly.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>月报表</a></li>
    <li><a href="${path }/quarter/goQuarter.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>季报表</a></li>
    <li><a href="${path }/year/goYear.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>年报表</a></li>
    </ul>
    </li> --%>
    <li class="treeview">
    <a href="####">
    <i class="fa"><img src="${path }/static/img/icon/data.png"></i>
    <span>施工考勤</span>
    <i class="fa fa-angle-left pull-right"></i>
    </a>
    <ul class="treeview-menu">
    <%-- <li><a href="${path }/kaoqin/toPcstation.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>人员及车辆考勤</a></li> --%>
     <li><a href="${path }/kaoqin/toPcinform.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>人员及车辆考勤</a></li>
    <li><a href="${path }/baobiao/goBaobiao.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>考勤统计</a></li>
    <li><a href="${path }/kaoqin/toAutoreport.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>报表功能</a></li>
    <li><a href="${path }/baojing/main.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>报警功能</a></li>
    </ul>
    </li>
    <%-- <li class="treeview">
    <a href="####">
    <i class="fa"><img src="${path }/static/img/icon/user.png"></i> <span>用户管理</span>
    <i class="fa fa-angle-left pull-right"></i>
    </a>
    <ul class="treeview-menu">
    <li><a href="${path }/yonghu/xinxi.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>用户信息</a></li>
    <li><a href="${path }/yonghu/zuguanli.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>用户组管理</a></li>
    <li><a href="${path }/yonghu/jueseguanli.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>角色管理</a></li>
    </ul>
    </li> --%>
    <%-- <li class="treeview">
    <a href="####">
    <i class="fa"><img src="${path }/static/img/icon/add.png"></i>
    <span>版本信息</span>
    <i class="fa fa-angle-left pull-right"></i>
    </a>
    <ul class="treeview-menu">
    <li><a href="${path }/cc.do" target="rightFrame"><i class="fa fa-angle-double-right"></i>版本信息</a></li>
    </ul>
    </li> --%>
    </ul>
    </li>
    </ul>
    <div class="footer-par">
        <p><img alt="" src="${path }/static/img/banquan-logo.png"></p>
    </div>
    </section>
   <script type="text/javascript" src="${path }/static/js/jquery.min.js"></script>
   <script type="text/javascript">
   $.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js ', function(_result) {
		if(remote_ip_info.ret == '1') {
			var cityName = remote_ip_info.city;
			console.log(cityName);
			$.ajax({
				url: "http://api.map.baidu.com/telematics/v3/weather ",
				type: "get",
				data: {
					location: cityName,
					output: 'json',
					ak: '6tYzTvGZSOpYB5Oc2YGGOKt8'
				},
				dataType: "jsonp",
				success: function(data) {
					var weatherData = data.results[0].weather_data;
					var dayImg = weatherData[0].dayPictureUrl.split("day/");
					var dayImg1 = dayImg[1].split(".");
					var dayUrl = "${path}/static/img/weather/"+dayImg1[0]+".gif";
					
					document.getElementById("city").innerHTML = cityName;
					document.getElementById("icon").innerHTML = "<img style='width:70px;margin:10px 0 10px 0;' src="+dayUrl+" alt=''/>";
					document.getElementById("weather").innerHTML =weatherData[0].weather;
					document.getElementById("wind").innerHTML = weatherData[0].wind;
					document.getElementById("warm").innerHTML = weatherData[0].temperature;
				}
			})
		} else {
			alert('没有找到匹配的IP地址信息！');
		}
	});

   
   </script>
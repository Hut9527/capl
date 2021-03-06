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
	<link href="${path }/static/css/layui.css" rel="stylesheet" type="text/css" />
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
	<script src="${path }/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=bx488V75MS82pnMhvuLzgWLT1vRqmkA9"></script>
	<script type="text/javascript" src="${path }/static/js/form.js"></script>
    <script type="text/javascript" src="${path }/static/layer/layer.js"></script>
    <script type="text/javascript" src="${path }/static/validation/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${path }/static/validation/messages_zh.js"></script>
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
        /*删除框*/
	.diacanshu{
		width: 640px;
		height: 200px;
		width: 640px;
		height: 200px;
		background: #ffffff;
		border: 1px solid #dbdbdb;
		position: fixed;
		left:40%;
		top:40%;
		margin-top: -100px;
		margin-left: -320px;
		z-index: 1000;
		display: none;
		box-shadow:0px 4px 10px rgba(142,142,142,0.6);
		border-radius:6px;
	}
	.moudsha>span,.diacanshu>span,.surface-maishe>span{
		display: block;
		height: 39px;
		line-height: 39px;
		padding-left:20px;
		border-bottom: 1px solid #dbdbdb;
		font-size: 15px;
		color: #f9a825;
		font-weight: 600;
	}
	.diacanshu-quer{
		height: 60px;
	}
	.diacanshu-quer>span{
		display: block;
		font-size: 16px;
		color: #333;
		width: 200px;
		text-align: center;
		margin-left:28px;
		margin-top:30px;
	}
	.diacanshu-but{
		width: 230px;
		position: absolute;
		right: 25px;
		bottom: 10px;
	}
	.diacanshu-ndas{
		position: absolute;
		left: 0;
		bottom: 0;
		border-top:1px solid #dbdbdb;
		height: 55px; 
		width: 100%;
	}
	.diacanshu-but .layui-btn{
		background:#f9a825;
		width: 100px;
		height: 34px; 
		font-size: 16px;
		border-radius:4px; 
	}
	.diacanshu-but .layui-zis{
		background: #ffffff;
		color: #333;
		border: 1px solid #dbdbdb;
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
				人员以及车辆位置
			</h5>
			<ol class="breadcrumb">
				<li>考勤系统</li>
				<li class="active">人员以及车辆位置</li>
			</ol>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
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
										<th><input id="but1" type="button" onclick="quanxuan()" value="全选" style="width:55px;text-align: center;font-size:13px;"></input></th>
										<th>所属单位</th>
										<th>录入时间</th>
										<th>GPS点1</th>
										<th>GPS点2</th>
										<th>GPS点3</th>
										<th>GPS点4</th>
										<th>备注</th>
										<th>是否启用</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${list }" var="area">
									<tr>
										<input type="hidden" value="${area.wkid }"/>
										<td><input name="check" type="checkbox" value="${area.wkid }"/></td>
										<td>${area.unitpart }</td>
										<td><fmt:formatDate value="${area.creattime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>${area.gps1 }</td>
										<td>${area.gps2 }</td>
										<td>${area.gps3 }</td>
										<td>${area.gps4 }</td>
										<td>${area.remark }</td>
										<td>
											<c:choose>
												<c:when test="${area.flag == 1}">
													<span class="switch-on" onclick="flag(${area.wkid},${area.flag})" style="zoom:0.7;-moz-transform:scale(0.7);"></span>
												</c:when>
												<c:otherwise>
													<span class="switch-off" onclick="flag(${area.wkid},${area.flag})" style="zoom:0.7;-moz-transform:scale(0.7);"></span>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
									</c:forEach>
									
								</tbody>
							</table>
						</div><!-- /.box-body -->
						<div>
	                        <div>
	                            <%@ include file="/static/fenye/fenye3.jsp"%>
	                        </div>
                    	</div>
					</div><!-- /.box -->
				</div>
			</div>
		</section><!-- /.content -->
	</div>
	<!-- ./wrapper -->
	
	<!-- 删除 -->
	<div class="diacanshu">
		<span>删除</span>
		<div class="diacanshu-quer">
			<span>确定要删除该数据？</span>
		</div>
		<div class="diacanshu-but">
			<button type="button" id="queding" class="layui-btn layui-btn-sm">确定</button>
			<button type="button" id="quxiao" class="layui-btn layui-btn-sm layui-zis but-shachu">取消</button>
		</div>
	</div>
	
	<!--遮罩层-->
	<div id="dialogBg"></div>
	<!--dialog-->
	<div id="dialog">
		<h4>人员以及车辆位置</h4>
		<div class="row">
			<div class="col-xs-12" style="margin-top:30px;">
				<div class="condition">
					<form id="gpsform" method="post">
						<div class="col-xs-6 choice">
                            <div class="input-group">
                                <div class="input-group-btn seltit"><span>所属单位</span></div>
                                <div class="select">
                                    <a href="###" class="clear"><span class="fa fa-times"></span><span class="sr-only"></span></a>
                                    <span class="caret"></span>
                                    <select name="unitpart" id="bignum" class="sel">
                                    	<c:forEach items="${unitList }" var="uuit">
                                    		<option value="${uuit.uuname }">${uuit.uuname }</option>
                                    	</c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    	<div class="col-xs-6 choice">
                            <div class="input-group">
                                <div class="input-group-btn seltit"><span>时间</span></div>
                                <input id="creattime" name="creattime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:dd'})">
                            </div>
                        </div>
                        <div class="col-xs-12 choice">
	                        <div class="input-group text" style="width:566px">
	                            <div class="input-group-btn seltit"><span>备注</span></div>
	                            <input id="describe" name="remark" type="text" placeholder="请输入..." class="form-control"  style="width:463px!important;" /><span class="del fa fa-times"></span>
	                        </div>
	                    </div>
	                    <div class="col-xs-12 choice">
                            <div class="latitude">
								<div class="latitude-ta">
									<span>GPS点1</span>
								</div>
								<div class="latitude-ipt">
									<div class="latitude-ipt-jd">
										<span>经度</span>
										<input type="text" name="lng1" id="lng1" placeholder="请输入..." >
									</div>
									<div class="latitude-ipt-wd">
										<span>纬度</span>
										<input type="text" name="lat1" id="lat1" placeholder="请输入...">
									</div>
								</div>
								<button class="latitude-ipt-dt latitude-but" type="button" id="gps1">从地图选取</button>
                            </div>
                        </div>
                        <div class="col-xs-12 choice">
                            <div class="latitude">
								<div class="latitude-ta">
									<span>GPS点2</span>
								</div>
								<div class="latitude-ipt">
									<div class="latitude-ipt-jd">
										<span>经度</span>
										<input type="text" name="lng2" id="lng2" placeholder="请输入..." >
									</div>
									<div class="latitude-ipt-wd">
										<span>纬度</span>
										<input type="text" name="lat2" id="lat2" placeholder="请输入...">
									</div>
								</div>
								<button disabled="disabled" class="lati" type="button" id="res" >重置地图</button>
                            </div>
                        </div>
                        <div class="col-xs-12 choice">
                            <div class="latitude">
								<div class="latitude-ta">
									<span>GPS点3</span>
								</div>
								<div class="latitude-ipt">
									<div class="latitude-ipt-jd">
										<span>经度</span>
										<input type="text" name="lng3" id="lng3" placeholder="请输入..." >
									</div>
									<div class="latitude-ipt-wd">
										<span>纬度</span>
										<input type="text" name="lat3" id="lat3" placeholder="请输入...">
									</div>
								</div>
								<!-- <button class="latitude-ipt-dt  latitude-but" type="button" id="gps3">从地图选取</button> -->
                            </div>
                        </div>
                        <div class="col-xs-12 choice">
                            <div class="latitude">
								<div class="latitude-ta">
									<span>GPS点4</span>
								</div>
								<div class="latitude-ipt">
									<div class="latitude-ipt-jd">
										<span>经度</span>
										<input type="text" name="lng4" id="lng4" placeholder="请输入..." >
									</div>
									<div class="latitude-ipt-wd">
										<span>纬度</span>
										<input type="text" name="lat4" id="lat4" placeholder="请输入...">
									</div>
								</div>
								<!-- <button class="latitude-ipt-dt  latitude-but" type="button" id="gps4">从地图选取</button> -->
                            </div>
                        </div>
						<ul class="col-xs-12 eletcadd">
							<button id="sub" type="button" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-check-square"></i> 提 交</button>
							<button id="cancel" type="button" class="btn btn-danger btn-lg"><i class="fa fa-fw fa-times"></i> 取 消</button>
						</ul>
					</form>
				</div>
			</div>
		</div><!-- ./dialog-->
	</div>
<!-- 	获取百度地图 -->
	<div class="mymap" id="box">
		<div id="bar"><span class="mymap-myi">关闭</span></div>
		<div id="allmap" class="llmap"></div>
	</div>
	
	<!-- Bootstrap -->
	<script src="${path }/static/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${path }/static/js/bootstrap-select.js"></script>
	<script type="text/javascript" src="${path }/static/js/header.js"></script>
	<script type="text/javascript" src="${path }/static/js/tuodong.js"></script>
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
	//添加
	$("#sub").click(function(){
		
		if($("#creattime").val() == ""){
			layer.msg("请选择时间段", {
	    		  offset:'40%',
	    		  shift: 6
	    		})
		}else{
			$("#gpsform").submit();
		};
	});
	
	//flag
	function flag(wkid,flag){
		if(flag == 1){
			
			location.href = "${path}/kaoqin/flag.do?wkid="+wkid+"&&flag="+0;
		}
		if(flag == 0){
			
			location.href = "${path}/kaoqin/flag.do?wkid="+wkid+"&&flag="+1;
		}
	}
	
</script>

<script type="text/javascript">

lat1.onpropertychange = lat1.oninput = lat1.onchange = function(){
   alert(1234);
}
	

	//全选 
	function quanxuan(){
		
		var xuan = $("#but1").val();
	
		if (xuan == '全选') {
		 	$("#but1").val("全不选")
			$("input[name='check']").prop("checked",true);
		}
		if (xuan == '全不选') {
			$("#but1").val("全选")
			$("input[name='check']").prop("checked",false);
		}
	}
	
	//显示弹框
	$("#insert").on('click',function(){
	   $('#dialogBg').fadeIn(300);
	    $("#dialog").center().show();
	    $("#gpsform").removeAttr("action");
	    $("#gpsform").attr("action","${path}/kaoqin/saveGps.do");
	});
	
	//添加弹窗end
	
	//关闭弹窗
	$("#cancel").on('click',function(){
	   $('#dialogBg').fadeOut(300,function(){
	    $("#dialog").hide();
	    $("#dialog2").hide();
	    return false;
	   });
	});
	
	 //点击修改按钮弹出
	$("#modify").on("click",function (){
	    if($("#example2 tr").hasClass("pitch")){
	        $("#dialog").center().show();
	        var wkid = $(".pitch input").val();
	        $("#gpsform").removeAttr("action");
		    $("#gpsform").attr("action","${path}/kaoqin/updateGps.do");
		    
		    $("#gpsform").append("<input type='hidden' name='wkid' value='"+wkid+"'/>");
	        $.ajax({
	        	type : 'post',
	        	url : '${path}/kaoqin/selectById.do',
	        	async : false,
	        	dataType : 'json',
	        	data : {"wkid" : wkid},
	        	
	        	success : function(data){
	        		$("#bignum").val(data.unitpart);
	        		//把data类型转换成字符串
	        		var date = new Date();
					date.setTime(data.creattime);
					var m = date.getMonth() + 1;
					var time = date.getFullYear() +"-"+ m + "-" + date.getDate() + " " +date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
					$("#creattime").val(time);
					
					var gps1 = data.gps1.split(",");
					var gps2 = data.gps2.split(",");
					var gps3 = data.gps3.split(",");
					var gps4 = data.gps4.split(",");
					$("#lng1").val(gps1[0]);
					$("#lat1").val(gps1[1]);
					$("#lng2").val(gps2[0]);
					$("#lat2").val(gps2[1]);
					$("#lng3").val(gps3[0]);
					$("#lat3").val(gps3[1]);
					$("#lng4").val(gps4[0]);
					$("#lat4").val(gps4[1]);
					
					$("#describe").val(data.remark);
	        	}
	        	
	        });
	    }
	    else{
	    	layer.msg("请选择一行", {
	    		  offset:'40%',
	    		  shift: 6
	    		})
	    }
	})
	
	//删除弹窗
	$('#delete').click(function () {
		
		//获取所有选中的值用句号分开
		var valArr = new Array;
		$("input[name='check']:checked").each(function(i){
			valArr[i] = $(this).val();
		})
		var veh = valArr.join(',');
		
		if(veh != ""){
			$(".diacanshu").show();	//显示弹框
			//确定按钮
			$("#queding").click(function(){
			//删除的链接
				location.href="${path}/kaoqin/deleteGps.do?wkid="+veh;
			});
			//取消按钮
			$("#quxiao").click(function(){
				$(".diacanshu").hide();
			});
	    }
	    else{
	    	layer.msg("请选择一行", {
	    		  offset:'40%',
	    		  shift: 6
	    		})
	    }
	
	})
	
</script>

</html>
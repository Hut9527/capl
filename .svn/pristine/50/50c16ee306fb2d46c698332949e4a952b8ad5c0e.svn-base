<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="${path }/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${path}/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <link href="${path}/static/css/query.css" rel="stylesheet" type="text/css" />
</head>
 <style type="text/css">
    	/*底部分页*/
        .Pager{
            overflow: hidden;
            width: 530px;
            margin: 0 auto;
        }
        .Pager-one,.Pager-zh,.Pager-qw{
            background: #3c85e5;
            width:64px;
            height:26px;
            color:#fff;
            font-size: 14px;
            border: none;
            border-radius: 4px;
            display: block;
            float: left;
        }
        .Pager-left,.Pager-right{
            width: 26px;
            height: 26px;
            background:#3c85e5;
            display: block;
            text-align: center;
            line-height: 26px;
            border-radius: 2px;
            color: #fff;
            font-size: 14px;
            float: left;
            margin: 0 20px 0 20px;
            cursor:pointer;
        }
        .Pager-qw{
            width: 56px;
            margin: 0 0px 0 15px;
        }
        .Pager-ipt{
            width: 52px;
            height: 21px;
            line-height: 21px;
            text-align: center;
            margin: 0 4px;
        }
        .Pager>p{
            float: left;
            height: 26px;
            font-size: 14px;
            line-height: 26px;
        }
        
        /*新增css*/
        /* 标题 */
        .content-header {
		    background: #fbfbfb;
		    box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
		    position: relative;
		    padding: 15px 15px 10px 20px;
		}
		/* 面包屑 */
		.breadcrumb {
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
        .f-contents02{
        	display: none;
        }
        .f-contents-tab01 ul{
        	overflow: hidden;
		    border-bottom: 1px solid #e8edf1;
		    padding-left: 15px;
        }
        .f-contents-tab01 ul li{
        	float: left;
		    padding: 0 20px;
		    text-align: center;
		    height: 38px;
		    line-height: 38px;
		    font-size: 14px;
		    color: #666666;
		    cursor: pointer;
        }
        .f-contents-tab01 ul .f-contents-tab01-li{
        	border-bottom: 2px solid #1976d2;
		    color: #1976d2;
		    font-weight: 600;
		    font-size: 14px;
        }
        .f-contents-tab01{
        	padding-top:20px;
        }
		
    </style>
</head>
<body class="skin-blue">
<div class="wrapper row-offcanvas row-offcanvas-left">
    <div class="f-baobiao">
        <section class="content-header">
            <h5>
				报警功能
			</h5>
			<ol class="breadcrumb">
				<li>施工考勤</li>
				<li class="active">报警功能</li>
			</ol>
        </section>
		<section class="f-contents-tab01">
            <ul>
            	<li class="f-contents-tab01-li" value="li01">人员报警信息</li>
            	<li value="li02">车辆报警信息</li>
            </ul>
        </section>
        <!-- Main content -->
        	<section class="content">
	            <div class="row">
	                <div class="col-xs-12">
	                    <form action="">
	                        <div class="condition">
	                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 choice">
	                                <div class="input-group">
	                                    <div class="input-group-btn seltit"><span>起始时间</span></div>
	                                    <input id="starttime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker()">
	                                </div>
	                            </div>
	                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 choice">
	                                <div class="input-group">
	                                    <div class="input-group-btn seltit"><span>结束时间</span></div>
	                                    <input id="stoptime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker()">
	                                </div>
	                            </div>
	                            <ul class="col-xs-6 elect pull-right">
	                                <button id="search" type="button" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-search"></i> 搜 索</button>
	                                <button id="export" type="button" class="btn btn-danger btn-lg"><i class="fa fa-fw fa-share-square-o"></i> 导 出</button>
	                            </ul>
	                        </div>
	                    </form>
	                    <div class="box">
	                        <div class="box-header">
	                        </div><!-- /.box-header -->
	                        <div class="box-body table-responsive f-contents01">
	                            <table id="peo" class="table table-bordered text-center">
	                                <thead>
		                                <tr>
		                                    <th>姓名</th>
		                                    <th>报警内容</th>
		                                    <th>报警时间</th>
		                                </tr>
	                                </thead>
	                                <tbody>
		                                
	                                </tbody>
	                            </table>
	                        </div><!-- /.box-body -->
	                        <div class="box-body table-responsive f-contents02">
	                            <table id="car" class="table table-bordered text-center">
	                                <thead>
		                                <tr>
		                                    <th>车牌号</th>
		                                    <th>报警内容</th>
		                                    <th>报警时间</th>
		                                </tr>
	                                </thead>
	                                <tbody>
		                                
	                                </tbody>
	                            </table>
	                        </div><!-- /.box-body -->
	                        <div  class="box-footer clearfix text-center">
							<div class="Pager">
							    <a class="Pager-one" href="javascript:void(0)" id="beginpage">首页</a>
							    <a href='javascript:void(0)' id="SiloDataUp"  class="Pager-left">«</a>
							    <p>共<span class="Pager-dij" id="pagecount">${page.pageCount}</span>页，
								当前第<input type="text" id="currentpage" class="Pager-ipt" value="${page.currentPage}">页</p>
							    <a class="Pager-qw"  onclick="btnPageGo()">前往</a>
							    <a href='javascript:void(0)' class="Pager-right" id="SiloDataDown">»</a>
							    <a class="Pager-zh" href="javascript:void(0)" id="endpage">尾页</a>
							</div>
						</div><!-- /.box-fotter -->
	                    </div><!-- /.box -->
	                </div>
	            </div>
	        </section>
        
        <!-- /.content -->
    </div><!-- /.right-side -->
</div><!-- ./wrapper -->
<div id="dialogBg"></div>
<div id="doing" class="jd" style="display: none;position: fixed;z-index:88888;top: 40%;left: 40%">
	<div class="tu"> <img src="${path }/static/img/22.gif"> </div>
	<div class="zi"> 数据加载中，请稍后！ </div>
</div>
<!-- jQuery 2.0.2 -->
<script type="text/javascript" src="${path}/static/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script type="text/javascript" src="${path}/static/js/bootstrap.min.js" ></script>
<!--日期-->
<script type="text/javascript" src="${path}/static/js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$('.table tbody tr').on('click',function(){
		$(this).css('background','#ddf4ff').siblings().css('background','none');
	})
	
	var flag,starttime,stoptime;
    //页面加载完成后执行
	$(function(){
		flag = $('.f-contents-tab01 ul li').attr('value');
		$('.f-contents-tab01 ul li').on('click',function(){
			flag = $(this).attr('value');
			
			if ($(this).attr('value')=='li01') {
				$('.f-contents01').css('display','block');
				$('.f-contents02').css('display','none');
			} else{
				$('.f-contents01').css('display','none');
				$('.f-contents02').css('display','block');
			}
			$(this).addClass('f-contents-tab01-li').siblings().removeClass('f-contents-tab01-li');
			gotoWarnPage(1);
		})
		gotoWarnPage(1);
	})
	
	//搜索
	$("#search").click(function(){
		
		starttime = $("#starttime").val() + " 00:00:00";
		stoptime = $("#stoptime").val() + " 23:59:59";
		
		gotoWarnPage(1);
	});
	
	//导出
	$("#export").click(function(){
		
		starttime = $("#starttime").val();
		stoptime = $("#stoptime").val();
		
		window.location.href = "${path}/baojing/export.do?flag="+flag+
				"&starttime="+starttime+"&stoptime="+stoptime;
	});
</script>

<script type="text/javascript">
//获取报警数据
var gotoWarnPage = function (pageNum){
	console.log("..."+flag);
	$.ajax({
		type : 'post',
		url : '${path}/baojing/getWarnInfo.do',
		async : false,
		data : {"pageNum" : pageNum,"flag" : flag,
			"starttime" : starttime,"stoptime" : stoptime
		},
		dataType : 'json',
		beforeSend:function() {
      		 $('#dialogBg').fadeIn(300);
      		 $("#doing").show();
      		}, 
  		complete:function(data) {
  			$('#dialogBg').fadeOut(300);
  			$("#doing").hide();
  		},
  		
  		success : function(data){
  			if(data.list.length > 0){
  				if(data.flag == "li01"){
  					//清楚原表数据
  					$("#peo tbody").empty();
  					
  					$.each(data.list,function(n,v){
  						var tab = $("#peo");
  						//名称
  						var name = $("<td>"+v.name+"</td>");
  						//内容
  						var remark = $("<td>"+v.remark+"</td>");
  						//时间
  						var time = $("<td>"+getMyDate(v.gettime)+"</td>");
  						
  						var $tr = $("<tr></tr>");
  						$tr.append(name);
  						$tr.append(remark);
  						$tr.append(time);
  						
  						tab.append($tr);
  					});
  					
  				} else {
  					//清楚原表数据
  					$("#car tbody").empty();
  					
  					$.each(data.list,function(n,v){
  						var tab = $("#car");
  						//名称
  						var vehicle = $("<td>"+v.vehicle+"</td>");
  						//内容
  						var remark = $("<td>"+v.remark+"</td>");
  						//时间
  						var time = $("<td>"+getMyDate(v.gettime)+"</td>");
  						
  						var $tr = $("<tr></tr>");
  						$tr.append(vehicle);
  						$tr.append(remark);
  						$tr.append(time);
  						
  						tab.append($tr);
  					});
  					
  				}
  			} else {
				if (data.flag == "li01") {
					$('#peo tbody').empty();
				}else {
					$('#car tbody').empty();
				}
  			}
  			
  			$('#beginpage').attr(
					'href',
					'javascript:gotoWarnPage(1);');
			$('#endpage').attr(
					'href',
					'javascript:gotoWarnPage('
							+ (data.page.pageCount) + ');');
			
			$('#SiloDataUp').attr(
					'href',
					'javascript:gotoWarnPage('
							+ (data.page.currentPage - 1) + ');');
			$('#SiloDataDown').attr(
					'href',
					'javascript:gotoWarnPage('
							+ (data.page.currentPage + 1) + ');');
			$("#pagecount").html(data.page.pageCount);
			$("#currentpage").val(data.page.currentPage);
  		}
	});
}

var btnPageGo = function(){
	gotoWarnPage($("#currentpage").val());
}

function getMyDate(str){  
    var oDate = new Date(str),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),
    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) + " " +getzf(oHour)
    + ":" + getzf(oMin) + ":" + getzf(oSen);
    return oTime;  
};
//补0操作  
function getzf(num){  
    if(parseInt(num) < 10){  
        num = '0'+num;  
    }  
    return num;  
}
</script>
</body>

</html>
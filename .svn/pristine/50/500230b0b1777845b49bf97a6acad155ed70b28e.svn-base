<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>车辆信息</title>
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<!-- 时分秒控件 -->
	<link type="text/css" rel="stylesheet" href="${path }/static/layui/css/layui.css" />
	<link rel="shortcut icon" href="${path }/static/img/prolog.ico"/>
	<!-- bootstrap 3.0.2 -->
	<link href="${path }/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<!-- font Awesome -->
	<link href="${path }/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<!-- Theme style -->
	<link href="${path }/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />
	<link type="text/css" rel="stylesheet" href="${path }/static/css/query.css" />
	<link type="text/css" rel="stylesheet" href="${path }/static/css/pning.css" />
	<!-- jQuery 2.0.2 -->
	<script src="${path }/static/js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${path }/static/validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${path }/static/validation/messages_zh.js"></script>
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
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
</head>

<body class="skin-blue">
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
	<!-- header logo: style can be found in header.less -->
	<!-- <header class="header"></header> -->
	<form action="${path}/luru/selectAll.do" method="post">
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<!-- <aside class="left-side sidebar-offcanvas">
		</aside> -->
			<!-- Content Header (Page header) -->
		<section class="content-header">
			<h5>
				车辆信息录入
			</h5>
			<ol class="breadcrumb">
				<li>信息录入</li>
				<li class="active">车辆信息录入</li>
			</ol>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="condition">
						<ul class="col-xs-6 elect pull-left">
							<button id="insert"  type="button" class="btn btn-success btn-lg"><i class="fa fa-fw fa-plus"></i> 添 加</button>
							<button id="modify"  type="button" class="btn btn-warning btn-lg"><i class="fa fa-fw fa-pencil"></i> 修 改</button>
							<button id="delete"  type="button"  class="btn btn btn-danger btn-lg"><i class="fa fa-fw fa-trash-o"></i> 删 除</button>
						</ul>
					</div>
					</form>
					<div class="box">
						<div class="box-header">
						</div><!-- /.box-header -->
						<div class="box-body table-responsive">
							<table id="example2" class="table table-bordered text-center">
								<thead>
								<tr>
									<th><input id="but1" type="checkbox" style="width:55px;text-align: center;font-size:13px;"/></th>
									<th>车牌号</th>
									<th>车辆类型</th>
									<th>设备唯一识别码</th>
									<th>设备SIM卡号</th>
									<th>所属单位</th>
									<th>上班时间</th>
									<th>下班时间</th>
									<th>活动区域</th>
									<th>车辆负责人</th>
									<th>负责人联系方式</th>
									<th>创建时间</th>
								</tr>
								</thead>
								<tbody id="tbody">
								<c:forEach items="${list}" var="obj">
								<tr>
								<input type="hidden" name="id" value="${obj.id }">
									<td><input type="checkbox" name="check" value="${obj.id }"></td>
									<td>${obj.vehicle}</td>
									<td>${obj.vehicletype}</td>
									<td>${obj.devid}</td>
									<td>${obj.simnumber}</td>
									<td>${obj.company}</td>
									<td>${obj.ontime}</td>
									<td>${obj.offtime}</td>
									<td>${obj.zone }</td>
									<td>${obj.responsibility}</td>
									<td>${obj.liabilityphone}</td>
									<td><fmt:formatDate value="${obj.gettime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								</tr>
								 </c:forEach>
								</tbody>
							</table>
						</div><!-- /.box-body -->
						<!--  <div  class="box-footer clearfix text-center">
                        <div class="Pager"> -->
                            <%@ include file="/static/fenye/fenye3.jsp"%>
                   <!--      </div>-->
                    </div>
				</div>
			</div>
		</section><!-- /.content -->
	</div>
	<!-- ./wrapper -->

	<!--遮罩层-->
<div id="dialogBg"></div>
	<!--dialog-->
	<div id="dialog">
		<h4  id="mesg">车辆信息添加</h4>
		<div class="row">
			<div class="col-xs-12" style="margin-top:30px;">
				<div class="condition">
					<form action="" id="form" method="post">
						<div class="col-xs-6 choice">
	                        <div class="input-group text">
	                            <div class="input-group-btn seltit"><span>设备唯一识别码</span></div>
	                            <input id="code" name="devid" type="text" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
	                        </div>
	                    </div>
	                    
	                    <div class="col-xs-6 choice">
	                        <div class="input-group text">
	                            <div class="input-group-btn seltit"><span>车牌号</span></div>
	                            <input id="site" name="vehicle" type="text" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
	                        </div>
	                    </div>
	                     
	                     <div class="col-xs-6 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>活动区域</span></div>
                                    <div class="select">
                                        <a href="###" class="clear"><span class="fa fa-times"></span><span class="sr-only"></span></a>
                                        <span class="caret"></span>
                                        <select name="zone" id="zone" class="sel">
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
	                     
	                    <div class="col-xs-6 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>车辆类型</span></div>
                                    <div class="select">
                                        <a href="###" class="clear"><span class="fa fa-times"></span><span class="sr-only"></span></a>
                                        <span class="caret"></span>
                                        <select name="vehicletype" id="vetype" class="sel">
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                           
	                    <div class="col-xs-6 choice">
	                        <div class="input-group text">
	                            <div class="input-group-btn seltit"><span>SIM卡号</span></div>
	                            <input id="sim" name="simnumber" type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"  placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
	                        </div>
	                    </div>
	                   <div class="col-xs-6 choice">
                                <div class="input-group">
                                    <div class="input-group-btn seltit"><span>所属单位</span></div>
                                    <div class="select">
                                        <a href="###" class="clear"><span class="fa fa-times"></span><span class="sr-only"></span></a>
                                        <span class="caret"></span>
                                        <select name="company" id="companyId" class="sel">
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
	                    <div class="col-xs-6 choice">
	                        <div class="input-group text">
	                            <div class="input-group-btn seltit"><span>车辆负责人</span></div>
	                            <input id="reponse" name="responsibility" type="text" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
	                        </div>
	                    </div>
	                    <div class="col-xs-6 choice">
	                        <div class="input-group text">
	                            <div class="input-group-btn seltit"><span>联系方式</span></div>
	                            <input id="phone" name="liabilityphone" type="text"  onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入..." class="form-control" /><span class="del fa fa-times"></span>
	                        </div>
	                    </div>
	                    <div class="col-xs-6 choice">
	                        <div class="input-group text">
	                            <div class="input-group-btn seltit"><span>创建时间</span></div>
	                            <input id="lurutime"  name="gettime" class="form-control Wdate" placeholder="选择日期" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:dd'})"
	                            style="display: inline;width:165px!important;border-radius: 4px!important;"><span class="del fa fa-times"></span>
	                        </div>
	                    </div>  
	                    
	                    <div class="col-xs-6 choice">
	                        <div class="input-group text">
	                            <div class="input-group-btn seltit"><span>上班时间</span></div>
	                            <input id="ontime"  name="ontime" class="form-control Wdate" placeholder="选择时间" type="text"
	                            style="display: inline;width:165px!important;border-radius: 4px!important;"><span class="del fa fa-times"></span>
	                        </div>
	                    </div> 
	                    
	                    <div class="col-xs-6 choice">
	                       <div class="input-group text">
	                            <div class="input-group-btn seltit"><span>下班时间</span></div>
	                            <input id="offtime"  name="offtime" class="form-control Wdate" placeholder="选择时间" type="text"
	                            style="display: inline;width:165px!important;border-radius: 4px!important;"><span class="del fa fa-times"></span>
	                        </div>
	                    </div> 
	                    
						<ul class="col-xs-12 eletcadd">
							<input type="hidden" name="id" id="id">
							<button  type="submit"   class="btn btn-warning btn-lg"><i class="fa fa-fw fa-check-square"></i> 提 交</button>
							<button id="cancel"  style="margin-left:50px;" type="button"  class="btn btn-danger btn-lg"><i class="fa fa-fw fa-times"></i> 取 消</button>
						</ul>
					</form>
				</div>
			</div>
		</div><!-- ./dialog-->
	</div>
	
	
	<!-- Bootstrap -->
	<script src="${path }/static/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${path }/static/js/bootstrap-select.js"></script>
	<script type="text/javascript" src="${path }/static/js/header.js"></script>
	<!-- AdminLTE App -->
	<script type="text/javascript" src="${path }/static/js/AdminLTE/app2.js" ></script>
	<!--天气-->
	<script type="text/javascript" src="${path }/static/js/jquery.leoweather.min.js"></script>
	<!--日期-->
	<script type="text/javascript" src="${path }/static/layui/layui.js"></script>
	<script type="text/javascript" src="${path }/static/js/DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	var MSG='${MSG}';
	if(MSG!=null&&MSG!=''){
		//layer.msg(MSG);
		alert(MSG);
	}
	
	//全选
	$("#but1").click(function(){ 
		var bo = document.getElementById("but1").checked;
		if(!bo) {
			$("input[name='check']").prop("checked",false);
		} else {
			$("input[name='check']").prop("checked",true);
		}
		
	})
	/* function duoshan(){
		var aCh = $("#tbody tr td input[type=checkbox]:checked");
		//alert(aCh.size());
		var arr = [];
		for(var i=0;i<aCh.length;i++)
		{
			arr[i]=aCh[i].val();
		}
		var arr = arr +"";
		 $.ajax({
	      	   type: "POST",
	      	   url: "${path}/luru/selectVehicleById.do",
	      	   data: {'arr':arr},
	      	   dataType:"json",
	      	   success: function(msg){
					
	      	   }
	      	}); 
		
	} */
	//显示弹框
    $("#insert").on('click',function(){
       $('#dialogBg').fadeIn(300);
        $("#dialog").show();
    });
	
  //关闭弹窗
    $("#cancel").click(function(){
    	//    $('#dialogBg').fadeOut(300,function(){
    		$("#inpstart").val('');
    		$("#iddd").val('');
    		$("#code").val('');
    		$("#site").val('');
            $("#facility").val('');
            $("#node").val('');
            $("#onset").val('');
            $("#offset").val('');
        $("#dialog").hide();
//        });
    });
	
	


//添加车辆信息,提交表单
/* function buttonsubmit(){
	//提交数据
	$("#add").submit();
} */


//点击添加按钮
$("#insert").on('click',function(){
	$("#form").attr('action','${path }/luru/addOrupdateVehicleinfo.do');
	 $("#mesg").html("添加车辆信息");
	 $('#code').val("");
	 $('#site').val("");
	 $('#sim').val("");
	 $('#reponse').val("");
	 $('#phone').val("");
	 $('#lurutime').val("");
	 $("#companyId option:selected").attr("selected",false);
	 $("#vetype option:selected").attr("selected",false);
	 $("#zone option:selected").attr("selected",false);
	 //$('#id').val("");
	// $('#vetype option').val("");
	//$('#companyId option').val("");
	 $('#dialogBg').fadeIn(300);
     $("#dialog").show();
     
     
 });
//点击修改按钮
$("#modify").on("click",function (){
    if($("#example2 tr").hasClass("pitch")){
        $("#dialog").show();
        $("#mesg").html("修改车辆信息");
        var id=$('.pitch input').val();
        //alert(id);
        $.ajax({
      	   type: "POST",
      	   url: "${path}/luru/selectVehicleById.do",
      	   data: {id:id},
      	   dataType:"json",
      	   success: function(msg){
      		 	$("#form").attr('action','${path}/luru/updateinfo.do');
				$('#code').val(msg.devid);
				$('#site').val(msg.vehicle);
				$('#sim').val(msg.simnumber);
				$('#reponse').val(msg.responsibility);
				$('#phone').val(msg.liabilityphone);
				$('#id').val(msg.id);
				console.log(msg.zone);
				$('#zone').val(msg.zone);
				$('#ontime').val(msg.ontime);
				$('#offtime').val(msg.offtime);
				$('#lurutime').val(getMyDate(msg.gettime));
				//$('#lurutime').val(msg.gettime);
				$('#vetype option').each(function() {
					var value = $(this).val();
					if (msg.vehicletype == value) {
						$(this).prop('selected', 'selected');
					}
				})
				$('#companyId option').each(function() {
					var value = $(this).val();
					if (msg.company == value) {
						$(this).prop('selected', 'selected');
					}

				})
 				
      	   }
      	}); 
    }
    else{
        confirm("请选择一行");
    }
})

//删除
var aCh1;	
//删除弹窗
$('#delete').click(function () {
	aCh1 = $("#tbody tr td input[type=checkbox]:checked");
    if(aCh1.size()>0){
    	$(".diacanshu").show();	
    }
    else{
        //confirm("请选择一行");
    	layer.msg("请选择一行", {
    		  offset:'40%',
    		  shift: 6
    		})
    }

})

$("#queding").click(function(){
	var arr = new Array();
	for (var i = 0; i < aCh1.length; i++) {
		arr[i]=$(aCh1[i]).val();
	}
	var arr = arr+""
	//var id=$('.pitch input').val();
	 window.location.href="${path}/luru/deleteVehicleById.do?arr="+arr;   
});
	
$("#quxiao").click(function(){
	$(".diacanshu").hide();
});	
	
	
	
	/* $('#delete').click(function () {
		var aCh = $("#tbody tr td input[type=checkbox]:checked");
        if(aCh.size()>0){
	        if(confirm("确定删除吗？")){
	        	var arr = new Array();
	    		for(var i=0;i<aCh.length;i++){
	    			arr[i]=$(aCh[i]).val();
	    		}
	    		var arr = arr +"";
	    		//alert(ids)
	        	window.location.href="${path}/luru/deleteVehicleById.do?arr="+arr; 
	            }
	        }
        else{
            confirm("请至少选择一个");
        }

    }) */
	//form表单的校验
	window.onload=function(){
	//异步加载车辆类型信息
	$.ajax({
 	    timeout: 3000,
 	    async: false,
 	    type: "POST",
 	    url: "${path}/luru/findAll.do",
 	    dataType: "json",
 	    data: {
 	      
 	    },
 	    success: function (data) {
 	    	$("#vetype").html("<option value=''>请选择</option>");
 	    	
 	    	for (var i = 0; i < data.length; i++) {
 	        $("#vetype").append("<option value='"+data[i].vehicletype+"' >" + data[i].vehicletype + "</option>");
 	      }
 	    }
 	  });
	
	//异步加载所属单位信息
	$.ajax({
 	    timeout: 3000,
 	    async: false,
 	    type: "POST",
 	    url: "${path}/luru/selectDanwei.do",
 	    dataType: "json",
 	    data: {
 	      
 	    },
 	    success: function (data) {
 	    	$("#companyId").html("<option value=''>请选择</option>");
 	    	
 	    	for (var i = 0; i < data.length; i++) {
 	        $("#companyId").append("<option value='"+data[i].uuname+"' >" + data[i].uuname + "</option>");
 	        
 	      }
 	    }
 	  });
	
	//异步加载活动区域
	$.ajax({
		type : 'post',
		url : '${path}/zone/getZone.do',
		async : false,
		dataType : 'json',
		data : {},
		
		success : function (data) {
			
			$.each(data,function(n,v){
				$("#zone").append("<option value='"+v.id+"'>"+v.remark+"</option>");
			});
		}
		
	});
	
	
	//自定义simnumber卡号验证
	jQuery.validator.addMethod("checksim",function(value,element){  
	        var checksim = /^[1][3,4,5,7,8][0-9]{9}$/;  
	        return checksim.test(value);  
	  },"请输入正确的SIM卡号");
	//自定义手机号码验证
	jQuery.validator.addMethod("checkphone",function(value,element){  
	        var checksim = /^[1][3,4,5,7,8][0-9]{9}$/;  
	        return checksim.test(value);  
	  },"请输入正确的手机号码");
	//自定义车牌号验证
	jQuery.validator.addMethod("checkvehicle",function(value,element){  
	        var checkvehicle = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;  
	        return checkvehicle.test(value);  
	  },"请输入正确的车牌号码");
	var layerFontColer="#78BA32";
	$("#form").validate({
		onfocusout: function(element){
	        
	    },
	    onkeyup: false,
		rules : {
			devid : {
				required : true,
				maxlength : 50,
				remote : {
					url : "${path}/luru/selectByDevid.do",
					type : "post",
					dataType : "json",
					data : {
						devid : function() {
							return $('#code').val();
						},
						id : function() {
							return $('#id').val();
						}
					}
				}
			},
			 vehicle:{
				required : true,
				checkvehicle : true,
				remote : {
					url : "${path}/luru/selectByVehicle.do",
					type : "post",
					dataType : "json",
					data : {
						vehicle : function() {
							return $('#site').val();
						},
						id : function() {
							return $('#id').val();
						}
					}
				}
				
			},
			vehicletype:{
				required : true
			},
			zone : {
				required : true
			},
			simnumber:{
				required : true,
				checksim : true,
				remote : {
					url : "${path}/luru/selectBySimnumber.do",
					type : "post",
					dataType : "json",
					data : {
						vehicle : function() {
							return $('#sim').val();
						},
						id : function() {
							return $('#id').val();
						}
					}
				}
			},
			company:{
				required : true
			},
			responsibility:{
				required : true
			},
			liabilityphone:{
				required : true,
				checkphone : true
				
			}, 
			gettime:{
				required : true,
			} 
			
			
		},
		messages : {
			devid : {
				required : "设备唯一识别码不能为空",
				maxlength:"长度必须小于50",
				remote : "设备识别码已存在"
			},
			 vehicle:{
				required : "车牌号不能为空",
				remote : "车牌号码已存在"
			},
			vehicletype:{
				required : "车辆类型不能为空"
			}, 
			zone : {
				required : "活动区域不能为空"
			},
			simnumber:{
				required : "SIM卡号不能为空",
				remote : "SIM卡号已存在"
			},
			company:{
				required : "所属单位不能为空"
			},
			responsibility:{
				required : "车辆负责人不能为空"
			},
			
			liabilityphone:{
				required : "手机号码不能为空",
				minlength : "手机号不能小于11个数字"
			},
			gettime:{
				required :"创建时间不能为空"
			} 
		},
		/*  重写错误显示消息方法,以alert方式弹出错误消息   */
		   errorPlacement: function (error, element) {
			   layer.tips(error.html(), '#'+element[0].id, {
	    			  tips: [2, layerFontColer],
	    			  tipsMore: true
	    			}); 
	        }
	}); 
	
	
}
    
</script>

<script type="text/javascript">

layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  laydate.render({
		    elem: '#ontime'
		    ,type: 'time'
		  });
	  
	  laydate.render({
		    elem: '#offtime'
		    ,type: 'time'
		  });
});
	
</script>
	
</body>
</html>
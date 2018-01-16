var map;
var params = {
	left:0,
	top: 0,
	currentX: 0,
	currentY: 0,
	flag: false
};
var bo = false;
var bo1 = false;
var getCss = function(o,key){
	return o.currentStyle? o.currentStyle[key] : document.defaultView.getComputedStyle(o,false)[key]; 	
};

var startDrag = function(bar, target, callback){
	if(getCss(target, "left") !== "auto"){
		params.left = getCss(target, "left");
	}
	if(getCss(target, "top") !== "auto"){
		params.top = getCss(target, "top");
	}
	bar.onmousedown = function(event){
		params.flag = true;
		if(!event){
			event = window.event;
			bar.onselectstart = function(){
				return false;
			}  
		}
		var e = event;
		params.currentX = e.clientX;
		params.currentY = e.clientY;
	};
	document.onmouseup = function(){
		params.flag = false;	
		if(getCss(target, "left") !== "auto"){
			params.left = getCss(target, "left");
		}
		if(getCss(target, "top") !== "auto"){
			params.top = getCss(target, "top");
		}
	};
	document.onmousemove = function(event){
		var e = event ? event: window.event;
		if(params.flag){
			var nowX = e.clientX, nowY = e.clientY;
			var disX = nowX - params.currentX, disY = nowY - params.currentY;
			target.style.left = parseInt(params.left) + disX + "px";
			target.style.top = parseInt(params.top) + disY + "px";
			if (event.preventDefault) {
				event.preventDefault();
			}
			return false;
		}
		
		if (typeof callback == "function") {
			callback(parseInt(params.left) + disX, parseInt(params.top) + disY);
		}
	}	
};
$(function(){
	var _index,_this,gpsid1,gpsid2; 
	$(".latitude-but").click(function(){
		$(".mymap").show();
		/*_this=$(this);
		gpsid = $(this).attr("id");
		return _this;*/
	})
	$(".mymap-myi").click(function(){
		$(".mymap").hide();
		$('#res').attr('disabled','disabled');
		if($('#lng1').val() != "" && 
				$('#lng1').val() != null){
			$('#res').removeAttr('disabled');
		}
	});
	
	$("#cancel").click(function(){
		$(".mymap").hide();
		
	});
	// 百度地图API功能
	map = new BMap.Map("allmap");            
	map.centerAndZoom("佛坪县",9);                
	map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
	map.centerAndZoom("佛坪县",9);   
	
	 
	//单击获取点击的经纬度
	map.addEventListener("click",function(e){
		aa(e,arguments.callee);
	});
	
	
	
	var oBox = document.getElementById("box");
	var oBar = document.getElementById("bar");
	startDrag(oBar, oBox);
})

function aa(e,fun){
	$('#res').removeAttr('disabled');
	var marker2 = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat));
	map.addOverlay(marker2);
	var len = map.getOverlays().length;
	var i = 4;
	if(bo){
		len += 1;
		i = 3;
	}
	if(len == 2){
		$('#lng1').val(e.point.lng);
		$('#lat1').val(e.point.lat);
		bo1 = false;
	}
	if(len == 3){
		$('#lng2').val(e.point.lng);
		$('#lat2').val(e.point.lat);
		bo1 = false;
	}
	if(len == 4){
		$('#lng3').val(e.point.lng);
		$('#lat3').val(e.point.lat);
		bo1 = false;
		var polygon = new BMap.Polygon([
		                        		new BMap.Point($('#lng1').val(), $('#lat1').val()),
		                        		new BMap.Point($('#lng2').val(), $('#lat2').val()),
		                        		new BMap.Point($('#lng3').val(), $('#lat3').val()),
		                        		], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
		map.addOverlay(polygon); 
		
	}
	if(len == 6){
		$('#lng4').val(e.point.lng);
		$('#lat4').val(e.point.lat);
		bo1 = true;
		var allOver = map.getOverlays();
		map.removeOverlay(allOver[i]);
		var polygon = new BMap.Polygon([
		                        		new BMap.Point($('#lng1').val(), $('#lat1').val()),
		                        		new BMap.Point($('#lng2').val(), $('#lat2').val()),
		                        		new BMap.Point($('#lng3').val(), $('#lat3').val()),
		                        		new BMap.Point($('#lng4').val(), $('#lat4').val()),
		                        		], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
		map.addOverlay(polygon); 
		map.removeEventListener("click",fun);
	}
}

$('#res').click(function(){
	map.clearOverlays();
	$('#lng1').val("");
	$('#lng2').val("");
	$('#lng3').val("");
	$('#lng4').val("");
	$('#lat1').val("");
	$('#lat2').val("");
	$('#lat3').val("");
	$('#lat4').val("");
	bo = true;
	$('#res').attr('disabled','disabled');
	if(bo1){
		map.addEventListener("click",function(e){
			aa(e,arguments.callee);
		});
	}
	
});


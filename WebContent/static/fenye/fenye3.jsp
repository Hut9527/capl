<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	
<link rel="stylesheet" type="text/css" />
<style>
		*{
			margin: 0;
			padding: 0;
			font-size: "微软雅黑";
		}
				.Pagerwc{
			overflow: hidden;
			width: 530px;
			margin: 0 auto;
		}
		.Pager-one,.Pager-zh,.Pager-qw{
			background: #3c85e5;
			width:64px;
			height:26px;
			line-height:26px;
			color:#fff;
			font-size: 14px;
			border: none;
			border-radius: 4px;
			display: block;
			float: left;
			border: none;
			outline:none;
		}
		.Pager-zh{
		margin-left: 8px;
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
			margin: 0 8px 0 10px;
			border: none;
			outline:none;
		}
		.Pager-qw{
			width: 56px;
			margin: 0 0px 0 8px;
		}
		.Pager-ipt{
			width: 52px;
			height: 18px;
			line-height: 18px;
			text-align: center;
			margin: 0 4px;
		}
		.Pagerwc>p{
			float: left;
			height: 26px;
			font-size: 14px;
			line-height: 26px;
		}

</style>	
<div class="box-footer clearfix text-center">
	<div class="Pagerwc">
			<a class="Pager-one" href="javascript:gotoPage(1);">首页</a>
			<a class="Pager-left" href='javascript:gotoPage(${page.currentPage-1});'>«</a>
			<p>共<span class="Pager-dij">${page.pageCount}</span>页，当前第<input type="text" id="gopage" class="Pager-ipt" value="${page.currentPage}">页</p>
			<input class="Pager-qw" type="button" value="前往" onclick="btnPageGo()">
			<a class="Pager-left" href="javascript:gotoPage(${page.currentPage+1});">»</a>
			<a class="Pager-zh" href="javascript:gotoPage(${page.pageCount});">尾页</a>
	</div>
</div>
<!-- /.box-fotter -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>	
<script>
var pc = '${page.pageCount}';//总页数
function gotoPage( pageNum ){
	$(document.forms[0]).append("<input type='hidden' name='pageNum' value='" + pageNum +"'>");
	document.forms[0].submit();
	layer.msg('加载中', {
		  icon: 16
		  ,shade: 0.01
		});
}
function gotoPageSize(obj){
	$("input[name='pageSize']").val(obj.value);
	document.forms[0].submit();
}
function btnPageGo(){
	var gopage=$("#gopage").val();
	//alert(111);
	gotoPage(gopage);
}
</script>


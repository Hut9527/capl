<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>版本信息</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link rel="shortcut icon" href="${path }/static/img/prolog.ico"/>
    <!-- bootstrap 3.0.2 -->
    <link href="${path }/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="${path }/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${path }/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <link type="text/css" rel="stylesheet" href="${path }/static/css/query.css"/>
    <link type="text/css" rel="stylesheet" href="${path }/static/css/pning.css"/>
</head>
<body class="skin-blue">
<div class="wrapper row-offcanvas row-offcanvas-left">
    <section class="content-header">
        <h5>
            版本信息
        </h5>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="editionc">
                <div class="editionc-pp">
                    <img src="${path }/static/img/qidong.png" alt="">
                    <p>施工车辆与人员定位检测系统</p>
                </div>
                <div class="editionc-p02">
                    <p class="editionc-p02-01">版本声明</p>
                    <p class="editionc-p02-02">本系统的所有功能和内容仅针对施工车辆与定位检测系统项目，由郑州双杰科技股份有限公司开发，仅用于约定的授权用户使用，用户同时遵守著作权法及其他相关法律规定，不得侵犯本系统及相关权利人的权利，除此之外，将本系统任何内容或服务用于其他用途时，需征得我方及相关权利人的书面许可。</p>
                </div>
            </div>
        </div>
    </section><!-- /.content -->
</div><!-- ./wrapper -->
<!-- jQuery 2.0.2 -->
<script type="text/javascript" src="${path }/static/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script type="text/javascript" src="${path }/static/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="${path }/static/js/header.js"></script>
<!-- AdminLTE App -->
<script type="text/javascript" src="${path }/static/js/AdminLTE/app.js" ></script>
<!--天气-->

</body>
</html>
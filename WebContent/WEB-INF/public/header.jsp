<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<a href="${path}/yonghu/xinxi.do" class="logo">
                <img src="${path }/static/img/logo.png" alt="logo">
                <span>引汉济渭</span>
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <div class="navbar-left">
                    <span class="small-tit">施工车辆及人员跟踪定位管理</span>
                </div>
                <div class="navbar-right">
                    <!-- Sidebar toggle button-->
                    <a href="####" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <ul class="nav navbar-nav">
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="####" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span></span>
                            </a>
                            <ul class="dropdown-menu" >
                                <li>
                                    <a href="####" id="ChangePassword" class="btn btn-default btn-flat" onclick="changePassword();"></i>修改密码</a>
                                </li>
                                <li><a href="${path}/login/logout.do" class="btn btn-default btn-flat"><i class="fa fa-sign-out"></i>退出</a>
                                </li>
                                <!--<li><a href="javascript:window.close()" class="btn btn-default btn-flat"><i class="fa fa-power-off"></i>退出</a>-->
                                <!--</li>-->
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
    

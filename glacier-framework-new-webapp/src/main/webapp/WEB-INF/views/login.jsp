<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 获取项目根path -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<title>冰川进销存管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- 引入网站标识icon -->
		<link rel="shortcut icon" href="${ctx}/resources/images/favicon/favicon.ico"></link>
		<link rel="icon" href="${ctx}/resources/images/favicon/favicon.ico"></link>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="${ctx}/resources/js/bootstrap-3.0.3-dist/dist/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container" style="width:1376px !important;padding-top:150px;">
			<div class="row">
			  <div class="col-md-5">
			  	<div>
			  		<img src="${ctx}/resources/images/login.jpg" class="img-responsive" alt="Responsive image">
			  	</div>
			  </div>
			  <div class="col-md-7">
			  	<div class="page-header">
				  <h1>GS Invoicing Management System<small>冰川进销存管理软件</small></h1>
				</div>
			  	<div class="row">
			  		<div class="col-md-7">
				  		<form id="loginForm" role="form" action="${ctx}/do/login.htm" method="post">
						  <div class="form-group">
						    <label for="username" class="sr-only">用户名</label>
						    <input type="text" id="username" name="username" class="form-control input-lg"  placeholder="您的用户名" value="${username}">
						  </div>
						  <div class="form-group">
						    <label for="password" class="sr-only">密码</label>
						    <input type="password" id="password" name="password" class="form-control input-lg"  placeholder="您的密码">
						  </div>
						  <div class="form-group">
						  	<div class="row">
						  		<div class="col-md-3"><button type="submit" class="btn btn-primary btn-block">登录</button></div>
						  		<div class="col-md-3"><button type="reset" class="btn btn-success btn-block">重置</button></div>
						  	</div>
	  					  </div>
						</form>
					</div>
				</div>
			  </div>
			</div>
		</div>
	</body>
</html>

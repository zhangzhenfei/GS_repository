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
		<link rel="stylesheet" href="${ctx}/resources/js/bootstrap-3.0.3-dist/dist/css/bootstrap.min.css"></link>
		<link rel="stylesheet" href="${ctx}/resources/js/bootstrap-switch/bootstrap-switch.min.css"></link>
	</head>
	<body>
		<div class="container" style="padding-top:150px;">
			<div class="row">
				<div class="col-md-6 hidden-xs hidden-sm">
					<div> <img src="${ctx}/resources/images/login.jpg" class="img-responsive" alt="Responsive image"> </div>
				</div>
				<div class="col-md-6">
					<div class="page-header">
						<h1>GS Invoicing Management System <small>冰川进销存管理软件</small></h1>
					</div>
					<div class="row">
						<div class="col-md-10">
							<form id="loginForm" class="form-horizontal" role="form"  action="${ctx}/do/login.htm" method="post">
								<div class="form-group">
									<label for="username" class="control-label col-xs-3">用户名</label>
									<div class="col-xs-9">
										<input type="text" id="username" name="username" class="form-control input-lg"  placeholder="用户名/邮箱/手机" value="${username}">
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="control-label col-xs-3">密码</label>
									<div class="col-xs-9">
										<input type="password" id="password" name="password" class="form-control input-lg"  placeholder="密码">
									</div>
								</div>
								<div class="form-group">
									<label for="remember" class="control-label col-xs-3">记住我</label>
										<div class="col-xs-9">
										<input id="remember" name="remember" type="checkbox" checked data-on="primary" data-off="danger"  data-on-label="开启" data-off-label="关闭">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6 col-xs-offset-3">
										<div class="input-group">
											<span class="input-group-addon">
												<a href="javascript:void(0);">
													<img style="width:110px;height:32px;" id="login_kaptcha" src="${ctx}/resources/images/kaptcha.jpg" alt="刷新验证码">
												</a>
											</span>
											<input type="text" id="captcha" name="captcha" class="form-control input-lg">
										</div>
									</div>
									<div class="col-xs-3">
										<button type="submit" class="btn btn-primary btn-lg btn-block" disabled>登录</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="${ctx}/resources/js/jquery-extensions-master/jquery/jquery-1.10.2.js" type="text/javascript"></script> 
		<script src="${ctx}/resources/js/bootstrap-switch/bootstrap-switch.min.js" type="text/javascript"></script> 
		<script type="text/javascript">
			$(document).ready(function() {
				$('#remember').bootstrapSwitch();
				$('#login_kaptcha').click(function() {     
		           $(this).hide().attr('src','${ctx}/resources/images/kaptcha.jpg?' + Math.floor(Math.random() * 100)).fadeIn();     
			    });
			});
		</script>
	</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 获取项目根path -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>冰川进销存管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<!-- 引入网站标识icon -->
		<link rel="shortcut icon" href="${ctx}/resources/images/favicon/favicon.ico"></link>
		<link rel="icon" href="${ctx}/resources/images/favicon/favicon.ico"></link>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="${ctx}/resources/js/bootstrap-3.0.3-dist/dist/css/bootstrap.min.css"></link>
		<link rel="stylesheet" href="${ctx}/resources/js/bootstrap-switch/bootstrap-switch.min.css"></link>
	</head>
	<body>
		<div class="container">
			<div id="normal_container" class="row">
				<div class="col-md-12">
					<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
						<div class="navbar-header">
						    <a class="navbar-brand" href="#">GlacierSoft</a>
					  </div>
					</nav>
				</div>
				<div class="col-md-12 hidden-sm hidden-xs" style="height: 120px;">
				</div>
				<div class="col-md-6 hidden-sm hidden-xs">
					<img src="${ctx}/resources/images/login.jpg" class="img-responsive" alt="Glacier Soft" />
				</div>
				<div class="col-md-6 col-xs-12">
					<div class="page-header">
						<h1>GS Invoicing Management System <small>冰川进销存管理软件</small></h1>
					</div>
					<div class="row">
						<div class="col-md-10 col-xs-12">
							<form id="loginForm" class="form-horizontal" role="form"  action="${ctx}/do/login.htm" method="post" onsubmit="return validaForm();">
								<div id="userrname_form_group" class="form-group">
									<label for="username" class="control-label col-xs-3 hidden-sm hidden-xs">用户名</label>
									<div class="col-md-9 col-xs-12">
										<input type="text" id="username" name="username" class="form-control input-lg"  placeholder="用户名/邮箱/手机" value="${username}">
									</div>
								</div>
								<div id="password_form_group" class="form-group">
									<label for="password" class="control-label col-xs-3 hidden-sm hidden-xs">密码</label>
									<div class="col-md-9 col-xs-12">
										<input type="password" id="password" name="password" class="form-control input-lg"  placeholder="密码">
									</div>
								</div>
								<div class="form-group">
									<label for="rememberMe" class="control-label col-xs-3 hidden-sm hidden-xs">记住我</label>
										<div class="col-md-9 col-xs-12">
										<input id="rememberMe" name="rememberMe" type="checkbox" data-on="primary" data-off="danger"  data-on-label="开启" data-off-label="关闭"/>
									</div>
								</div>
								<div id="captcha_form_group" class="form-group">
									<div class="col-md-6 col-md-offset-3 col-xs-9">
										<div class="input-group">
											<span class="input-group-addon">
												<a href="javascript:void(0);" style="width:110px;height:32px;display:block;">
													<img class="img-responsive" style="width:110px;height:32px;" id="login_kaptcha" src="${ctx}/resources/images/kaptcha.jpg" alt="刷新验证码"  />
												</a>
											</span>
											<input type="text" id="captcha" name="captcha" maxlength="4" class="form-control input-lg">
										</div>
									</div>
									<div class="col-md-3 col-xs-3">
										<button id="login_submit" class="btn btn-primary btn-lg btn-block">登录</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div id="abnormal" style="display:none;">
			<h1>经研究表面，IE8版本以下的IE浏览器属于反人类浏览器，为了保证您的体验，推荐使用谷歌。。</h1>
		</div>
		<script src="${ctx}/resources/js/jquery-extensions-master/jquery/jquery-1.10.2.js" type="text/javascript"></script> 
		<script src="${ctx}/resources/js/bootstrap-switch/bootstrap-switch.min.js" type="text/javascript"></script> 
		<!-- Just for debugging purposes. Don't actually copy this line! -->
	    <!--[if lt IE 9]>
	    	<script type="text/javascript">
	    		$("#normal_container").hide();
	    		$("#abnormal").show();
	    	</script>
	    <![endif]-->
	
	    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
	      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
	    <![endif]-->
		<script type="text/javascript">
			$(document).ready(function() {
				$('#rememberMe').bootstrapSwitch();//开关风格checkbox
				$('#login_kaptcha').click(function() {  
					$('#captcha').val('');
		        	$(this).hide().attr('src','${ctx}/resources/images/kaptcha.jpg?' + Math.floor(Math.random() * 100)).fadeIn();     
			    });
				
				$('#captcha').val('').keyup(function() {
				    var target = this;
				    if (target.value.length === 4) {
				        if(validaForm()){
				        	$("#loginForm").submit();
				        }
				    }
				});
				//表单验证
				validaForm = function(){
					var $username = $('#username');
					if($username.val() === ''){
						$('#userrname_form_group').addClass("has-error");
						$username.focus();
						return false;
					}
					var $password = $('#password');
					if($password.val() === ''){
						$('#password_form_group').addClass("has-error");
						$password.focus();
						return false;
					}
					var $captcha = $('#captcha');
					if($captcha.val().length < 4){
						$('#captcha_form_group').addClass("has-error");
						$captcha.focus();
						return false;
					}
					$('#login_submit').attr('disabled', 'disabled');
					return true;
				};
			});
		</script>
	</body>
</html>

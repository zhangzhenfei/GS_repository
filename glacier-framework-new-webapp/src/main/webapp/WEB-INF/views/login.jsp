<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>冰川进销存管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<!-- 引入网站标识icon -->
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon/favicon.ico"></link>
		<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon/favicon.ico"></link>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/bootstrap-3.0.3-dist/dist/css/bootstrap.min.css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/bootstrap-switch/bootstrap-switch.min.css"></link>
		<style type="text/css">
			body {
				font-family: Microsoft YaHei,verdana, arial, tahoma, helvetica, sans-serif;
				font-size: 15px;
				margin: 0;
				padding: 0;
			}
			.holder{
				width:60%;
				padding:15px;
				margin:0 auto;
			}
			.holder .holder_header{
				font-size:20px;
				color: #555555;
				padding:20px 0px;
			}
			.holder .holder_ul{
				color: #777777;
			}
			.holder .holder_help span{
				display:block;
				padding:30px 5px;
				text-align:right;
				color: #BBBBBB;
			}
		</style>
	</head>
	<body>
		<div id="normal_container" class="container">
			<div class="row">
				<div class="col-md-12">
					<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
						<div class="navbar-header">
						    <a class="navbar-brand" href="${pageContext.request.contextPath}/do/login.htm">GlacierSoft</a>
					  </div>
					</nav>
				</div>
				<div class="col-md-12 hidden-sm hidden-xs" style="height: 120px;">
				</div>
				<div class="col-md-6 hidden-sm hidden-xs">
					<img src="${pageContext.request.contextPath}/resources/images/login.jpg" class="img-responsive" alt="Glacier Soft" />
				</div>
				<div class="col-md-6 col-xs-12">
					<div class="page-header">
						<h1>GS Invoicing Management System <small>冰川进销存管理软件</small></h1>
					</div>
					<div class="row">
						<div class="col-md-10 col-xs-12">
							<form id="loginForm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/do/login.htm" method="post" onsubmit="return validaForm();">
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
													<img class="img-responsive" style="width:110px;height:32px;" id="login_kaptcha" src="${pageContext.request.contextPath}/resources/images/kaptcha.jpg" alt="刷新验证码"  />
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
		
		<div id="abnormal" style="display:none;" class="holder">
			<div class="holder_header">
				<strong>尊敬的用户：经系统检测，您现在使用的IE版本过低!</strong>
			</div>
			<div class="holder_ul">
				<p>如果继续用该浏览器访问，可能会发生以下情况：</p>
				<ul>
					<li>当前脚本出现运行错误，是否纠正错误</li>
					<li>页面显示错误，反人类设计榜首</li>
					<li>Microsoft Internet Explorer 遇到问题需要关闭...</li>
					<li>Microsoft Internet Explorer 无法响应【卡屏】</li>
					<li>......</li>
				</ul>
				<p>90% 的使用者向我们表明：IE8版本以下的IE浏览器属于反人类浏览器，推荐使用：</p>
			</div>	
			<div class="holder_ul">
				<ul>
					<li>谷歌浏览器：<a href="https://www.google.com/intl/zh-CN/chrome/browser/" target="_blank">访问下载页</a></li>
					<li>360急速浏览器：<a href="https://www.google.com/intl/zh-CN/chrome/browser/" target="_blank">访问下载页</a></li>
					<li>火狐浏览器：<a href="https://www.google.com/intl/zh-CN/chrome/browser/" target="_blank">访问下载页</a></li>
				</ul>
			</div>
			<div class="holder_help">
				<p><span id="link_to" href="javascript:void(0);">-->我已了解，仍然使用本浏览器访问</span></p>
			</div>	
		</div>
		<!-- 获取项目根path -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-extensions-master/jquery/jquery-1.10.2.js" type="text/javascript"></script> 
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-switch/bootstrap-switch.min.js" type="text/javascript"></script> 
		<!-- Just for debugging purposes. Don't actually copy this line! -->
	    <!--[if lt IE 9]>
	    	<script type="text/javascript">
	    		$("#normal_container").hide();
	    		$("#abnormal").show();
	    		$('#link_to').click(function() {  
					$("#normal_container").fadeIn();
	    			$("#abnormal").hide();     
			    });
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
		        	$(this).hide().attr('src','${pageContext.request.contextPath}/resources/images/kaptcha.jpg?' + Math.floor(Math.random() * 100)).fadeIn();     
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

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
	<body>
	<form id="loginForm" action="${ctx}/do/login.htm" method="post">
			<%
				String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
				if(error != null){
			%>
					<div class="alert alert-error controls input-large">
						<button class="close" data-dismiss="alert">×</button>
			<%
					if(error.contains("DisabledAccountException")){
						out.print("用户已被屏蔽,请登录其他用户.");
					}
					else{
						out.print("登录失败，请重试.");
					}
			%>		
					</div>
			<%
				}
			%>
			<div class="control-group">
				<label for="username" class="control-label">名称:</label>
				<div class="controls">
					<input type="text" id="username" name="username" value="${username}" class="input-medium required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="password" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="password" name="password" class="input-medium required"/>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<label class="checkbox inline" for="rememberMe"> <input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我</label>
					<input id="submit_btn" class="btn" type="submit" value="登录"/>
					<p class="help-block">(管理员：<b>admin/admin</b>, 普通用户：<b>user/admin</b>)</p>
				</div>
			</div>
		</form>
	</body>
</html>

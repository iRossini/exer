<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./layui/css/layui.css">
<link rel="stylesheet" href="./css/global.css">
<script type="text/javascript" src="./layui/layui.js"></script>
</head>
<body>
	<style type="text/css">
html {
	background: #C2C2C2;
}
</style>
	<div class="login_page">
		<img class="logo-login" src="./images/logo-login.png" alt="logo">
		<h1>iRossini</h1>
		<form class="layui-form" action="login" method="POST">
			<div class="layui-form-item">
				<div class="layui-input-inline input-custom-width">
					<input type="text" name="id" placeholder="员工号" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-inline input-custom-width">
					<input type="password" name="password" placeholder="密码"
						autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-inline input-custom-width">
					<button class="layui-btn input-custom-width">登陆</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
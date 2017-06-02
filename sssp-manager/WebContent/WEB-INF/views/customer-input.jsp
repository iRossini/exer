<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 引入Bootstrap样式 -->
<link rel="stylesheet"
	href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>新增客户</h1>
	<form:form action="customer-save" method="POST"
		modelAttribute="customer">
		公司名称：<form:input path="companyName" />
		<br>
		公司地址：<form:input path="address" />
		<br>
		联&nbsp&nbsp系&nbsp&nbsp人：<form:input path="contacts" />
		<br>
		联系电话：<form:input path="phone" />
		<input type="submit" value="提交">
	</form:form>
</body>
</html>
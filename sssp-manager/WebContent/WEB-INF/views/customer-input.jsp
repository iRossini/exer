<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>添加新客户</h4>
	<form:form action="customer-save" method="POST"
		modelAttribute="customer">
	公司名称：<form:input path="companyName" />
		<br>
	公司地址：<form:input path="address" />
		<br>
	联系人：<form:input path="contacts" />
		<br>
	联系电话：<form:input path="phone" />
		<input type="submit" value="提交">
	</form:form>
</body>
</html>
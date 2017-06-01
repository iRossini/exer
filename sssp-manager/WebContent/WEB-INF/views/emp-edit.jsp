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
	<h4>修改员工信息</h4>
	<form:form action="emp-save" method="POST" modelAttribute="employee">
		<input type="hidden" name="_method" value="PUT">
		<form:hidden path="id" />
			姓名：<form:input path="name" />
			手机号<form:input path="phone" />
			生日：<form:input path="birth" />
			入职日期：<form:input path="joinTime" />
			所属部门<form:select path="department.id" items="${departments}"
			itemLabel="departmentName" itemValue="department.id"></form:select>
		<input type="submit" value="提交" />
	</form:form>

</body>
</html>
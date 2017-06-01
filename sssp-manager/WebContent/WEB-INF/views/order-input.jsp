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
	<h4>添加新仪器</h4>
	<form:form action="instrument-save" method="POST"
		modelAttribute="instrument">
		仪器名称：<form:input path="name" />
		<br>
		生产厂家：<form:input path="factory" />
		<br>
		仪器型号：<form:input path="type" />
		<br>
		购买（校准）日期：<form:input path="buyTime" />
		<br>
		所属科室：<form:select path="department.id" items="${departments}"
			itemLabel="departmentName" itemValue="department.id"></form:select>
		<input type="submit" value="提交" />
	</form:form>
</body>
</html>
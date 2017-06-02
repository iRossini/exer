<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<script src="${APP_PATH}/scripts/jquery-2.1.1.min.js"></script>
<link rel="stylesheet"
	href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="orderShowModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	<h4>设备显示</h4>
	<c:if test="${!empty requestScopre.instruments}">没有任何仪器信息</c:if>
	<c:if test="${empty requestScopre.instruments}">
		<table border="1" cellspacing="0" cellpadding="10">
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>生产厂家</td>
				<td>型号</td>
				<td>购买日期</td>
				<td>使用部门</td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach items="${requestScope.instruments}" var="instrument">
				<tr>
					<td>${instrument.id}</td>
					<td>${instrument.name}</td>
					<td>${instrument.factory}</td>
					<td>${instrument.type}</td>
					<td>${instrument.buyTime}</td>
					<td>${instrument.department.departmentName}</td>
					<td><a href="instrument-edit/${instrument.id}">修改</a></td>
					<td><a href="instrument-delete/${instrument.id}"
						class="delete">删除</a> <input type="hidden" value="${name}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE" />
	</form>
	<script>
		$(function() {
			$(document).on("click", "#orderShow", function() {
				$("#orderShowModal").modal()
			})

		});
	</script>
</body>
</html>
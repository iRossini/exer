<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		});
		$(".delete").click(function() {
			var name = $(this).next(":hidden").val();
			var flag = confirm("确定要删除 " + name + " 的信息吗？");
			if (flag) {
				var $tr = $(this).parent().parent();
				var url = this.href;
				var args = {
					"time" : new Date()
				}
				$.post(url, args, function(data) {
					if (data == "1") {
						alert("删除成功！");
						$tr.remove();
					} else {
						alert("删除失败！");
					}
				});
			}
			return false;
		});

	})
</script>
</head>
<body>
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
</body>
</html>
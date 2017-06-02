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
	<!--订单显示模态框 -->
	<div class="modal fade" id="orderShowModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">查看该客户所有订单号</h4>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!--客户信息编辑模态框 -->
	<div class="modal fade" id="customerEditModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改客户信息</h4>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<!-- 标题 -->
		<div class="row ">
			<div class="col-md-12">
				<h1>客户信息</h1>
			</div>
		</div>
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<c:if test="${empty requestScope.customers}">没有任何客户信息</c:if>
				<c:if test="${!empty requestScope.customers}">
					<table class="table table-hover">
						<tr>
							<td>编号</td>
							<td>公司名称</td>
							<td>公司地址</td>
							<td>联系人</td>
							<td>联系电话</td>
							<td></td>
							<td></td>
						</tr>
						<c:forEach items="${requestScope.customers}" var="customer">
							<tr class="tr">
								<td>${customer.id}</td>
								<td>${customer.companyName}</td>
								<td>${customer.address}</td>
								<td>${customer.contacts}</td>
								<td>${customer.phone}</td>
								<td>
									<button class="btn btn-info btn-sm" id="orderShow">
										<span class="glyphicon glyphicon-list-alt"></span>订单
									</button>
								</td>
								<!-- <a href="customer/${customer.id}">修改</a> -->
								<td>
									<button class="btn btn-success btn-sm" id="customerEdit">
										<span class="glyphicon glyphicon-pencil"></span>修改
									</button>
								</td>
								<!-- <a href="customer/${customer.id}" class="delete">删除</a> -->
								<td>
									<button class="btn btn-danger btn-sm">
										<span class="glyphicon glyphicon-trash"></span>删除
									</button> <input type="hidden" value="${name}" />
								</td>
							</tr>
							<div></div>
						</c:forEach>
					</table>
				</c:if>
				<form action="" method="POST">
					<input type="hidden" name="_method" value="DELETE" />
				</form>
			</div>
		</div>
		<!-- 分页 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6">当前记录数：XXX，总共记录数：XXX；当前第X页，总共XX页；</div>
			<!-- 分页按钮 -->
			<div class="col-md-4 col-md-offset-2">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			$(document).on("click", "#orderShow", function() {
				$("#orderShowModal").modal()
			})
			$(document).on("click", "#customerEdit", function() {
				$("#customerEditModal").modal()
			})

		});
	</script>
</body>
</html>
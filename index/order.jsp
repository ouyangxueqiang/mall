<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>我的订单</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
</head>
<body>
	
	<jsp:include page="header.jsp"/>
	
	<!--cart-items-->
	<div class="cart-items">
		<div class="container">
		
		<c:if test="${msg!=null}"><div class="alert alert-success">${msg}</div></c:if>
			<h2>我的订单</h2>
			
				<table class="table table-bordered table-hover">

				<tr>
					<th width="10%">商品名称</th>
					<th width="10%">商品单价</th>
					<th width="10%">商品数量</th>
					<th width="10%">付款方式</th>
					<th width="10%">下单时间</th>
					<th width="10%">地址</th>
					<th width="10%">电话</th>
					<th width="10%">姓名</th>
				</tr>
				<c:forEach var="order" items="${orders}">
			         <tr>
			         	<td><p>${order.goodName}</p></td>
			         	<td><p>${order.price}</p></td>
			         	<td><p>${order.amount}</p></td>
			         	<td><p>${order.paytype}</p></td>
			         	<td><p>${order.systime}</p></td>
			         	<td><p>${order.address}</p></td>
			         	<td><p>${order.phone}</p></td>
			         	<td><p>${order.userName}</p></td>
			       	</tr>
				</c:forEach>
			     
			</table>
			
			<c:if test="${orders==null}"><div class="alert alert-info">空空如也</div></c:if>
			
		</div>
	</div>
	

</body>
</html>
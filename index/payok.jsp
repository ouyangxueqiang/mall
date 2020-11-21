<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>支付成功</title>
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
			<form action="mail" method="post"> 
					<div class="register-top-grid">
						<h3>输入邮箱地址，接受商家发货提醒</h3>
						<div class="input">
							<span>qq邮箱 <label style="color:red;">*</label></span>
							<input type="text" name="mail" placeholder="请输入邮箱" required="required"> 
						</div>
						<div class="register-but text-center">
					   		<input type="submit" value="提交">
					   <div class="clearfix"> </div>
					</div>
					</div>
			</form>
			<p><a class="btn btn-success" href="order?userid=${user.id }">查看我的订单</a></p>
		</div>
	</div>
	<!--//cart-items-->	
	

</body>
</html>
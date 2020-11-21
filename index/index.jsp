<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>商城首页</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
</head>
<body style="background-image:url(images/bg.jpeg);background-size:100%;">
	
	<jsp:include page="header.jsp"/>
	
	<!--gallery-->
	<div class="gallery">
		<div class="container">
			<c:if test="${msg!=null}">
			<div class="alert alert-success">${msg}</div>
			</c:if>
		</div>
	</div>
	<!--//gallery-->

</body>
</html>
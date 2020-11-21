<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>支付</title>
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
	<div class="cart-items">
		<div class="container">
			<h2>确认收货信息</h2>
			<form class="form-horizontal" action="pay" method="post" id="payform">
				<div class="row">
					<label class="control-label col-md-1"></label>
					<div class="col-md-6">
					<h1>收货人:${user.name}</h1>
						<br>
					</div>
				</div>
				<div class="row">
					<label class="control-label col-md-1"></label>
					<div class="col-md-6">
					<h1>收货电话:${user.phone}</h1>
						<br>
					</div>
				</div>
				<div class="row">
					<label class="control-label col-md-1"></label>
					<div class="col-md-6">
					<h1>收货地址:${user.address}</h1>
						<br>
					</div>
				</div>
				<h3>若信息有误，请修改我的信息。</h3>
			</form>
			
			<br><hr><br>
			
			<h2>选择支付方式</h2>
			<h3>支付金额: ${allprice}</h3><br><br>
			<div class="col-sm-6 col-md-4 col-lg-3 ">
				<div class="thumbnail">
					<a href="save?userid=${sessionScope.user.id}&pay=1"> 
						<img src="images/alipay.jpg" alt="支付宝支付">
					</a>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3 ">
				<div class="thumbnail">
					<a href="save?userid=${sessionScope.user.id}&pay=2"> 
						<img src="images/wechat.jpg" alt="微信支付">
					</a>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3 ">
				<div class="thumbnail">
					<a href="save?userid=${sessionScope.user.id}&pay=3"> 
						<img src="images/offline.jpg" alt="货到付款">
					</a>
				</div>
			</div>
		</div>
	</div>

	
<script type="text/javascript">
	function dopay(paytype){
		// 信息校验
		var name = $("#fname").val();
		if(name==null || name==""){
			layer.msg("请正确填写收货人!");
			return;
		}
		var phone = $("#fphone").val();
		if(phone==null || phone=="" || !/^[0-9]*$/.test(phone)){
			layer.msg("请正确填写收货电话!");
			return;
		}
		var address = $("#faddress").val();
		if(address==null || address==""){
			layer.msg("请正确填写收货地址!");
			return;
		}
		
		$("#paytype").val(paytype);
		$("#payform").submit();
	}
</script>

</body>
</html>
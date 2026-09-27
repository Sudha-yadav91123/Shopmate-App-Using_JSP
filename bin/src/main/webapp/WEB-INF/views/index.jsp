<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShopMate - Index</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<!-- HERO SECTION -->
<section class="index-hero">
    <h1>Welcome to ShopMate</h1>
    <p>Your One-Stop Shopping Destination</p>
    <a href="/login" class="index-btn">Let's Login →</a>
</section>

<!-- FEATURE SECTION -->
<section class="index-features">

    <div class="index-card">
        <h3>🛍 Latest Products</h3>
        <p>Discover trending items at the best prices.</p>
    </div>

    <div class="index-card">
        <h3>🚚 Fast Delivery</h3>
        <p>Quick and reliable doorstep delivery.</p>
    </div>

    <div class="index-card">
        <h3>💳 Secure Payments</h3>
        <p>Safe and easy payment options.</p>
    </div>

</section>

<%@ include file="footer.jsp" %>

</body>
</html>

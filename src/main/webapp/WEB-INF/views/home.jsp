<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShopMate - Home</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<style>
/* Overlay for dark background */
.home-overlay {
	background: 
	        linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)),
	        url('/images/bg.jpg') no-repeat center center/cover;
    min-height: 90vh;
    display: flex;
    align-items: center;
    justify-content: center;
    text-align: center;
    padding: 20px;
}

/* Light text styling */
.home-content {
    color: #ffffff;
    max-width: 800px;
}

.home-content h1 {
    font-size: 42px;
    margin-bottom: 20px;
    text-shadow: 0 0 10px rgba(255,255,255,0.4);
}

.home-content h2 {
    font-size: 22px;
    color: #dddddd;
    margin-top: 20px;
}

.home-content p {
    color: #cccccc;
    margin-top: 10px;
}

.home-content a {
    display: inline-block;
    margin-top: 25px;
    padding: 14px 28px;
    background: #ffffff;
    color: #222;
    text-decoration: none;
    font-weight: 600;
    border-radius: 8px;
    transition: 0.3s ease;
}

.home-content a:hover {
    background: #f5f5f5;
    transform: translateY(-3px);
}

/* Responsive */
@media (max-width: 768px) {
    .home-content h1 {
        font-size: 28px;
    }

    .home-content h2 {
        font-size: 18px;
    }
}
</style>

</head>
<body>

<%@ include file="header.jsp" %>

<div class="home-overlay">
    <div class="home-content">

        <c:if test="${not empty msg}">
            <div id="toast" class="toast success">${msg}</div>
        </c:if>

        <h1>Welcome to ShopMate</h1>
        <h2>Your One-Stop Shopping App</h2>
        <p>Explore our latest products and best offers.</p>
        <a href="/shop">Lets Shop Now →</a>

    </div>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>

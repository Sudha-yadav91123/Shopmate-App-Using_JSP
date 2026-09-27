<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Products</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
	<%@ include file="header.jsp" %>
	<c:if test="${not empty msg}">
			    <div id="toast" class="toast success">${msg}</div>
			</c:if>

<div class="container">

    <h2>Product Catlog</h2>

    <div class="product-grid">
        <c:forEach var="p" items="${products}">
            <div class="card">
				<img src="${pageContext.request.contextPath}/images/${p.imagepath}" 
				     alt="${p.pname}">

                <div class="card-body">
                    <h4>${p.pname}</h4>
                    <p>Category: <c:choose><c:when test="${p.category != null}">${p.category.name}</c:when><c:otherwise>${p.legacyCategory}</c:otherwise></c:choose></p>
                    <p class="price">₹ ${p.price}</p>
					<a href="/add-to-cart/${p.pid}">Add-To-Cart</a><!-- we can also add checkboxes-->
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="shop-cart-action">
        <a href="${pageContext.request.contextPath}/cart" class="shop-view-cart">
            🛒 View Cart
            <span class="shop-cart-arrow">→</span>
        </a>
    </div>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>

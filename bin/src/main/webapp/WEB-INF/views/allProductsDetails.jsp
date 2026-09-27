<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>

<link rel="stylesheet" type="text/css" href="/css/style.css">


</head>
<body>
	<%@ include file="header.jsp" %>
<div class="container">

    <h2>All Products</h2>

    <div class="product-grid">
        <c:forEach var="product" items="${products}">
            <div class="card">
				<img src="${pageContext.request.contextPath}/images/${product.imagepath}" 
				     alt="${product.pname}">

                <div class="card-body">
                    <h4>${product.pname}</h4>
                    <p>Category: <c:choose><c:when test="${product.category != null}">${product.category.name}</c:when><c:otherwise>${product.legacyCategory}</c:otherwise></c:choose></p>
                    <p class="price">₹ ${product.price}</p>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>

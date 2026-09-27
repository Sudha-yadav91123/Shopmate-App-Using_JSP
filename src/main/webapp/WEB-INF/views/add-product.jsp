<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Add Product</title>


<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{

    min-height:100vh;

    background-image:url('/images/bg.jpg');
    background-size:cover;
    background-position:center;
    background-repeat:no-repeat;

    display:flex;
    flex-direction:column;
    align-items:center;
}

.form-container{

    width:450px;
    max-width:92%;
    margin:55px auto;

    padding:35px;

background:rgba(70, 70, 70, 0.60);

    border-radius:15px;

    box-shadow:0 8px 20px rgba(0,0,0,0.3);
}

h2{

    text-align:center;

    margin-bottom:25px;

    color:rgb(255, 255, 255);
}

.form-group{

    margin-bottom:18px;
}

.form-group label{

    display:block;

    margin-bottom:6px;

    font-weight:bold;

    color:rgb(255, 255, 255);
}

.form-group input,
.form-group select{

    width:100%;

    padding:12px;

    border:1px solid #ccc;

    border-radius:8px;

    font-size:15px;

    outline:none;
}

.form-group input:focus,
.form-group select:focus{

    border-color:#ff6600;

    box-shadow:0 0 5px rgba(255,102,0,0.4);
}

button{

    width:100%;

    padding:12px;

    background:#28a745;

    color:white;

    border:none;

    border-radius:8px;

    font-size:16px;

    font-weight:bold;

    cursor:pointer;

    transition:0.3s;
}

button:hover{

    background:#218838;
}

</style>

</head>

<body>

<%@ include file="admin-navbar.jsp" %>

<div class="form-container">

<h2>📦 Add Product</h2>

<c:if test="${not empty msg}">
    <div style="background:#d4edda;color:#155724;padding:10px;border-radius:8px;margin-bottom:15px;text-align:center;">
        ${msg}
    </div>
</c:if>

<form action="${pageContext.request.contextPath}/save-product" method="post">

    <div class="form-group">
        <label>Product Name</label>
        <input type="text" name="pname" placeholder="Enter product name" required>
    </div>

    <div class="form-group">
        <label>Category</label>
        <select name="categoryId" id="categoryId" required>
            <option value="">-- Select Category --</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.categoryId}">${category.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label>Image Path</label>
        <input type="text" name="imagepath" placeholder="e.g. iphone.jpg" required>
    </div>

    <div class="form-group">
        <label>Price</label>
        <input type="number" step="0.01" min="0" name="price" placeholder="Enter price" required>
    </div>

    <button type="submit">Save Product</button>

</form>

</div>

</body>
</html>

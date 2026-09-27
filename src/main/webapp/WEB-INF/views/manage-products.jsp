<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Manage Products</title>

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

    padding:0 0 40px;
}

.container{

    width:90%;
    margin-top:45px;

    margin:auto;

    background:rgba(255,255,255,0.85);

    padding:30px;

    border-radius:15px;

    box-shadow:0 8px 20px rgba(0,0,0,0.3);
}

h2{

    text-align:center;

    margin-bottom:25px;

    color:#333;
}

.add-btn{

    display:inline-block;

    text-decoration:none;

    background:#28a745;

    color:white;

    padding:10px 20px;

    border-radius:8px;

    margin-bottom:20px;

    font-weight:bold;
}

.add-btn:hover{
    background:#218838;
}

table{

    width:100%;

    border-collapse:collapse;

    background:white;
}

table th{

    background:#343a40;

    color:white;

    padding:12px;
}

table td{

    padding:12px;

    text-align:center;

    border-bottom:1px solid #ddd;
    color:#222;
}

table tr:hover{
    background:#f5f5f5;
}

.delete-btn{

    text-decoration:none;

    background:#dc3545;

    color:white;

    padding:8px 15px;

    border-radius:6px;

    font-size:14px;
}

.delete-btn:hover{
    background:#c82333;
}

.success-msg{
    background:#d4edda;
    color:#155724;
    padding:12px;
    border-radius:8px;
    margin-bottom:15px;
    text-align:center;
    font-weight:bold;
    border:1px solid #c3e6cb;

    transition:opacity 0.5s ease;
}


.admin-management-page {
    color: #222;
}

.admin-management-page .admin-container {
    color: #222;
}

.admin-management-page .admin-container h2 {
    color: #222;
}

.admin-management-page .admin-container table {
    color: #222;
}

.admin-management-page .admin-container table td {
    color: #222;
    background: #ffffff;
}

.admin-management-page .admin-container table tbody tr:nth-child(even) td {
    background: #f8f9fa;
}

.admin-management-page .admin-container table tbody tr:hover td {
    background: #eef2f7;
    color: #111;
}

.admin-management-page .admin-container table th {
    color: #ffffff;
}

</style>

</head>

<body class="admin-management-page">

<%@ include file="admin-navbar.jsp" %>

<div class="container admin-container">

<h2>📦 Manage Products</h2>

<a href="${pageContext.request.contextPath}/add-product" class="add-btn">
    + Add Product
</a>
<c:if test="${not empty msg}">
    <div id="successMsg" class="success-msg">
        ${msg}
    </div>
</c:if>
<table>

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Category</th>
    <th>Price</th>
    <th>Action</th>
</tr>

<c:forEach items="${products}" var="p">

<tr>

<td>${p.pid}</td>
<td>${p.pname}</td>
<td><c:choose><c:when test="${p.category != null}">${p.category.name}</c:when><c:otherwise>${p.legacyCategory}</c:otherwise></c:choose></td>
<td>₹ ${p.price}</td>

<td>
	<a href="${pageContext.request.contextPath}/delete-product/${p.pid}"
	   class="delete-btn"
	   onclick="return confirm('Are you sure you want to delete this product?')">
	   Delete
	</a>
</td>

</tr>

</c:forEach>

</table>

</div>

<script>

window.onload = function() {

    const msg = document.getElementById("successMsg");

    if(msg){

        setTimeout(function(){

            msg.style.opacity = "0";

            setTimeout(function(){
                msg.style.display = "none";
            }, 500);

        }, 3000); // disappears after 3 seconds
    }
};

</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Admin Dashboard</title>

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
.dashboard-container{

    width:min(700px, 92%);
    margin:70px auto;

    padding:40px;

    background:rgba(0, 0, 0, 0.45);

    backdrop-filter:blur(6px);

    border-radius:20px;

    box-shadow:0px 8px 20px rgba(0,0,0,0.3);

    text-align:center;

    color:white;

    border:1px solid rgba(255,255,255,0.2);
}

.dashboard-container h1{
    margin-bottom:30px;
    font-size:36px;
    color:white;
    text-shadow:1px 1px 3px rgba(0,0,0,0.5);
}

.menu{
    display:flex;
    justify-content:center;
    gap:30px;
    flex-wrap:wrap;
}

.menu a{

    text-decoration:none;

    background:#ff6600;

    color:white;

    padding:15px 25px;

    border-radius:10px;

    font-size:18px;

    font-weight:bold;

    transition:0.3s;
}

.menu a:hover{
    background:#e65c00;
    transform:translateY(-3px);
}

</style>

</head>

<body>

<%@ include file="admin-navbar.jsp" %>

<div class="dashboard-container">

    <h1>🛒 Admin Dashboard</h1>

    <div class="menu">

        <a href="${pageContext.request.contextPath}/manage-products">
            📦 Manage Products
        </a>

        <a href="${pageContext.request.contextPath}/manage-customers">
            👥 Manage Customers
        </a>

    </div>

</div>

</body>
</html>
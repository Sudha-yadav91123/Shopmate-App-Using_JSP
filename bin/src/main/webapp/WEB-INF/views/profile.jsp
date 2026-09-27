<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<div class="container">
    
    <h2 style="text-align:center; margin-bottom:30px;">👤 My Profile</h2>

    <div class="card" style="max-width:600px; margin:0 auto; padding:30px;">
        
        <p><strong>Full Name:</strong> ${customer.fullname}</p>
        <p><strong>Email:</strong> ${customer.email}</p>
        <p><strong>Mobile:</strong> ${customer.mobile}</p>
        <p><strong>Address:</strong> ${customer.address}</p>
        <p><strong>Username:</strong> ${customer.username}</p>

        <div style="margin-top:25px; text-align:center;">
            <a href="/update-profile" class="index-btn">Update Profile</a>
        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>

</body>
</html>


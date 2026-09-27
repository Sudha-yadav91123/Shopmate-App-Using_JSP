<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
<link rel="stylesheet" href="/css/style.css">
</head>

<body>

<%@ include file="header.jsp" %>

<div class="container">

<h2 style="text-align:center;">✏ Update Profile</h2>

<form action="/update-profile" method="post" class="form-card">

<input type="hidden" name="cid" value="${customer.cid}">

<label>Full Name</label>
<input type="text" name="fullname" value="${customer.fullname}" required>

<label>Email</label>
<input type="email" name="email" value="${customer.email}" required>

<label>Mobile</label>
<input type="text" name="mobile" value="${customer.mobile}" required>

<label>Address</label>
<input type="text" name="address" value="${customer.address}" required>

<label>Username</label>
<input type="text" name="username" value="${customer.username}" required>

<label>Password</label>
<input type="password" name="password" value="${customer.password}" required>

<div style="text-align:center;margin-top:20px;">
<button type="submit" class="index-btn">Update Profile</button>
</div>

</form>

</div>

<%@ include file="footer.jsp" %>

</body>
</html>

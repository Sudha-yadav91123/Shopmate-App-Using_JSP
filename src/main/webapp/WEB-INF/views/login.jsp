<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>

    <%@ include file="header.jsp" %>

    <div class="login-container">

		<c:if test="${not empty msg}">
		    <div id="toast"
		         class="toast ${msg.contains('successfully') ? 'success' : 'error'}">
		        ${msg}
		    </div>
		</c:if>

        <h2>Login Here</h2>

        <form action="/verify-login" method="post">
            <label>Username</label>
            <input type="text" name="username" required>

            <label>Password</label>
            <input type="password" name="password" required>

            <button type="submit">Login</button>
        </form>

        <p>
            Don't have an account?
            <a href="/register">Register here</a>
        </p>

    </div>

    <%@ include file="footer.jsp" %>

</body>
</html>

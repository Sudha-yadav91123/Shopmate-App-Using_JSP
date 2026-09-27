<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Register Page</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>

	<body>
		<%@ include file="header.jsp" %>
		<div class="content">
		<h1>Register Page</h1>
		<c:if test="${not empty msg}">
				    <div id="toast" class="toast success">${msg}</div>
				</c:if>
				<form action="/register-customer" method="post" onsubmit="return validateForm()">

				    <label>Full Name:</label>
				    <input type="text" id="fullname" name="fullname"
				           pattern="[A-Za-z ]{3,50}"
				           title="Name should contain only letters and spaces (3-50 characters)"
				           required />
				    <br>

				    <label>Email:</label>
				    <input type="email" id="email" name="email" required />
				    <br>

				    <label>Mobile:</label>
				    <input type="text" id="mobile" name="mobile"
				           pattern="[6-9][0-9]{9}"
				           title="Enter a valid 10-digit mobile number"
				           required />
				    <br>

				    <label>Address:</label>
				    <input type="text" id="address" name="address"
				           minlength="5" maxlength="100"
				           required />
				    <br>

				    <label>Username:</label>
				    <input type="text" id="username" name="username"
				           pattern="[A-Za-z0-9_]{4,20}"
				           title="Username must be 4-20 characters and contain only letters, numbers, and underscore"
				           required />
				    <br>

				    <label>Password:</label>
				    <input type="password" id="password" name="password"
				           minlength="8"
				           required />
				    <br>

				    <label>Confirm Password:</label>
				    <input type="password" id="confirmPassword"
				           required />
				    <br>

				    <button type="submit">Register</button>

				</form>

		<p>
		    Already have an account?
		    <a href="/login">Login here</a>
		</p>
		</div>
		<%@ include file="footer.jsp" %>
		<script>
		function validateForm() {

		    let password = document.getElementById("password").value;
		    let confirmPassword = document.getElementById("confirmPassword").value;

		    // Password validation
		    let passwordRegex =
		        /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$/;

		    if (!passwordRegex.test(password)) {
		        alert("Password must contain:\n" +
		              "- At least 8 characters\n" +
		              "- One uppercase letter\n" +
		              "- One lowercase letter\n" +
		              "- One number\n" +
		              "- One special character");
		        return false;
		    }

		    // Confirm password validation
		    if (password !== confirmPassword) {
		        alert("Passwords do not match.");
		        return false;
		    }

		    return true;
		}
		</script>
	</body>

	</html>
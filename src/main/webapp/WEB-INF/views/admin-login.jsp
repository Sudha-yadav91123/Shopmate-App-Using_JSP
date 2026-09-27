<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login - ShopMate</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    height:100vh;

    background-image:url('/images/bg.jpg');
    background-size:cover;
    background-position:center;
    background-repeat:no-repeat;

    display:flex;
    justify-content:center;
    align-items:center;
}

.login-box{

    width:400px;

    padding:40px;

    background:rgba(255,255,255,0.15);

    backdrop-filter:blur(10px);

    border-radius:20px;

    box-shadow:0px 8px 20px rgba(0,0,0,0.3);

    color:white;
}

.login-box h1{
    text-align:center;
    margin-bottom:25px;
}

.input-group{
    margin-bottom:20px;
}

.input-group label{
    display:block;
    margin-bottom:8px;
    font-weight:bold;
}

.input-group input{

    width:100%;

    padding:12px;

    border:none;

    border-radius:8px;

    outline:none;

    font-size:15px;
}

button{

    width:100%;

    padding:12px;

    background:#ff6600;

    color:white;

    border:none;

    border-radius:8px;

    font-size:16px;

    font-weight:bold;

    cursor:pointer;

    transition:0.3s;
}

button:hover{
    background:#e65c00;
}

.error-msg{
    text-align:center;
    color:#ffcccc;
    margin-top:15px;
    font-weight:bold;
}

.logo{
    text-align:center;
    margin-bottom:15px;
    font-size:28px;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="login-box">

    <div class="logo">
        🛒 ShopMate Admin
    </div>

    <h1>Admin Login</h1>

    <form action="/admin-login" method="post">

        <div class="input-group">
            <label>Username</label>
            <input type="text"
                   name="username"
                   placeholder="Enter Username"
                   required>
        </div>

        <div class="input-group">
            <label>Password</label>
            <input type="password"
                   name="password"
                   placeholder="Enter Password"
                   required>
        </div>

        <button type="submit">
            Login
        </button>

    </form>

    <p class="error-msg">${msg}</p>

</div>

</body>
</html>
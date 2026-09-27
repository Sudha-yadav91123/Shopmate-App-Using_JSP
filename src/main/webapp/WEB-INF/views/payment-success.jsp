<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Successful | ShopMate</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>

/* =========================
   BODY & PAGE BACKGROUND
========================= */

body{
    background:linear-gradient(135deg,#e8f5e9,#f5f7fb);
    font-family:'Segoe UI',sans-serif;
}

/* =========================
   CENTER CONTAINER
========================= */

.success-container{
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:20px;
}

/* =========================
   SUCCESS CARD
========================= */

.success-card{
    background:white;
    padding:40px;
    border-radius:20px;
    text-align:center;
    box-shadow:0 10px 35px rgba(0,0,0,0.1);
    max-width:520px;
    width:100%;
    transition:all 0.3s ease;
}

.success-icon{
    font-size:80px;
    color:#28a745;
    animation:pop .6s ease;
}

@keyframes pop{
    0%{transform:scale(0);}
    80%{transform:scale(1.2);}
    100%{transform:scale(1);}
}

.success-title{
    font-weight:700;
    margin-top:15px;
    font-size:1.8rem;
}

.success-text{
    color:#666;
    margin:15px 0 25px;
    font-size:1rem;
    line-height:1.5;
    position: relative;
    padding:12px 16px;
    border-radius:10px;
    background: linear-gradient(90deg, #d9f7ff 0%, #ffffff 100%);
    border-left: 4px solid #28a745;
    box-shadow:0 5px 15px rgba(0,0,0,0.05);
    transition: all 0.3s ease;
}

.success-text:hover {
    background: linear-gradient(90deg, #b3ecff 0%, #ffffff 100%);
    transform: scale(1.02);
}

.success-text strong{
    color:#28a745;
    font-size:1.1rem;
}

/* =========================
   BUTTONS
========================= */

.action-btn{
    padding:12px 20px;
    border-radius:8px;
    text-decoration:none;
    font-weight:600;
    margin:6px;
    display:inline-block;
    transition:.3s;
    min-width:140px;
    text-align:center;
}

.print-btn{
    background:#333;
    color:white;
}

.shop-btn{
    background:#28a745;
    color:white;
}

.home-btn{
    background:#0d6efd;
    color:white;
}

.action-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 6px 15px rgba(0,0,0,0.2);
}

/* =========================
   RESPONSIVE MEDIA QUERIES
========================= */

/* Small devices (phones) */
@media(max-width:576px){
    .success-card{
        padding:25px;
        margin:15px;
    }

    .success-icon{
        font-size:60px;
    }

    .success-title{
        font-size:1.5rem;
    }

    .success-text{
        font-size:0.95rem;
        padding:10px 14px;
    }

    .action-btn{
        width:100%;
        margin:8px 0;
        font-size:0.95rem;
    }
}

/* Medium devices (tablets) */
@media(max-width:768px){
    .success-card{
        padding:30px;
    }

    .success-icon{
        font-size:70px;
    }

    .success-text{
        font-size:1rem;
    }

    .action-btn{
        min-width:120px;
    }
}

/* Flex wrap buttons */
.mt-4{
    display:flex;
    justify-content:center;
    flex-wrap:wrap;
    gap:8px;
}

</style>
</head>

<body>

<div class="success-container">

    <div class="success-card">

        <i class="fa-solid fa-circle-check success-icon"></i>

        <h2 class="success-title">Payment Successful 🎉</h2>

        <p class="success-text">
            <strong>Order Confirmed ✅</strong><br>
            Your invoice has been sent to your registered email address.
        </p>

        <div class="mt-4">
            <a href="/download-invoice" target="_blank" class="action-btn print-btn">
               🖨 Print / View Invoice
            </a>

            <a href="/shop" class="action-btn shop-btn">
               Continue Shopping
            </a>

            <a href="/home" class="action-btn home-btn">
               Go Home
            </a>
        </div>

    </div>

</div>

</body>
</html>

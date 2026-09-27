<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShopMate | Payment</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
 href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>

body{
    background:#f5f7fb;
    font-family: 'Segoe UI', sans-serif;
}

.payment-container{
    margin-top:50px;
}

.card{
    border:none;
    border-radius:15px;
    box-shadow:0 5px 20px rgba(0,0,0,0.08);
}

.payment-option{
    border:2px solid #eee;
    padding:15px;
    border-radius:10px;
    cursor:pointer;
    transition:0.3s;
}

.payment-option:hover{
    border-color:#0d6efd;
    background:#f0f6ff;
}

input[type="radio"]{
    margin-right:10px;
}

.pay-btn{
    background:#0d6efd;
    color:white;
    border:none;
    padding:12px;
    border-radius:8px;
    font-size:18px;
    width:100%;
    transition:0.3s;
}

.pay-btn:hover{
    background:#0b5ed7;
}

.order-price{
    font-size:22px;
    font-weight:bold;
    color:#0d6efd;
}

</style>
</head>

<body>

<div class="container payment-container">

<div class="row">

    <!-- PAYMENT METHODS -->
    <div class="col-md-7">

        <div class="card p-4">

            <h4 class="mb-4">
                <i class="fa-solid fa-credit-card"></i>
                Select Payment Method
            </h4>

            <form action="/process-payment" method="post">

                <!-- UPI -->
                <label class="payment-option d-block mb-3">
                    <input type="radio" name="method" value="UPI" required>
                    <i class="fa-brands fa-google-pay fa-lg"></i>
                    UPI Payment (GPay / PhonePe / Paytm)
                </label>

                <!-- CARD -->
                <label class="payment-option d-block mb-3">
                    <input type="radio" name="method" value="CARD">
                    <i class="fa-solid fa-credit-card"></i>
                    Debit / Credit Card
                </label>

                <!-- COD -->
                <label class="payment-option d-block mb-4">
                    <input type="radio" name="method" value="COD">
                    <i class="fa-solid fa-money-bill-wave"></i>
                    Cash on Delivery
                </label>

                <button class="pay-btn">
                    <i class="fa-solid fa-lock"></i>
                    Pay Securely
                </button>

            </form>

        </div>

    </div>


    <!-- ORDER SUMMARY -->
    <div class="col-md-5">

        <div class="card p-4">

            <h4 class="mb-3">
                <i class="fa-solid fa-cart-shopping"></i>
                Order Summary
            </h4>

            <hr>

            <p>Items Total :
                <span class="float-end">₹ ${totalAmount}</span>
            </p>

            <p>Delivery :
                <span class="float-end text-success">FREE</span>
            </p>

            <hr>

            <h5>
                Total Payable :
                <span class="float-end order-price">
                    ₹ ${totalAmount}
                </span>
            </h5>

        </div>

    </div>

</div>
</div>

</body>
</html>

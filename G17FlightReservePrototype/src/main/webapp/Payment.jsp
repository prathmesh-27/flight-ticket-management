<%@page import="utility.classes.Booking"%>
<%@page import="utility.methods.BookingDaoImpl"%>
<%@page import="dao.interfaces.BookingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/form-elements.css">
<title>Payment</title>
</head>
<style>

body{
 background-image: url("assets/images/payment_background.png");
 background-size: cover;
  background-repeat: no-repeat;
}
.container {
	
	padding: 5px;
	background-color: rgb(232 232 232 / 27%);
	margin: auto;
	border-radius: 20px;
	max-width: 50%;

}

h3 {
	text-align: center;
}

.btn.btn-primary {
	width: 70%;
	height: 50px;
	display: flex;
	padding: 0 5px;
	align-items: center;
	background-image: linear-gradient(to right, #77A1D3 0%, #79CBCA 51%, #77A1D3 100%);
	border: none;
	transition: 0.5s;
	background-size: 200% auto;
	justify-content: center;
	font-size: 20px;
}

.btn.btn.btn-primary:hover {
	background-position: right center;
	color: #fff;
	text-decoration: none;
}

.form-control {
	height: 30px;
	margin: 0;
	padding: 0 20px;
	vertical-align: middle;
	background: #fff;
	border: 3px solid #fff;
	font-family: 'Roboto', sans-serif;
	font-size: 16px;
	font-weight: 300;
	line-height: 50px;
	color: #888;
	border-radius: 4px;
}

table {
	width: 70%;
	text-align: center;
	margin: auto;
}
select {
	height: 30px;
	padding: 0 20px;
	vertical-align: middle;
	background: #fff;
	border: 3px solid #fff;
	font-family: 'Roboto', sans-serif;
	font-size: 16px;
	font-weight: 300;
	line-height: 50px;
	color: #888;
	border-radius: 4px;
}

th, td {
	padding: 10px;
}

h3{
	font-family: 'Nunito', cursive;
	color: rgb(31, 117, 254);
	font-size: 1.5em;
	text-align: center;}
</style>
<%
String bookId =(String)request.getParameter("bookId");
BookingDao bd =new BookingDaoImpl();
Booking booking =bd.getId(bookId);
%>

<body>
	<div style="text-align: center; height: 100px;">
		<a href="deletebooking?bid=<%=bookId%>"><button class="btn">Go back</button></a>
	</div>
	<div class="container">
		<div >
			<h3>Payment Details</h3>
			<form action="payment?bookId=<%=bookId%>" method="post">
			
				<table>
					<tr>
						<!-- Person Name  -->
						<td class="">Person Name</td>
						<td><input type="text" id="name" name="fname"
							class="form-control" placeholder="Name" required/></td>

					</tr>
					<tr>
						<!-- Card Number  -->
						<td class="">Card Number</td>
						<td><input type="text" id="cnumber" name="cnumber"
							class="form-control" placeholder="---- ---- ---- ----" required/></td>

					</tr>
					<tr>
						<!-- Expiry Date  -->
						<td class="">Expiry Date</td>
						<td><select name='expireMM' id='expireMM' required>
                        <option value='' selected>Month</option>
                        <option value='01'>January</option>
                        <option value='02'>February</option>
                        <option value='03'>March</option>
                        <option value='04'>April</option>
                        <option value='05'>May</option>
                        <option value='06'>June</option>
                        <option value='07'>July</option>
                        <option value='08'>August</option>
                        <option value='09'>September</option>
                        <option value='10'>October</option>
                        <option value='11'>November</option>
                        <option value='12'>December</option>
                    </select> 
                    <select name='expireYY' id='expireYY' required>
                        <option value='' selected>Year</option>
                        <option value='24'>2024</option>
                        <option value='25'>2025</option>
                        <option value='26'>2026</option>
                        <option value='27'>2027</option>
                        <option value='28'>2028</option>
                        <option value='29'>2029</option>
                        <option value='30'>2030</option>
                        <option value='31'>2031</option>
                        <option value='32'>2032</option>
                        <option value='33'>2033</option>
                        <option value='34'>2034</option>
                        <option value='35'>2035</option>
                        <option value='36'>2036</option>
                    </select></td>

					</tr>
					<tr>
						<!-- CVV/CVC  -->
						<td class="">CVV/CVC</td>
						<td><input type="text" id="name" name="cvv"
							class="form-control" placeholder="***"  maxlength="3" required/></td>

					</tr>
				</table>
			
			<button class="btn btn-primary ">	 ₹ <%=booking.getCost() %></button>
			
			</form>
		</div>
		
		</div>
</body>
</html>
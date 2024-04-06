<%@page import="utility.methods.DateTimeUtils"%>
<%@page import="utility.methods.Use"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Successful</title>
</head>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f2f2f2;
}

.container {
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    background-color: #ffffff;
    border-radius: 5px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    text-align: center;
}

h1 {
    color: #007BFF;
}

p {
    margin-bottom: 10px;
}

#order-id {
    font-weight: bold;
}

.btn {
	font-size: 1em;
	background-color: #1f75fe;
	color: #fff;
	border-radius: 34px;
	margin: 3% auto;
	height: 50px;
}
</style>
<%
Date date = Use.getTodayDate();
System.out.println(date);
%>
<body>
    <div class="container">
        <h1>Payment Successful</h1>
        <p>Thank you for Booking!</p>
        <p>Your transaction has been completed successfully.</p>
        <p>Date: <%=DateTimeUtils.DateInFormatddmmyyyy(date)%></p>
    </div>
    	<div style="text-align: center; height: 100px;">
		<a href="index.jsp"><button class="btn">Go back</button></a>
	</div>
</body>
</html>
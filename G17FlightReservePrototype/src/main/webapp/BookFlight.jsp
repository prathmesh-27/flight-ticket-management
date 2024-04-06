<%@page import="utility.methods.DateTimeUtils"%>
<%@page import="utility.methods.Use"%>
<%@page import="utility.classes.User"%>
<%@page import="utility.classes.Flight"%>
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
<title>Book-Flight</title>
</head>
<style>
.container {
	padding: 15px;
	background-color: rgb(232, 232, 232);
	margin: auto;
	border-radius: 20px;
	max-width: 60%;
}

h3 {
	text-align: center;
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
	margin: auto;
}

table, td {
	padding: 10px;
	border: 2px solid black;
	border-collapse: collapse;
}
h3{
	font-family: 'Nunito', cursive;
	color: rgb(31, 117, 254);
	font-size: 1.5em;
	text-align: center;}
</style>
<%
String bookId = (String) request.getParameter("bookId");
BookingDao bd = new BookingDaoImpl();
Booking booking = bd.getId(bookId);
Flight flight = bd.getFlightById(booking.getFid());
User user = bd.getUserByUsername(booking.getUname());
%>
<body>
	<div style="text-align: center; height: 100px;">
		<a href="deletebooking?bid=<%=bookId%>"><button class="btn">Go
				back</button></a>
	</div>
	<div class="container">

		<h3>My Booking Details</h3>
		<table>
			<tr>
				<td>Name</td>
				<td><%=user.getFirstname() + " " + user.getLastname()%></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><%=user.getUsername()%></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=user.getEmail()%></td>
			</tr>
			<tr>
				<td>Flight Id</td>
				<td><%=flight.getFid()%></td>
			</tr>
			<tr>
				<td>Flight Name</td>
				<td><%=flight.getFlightname()%></td>
			</tr>
			<tr>
				<td>Departure City ----------> Destination City</td>
				<td><%=Use.capitalize(flight.getDepartCity())%>----------><%=Use.capitalize(flight.getDestiCity())%></td>
			</tr>
			<tr>
				<td>Departure Date</td>
				<td><%=DateTimeUtils.DateInFormatddmmyyyy(flight.getDepartDate())%></td>
			</tr>
			<tr>
				<td>Departure Time</td>
				<td><%=DateTimeUtils.HourFormat24to12(flight.getDepartTime())%></td>
			</tr>
			<tr>
				<td>Number of seats booked</td>
				<td><%=booking.getNum_of_passegers()%></td>
			</tr>
			<tr>
				<td>Total Cost</td>
				<td><%=booking.getCost()%></td>
			</tr>
		</table>
		<div style="text-align: center; height: 100px;">
			<a href="Payment.jsp?bookId=<%=bookId%>"><button class="btn"
					style="width: 150px; height: 60px;">Proceed to Payment</button></a>
		</div>
	</div>


</body>
</html>
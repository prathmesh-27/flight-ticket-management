<%@page import="utility.classes.Booking"%>
<%@page import="utility.methods.Use"%>
<%@page import="utility.methods.DateTimeUtils"%>
<%@page import="utility.classes.Flight"%>
<%@page import="utility.classes.PaymentDetails"%>
<%@page import="utility.classes.User"%>
<%@page import="utility.methods.PaymentDaoImpl"%>
<%@page import="dao.interfaces.PaymentDao"%>
<%@page import="utility.methods.UserDaoImpl"%>
<%@page import="dao.interfaces.UserDao"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My bookings</title>
</head>
<style>
body{
 background-image: url("assets/images/payment_background.png");
 background-size: cover;
  background-repeat: no-repeat;
}

.container {
	padding: 15px;
	background-color: rgb(232 232 232 / 27%);
	margin: auto;
	border-radius: 20px;
}

.btn {
	font-size: 1.5em;
	background-color: #1f75fe;
	color: #fff;
	border-radius: 34px;
	margin: 3% auto;
}

table {
	text-align: center;
	margin: auto;
	font-size: 15px;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	margin: 5px;
	padding: 10px;
}

a {
	text-decoration: none;
}
</style>
<body>
	<div style="text-align: center; height: 100px;">
		<a href="index.jsp"><button class="btn">Go back</button></a>
	</div>
	<div class="container mt-5" style="max-width: 90%;">
		<table>
			<tr>
				<th>Username</th>
				<th>Booking ID</th>
				<th>Flight ID</th>
				<th>Flight Name</th>
				<th>Departure City</th>
				<th>Destination City</th>
				<th>Departure Date</th>
				<th>Departure Time</th>
				<th>Number of Seats Booked</th>
				<th>Amount</th>
				<th>Action</th>

			</tr>
			<%
			String username = (String) session.getAttribute("uname");
			UserDao ud = new UserDaoImpl();
			PaymentDao pd = new PaymentDaoImpl();
			User user = ud.getUsername(username);

			List<PaymentDetails> pdetails = pd.getAllByUserId(user.getUid());
			
			
			
			try {

				for (PaymentDetails pdetail : pdetails) {
					
					Flight flight = pd.getFlightById(pdetail.getFid());
					Booking booking = pd.getBookingById(pdetail.getBid());
					%>
			<tr>
			
				<td><%=user.getUsername()%></td>
				<td><%=pdetail.getBid()%></td>
				<td><%=pdetail.getFid()%></td>
				<td><%=Use.capitalize(flight.getFlightname())%></td>
				<td><%=Use.capitalize(flight.getDepartCity())%></td>
				<td><%=Use.capitalize(flight.getDestiCity())%></td>
				<td><%=DateTimeUtils.DateInFormatddmmyyyy(flight.getDepartDate())%></td>
				<td><%=DateTimeUtils.HourFormat24to12(flight.getDepartTime())%></td>
				<td><%=booking.getNum_of_passegers()%></td>
				<td>Rs.<%=pdetail.getAmount_paid()%></td>
				<td><a
					href="cancelbooking?transId=<%=pdetail.getTransaction_id()%>"
					style="color: red; font-weight: 800;">Cancel</a>/<a href="#">Download
						Receipt</a></td>
			</tr>

			<%
			}

			} catch (Exception e) {

			System.out.println(e.getMessage());

			}
			%>



		</table>


	</div>

</body>
</html>
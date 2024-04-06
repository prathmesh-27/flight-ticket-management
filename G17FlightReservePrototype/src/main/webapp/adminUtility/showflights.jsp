<%@page import="utility.methods.DateTimeUtils"%>
<%@page import="utility.methods.Use"%>
<%@page import="java.util.List"%>
<%@page import="dao.interfaces.FlightDao"%>
<%@page import="utility.methods.FlightDaoImpl"%>
<%@page import="utility.classes.Flight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Flight-details</title>
</head>
<style>
body{
 background-image: url("../assets/images/payment_background.png");
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
</style>
<body>
	<div style="text-align: center; height: 100px;">
		<a href="../index.jsp"><button class="btn">Go back</button></a>
	</div>

	<div class="container mt-5" style="max-width: 90%;">
		<h2 style="text-align: center; color: #1f75fe;">All-Flight-Details</h2>
		<table class="table table-striped table-md ">
		
			<tr>
				<th>S .No</th>
				<th>Flight Id</th>
				<th>Flight Name</th>
				<th>Departure City</th>
				<th>Destination City</th>
				<th>Departure Details</th>
				<th>Arrival Details</th>
				<th>Travel Duration</th>
				<th>Number of seats</th>
				<th>Cost per seat</th>
				<th>Action</th>
			</tr>
			<%
			try {
				int i = 1;
				FlightDao fd = new FlightDaoImpl();
				List<Flight> flights = fd.getAll();
				for (Flight flight : flights) {
			%>
			<tr>
				<td>
					<%
					out.println(i++);
					%>
				</td>
				<td>
					<%
					out.println(flight.getFid());
					%>
				</td>
				<td>
					<%
					out.println(flight.getFlightname());
					%>
				</td>
				<td>
					<%
					out.println(Use.capitalize(flight.getDepartCity()));
					%>
				</td>
				<td>
					<%
					out.println(Use.capitalize(flight.getDestiCity()));
					%>
				</td>
				<td>
					<%
					out.println(flight.getDepartDate());
					%>,<br> 
					<%
					out.println(Use.getWeekDayName(flight.getDepartDate().toString()));
					%>
					<br>
					<%
					out.println(DateTimeUtils.HourFormat24to12(flight.getDepartTime()));
					%>

				</td>
				<td>
					<%
					out.println(flight.getArrivalDate());
					%>,<br><%
					out.println(Use.getWeekDayName(flight.getArrivalDate().toString()));
					%><br>
					<%
					out.println(DateTimeUtils.HourFormat24to12(flight.getArrivalTime()));
					%>

				</td>
				<td>
					<%
					out.println(flight.getDuration());
					%>
				</td>

				<td>
					<%
					out.println(flight.getNumOfSeats());
					%>
				</td>

				<td>
					<%
					out.println(flight.getCostPerSeat());
					%>
				</td>

				<td><a href="deleteFlight.jsp?id=<%=flight.getFid()%>" style="color:red; text-decoration: none;" >Delete</a> / <a
					href="../updateFlights.jsp?id=<%=flight.getFid()%>" style="color:blue; text-decoration: none;">Modify</a></td>


			</tr>

			<%
			}

			} catch (Exception e) {
			out.println("The error is:: " + e.getMessage());
			}
		
			
			%>
		</table>
		<%
	String msg = request.getParameter("msg");
			if(msg!=null){
				out.println("<font color='green' text-align='center'>"+msg+"</font>");
			}%>
	</div>

</body>
</html>
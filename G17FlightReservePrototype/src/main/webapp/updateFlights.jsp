<%@page import="utility.methods.Use"%>
<%@page import="utility.methods.FlightDaoImpl"%>
<%@page import="utility.classes.Flight"%>
<%@page import="java.util.List"%>
<%@page import="dao.interfaces.FlightDao"%>
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
<title>Update-Flights</title>
</head>
<style>
.container {
	padding: 15px;
	background-color: rgb(232, 232, 232);
	margin: auto;
	border-radius: 20px;
	max-width: 50%;
	color:
}

.btn {
	font-size: 1.5em;
	background-color: #1f75fe;
	color: #fff;
	border-radius: 34px;
	margin: 3% auto;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	margin: 5px;
	padding: 10px;
}

input {
	height: 30px;
	width: 200px;
	background-color: #045ce926;
}
</style>
<body>
	<div style="text-align: center; height: 100px;">
		<a href="index.jsp"><button class="btn" style="font-size: 1em;">Go
				back</button></a>
	</div>


	<%
	String id = request.getParameter("id").trim();
	%>

	<div class="container  mt-3" style="max-width: 75%;">
		<h2 style="text-align: center; color: #1f75fe;">Flight-Details</h2>
		<form action="update" method="post" id="form">
			<table class="table table-striped w-75 text-center">
				<caption></caption>
				<%
				try {
					int i = 1;

					FlightDao fd = new FlightDaoImpl();
					Flight flight = fd.getId(id);
				%>
				<tr>
					
					<td>Flight name</td>
					<td>
					<input type="hidden" value="<%=flight.getFid()%>"
						name="fid">
					<input type="text" value="<%=flight.getFlightname()%>"
						name="flightname" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Departure City</td>
					<td><input type="text"
						value="<%=Use.capitalize(flight.getDepartCity())%> "
						name="departcity" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Destination City</td>
					<td><input type="text"
						value="<%=Use.capitalize(flight.getDestiCity())%>"
						name="desticity" readonly="readonly"></td>
				</tr>

				<tr>
					<td>Departure Date</td>
					<td><input  value="<%=flight.getDepartDate().toString()%>T<%=flight.getDepartTime().toString()%>" type="datetime-local" name="ddatetime"></td>
				</tr>
				<tr>
					<td>Arrival Date</td>
					<td><input  value="<%=flight.getArrivalDate().toString()%>T<%=flight.getArrivalTime().toString()%>" type="datetime-local" name="adatetime"></td>
				</tr>

				<tr>
					<td>Number of seats</td>
					<td><input value="<%=flight.getNumOfSeats()%>"  type="number"
						name="seat"></td>
				</tr>
				<tr>
					<td>Cost per seat (INR)</td>
					<td><input value="<%=flight.getCostPerSeat()%>" type="text"
						name="costperseat"></td>
				</tr>
				<%
				} catch (Exception e) {
				out.println("The error is:: " + e.getMessage());
				}
				%>
			</table>
			<div style="text-align: center; height: 100px;">
				<button type="submit" value="submit" class="btn"
					style="font-size: 1em;">Update</button>
			</div>
		</form>
	</div>
</body>
</html>
<%@page import="utility.methods.DateTimeUtils"%>
<%@page import="utility.classes.Flight"%>
<%@page import="java.util.List"%>
<%@page import="utility.methods.FlightDaoImpl"%>
<%@page import="dao.interfaces.FlightDao"%>
<%@page import="java.sql.Date"%>
<%@page import="utility.methods.Use"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/form-elements.css">
<title>Search-Flights</title>
</head>
<style>
body{
 background-image: url("assets/images/search_background.jpg");
 background-size: cover;
  background-repeat: no-repeat;
}
.container {
	padding: 15px;
	background-color: rgb(232 232 232 / 89%);
	margin: auto;
	border-radius: 20px;
	max-width: 50%;
}

.container1 {
	margin: 15px auto;
	background-color: rgb(232 232 232 / 89%);
	padding: 15px;
	border-radius: 20px;
	max-width: 75%;
	border-radius: 20px;
}

p {
	text-align: center;
	font-size: 25px;
}

.btn {
	font-size: 1em;
	background-color: #1f75fe;
	color: #fff;
	border-radius: 34px;
	margin: 3% auto;
}

table {
	width: 70%;
	text-align: center;
	margin: auto;
	font-size: 20px;
}

th, td {
	padding: 10px;
	font-size: 18px;
}

.search-table td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 2px;
}

.search-table th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 2px;
}

select {
	height: 30px;
	width: 230px;
	margin: 0px 15px;
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
	margin: 0px 15px;
}
</style>

<body>

	<div style="text-align: center; height: 100px;">
		<a href="index.jsp"><button class="btn">Go back</button></a>
	</div>
	<div class="container">
		<form action="searchflight" method="post">
			<table>
				<%
				FlightDao fd = new FlightDaoImpl();
				List<Flight> flights = fd.getAll();
				%>
				<tr>
					<!-- For Departure  -->
					<td class="form-label">Departure City</td>
					<td><select name="from">
							<option value="-1" selected>Select Departure City</option>
							<%
							for (Flight flight : flights) {
							%>
							<option value="<%=flight.getDepartCity()%>"><%=Use.capitalize(flight.getDepartCity())%></option>
							<%
							}
							%>
					</select></td>
				</tr>
				<tr>
					<!-- For Destination-->
					<td class="form-label">Destination City</td>
					<td><select name="to">
							<option value="-1" selected>Select Destination City</option>
							<%
							for (Flight flight : flights) {
							%>
							<option value="<%=flight.getDestiCity()%>"><%=Use.capitalize(flight.getDestiCity())%></option>
							<%
							}
							%>
					</select></td>
				</tr>
				<tr>
					<!-- Number of passengers -->
					<td class="form-label">Number of Passengers</td>
					<td><input type="number" name="passengers"
						class="form-control" id="form-depart"
						placeholder="Number of Passengers" /></td>
				</tr>
			</table>
			<div style="text-align: center;">
				<button type="submit" class="btn">Search Flights</button>
			</div>
		</form>
	</div>

	<%
	String msg = request.getParameter("message");
	if (msg != null) {
		String fromd = request.getParameter("fromd").toLowerCase().trim();
		String tod = request.getParameter("tod").toLowerCase().trim();
		int num_of_passengers = Integer.parseInt(request.getParameter("num_of_passengers"));
	%>

	<div class="container1">
		<%
		List<Flight> flist = fd.getSearchFlights(fromd, tod);
		if (flist.isEmpty() == true) {
		%>
		<p style="color: red;">
			Sorry, There is no flight Available from
			<%=Use.capitalize(fromd)%>
			to
			<%=Use.capitalize(tod)%></p>
		<%
		} else {
		%>
		<p>Available Flights</p>
		<table class=" search-table"
			style="width: 95%; border: 2px solid black; border-collapse: collapse;">
			<tr>
				<th>Flight Id</th>
				<th>Flight Name</th>
				<th>Departure Details</th>
				<th>Arrival Details</th>
				<th>Duration</th>
				<th>Number of Seats Available</th>
				<th>Action</th>
			</tr>
			<%
			try {
				for (Flight flight : flist) {
			%>
			<tr>
				<td><%=flight.getFid()%></td>
				<td><%=flight.getFlightname()%></td>
				<td><%=Use.capitalize(flight.getDepartCity())%><br>On <%=Use.getWeekDayName(flight.getDepartDate().toString())%><br><%=DateTimeUtils.DateInFormatddmmyyyy(flight.getDepartDate())%><br><%=flight.getDepartTime()%></td>
				<td><%=Use.capitalize(flight.getDestiCity())%><br>On <%=Use.getWeekDayName(flight.getArrivalDate().toString())%><br><%=DateTimeUtils.DateInFormatddmmyyyy(flight.getArrivalDate())%><br><%=flight.getArrivalTime()%></td>
				<td><%=flight.getDuration()%></td>
				<td><%=flight.getNumOfSeats()%></td>
				<%
				if (num_of_passengers > flight.getNumOfSeats()) {
				%>
				<td><div style='color: red; font-weight: 900;'>Not Enough Seats</div></td>
				<%
				} else {
				%>
				<td><div>
						<a
							href="bookflight?id=<%=flight.getFid()%>&number_of_passengers=<%=num_of_passengers%>"
							style='text-decoration: none; color: green; font-weight: 600;'>Book</a>
					</div></td>
				<%
				}
				%>
			</tr>
		</table>
		<%
		}
		%>
		<%
		} catch (Exception e) {
		System.out.println("Error :" + e.getMessage());
		}
		%>

	</div>

	<%
	}
	}
	%>

</body>
</html>
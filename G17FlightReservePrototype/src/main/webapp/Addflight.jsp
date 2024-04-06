<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/form-elements.css">
<script defer src="assets/js/addflight_form_validator.js"></script>
<title>Add Flights</title>
</head>
<style>
body{
 background-image: url("assets/images/payment_background.png");
 background-size: cover;
  background-repeat: no-repeat;
}

tbody {
	height: 420px;
}
</style>
<body>
	<div style="text-align: center; height: 100px;">
		<a href="index.jsp"><button class="btn">Go back</button></a>
	</div>
	<div class="container" style="margin-top: 5px;">
	<form action="addflight" method="post" id="form">
			<table>
				<tr>
					<td class="form-label">Name of flight</td>
					<td><input type="text" name="flight_name" placeholder="Name of flight"  id="fname"/></td>
				</tr>
				<tr>
					<td class="form-label">From</td>
					<td><input type="text" name="departure" placeholder="Departure City" id="fromd" /></td>
				</tr>
				<tr>
					<td class="form-label">To</td>
					<td><input type="text" name="destination" placeholder="Destination City" id="tod"/></td>
				</tr>
				<tr>
					<td class="form-label">Departure Date</td>
					<td><input type="datetime-local" name="ddatetime" placeholder="Departure Date" id="ddatetime"/></td>
				</tr>
				<tr>
					<td class="form-label">Arrival Date</td>
					<td><input type="datetime-local" name="adatetime" placeholder="Arrival Time"  id="adatetime"/></td>
				</tr>
				<tr>
					<td class="form-label">Number of seats</td>
					<td><input type="number" name="seat" placeholder="Seats" id="seat"/></td>
				</tr>
				<tr>
					<td class="form-label">Cost per seat</td>
					<td><input type="text" name="cost" placeholder="Cost per seat" id="cost"/></td>
				</tr>
			</table>
			<div style="text-align: center; height: 100px;">
				<button class="btn" type="submit" value="submit"
					style="text-align: center; height:50px; width:150px;">Add to flights</button>
			</div>
	</form>
		<p id = "error" style="text-align: center; color: red;"></p>
		<%
		String msg = request.getParameter("message");
		if (msg != null) {
		%>
		<p style="text-align: center; color: green; "><%=msg%></p>
		<%
		}
		%>
	</div>

</body>
</html>
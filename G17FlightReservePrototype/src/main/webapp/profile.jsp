<%@page import="utility.methods.*"%>
<%@page import="utility.classes.*"%>
<%@page import="dao.interfaces.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title><%=session.getAttribute("uname")%>-Current User</title>
</head>

<style>
.container {
	padding: 30px;
	background-color: rgb(232, 232, 232);
	margin: 10% auto;
	border-radius: 20px;
	max-width: 50%;
	margin: 10% auto;
	border-radius: 20px;
	border-radius: 20px;
}
h1{
text-align: center;
color:#1f75fe;
}

.btn {
	font-size: 1em;
	background-color: #1f75fe;
	color: #fff;
	border-radius: 34px;
	margin: 2.5% auto;
}

table {
	width: 50%;
	text-align: center;
	margin: auto;
	font-size: 25px;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
}
</style>

<body>
	<jsp:include page="templates/UserPanel.jsp" />
	<div class="container">
		<%
		String uname = (String) session.getAttribute("uname");
		UserDao ud = new UserDaoImpl();
		try {
			User user = ud.getUsername(uname);
		%>
		<h1 >My Details</h1>
		<table class="table table-striped">
		
			<tr>
				<td>User ID</td>
				<td>
					<%
					out.println(user.getUid());
					%>
				</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>
					<%
					out.println(user.getFirstname());
					%>
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>
					<%
					out.println(user.getLastname());
					%>
				</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td>
					<%
					out.println(user.getUsername());
					%>
				</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td>
					<%
					out.println(user.getDateOfBirth());
					%>
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<%
					out.println(user.getGender());
					%>
				</td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td>
					<%
					out.println(user.getPhone());
					%>
				</td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td>
					<%
					out.println(user.getEmail());
					%>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<%
					out.println(user.getPassword());
					%>
				</td>
			</tr>

			<%
			} catch (Exception e) {
			System.out.println("Error is : " + e.getMessage());
			}
			%>
		</table>

		<div style="display: flex;">
			<button class="btn">Edit</button>
			<button class="btn">Delete Account</button>
		</div>

	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="templates/metadata.jsp" />
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>User login</title>
</head>
<style>
tbody {
	height: 90px;
}

table {
	width: 350px
}

button {
	display: block;
	margin: auto;
}
</style>

<body>
	<jsp:include page="templates/navpanel.jsp" />

	<div class="container" style="margin: 120px auto">
		<form id="form" action="userlogin" method="post">
			<fieldset>
				<legend>User-Login </legend>
				<table>
					<!-- Email/Username input -->
					<tr>
						<td class="form-label">Username</td>
						<td><input type="text" id="loginName" name="username"
							class="form-control" placeholder="Username or Email " required /></td>
					</tr>
					<!-- Password input -->
					<tr>
						<td class="form-label">Password</td>
						<td><input type="password" id="loginPassword" name="password"
							class="form-control" placeholder="Enter Password" required /></td>
						<!-- Submit button -->
					</tr>
				</table>

				<button type="submit" class="btn">Sign in</button>

				<!-- Register buttons -->
				<div class="text-center">
					<p style="text-align: center;">
						Create account? <a href="signup.jsp">Register</a>
					</p>
				</div>
			</fieldset>
		</form>
		<%
		String msg = request.getParameter("message");
		if (msg != null) {
		%>
		<p style="text-align: center; color: green;"><%=msg%></p>
		<%
		}
		%>
	</div>
</body>

</html>
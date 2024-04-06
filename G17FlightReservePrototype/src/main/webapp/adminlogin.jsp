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
<title>admin-login</title>
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
		<form id="form" action="adminlogin" method="post">
			<fieldset>
				<legend>Admin-login</legend>
				<table>
					<!-- Email input -->
					<tr>
						<td class="form-label">Username</td>
						<td><input type="text" id="loginName" name="username"
							class="form-control" placeholder="Enter Username..." required /></td>
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
			</fieldset>
		</form>
	</div>

</body>
</html>
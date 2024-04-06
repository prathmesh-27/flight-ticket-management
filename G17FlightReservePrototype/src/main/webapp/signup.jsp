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
<title>Register</title>
</head>
<style>
table {
	height: 450px;
}
</style>

<body>
	<jsp:include page="templates/navpanel.jsp" />

	<div class="container" style="margin: 120px auto">
		<form action="register" method="post" id="form">
			<fieldset>
				<legend style="margin: 10px auto">Sign-up</legend>
				<table>
					<tr>
						<!--First Name input -->
						<td class="form-label">First Name</td>
						<td><input type="text" id="fname" name="fname"
							class="form-control" placeholder="Enter First Name..." /></td>

					</tr>
					<tr>
						<!--Last Name input -->
						<td class="form-label">Last Name</td>
						<td><input type="text" id="lname" name="lname"
							class="form-control" placeholder="Enter Last Name..." /></td>

					</tr>

					<!-- Username input -->
					<tr>
						<td class="form-label">Username</td>
						<td><input type="text" id="uname" name="uname"
							class="form-control" placeholder="Enter Username..." /></td>

					</tr>

					<!-- Date Of Birth input -->
					<tr>
						<td class="form-label">Date of Birth</td>
						<td><input type="date" id="dob" name="dob"
							class="form-control" placeholder="" /></td>

					</tr>
					<!-- Phone Number input -->

					<tr>
						<td class="form-label">Phone Number</td>
						<td><input type="number" id="mobileNo" name="mobileNo"
							class="form-control" placeholder="Enter phone number..." /></td>

					</tr>
					<!-- Gender -->
					<tr>
						<td class="form-label">Gender:</td>
						<td><input class="form-check-input" type="radio"
							name="gender" value="male" checked /> <label
							class="form-check-label" for="femaleGender">Male</label> <input
							class="form-check-input" type="radio" name="gender"
							value="female" /> <label class="form-check-label"
							for="maleGender">Female</label> <input class="form-check-input"
							type="radio" name="gender" value="other" /> <label
							class="form-check-label" for="otherGender">Other</label></td>

					</tr>
					<!-- Email input -->
					<tr>
						<td class="form-label">Email</td>
						<td><input type="email" name="email" id="emailId"
							placeholder="example@gmail.com" class="form-control" /></td>

					</tr>


					<!-- Password input -->
					<tr>
						<td class="form-label">Password</td>
						<td><input type="password" id="password" name="password"
							placeholder="Enter Password..." class="form-control" /></td>

					</tr>

					<!-- Re-Enter password input -->
					<tr>
						<td class="form-label">Confirm Password</td>
						<td><input type="password" id="repassword" name="repassword"
							placeholder="Re-Type Password..." class="form-control" /></td>

					</tr>

				</table>

				<!-- Checkbox -->

				<div
					style="display: flex; flex-direction: column; align-items: center; margin: 17px;">
					<div class="check">
						<input class="form-check-input" type="checkbox" value=""
							id="registerCheck" style="margin: -3px 2px;" checked /> <label
							class="form-check-label" for="registerCheck"> I have read
							and agree to the terms </label>
					</div>
					<!-- Submit button -->
					<div style="width: 50%; display: flex; margin: 10px;">

						<button type="reset" value="reset" class="btn">Reset</button>
						<button id="submit" type="submit" value="submit" class="btn">
							Submit</button>
					</div>

					<p id="error" style="color: red;"></p>
				</div>
			</fieldset>
		</form>
		<%
		String msg = request.getParameter("message");
		if (msg != null) {
		%>
		<p style="text-align: center; color: red;"><%=msg%></p>
		<%
		}
		%>

	</div>
	<script src="assets/js/form_valid.js"></script>



</body>
</html>
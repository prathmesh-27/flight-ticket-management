<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="templates/metadata.jsp" />
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/slider.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Airlines: Book your Tickets Online</title>

</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	String uname = (String) session.getAttribute("uname");
	String pass = (String) session.getAttribute("pass");
	if (uname == null) {
	%>
	<jsp:include page="templates/navpanel.jsp" />
	<%
	} else if (uname.equals("admin") && pass.equals("12345678")) {
	%>
	<jsp:include page="templates/AdminPanel.jsp"></jsp:include>
	<%
	} else {
	%>
	<jsp:include page="templates/UserPanel.jsp" />
	<%
	}
	%>
	<div class="container"
		style="padding-top: 60px; background-color: rgb(232, 232, 232);">

		<div class="welcomeSlider">
			<div class="slides">
				<input type="radio" name="radio-btn" id="radio1"> <input
					type="radio" name="radio-btn" id="radio2"> <input
					type="radio" name="radio-btn" id="radio3"> <input
					type="radio" name="radio-btn" id="radio4">

				<div class="slide first">
					<img src="assets/images/home1.jpg" alt="">

				</div>
				<div class="slide">
					<img src="assets/images/home2.png" alt="">
				</div>
				<div class="slide">
					<img src="assets/images/home3.png" alt="">
				</div>
				<div class="slide">
					<img src="assets/images/home4.jpg" alt="">
				</div>

				<div class="navigation_auto">
					<div class="auto-btn1"></div>
					<div class="auto-btn2"></div>
					<div class="auto-btn3"></div>
					<div class="auto-btn4"></div>
				</div>

				<div class="navigation_manual">
					<label for="radio1" class="manual_btn"></label> <label for="radio2"
						class="manual_btn"></label> <label for="radio3" class="manual_btn"></label>
					<label for="radio4" class="manual_btn"></label>
				</div>
			</div>
		</div>
		<hr class="separator">
		
		
		
	</div>
</body>

<jsp:include page="templates/footer.jsp" />
<script src="assets/js/script.js"></script>
</body>
</html>
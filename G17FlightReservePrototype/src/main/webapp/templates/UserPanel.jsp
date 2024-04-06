<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<div class="nav">
		<div class="logo">Airlines</div>
		<div class="navOptions">
			<ul style="list-style: none; display: flex;">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="SearchFlights.jsp">Search-Flights</a></li>
				<li><a href="current_booking.jsp">My-Bookings</a></li>
				<li class="sublogin"><a href="#">Welcome <%=session.getAttribute("uname")%><i
						class="fa fa-caret-down"
						style="color: aliceblue; margin-left: 5px;"></i></a>
					<ul class="dropdown">
						<li><a href="profile.jsp">Profile<i
								class="fa fa-user" style="color: aliceblue; margin-left: 5px;"></i></a></li>
						<li><a href="logout.jsp">Logout<i class="fa fa-sign-out"
								style="color: aliceblue; margin-left: 5px;"></i></a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</header>

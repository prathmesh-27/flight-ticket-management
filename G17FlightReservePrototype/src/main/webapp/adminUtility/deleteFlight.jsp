<%@page import="utility.methods.BookingDaoImpl"%>
<%@page import="dao.interfaces.BookingDao"%>
<%@page import="utility.classes.PaymentDetails"%>
<%@page import="dao.interfaces.PaymentDao"%>
<%@page import="utility.methods.PaymentDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="utility.methods.FlightDaoImpl"%>
<%@page import="dao.interfaces.FlightDao"%>
<%@page import="utility.classes.Flight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Flight</title>
</head>
<body>

<%
	String id = request.getParameter("id").trim();

	FlightDao fd = new FlightDaoImpl();
	try {
		Flight flight = fd.getId(id);
		int result = fd.delete(flight);
		BookingDao bd= new BookingDaoImpl();
		PaymentDao pd = new PaymentDaoImpl();
		List<PaymentDetails> pdetails = pd.getAllByFlightid(flight.getFid());

		for (PaymentDetails p : pdetails) {
		pd.delete(p.getTransaction_id());
		bd.delete( pd.getBookingById(p.getBid()));
		}
		
		if(result>0){
			response.sendRedirect("showflights.jsp");
		}
		else{
			System.out.println("Data can't deleted into database successfully");
		}

	} catch (Exception e) {
		System.out.println("Error :" + e.getMessage());

	}
	%>


</body>
</html>
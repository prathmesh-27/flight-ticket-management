

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.BookingDao;
import utility.classes.Booking;
import utility.methods.BookingDaoImpl;

/**
 * Servlet implementation class DeleteBooking
 */
@WebServlet("/deletebooking")
public class DeleteBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String bid =request.getParameter("bid");
	
	BookingDao bd = new BookingDaoImpl();
	try {
		Booking b= bd.getId(bid);
		int res =bd.delete(b);
		if(res>0) {
			System.out.println("Booking delete Successfully");
			response.sendRedirect("index.jsp");
		}
		else {
			System.out.println("A problem occured");
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}



}

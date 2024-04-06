package user;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.BookingDao;
import dao.interfaces.PaymentDao;
import utility.classes.*;
import utility.methods.*;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String bookId = request.getParameter("bookId");
		System.out.println(bookId);
		BookingDao bd = new BookingDaoImpl();
		
		Booking booking;
		try {
			PaymentDao pd= new PaymentDaoImpl();
			booking = bd.getId(bookId);
			Flight flight=bd.getFlightById(booking.getFid());
			String transaction_id=Use.generate18CharRandomString();
			String uid= booking.getUid();
			String fid = booking.getFid();
			int bid = Integer.parseInt(booking.getBooking_id());   
			String fullname = (String) request.getParameter("fname").trim();
			String cardNumber= (String)request.getParameter("cnumber").trim();
			int cvv = Integer.parseInt(request.getParameter("cvv"));
			
			String exMM =(String)request.getParameter("expireMM");
			String exYY =(String)request.getParameter("expireYY");
			String exdate= exMM+"/"+exYY;
			Date date=Use.getTodayDate();
			Double amount=booking.getCost();
			
			PaymentDetails payment = new PaymentDetails(transaction_id,uid,fid,bid,fullname,cardNumber,cvv,exdate,date,amount);
			
			int result=pd.insert(payment);
			
			if(result>0) {
				System.out.println("Data inserted into payment Successfully");
				int remainingSeats=flight.getNumOfSeats()-booking.getNum_of_passegers();
				flight.setNumOfSeats(remainingSeats);
				
				int result1 =pd.updateSeats(flight);
				if(result1>0) {
				System.out.println("Seats updated successfully");
				}
				RequestDispatcher requestDispatcher;
				requestDispatcher = request.getRequestDispatcher("templates/PaymentSuccessfulPage.jsp");
				requestDispatcher.forward(request, response);
			}
			else{
				System.out.println("oops a problem is occured ");
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
	
	
		
		
	}

}

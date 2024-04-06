
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.BookingDao;
import dao.interfaces.FlightDao;
import dao.interfaces.PaymentDao;
import utility.classes.Booking;
import utility.classes.Flight;
import utility.classes.PaymentDetails;
import utility.methods.BookingDaoImpl;
import utility.methods.FlightDaoImpl;
import utility.methods.PaymentDaoImpl;

/**
 * Servlet implementation class CancelBooking
 */
@WebServlet("/cancelbooking")
public class CancelBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tid = request.getParameter("transId");
	//	System.out.println(tid);

		PaymentDao pd = new PaymentDaoImpl();
		BookingDao bd = new BookingDaoImpl();

		try {
			PaymentDetails payment = pd.getId(tid);
		//	System.out.println(payment);
			Booking booking = pd.getBookingById(payment.getBid());
			Flight flight = pd.getFlightById(payment.getFid());
			int result = pd.delete(tid);
			if (result == 1) {
				System.out.println("Booking Canceled SuccessFully");
			} else {
				System.out.println("Booking not Canceled");
			}

			int seatsIncreased = flight.getNumOfSeats() + booking.getNum_of_passegers();
			System.out.println(seatsIncreased);
			System.out.println(flight);
			flight.setNumOfSeats(seatsIncreased);
			FlightDao fd = new FlightDaoImpl();
			int result1 = fd.update(flight);
		
			if (result1 > 0 ) {
				System.out.println("Seats increased successfully");
				
			}
			int result2= bd.delete(booking);
			if(result2>0) {
				System.out.println("Booking Deleted Successfully");
				response.sendRedirect("current_booking.jsp");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}

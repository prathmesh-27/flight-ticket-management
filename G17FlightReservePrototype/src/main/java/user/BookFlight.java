package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.BookingDao;
import utility.classes.Booking;
import utility.classes.Flight;
import utility.classes.User;
import utility.methods.BookingDaoImpl;



/**
 * Servlet implementation class BookFlight
 */
@WebServlet("/bookflight")
public class BookFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String bookId =  (String) request.getSession().getAttribute("bookId");
		String uname = (String) request.getSession().getAttribute("uname");
		String fid = (String) request.getParameter("id");
		int num_of_passengers = Integer.parseInt(request.getParameter("number_of_passengers"));
		out.println("<h1>Hello</h1>");
		out.println("<h1>" + bookId + "</h1>");
		out.println("<h1>" + uname + "</h1>");
		out.println("<h1>" + fid + "</h1>");
		out.println("<h1>" + num_of_passengers + "</h1>");
		System.out.println(bookId);
		BookingDao bd = new BookingDaoImpl();
		try {
			Flight flight = bd.getFlightById(fid);
			User user = bd.getUserByUsername(uname);
			Double cost = flight.getCostPerSeat() * num_of_passengers;

			Booking booking = new Booking(bookId, uname, user.getUid(), flight.getFid(), num_of_passengers, cost);

			int result = bd.insert(booking);

			if (result > 0) {
				System.out.println("Data entered into booking data");
			} else {
				System.out.println("NO data inserted");
			}

		} catch (SQLException e) {

			System.out.println("Error is  " + e.getMessage());
		}
		
		System.out.println("Via BookFlight servelet");
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("BookFlight.jsp?bookId="+bookId);
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

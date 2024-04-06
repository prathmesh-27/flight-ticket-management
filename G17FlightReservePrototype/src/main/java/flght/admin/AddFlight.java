package flght.admin;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.FlightDao;
import utility.classes.Flight;
import utility.methods.DateTimeUtils;
import utility.methods.FlightDaoImpl;
import utility.methods.Use;

@WebServlet("/addflight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//flight_name, departure, destination ,ddatetime ,adatetime ,seat ,cost
		String fid = Use.generate7RandomString().trim();
		String flightname = (request.getParameter("flight_name")).trim();
		String from = (request.getParameter("departure")).trim().toLowerCase();
		String to = (request.getParameter("destination")).trim().toLowerCase();
		String ddatetime = (request.getParameter("ddatetime")).trim();
		String adatetime = (request.getParameter("adatetime")).trim();
		int tseat = Integer.parseInt(request.getParameter("seat"));
		double cost = Double.parseDouble(request.getParameter("cost"));
		
		
        // Conversion to  required types
		Date ddate= DateTimeUtils.getDateSql(ddatetime);//Extract of date from datetime string
		Date adate = DateTimeUtils.getDateSql(adatetime);
		
		
		
		LocalTime dtime = DateTimeUtils.getTime(ddatetime);//Extract of time from datetime string
		LocalTime atime = DateTimeUtils.getTime(adatetime);
		String duration = Use.duration( ddatetime,adatetime).trim();

		Flight flight = new Flight(fid, flightname, from, to,ddate, dtime.toString(),adate, atime.toString(),duration, tseat, cost);

		FlightDao fd = new FlightDaoImpl();
		try {
			int result = fd.insert(flight);
			if (result > 0) {
                	RequestDispatcher rd = request.getRequestDispatcher("Addflight.jsp?message=Flight is added successfully");
      				rd.forward(request, response);
			} else {
            	RequestDispatcher rd = request.getRequestDispatcher("Addflight.jsp?message=System is facing some issue in adding flight");
  				rd.forward(request, response);
			}

		} catch (SQLException e) {
			System.out.println("Error :" + e.getMessage());
		}

	}

}

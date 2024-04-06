package flght.admin;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalTime;

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

/**
 * Servlet implementation class UpdateFlight
 */
@WebServlet("/update")
public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("fid");
		System.out.println(id);
		System.out.println(request.getParameter("flightname"));
		String flightname = (request.getParameter("flightname")).trim();
		String from = (request.getParameter("departcity")).trim().toLowerCase();
		String to = (request.getParameter("desticity")).trim().toLowerCase();
		String ddatetime = (request.getParameter("ddatetime")).trim();
		String adatetime = (request.getParameter("adatetime")).trim();
		int tseat = Integer.parseInt(request.getParameter("seat"));
		double cost = Double.parseDouble(request.getParameter("costperseat"));
		
		
// Conversion to  required types
		Date ddate= DateTimeUtils.getDateSql(ddatetime);//Extract of date from datetime string
		Date adate = DateTimeUtils.getDateSql(adatetime);
		LocalTime dtime = DateTimeUtils.getTime(ddatetime);//Extract of time from datetime string
		LocalTime atime = DateTimeUtils.getTime(adatetime);
		String duration = Use.duration( ddatetime,adatetime).trim();

		Flight flight = new Flight(id, flightname, from, to, ddate, dtime.toString(),adate, atime.toString(),duration, tseat, cost); 
		System.out.println(flight);
		FlightDao fd = new FlightDaoImpl();		
		
		try {
			int result = fd.update(flight);
			String message=null;
			
			if(result==1) {
				message="Flight with id  '"+flight.getFid()+"'  is updated Successfully";
			}
			else {
				message="Flight is not updated";
			}
			
			response.sendRedirect("adminUtility/showflights.jsp?msg="+message);
		} catch (SQLException e) {
		System.out.println("Error is "+e.getMessage());
		}
		
	}

}

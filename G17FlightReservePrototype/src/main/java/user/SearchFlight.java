package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.methods.Use;

@WebServlet("/searchflight")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println(
				"<style>" + "table,th,td{" + "margin:auto;" + "border:1px solid black;" + "border-collapse:collapse;"
						+ "}" + "tr,td,th{" + "text-align:center;" + "padding:10px;" + "}" + "</style>");

		//String uname = (String) request.getSession().getAttribute("uname");

		// Session variable for bookin id start
		String bookId = Use.generateOrderId();
		HttpSession ses = request.getSession();
		ses.setAttribute("bookId", bookId);
		String fromd = request.getParameter("from").toLowerCase().trim();
		String tod = request.getParameter("to").toLowerCase().trim();
		String num_of_passengers = request.getParameter("passengers");

		response.sendRedirect("SearchFlights.jsp?message=Hello&fromd=" + fromd + "&tod=" + tod + "&num_of_passengers="
				+ num_of_passengers);

	}

}

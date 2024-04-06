package form.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.classes.*;
import utility.methods.*;
/**
 * Servlet implementation class Admin_login
 */
@WebServlet("/adminlogin")
public class Admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		Admin admin = new Admin(uname,pass);
		AdminDao ad = new AdminDao();
		


		try {
			int result= ad.checkAdminCredentials(admin);
			String username = Use.getCurrentSessionUserName();
			String password = Use.getCurrentSessionPassword();

			if (result>0) {
				System.out.println("Inside If");
				HttpSession hs = request.getSession();
				hs.setAttribute("uname", username);
				hs.setAttribute("pass",password);
		
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				System.out.println("login successful");
			} else {
				System.out.println("Inside else");

				 out.print("<h1   style='color: red; font-size:34px;'>Incorrect username or password</h1>");
				 out.println("<a href='adminlogin.jsp'  style='font-size:34px; ' >try again</a>");
				System.out.println("login not Successful");
			}

		} catch (Exception e) {

			System.out.println("Error from login.jsp :" + e.getMessage());

		}
	}

}

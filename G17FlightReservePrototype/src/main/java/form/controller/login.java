package form.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.interfaces.*;
import utility.classes.*;
import utility.methods.Use;
import utility.methods.UserDaoImpl;

/**
 * Servlet implementation class login
 */
@WebServlet("/userlogin")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao ud = new UserDaoImpl();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);

		try {

			int result = ud.checkCredentials(user);

			String sessionUser = Use.getCurrentSessionUserName();

			if (result > 0) {
				System.out.println("Inside If");
				HttpSession hs = request.getSession();
				hs.setAttribute("uname", sessionUser);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				System.out.println("login successful");
			} else {
				System.out.println("Inside else");
				RequestDispatcher rd = request.getRequestDispatcher("loginError.jsp");
				rd.forward(request, response);
				System.out.println("login not Successful");
			}

		} catch (Exception e) {

			System.out.println("Error from login.jsp :" + e.getMessage());

		}

	}

}

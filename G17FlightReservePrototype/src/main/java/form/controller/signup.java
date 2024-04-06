package form.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.UserDao;
import utility.classes.*;
import utility.methods.Use;
import utility.methods.UserDaoImpl;

@WebServlet("/register")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uid = Use.generate5NumericRandomString();
		String uname = request.getParameter("uname");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String mobileNo = request.getParameter("mobileNo");
		String email = request.getParameter("email");
		String password = request.getParameter("password");


		User user = new User(uid, uname, Use.capitalize(fname), Use.capitalize(lname), dob, gender, mobileNo, email, password);
		UserDao ud = new UserDaoImpl();
		try {

			int result = ud.insert(user);
			if (result > 0) {
				System.out.println("Successfully saved user data");
				response.sendRedirect("login.jsp?message=Registration Successful !");
			} else {
				System.out.println("signup.jsp?message=Registration Error");
			}

		} catch (SQLException e) {
			System.out.println("Error is " + e.getMessage());
		}

	}

}

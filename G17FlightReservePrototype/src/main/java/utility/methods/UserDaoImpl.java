package utility.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import utility.classes.User;
import dao.interfaces.*;
import form.controller.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public User getId(String id) throws SQLException {
		User user = null;
		Connection con = DBConnection.getDBConnection(); // getting connection

		String sql = "SELECT * FROM userdao where user_id = ?";// query
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String uid = rs.getString("user_id");
			String username = rs.getString("username");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String dateOfBirth = rs.getString("date_of_birth");
			String gender = rs.getString("gender");
			String phone = rs.getString("phone_no");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String reg_date = rs.getString("registered_date");

			user = new User(uid, username, firstname, lastname, dateOfBirth, gender, phone, email, password, reg_date);

		}

		return user;
	}
	
	@Override
	public User getUsername(String uname) throws SQLException {
	      User user=null;
			Connection con = DBConnection.getDBConnection(); // For establishing connection 
			String sql = "SELECT * FROM userdao where username = ?";// query
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String uid = rs.getString("user_id");
				String username = rs.getString("username");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String dateOfBirth = rs.getString("date_of_birth");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone_no");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String reg_date = rs.getString("registered_date");

				user = new User(uid, username, firstname, lastname, dateOfBirth, gender, phone, email, password, reg_date);

			}
	 
		return user;
	}
	
	

	@Override
	public List<User> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(User t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User user) throws SQLException {
		Connection con = DBConnection.getDBConnection();

		String sql = "INSERT into userdao(user_id,username,firstname,lastname,date_of_birth,gender,phone_no,email,password) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUid());
		ps.setString(2, user.getUsername());
		ps.setString(3, user.getFirstname());
		ps.setString(4, user.getLastname());
		ps.setString(5, user.getDateOfBirth());
		ps.setString(6, user.getGender());
		ps.setString(7, user.getPhone());
		ps.setString(8, user.getEmail());
		ps.setString(9, user.getPassword());
		int result = ps.executeUpdate();
		return result;

	}


	@Override
	public int update(User user) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "UPDATE  userdao SET username=?,firstname=?,lastname=?,date_of_birth=?,gender=?,phone_no=?,email=?,password=? WHERE user_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getFirstname());
		ps.setString(3, user.getLastname());
		ps.setString(4, user.getDateOfBirth());
		ps.setString(5, user.getGender());
		ps.setString(6, user.getPhone());
		ps.setString(7, user.getEmail());
		ps.setString(8, user.getPassword());
		ps.setString(9, user.getUid());

		int result = ps.executeUpdate();

		return result;
	}

	@Override
	public int delete(User user) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "DELETE from database_1.userdao WHERE user_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUid());
		int result = ps.executeUpdate();
		return result;
	}

	@Override
	public int checkCredentials(User user) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "SELECT * from userdao where username=? or email = ? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());

		String unameDB = "";
		String passwordDB = "";
		String emailDB = "";

		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			unameDB = rs.getString("username");
			passwordDB = rs.getString("password");
			emailDB = rs.getString("email");
		}
           Use.setCurrentSessionUsername(unameDB);
	   	  Use.setCurrentSessionPassword(passwordDB);
		if ((user.getUsername().equals(unameDB)
				| user.getEmail().equals(emailDB) )& user.getPassword().equals(passwordDB)) {
			ps.close();
			rs.close();
			return 1;
		} else {
			ps.close();
			rs.close();
			return 0;

		}

	}


	

	
	
}

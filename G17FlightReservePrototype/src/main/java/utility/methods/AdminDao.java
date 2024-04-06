package utility.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.controller.DBConnection;
import utility.classes.Admin;

public class AdminDao {
	public int checkAdminCredentials(Admin admin) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "SELECT * from admindata where username=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, admin.getUsername());
		ps.setString(2, admin.getPassword());

		String unameDB = "";
		String passwordDB = "";

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			unameDB = rs.getString("username");
			passwordDB = rs.getString("password");
		}
		Use.setCurrentSessionUsername(unameDB);
		Use.setCurrentSessionPassword(passwordDB);
		if (admin.getUsername().equals(unameDB) && admin.getPassword().equals(passwordDB)) {
			return 1;
		} else {
			return 0;

		}

	}

}

package utility.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.interfaces.BookingDao;
import dao.interfaces.FlightDao;
import dao.interfaces.UserDao;
import form.controller.DBConnection;
import utility.classes.Booking;
import utility.classes.Flight;
import utility.classes.User;


public class BookingDaoImpl implements BookingDao {

	@Override
	public Booking getId(String id) throws SQLException {
		Booking booking = null;
		Connection con = DBConnection.getDBConnection();
		String sql = "SELECT *FROM booking_data WHERE booking_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String bid = rs.getString("booking_id");
			String uname = rs.getString("username");
			String uid = rs.getString("uid");
			String fid = rs.getString("fid");
			int nop = rs.getInt("number_of_passengers");
			double cost = rs.getDouble("total_cost");

			booking = new Booking(bid, uname, uid, fid, nop, cost);

		}

		return booking;

	}

	@Override
	public List<Booking> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Booking t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Booking booking) throws SQLException {
		Connection con = DBConnection.getDBConnection();

		String sql = "INSERT into booking_data" + "(booking_id,username,uid,fid,number_of_passengers,total_cost)"
				+ " VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, booking.getBooking_id().trim());
		ps.setString(2, booking.getUname().trim());
		ps.setString(3, booking.getUid().trim());
		ps.setString(4, booking.getFid().trim());
		ps.setInt(5, booking.getNum_of_passegers());
		ps.setDouble(6, booking.getCost());

		int result = ps.executeUpdate();
		return result;
	}

	@Override
	public int update(Booking t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Booking booking) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "DELETE from booking_data WHERE booking_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, booking.getBooking_id());
		int result = ps.executeUpdate();

		return result;
	}

	@Override
	public Flight getFlightById(String id) throws SQLException {
		Flight flight = null;
		FlightDao fd = new FlightDaoImpl();
		flight = fd.getId(id);
		return flight;

	}

	@Override
	public User getUserByUsername(String uname) throws SQLException {
		User user = null;
		UserDao ud = new UserDaoImpl();
		user = ud.getUsername(uname);
		return user;
	}

	@Override
	public Booking getUsername(String username) throws SQLException {
		Booking booking = null;
		Connection con = DBConnection.getDBConnection();
		String sql = "SELECT *FROM booking_data WHERE username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String bid = rs.getString("booking_id");
			String uname = rs.getString("username");
			String uid = rs.getString("uid");
			String fid = rs.getString("fid");
			int nop = rs.getInt("number_of_passengers");
			double cost = rs.getDouble("total_cost");
			booking = new Booking(bid, uname, uid, fid, nop, cost);

		}

		return booking;

	}

	@Override
	public Booking getId(int id) throws SQLException {
		Booking booking = null;
		Connection con = DBConnection.getDBConnection();
		String sql = "SELECT *FROM booking_data WHERE booking_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String bid = rs.getString("booking_id");
			String uname = rs.getString("username");
			String uid = rs.getString("uid");
			String fid = rs.getString("fid");
			int nop = rs.getInt("number_of_passengers");
			double cost = rs.getDouble("total_cost");

			booking = new Booking(bid, uname, uid, fid, nop, cost);

		}

		return booking;
	}

}

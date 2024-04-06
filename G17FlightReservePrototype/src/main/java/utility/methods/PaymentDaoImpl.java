package utility.methods;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.interfaces.BookingDao;
import dao.interfaces.FlightDao;
import dao.interfaces.PaymentDao;
import dao.interfaces.UserDao;
import form.controller.DBConnection;
import utility.classes.Booking;
import utility.classes.Flight;
import utility.classes.PaymentDetails;
import utility.classes.User;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public PaymentDetails getId(String id) throws SQLException {
		PaymentDetails payment=null;
		Connection connection = DBConnection.getDBConnection();
		String sql ="Select * from payment_data WHERE transaction_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			String tid = rs.getString("transaction_id");
			String userid = rs.getString("user_id");
			String fid = rs.getString("flight_id");
			int bid = Integer.parseInt(rs.getString("book_id"));
			String fullname = rs.getString("fullname");
			String cnumber = rs.getString("card_number");
			int cvv = rs.getInt("cvv");
			String expirydate = rs.getString("expiry_date");
			Date dop = rs.getDate("Date_of_payment");
			Double amount = rs.getDouble("amount_paid");
			payment = new PaymentDetails(tid,userid,fid,bid,fullname,cnumber,cvv,expirydate,dop,amount);
		}
		return payment;
	}

	@Override
	public List<PaymentDetails> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public List<PaymentDetails> getAllByUserId(String id) throws Exception {

		List<PaymentDetails> pdetails = new ArrayList<>();
		PaymentDetails pdetail = null;
		Connection connection = DBConnection.getDBConnection();
		String sql = "SELECT * FROM payment_data WHERE user_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String tid = rs.getString("transaction_id");
			String userid = rs.getString("user_id");
			String fid = rs.getString("flight_id");
			int bid = Integer.parseInt(rs.getString("book_id"));
			String fullname = rs.getString("fullname");
			String cnumber = rs.getString("card_number");
			int cvv = rs.getInt("cvv");
			String expirydate = rs.getString("expiry_date");
			Date dop = rs.getDate("Date_of_payment");
			Double amount = rs.getDouble("amount_paid");
			pdetail = new PaymentDetails(tid, userid, fid, bid, fullname, cnumber, cvv, expirydate, dop, amount);
			pdetails.add(pdetail);
		}

		ps.close();
		rs.close();
		return pdetails;

	}

	@Override
	public int save(PaymentDetails t) throws SQLException {
		return 0;
	}

	@Override
	public int insert(PaymentDetails payment) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "INSERT into payment_data"
				+ "(transaction_id,user_id,flight_id,book_id,fullname,card_number,cvv,expiry_date,Date_of_payment,amount_paid)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, Use.generate18CharRandomString().trim());
		ps.setString(2, payment.getUid().trim());
		ps.setString(3, payment.getFid().trim());
		ps.setInt(4, payment.getBid());
		ps.setString(5, payment.getFullName().trim());
		ps.setString(6, payment.getCardNumber());
		ps.setInt(7, payment.getCvv());
		ps.setString(8, payment.getExpiryDate());
		ps.setDate(9, payment.getDate_of_payment());
		ps.setDouble(10, payment.getAmount_paid());

		int result = ps.executeUpdate();
		return result;
	}

	@Override
	public int update(PaymentDetails payment) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String tid) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "DELETE from payment_data WHERE transaction_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tid);
		int result = ps.executeUpdate();

		return result;
	}
	
	@Override
	public Booking getBookingById(int id) throws SQLException{
		Booking booking=null;
		BookingDao bd = new BookingDaoImpl();
		booking =bd.getId(id);
		return booking;
		
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
	public int updateSeats(Flight flight) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "UPDATE flightdata set   no_of_seat=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, flight.getNumOfSeats());
		ps.setString(2, flight.getFid());

		int result = ps.executeUpdate();
		return result;
	}
	@Override
	public int delete(PaymentDetails t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<PaymentDetails> getAllByFlightid(String flightid) throws Exception {

		List<PaymentDetails> pdetails = new ArrayList<>();
		PaymentDetails pdetail = null;
		Connection connection = DBConnection.getDBConnection();
		String sql = "SELECT * FROM payment_data WHERE flight_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, flightid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String tid = rs.getString("transaction_id");
			String userid = rs.getString("user_id");
			String fid = rs.getString("flight_id");
			int bid = Integer.parseInt(rs.getString("book_id"));
			String fullname = rs.getString("fullname");
			String cnumber = rs.getString("card_number");
			int cvv = rs.getInt("cvv");
			String expirydate = rs.getString("expiry_date");
			Date dop = rs.getDate("Date_of_payment");
			Double amount = rs.getDouble("amount_paid");
			pdetail = new PaymentDetails(tid, userid, fid, bid, fullname, cnumber, cvv, expirydate, dop, amount);
			pdetails.add(pdetail);
		}

		return pdetails;

	}
	

}

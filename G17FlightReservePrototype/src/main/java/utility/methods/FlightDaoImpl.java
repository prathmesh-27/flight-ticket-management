package utility.methods;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.interfaces.FlightDao;
import form.controller.DBConnection;
import utility.classes.Flight;

public class FlightDaoImpl implements FlightDao {

	@Override
	public Flight getId(String id) throws SQLException {
		Flight flight = null;
		Connection con = DBConnection.getDBConnection(); // getting connection

		String sql = "SELECT * FROM flightdata where id = ?";// query
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String fid = rs.getString("id");
			String flightname = rs.getString("flightname");
			String departCity = rs.getString("fromd");
			String destiCity = rs.getString("tod");
			Date departDate = rs.getDate("departuredate");
			String departTime = rs.getString("departuretime");
			Date arrivalDate = rs.getDate("arrivaldate");
			String arrivalTime = rs.getString("arrivaltime");
			String duration = rs.getString("duration");
			int numOfSeats = rs.getInt("no_of_seat");
			double costPerSeat = rs.getDouble("cost_per_seat");

			flight = new Flight(fid, flightname, departCity, destiCity,departDate, departTime, arrivalDate,
					arrivalTime, duration, numOfSeats, costPerSeat);
		}
		return flight;
	}

	@Override
	public List<Flight> getAll() throws SQLException {

		List<Flight> flights = new ArrayList<>();
		Flight flight = null;
		Connection connection = DBConnection.getDBConnection();
		String sql = "SELECT * FROM flightdata";
		PreparedStatement ps = connection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String fid = rs.getString("id");
			String flightname = rs.getString("flightname");
			String departCity = rs.getString("fromd");
			String destiCity = rs.getString("tod");
			Date departDate = rs.getDate("departuredate");
			String departTime = rs.getString("departuretime");
			Date arrivalDate = rs.getDate("arrivaldate");
			String arrivalTime = rs.getString("arrivaltime");
			String duration = rs.getString("duration");
			int numOfSeats = rs.getInt("no_of_seat");
			double costPerSeat = rs.getDouble("cost_per_seat");

			flight = new Flight(fid, flightname, departCity, destiCity, departDate, departTime, arrivalDate,
					arrivalTime, duration, numOfSeats, costPerSeat);
			flights.add(flight);
		}
		return flights;
	}

	
	
	
	
	
	@Override
	public int save(Flight t) throws SQLException {

		return 0;
	}

	
	
	
	
	@Override
	public int insert(Flight flight) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "INSERT into flightdata"
				+ "(id,flightname,fromd,tod,departuredate,departuretime,arrivaldate,arrivaltime,duration,no_of_seat,cost_per_seat) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, flight.getFid());
		ps.setString(2, flight.getFlightname());
		ps.setString(3, flight.getDepartCity().toLowerCase());
		ps.setString(4, flight.getDestiCity().toLowerCase());
		ps.setDate(5, flight.getDepartDate());
		ps.setString(6, flight.getDepartTime().toString());
		ps.setDate(7, flight.getArrivalDate());
		ps.setString(8, flight.getArrivalTime().toString());
		ps.setString(9, flight.getDuration().trim());
		ps.setInt(10, flight.getNumOfSeats());
		ps.setDouble(11, flight.getCostPerSeat());

		int result = ps.executeUpdate();

		return result;
	}

	@Override
	public int update(Flight flight) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "UPDATE flightdata set flightname=? ,fromd=?,tod=?,"
				+ "departuredate=?,departuretime=?,arrivaldate=?,arrivaltime=?,duration=?,no_of_seat=?,"
				+ "cost_per_seat=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, flight.getFlightname());
		ps.setString(2, flight.getDepartCity().toLowerCase());
		ps.setString(3, flight.getDestiCity().toLowerCase());
		ps.setDate(4, flight.getDepartDate());
		ps.setString(5, flight.getDepartTime().toString());
		ps.setDate(6, flight.getArrivalDate());
		ps.setString(7, flight.getArrivalTime().toString());
		ps.setString(8, flight.getDuration());
		ps.setInt(9, flight.getNumOfSeats());
		ps.setDouble(10, flight.getCostPerSeat());
		ps.setString(11, flight.getFid());

		int result = ps.executeUpdate();
		return result;
	}

	
	@Override
	public int delete(Flight flight) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "DELETE from flightdata WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, flight.getFid().trim());
		int result = ps.executeUpdate();
		return result;
	}

	@Override
	public List<Flight> getSearchFlights(String fromd, String tod) throws SQLException {

		List<Flight> flights = new ArrayList<>();
		Flight flight = null;
		Connection connection = DBConnection.getDBConnection();
		String sql = "SELECT * FROM flightdata WHERE fromd=? and tod=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, fromd);
		ps.setString(2, tod);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String fid = rs.getString("id");
			String flightname = rs.getString("flightname");
			String departCity = rs.getString("fromd");
			String destiCity = rs.getString("tod");
			Date departDate = rs.getDate("departuredate");
			String departTime = rs.getString("departuretime");
			Date arrivalDate = rs.getDate("arrivaldate");
			String arrivalTime = rs.getString("arrivaltime");
			String duration = rs.getString("duration");
			int numOfSeats = rs.getInt("no_of_seat");
			double costPerSeat = rs.getDouble("cost_per_seat");

			flight = new Flight(fid, flightname, departCity, destiCity,departDate, departTime, arrivalDate,
					arrivalTime, duration, numOfSeats, costPerSeat);
			flights.add(flight);
		}

		return flights;
	}

	@Override
	public List<Flight> getSearchFlights(String fromd, String tod, String departuredate) throws SQLException {
		return null;
	}

	@Override
	public int checkIfFlightPresent(String fid) throws SQLException {
		
		Connection connection = DBConnection.getDBConnection();
		String sql = "SELECT * FROM flightdata WHERE id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, fid);
		
		
		int result= ps.executeUpdate();
		
		return result;
	}

}

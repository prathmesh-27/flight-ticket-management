package dao.interfaces;

import java.sql.SQLException;
import java.util.List;
import utility.classes.*;

public interface FlightDao extends Dao<Flight> {
	public List<Flight> getSearchFlights(String fromd, String tod, String departuredate) throws SQLException;

	List<Flight> getSearchFlights(String fromd, String tod) throws SQLException;

	public int checkIfFlightPresent(String fid) throws SQLException;
}
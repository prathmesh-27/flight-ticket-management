package dao.interfaces;

import java.sql.SQLException;
import utility.classes.*;

public interface BookingDao extends Dao<Booking>{
	Flight getFlightById(String id) throws SQLException;

	User getUserByUsername(String uname) throws SQLException;

	Booking getUsername(String username) throws SQLException;

	Booking getId(int id) throws SQLException;
}

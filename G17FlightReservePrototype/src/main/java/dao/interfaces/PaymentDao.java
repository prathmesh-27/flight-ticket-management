package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import utility.classes.*;

public interface PaymentDao extends Dao<PaymentDetails> {
	
	Flight getFlightById(String id) throws SQLException;

	User getUserByUsername(String uname) throws SQLException;

	int updateSeats(Flight flight) throws SQLException;


	List<PaymentDetails> getAllByUserId(String id) throws Exception;

	int delete(String tid) throws SQLException;

	Booking getBookingById(int id) throws SQLException;

	List<PaymentDetails> getAllByFlightid(String fid) throws Exception;


}

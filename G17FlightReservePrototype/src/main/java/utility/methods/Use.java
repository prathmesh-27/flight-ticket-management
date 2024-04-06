package utility.methods;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import form.controller.DBConnection;

public class Use {

	static String str = "";
	static String pswd = "";

	public static String getWeekDayName(String s) {
		DateTimeFormatter dtfInput = DateTimeFormatter.ofPattern("u-M-d", Locale.ENGLISH);
		DateTimeFormatter dtfOutput = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH);
		return LocalDate.parse(s, dtfInput).format(dtfOutput);
	}

	public static final String capitalize(String str) {
		if (str == null || str.length() == 0)
			return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static void setCurrentSessionUsername(String string) {
		str = string;
	}

	public static String getCurrentSessionUserName() {
		return str;
	}

	public static void setCurrentSessionPassword(String string) {
		pswd = string;
	}

	public static String getCurrentSessionPassword() {
		return pswd;
	}

	public static int deleteById(String id) throws SQLException {
		Connection con = DBConnection.getDBConnection();
		String sql = "DELETE from demo_database.flightdata WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id.trim());
		int result = ps.executeUpdate();
		return result;
	}

	public static String generateOrderId() {
		String str = "";
		int ranNo;
		for (int i = 0; i < 8; i++) {
			ranNo = new Random().nextInt(9);
			str = str.concat(Integer.toString(ranNo));

		}
		return str;

	}

	public static String generate5Id() {
		String str = "";
		int ranNo;
		for (int i = 0; i < 5; i++) {
			ranNo = new Random().nextInt(9);
			str = str.concat(Integer.toString(ranNo));

		}
		return str;

	}

	public static Date toSqlData(String date) {

		LocalDate localdate = LocalDate.parse(date);

		return Date.valueOf(localdate);
	}

	public static String generate18CharRandomString() {
		SecureRandom random = new SecureRandom();
		final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		final int LENGTH = 18;
		StringBuilder sb = new StringBuilder(LENGTH);

		for (int i = 0; i < LENGTH; i++) {
			int randomIndex = random.nextInt(ALPHANUMERIC.length());
			char randomChar = ALPHANUMERIC.charAt(randomIndex);
			sb.append(randomChar);
		}

		return sb.toString();
	}

	public static String generate7RandomString() {
		final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		final int LENGTH = 7;
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(LENGTH);

		for (int i = 0; i < LENGTH; i++) {
			if (i != 2) {
				int randomIndex = random.nextInt(ALPHABETS.length());
				char randomChar = ALPHABETS.charAt(randomIndex);
				sb.append(randomChar);
			} else {
				sb.append(" ");
			}

		}
		return sb.toString();
	}
	public static String generate5NumericRandomString() {
		final String ALPHABETS = "1234567890";
		final int LENGTH = 5;
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(LENGTH);

		for (int i = 0; i < LENGTH; i++) {
		
				int randomIndex = random.nextInt(ALPHABETS.length());
				char randomChar = ALPHABETS.charAt(randomIndex);
				sb.append(randomChar);

		}
		return sb.toString();
	}

	public static Date getTodayDate() {
		LocalDate localdate = LocalDate.now();
		return Date.valueOf(localdate);
	}
	
	
	public static String duration(String datetime1,String datetime2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		
		LocalDateTime dateTime1= LocalDateTime.parse(datetime1, formatter);
		LocalDateTime dateTime2= LocalDateTime.parse(datetime2, formatter);

		long diffInHours = java.time.Duration.between(dateTime1,dateTime2 ).toHours();
		String duration = Long.toString(diffInHours);
	
		if(Integer.parseInt(duration)<1) {	
			long diffMinutes=java.time.Duration.between(dateTime1, dateTime2).toMinutes();
			return diffMinutes+"mins";}
		else if(duration =="1") { return duration+" hour";}
		else {return duration+" hours";}
		
		
	}
	

	
	
}

package utility.methods;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

	public static Date getDateSql(String datetime) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(datetime, formatter);

		LocalDate localdate = dateTime.toLocalDate();

		return Date.valueOf(localdate);
	}

	public static LocalTime getTime(String datetime1) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(datetime1, formatter);

		LocalTime localTime = dateTime.toLocalTime();

		return localTime;
	}

	public static String DateInFormatddmmyyyy(Date date) {
		
		DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
		String text = df.format(date);
		
		return text;
		
	}
	
	
	public static String HourFormat24to12(String time) {
		StringBuilder s =new StringBuilder();
		int h1= (int)time.charAt(0)-'0';
		System.out.println(h1);
		int h2 =(int)time.charAt(1)-'0';
System.out.println(h2);
		
		int hh= h1*10 +h2;
		System.out.println(hh);
		
		String meridian ;
		if(hh<12) {
			meridian="a.m.";
		}else {
			meridian="p.m.";
		}
		hh%=12;
		if(hh==0) {
			s= new StringBuilder("12");
			for(int i=2;i<5;i++) {
		    s.append(time.charAt(i));	
			}		
			s= s.append(" "+meridian);
		}
		else {

			s = new StringBuilder(Integer.toString(hh));
			for(int i=2;i<5;i++) {
		   s.append(time.charAt(i));	
			}		
			s= s.append(" "+meridian);
		
		}
		
		return s.toString();
	}
	
	
	
}


import utility.methods.DateTimeUtils;


public class Main {

	public static void main(String[] args) {
	
		String s = "01:01";
	   	 
		String t= DateTimeUtils.HourFormat24to12(s);
		System.out.println(t);
		 
	}

}

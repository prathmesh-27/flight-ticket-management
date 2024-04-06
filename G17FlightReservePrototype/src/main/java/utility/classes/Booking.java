package utility.classes;


public class Booking {
	private String booking_id;
	private String uname;
	private String uid;
	private String fid;
	private int num_of_passegers;
	private double cost;

	public Booking(String booking_id, String uname, String uid, String fid, int num_of_passegers, double cost) {
	
		this.booking_id = booking_id;
		this.uname = uname;
		this.uid = uid;
		this.fid = fid;
		this.num_of_passegers = num_of_passegers;
		this.cost = cost;
	}

	public String getBooking_id() {
		return booking_id;
	}

	public String getUid() {
		return uid;
	}

	public String getUname() {
		return uname;
	}

	public String getFid() {
		return fid;
	}

	public int getNum_of_passegers() {
		return num_of_passegers;
	}

	public double getCost() {
		return cost;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public void setNum_of_passegers(int num_of_passegers) {
		this.num_of_passegers = num_of_passegers;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", uid=" + uid + ", uname=" + uname + ", fid=" + fid
				+ ", num_of_passegers=" + num_of_passegers + ", cost=" + cost + "]";
	}

}

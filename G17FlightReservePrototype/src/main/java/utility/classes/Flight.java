package utility.classes;

import java.sql.Date;


public class Flight {

	private String fid;
	private String flightname;
	private String departCity;
	private String destiCity;
	private Date departDate;
	private String departTime;
	private Date arrivalDate;
	private String arrivalTime;
	private String duration;
	private int numOfSeats;
	private double costPerSeat;

	public Flight(String fid, String flightname, String departCity, String destiCity,Date departDate,
			String departTime, Date arrivalDate, String arrivalTime, String duration, int numOfSeats,
			double costPerSeat) {
		super();
		this.fid = fid;
		this.flightname = flightname;
		this.departCity = departCity;
		this.destiCity = destiCity;
		this.departDate = departDate;
		this.departTime = departTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.numOfSeats = numOfSeats;
		this.costPerSeat = costPerSeat;
	}


	public String getFid() {
		return fid;
	}


	public String getFlightname() {
		return flightname;
	}


	public String getDepartCity() {
		return departCity;
	}


	public String getDestiCity() {
		return destiCity;
	}




	public Date getDepartDate() {
		return departDate;
	}


	public String getDepartTime() {
		return departTime;
	}


	public Date getArrivalDate() {
		return arrivalDate;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public String getDuration() {
		return duration;
	}


	public int getNumOfSeats() {
		return numOfSeats;
	}


	public double getCostPerSeat() {
		return costPerSeat;
	}


	public void setFid(String fid) {
		this.fid = fid;
	}


	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}


	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}


	public void setDestiCity(String destiCity) {
		this.destiCity = destiCity;
	}




	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}


	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}


	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}


	public void setCostPerSeat(double costPerSeat) {
		this.costPerSeat = costPerSeat;
	}


	@Override
	public String toString() {
		return "Flight [fid=" + fid + ", flightname=" + flightname + ", departCity=" + departCity + ", destiCity="
				+ destiCity +", departDate=" + departDate + ", departTime=" + departTime
				+ ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", duration=" + duration
				+ ", numOfSeats=" + numOfSeats + ", costPerSeat=" + costPerSeat + "]";
	}




}

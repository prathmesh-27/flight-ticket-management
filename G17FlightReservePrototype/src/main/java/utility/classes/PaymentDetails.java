package utility.classes;

import java.sql.Date;

public class PaymentDetails {

	private String transaction_id;
	private String uid;
	private String fid;
	private int bid;
	private String fullName;
	private String cardNumber;
	private int cvv;
	private String expiryDate;
	private Date date_of_payment;
	private Double amount_paid;

	public PaymentDetails(String transaction_id, String uid, String fid, int bid, String fullName, String cardNumber,
			int cvv, String expiryDate, Date date_of_payment, Double amount_paid) {
		super();
		this.transaction_id = transaction_id;
		this.uid = uid;
		this.fid = fid;
		this.bid = bid;
		this.fullName = fullName;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
		this.date_of_payment = date_of_payment;
		this.amount_paid = amount_paid;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public String getUid() {
		return uid;
	}

	public String getFid() {
		return fid;
	}

	public int getBid() {
		return bid;
	}

	public String getFullName() {
		return fullName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public Date getDate_of_payment() {
		return date_of_payment;
	}

	public Double getAmount_paid() {
		return amount_paid;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setDate_of_payment(Date date_of_payment) {
		this.date_of_payment = date_of_payment;
	}

	public void setAmount_paid(Double amount_paid) {
		this.amount_paid = amount_paid;
	}

	@Override
	public String toString() {
		return "PaymentDetails [transaction_id=" + transaction_id + ", uid=" + uid + ", fid=" + fid + ", bid=" + bid
				+ ", fullName=" + fullName + ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", expiryDate="
				+ expiryDate + ", date_of_payment=" + date_of_payment + ", amount_paid=" + amount_paid + "]";
	}

}

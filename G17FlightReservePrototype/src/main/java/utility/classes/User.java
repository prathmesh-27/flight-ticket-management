package utility.classes;

public class User {

	private String uid;
	private String username;
	private String firstname;
	private String lastname;
	private String dateOfBirth;
	private String gender;
	private String phone;
	private String email;
	private String password;
	private String reg_date;

	public User() {

	}

	public User(String uid, String username, String firstname, String lastname, String dateOfBirth, String gender,
			String phone, String email, String password, String reg_date) {

		this.uid = uid;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.reg_date = reg_date;
	}

	public User(String uid, String username, String firstname, String lastname, String dateOfBirth, String gender,
			String phone, String email, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public String getUid() {
		return uid;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", reg_date=" + reg_date + "]";
	}

}

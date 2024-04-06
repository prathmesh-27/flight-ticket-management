let form = document.getElementById("form");
let firstName = document.getElementById("fname");
let lastName = document.getElementById("lname");
let uname = document.getElementById("uname");
let dob = document.getElementById("dob");
let mobileNo = document.getElementById("mobileNo");
let gender = document.getElementsByName("gender");
let emailId = document.getElementById("emailId");
let password = document.getElementById("password");
let repassword = document.getElementById("repassword");

const submit = document.getElementById("submit");
const error = document.getElementById("error");




form.addEventListener("submit", (e) => {
	let errorMessages = [];

	console.log("Hello");

	if (
		firstName.value === "" ||
		lastName.value === "" ||
		uname.value === "" ||
		dob.value === "" ||
		password.value === "" ||
		mobileNo.value === "" ||
		emailId.value === ""
		|| repassword.value === ""

	) {
		console.log("All feilds are necessary");
		errorMessages.push("All feilds are necessary");
	}


	if (password.value.length < 6 || password.value.length > 10) {
		errorMessages.push("Password must be 6-10 characters long");
	}

	if (!(gender[0].checked || gender[1].checked) || gender[2].checked) {
		errorMessages.push("Please select a radio button");
	}

	if (validateEmailId(emailId) == true) {
		errorMessages.push("Wrong emailId format");
	}

	if (validatePhoneNumber(mobileNo) == true) {
		errorMessages.push("Wrong mobile no format");
	}

	if (password.value != repassword.value) {
		error.innerText = errorMessages.push("Password do no match Confirm Password");
	}

	if (errorMessages.length > 0) {
		error.innerText = errorMessages.join("\n");
		// The preventDefault() method cancels the event if it is cancelable, 
		// meaning that the default action that belongs to the event will not occur.
		// Clicking on a "Submit" button, prevent it from submitting a form
		e.preventDefault();
	}

});




function validatePhoneNumber(mobileNo) {
	// Regex: 10 digits with no comma, spaces, punctuation and no + sign
	var phoneno = /^\d{10}$/;

	if (mobileNo.value.match(phoneno) == null) {
		return true;
	} else {
		return false;
	}
}

function validateEmailId(emailId) {
	var emailFormat =
		/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

	if (emailId.value.match(emailFormat) == null) {
		return true;
	} else {
		return false;
	}
}










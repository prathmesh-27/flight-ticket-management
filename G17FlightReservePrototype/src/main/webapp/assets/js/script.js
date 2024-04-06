/*JavaScript for welcome Slider */
var counter=1;
setInterval(function(){
    document.getElementById('radio'+counter).checked = true;
    counter++;
    if(counter>4){
        counter=1;
    }
},3000)



/***
		 const name = document.getElementById("name");
		 const uname = document.getElementById("uname");
		 const dob = document.getElementById("dob");
		 const mobileNo = document.getElementById("mobileNo");
		 const radios = document.getElementsByName("gender");
		 const emailId = document.getElementsById("emailId");
		 const password = document.getElementById("password");
		 const repassword = document.getElementById("repassword");
		 const submit = document.getElementById("submit");
		 const error = document.getElementById("error");



		 function validateForm(){
		 	  if (
		     name.value === null ||
		     uname.value ===null||
		     dob.value ===null||
		     mobileNo.value ===""||
		     repassword.value===""||
		     password.value === "" ||
		     mobileNo.value === "" ||
		     emailId.value === ""
		   ) {
		 	  console.log("fill all fields");
		     errorMessages.push("All fields are compulsory");
		     return false;
		   }
		   
		   else if(uname.length()>2){
		   return false;
		   }
		   else
			  {
		 	  return true;
		   }
		 }
* */

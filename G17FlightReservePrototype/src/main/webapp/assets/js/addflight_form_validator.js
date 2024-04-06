const form = document.getElementById("form");
const fname = document.getElementById("fname");
const fromd = document.getElementById("fromd");
const tod = document.getElementById("tod");
const ddatetime = document.getElementById("ddatetime");
const adatetime = document.getElementById("adatetime");
const seat = document.getElementById("seat");
const cost = document.getElementById("cost");
const submit = document.getElementById("submit");
const error = document.getElementById("error");



form.addEventListener( "submit" ,(e)=>{
   console.log(fname.value);
   console.log(fromd.value);
   console.log(tod.value);
   console.log(ddatetime.value);
   console.log(adatetime.value);
   console.log(seat.value);
   console.log(cost.value);

    let errorMessages = [];

    if (
        fname.value === "" ||
        fromd.value === "" ||
        tod.value === "" ||
        ddatetime.value === ""||
        adatetime.value === ""||
        seat.value === ""||cost.value === ""
    ) {
      errorMessages.push("All fields are compulsory");
    }
     
  if(ddatetime.value <= date.toISOString()){
    errorMessages.push("Departure Date and Time should not be less than Today's Date")
  }

   if(ddatetime.value>=adatetime.value){
    errorMessages.push("Departure Date and Time should not exceed Arrival Date and Time ")
   }


    if (errorMessages.length > 0) {
      error.innerText = errorMessages.join("\n");
      e.preventDefault();
    }
  

});


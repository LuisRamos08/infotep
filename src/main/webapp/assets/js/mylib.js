const base_url = "localhost/citas/controllers/";

function toJSON(formData){
	var object = {};
	formData.forEach((value, key) => {
	    if(!Reflect.has(object, key)){
	        object[key] = value;
	        return;
	    }
	    if(!Array.isArray(object[key])){
	        object[key] = [object[key]];    
	    }
	    object[key].push(value);
	});
	var json = JSON.stringify(object);
	return json;
}

function dayName(day){
	switch(day){
      case 0: return "Monday";
      case 1: return "Tuesday";
      case 2: return "Wednesday";
      case 3: return "Thursday";
      case 4: return "Friday";
      case 5: return "Saturday";
      case 6: return "Sunday";
    }
}

function monthName(month){
	switch(month){
      case 0: return "January";
      case 1: return "February";
      case 2: return "March";
      case 3: return "April";
      case 4: return "May";
      case 5: return "June";
      case 6: return "July";
      case 7: return "August";
      case 8: return "September";
      case 9: return "October";
      case 10: return "November";
      case 11: return "December";
    }
}

function ordinal(number){
	switch(number){
      case 1: return number + "st";
      case 2: return number + "nd";
      case 3: return number + "rd";
      default : return number + "th";
    }
}

function dateFormat(date){
	return dayName(date.getDay()) + ", " + ordinal(date.getDate()) + " " + monthName(date.getMonth())  + " " + d.getFullYear();
}

function toast(msg){
    var x = document.getElementById("snackbar");
    x.innerHTML = msg;
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}

function successToast(msg){
    var x = document.getElementById("successSnackbar");
    x.innerHTML = msg;
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}

/* Login Form Validation */
function checkUserName() {
	var userName = document.getElementById('userName');	
	var message = "userName Must Be Between 5 & 50 Character";
	myFunction(userName, message);
}

function checkPassword() {
	var password = document.getElementById('password');
	var message = "Password Must Be Between 5 & 50 Character";
	myFunction(password, message);
}

function myFunction(field, message) {
	var mnlen = 5;
	var mxlen = 50;

	if (field.value.length < mnlen || field.value.length > mxlen) {
		showAlert(message);
		giveFocus(field.name);
		document.getElementById("btn").disabled = true;
	} else {
		document.getElementById("btn").disabled = false;
		setTimeout(function() {
			$("#alertdiv").remove();
		}, 0);
	}
}

function showLoginButton() {

	$('#button')
			.append(
					'<input id="buttondiv" class="pt-0 pr-3 pl-3 mt-3" type="submit" name="login" value="Login">')

}

/* Login Form Validation */

/* Update Form Validation */

function checkName() {
	var name = document.getElementById('employeeName');
	var message = "Max 100 Character Allowed";
	updateFormValidation(name, message, 100);
}

function checkLocation() {
	var location = document.getElementById('location');
	var message = "Max 500 Character Allowed";
	updateFormValidation(location, message, 500);
}

function checkEmail() {
	var email = document.getElementById('email');
	var mailFormat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;	
	if (email.value.match(mailFormat)) {
		var message = "Max 100 Character Allowed";
		document.getElementById("btn").disabled = false;
		updateFormValidation(email, message, 100);
	} else {
		showEmailAlert();
		giveFocus(email.name);
		document.getElementById("btn").disabled = true;
	}
}

function checkDate() {
	var date = document.getElementById('date');
	var message = "Date Format Must Be DD/MM/YYYY";
	var dateFormat = /^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
	if (!(date.value.match(dateFormat))) {			
		showAlert(message);
	}	
}


function updateFormValidation(field, message, mxlen) {	
	if (field.value.length > mxlen) {		
		showAlert(message);
		giveFocus(field.name);
		document.getElementById("btn").disabled = true;
	} else {		
		document.getElementById("btn").disabled = false;
		setTimeout(function() {
			$("#alertdiv").remove();
		}, 0);
	}
}

function showAlert(message) {	
	$('#alert').append(
			'<div id="alertdiv" class="alert alert-danger">'
					+ '<a class="close" data-dismiss="alert">X</a>' + '<span>'
					+ message + '</span></div>')
	setTimeout(function() {
		$("#alertdiv").remove();
	}, 2000);

}

function showEmailAlert() {
	$('#alert').append(
			'<div id="alertdiv" class="alert alert-danger">'
					+ '<a class="close" data-dismiss="alert">X</a><span>Invalid Email</span></div>')
	setTimeout(function() {
		$("#alertdiv").remove();
	}, 3000);

}

function giveFocus(field) {
	  document.getElementById(field).focus();
	}

/* Update Form Validation */
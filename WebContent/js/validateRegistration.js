function fieldValidation(username, mx, my) {
	var usernamelength = username.value.length;
	var expression = /^[0-9a-zA-Z0-9]+$/;
	if (usernamelength == 0 || usernamelength >= my || usernamelength < mx
			|| !(username.value.match(expression))) {
		username.focus();
		return false;
	}
	return true;
}

function formValidation() {
	var username = document.form.loginid;
	var password = document.form.password;
	if (fieldValidation(username, 3, 12)) {
		if (fieldValidation(password, 3, 12)) {
			return true;
		} else {
			document.getElementById("validatepass").innerHTML = "length 3-12, only alphanumeric";
			return false;
		}
	}
	document.getElementById("validateid").innerHTML = "length 3-12, only alphanumeric";
	return false;
}

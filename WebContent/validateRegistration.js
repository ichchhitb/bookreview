function fieldValidation(username, mx, my) {
            var usernamelength = username.value.length;
            var expression = /^[0-9a-zA-Z0-9]+$/;
            if (usernamelength == 0 || usernamelength >= my || usernamelength < mx  || !(username.value.match(expression))) {
                       //alert("The field should not be empty / length be between " + mx + " to "+ my+"and can contain only letters and numbers");
                       username.focus();
                        return false;
            }
            return true;
}



function formValidation()  
{  
            var username = document.form.loginid;  
            var password = document.form.password;  
            if(fieldValidation(username,5,12))  {  
                        if(fieldValidation(password,7,12))  {  
                        	return true;
                        }  
                        else {
                        	document.getElementById("validatepass").innerHTML="length 7-12, only alphanumeric";
                        	return false;
                        }
            } 
            document.getElementById("validateid").innerHTML="length 5-12, only alphanumeric";
            return false;  
}  

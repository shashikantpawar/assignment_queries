function formValidation()
{
var uname = document.registration.username;
var fname = document.registration.first_name;
var lname = document.registration.last_name;
var pass = document.registration.password;
var re_pass = document.registration.re_password;
var mail = document.registration.email;
var phone = document.registration.phone_no;

if(username_validation(uname,5,12))
{
if(pass_validation(pass,7,12))
{
if(matchpass(pass,re_pass))
{
if(allLetter(fname))
{
if(allnumeric(phone))
{
if(ValidateEmail(uemail))
{
} 
}
}
} 
}
}
return false;
}

function uname_validation(uname,mx,my)
{
var uname_len = uname.value.length;
if (uname_len == 0 || uname_len >= my || uname_len < mx)
{
alert("User name should not be empty / length be between "+mx+" to "+my);
uid.focus();
return false;
}
return true;
}
function pass_validation(passid,mx,my)
{
var pass_len = pass.value.length;
if (pass_len == 0 ||pass_len >= my || pass_len < mx)
{
alert("Password should not be empty / length be between "+mx+" to "+my);
passid.focus();
return false;
}
return true;
}
function allLetter(fname)
{ 
var letters = /^[A-Za-z]+$/;
if(uname.value.match(letters))
{
return true;
}
else
{
alert('first name must have alphabet characters only');
uname.focus();
return false;
}
}
function matchpass(pass,re_pass)
{ 
if(re_pass.value.match(pass))
{
return true;
}
else
{
alert('password not matched..');
re_pass.focus();
return false;
}
}
function allnumeric(phone)
{ 
var numbers = /^[0-9]+$/;
if(uzip.value.match(numbers))
{
return true;
}
else
{
alert('phone no. must have numeric characters only');
uzip.focus();
return false;
}
}
function ValidateEmail(mail)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(uemail.value.match(mailformat))
{
return true;
}
else
{
alert("You have entered an invalid email address!");
return false;
}
} 

<html>
<script type="text/javascript">
function formValidation()
{
var uname = document.registration.username;
var fname = document.registration.first_name;
var lname = document.registration.last_name;
var pass = document.registration.password;
var re_pass = document.registration.re_password;
var mail = document.registration.email;
var phone = document.registration.phone_no;

if(uname_validation(uname,5,12))
{
if(pass_validation(pass,7,12))
{
if(pass_check(pass,re_pass))
{
if(allLetter(fname))
{
if(ValidateEmail(mail))
{
if(allnumeric(phone))
{
	return true;
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
uname.focus();
return false;
}
return true;
}
function pass_validation(pass,mx,my)
{
var pass_len = pass.value.length;
if (pass_len == 0 ||pass_len >= my || pass_len < mx)
{
alert("Password should not be empty / length be between "+mx+" to "+my);
pass.focus();
return false;
}
return true;
}
function allLetter(fname)
{ 
var letters = /^[A-Za-z]+$/;
if(fname.value.match(letters))
{
return true;
}
else
{
alert('first name must have alphabet characters only')
fname.focus();
return false;
}
}
function pass_check(pass,re_pass)
{ 
if(pass.value==re_pass.value)
{
return true;
}
else
{
alert('password must be same...')
re_pass.focus();
return false;
}
}
function allnumeric(phone)
{ 
var numbers = /^[0-9]+$/;
if(phone.value.match(numbers))
{
return true;
}
else
{
alert('phone no. must have numeric characters only')
phone.focus();
return false;
}
}
function ValidateEmail(mail)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(mail.value.match(mailformat))
{
return true;
}
else
{
alert("You have entered an invalid email address!")
return false;
}
} 
</script>
<%String result = (String)request.getAttribute("result"); 
		  if(result != null){
		%>
	<span style="color:green">	<%=result%></span>
		<%} result = null;%>
<body bgcolor="wheat" onLoad="document.registration.uname.focus();">
<h2 align="center">User Registration!</h2></hr>
<center>
<div >		
<form name="registration" action="register" method="post" onSubmit="return formValidation();">
	<table>
		<tr><td align="right">Username:</td><td><input type="text" name="username" /></td></tr>
		<tr><td align="right">Password:</td><td><input type="password" name="password" /></td></tr>
		<tr><td align="right">Confirm Password:</td><td><input type="password" name="re_password"/></td></tr>
		<tr><td align="right">FirstName:</td><td><input type="text" name="first_name" /></td></tr>
		<tr><td align="right">LastName:</td><td><input type="text" name="last_name"/></td></tr>
		<tr><td align="right">Email:</td><td><input type="text" name="email" /></td></tr>
		<tr><td align="right">Phone No:</td><td><input type="text" name="phone_no" /></td></tr>
		<tr><td align="right">Location:</td><td><input type="text" name="location"/></td></tr>
		<tr><td></td><td align="left"><input type="submit" value="save"/>&nbsp<input type="reset" name="reset"/></td></tr>
	</table>
		<input type="hidden" name="action" value="register"/>
</form>
</div>	
</center>
<hr/>
<div>
	<jsp:include page="userInfo.jsp"/>
</div>
</body>
</html>

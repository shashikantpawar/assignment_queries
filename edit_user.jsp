<a href="index.jsp">back</a><br>
<body bgcolor="wheat">
<center>
<form action="register" method="post">
	<table>
		<tr><td align="right">Username:</td><td><input type="text" name="username" value="<%=request.getParameter("username")%>" readonly/></td></tr>
		<tr><td align="right">FirstName:</td><td><input type="text" value="<%=request.getParameter("first_name") %>" name="first_name" /></td></tr>
		<tr><td align="right">LastName:</td><td><input type="text" value="<%=request.getParameter("last_name")%>" name="last_name" /></td></tr>
		<tr><td align="right">Email:</td><td><input type="email" value="<%=request.getParameter("email")%>" name="email" /></td></tr>
		<tr><td align="right">Phone No:</td><td><input type="text" value="<%=request.getParameter("phone_no")%>" name="phone_no" /></td></tr>
		<tr><td align="right">Location:</td><td><input type="text" value="<%=request.getParameter("location")%>" name="location"  /></td></tr>
		<tr><td></td><td align="left"><input type="submit" value="update"/>&nbsp<input type="reset" name="reset"/></td></tr>
		<input type="hidden" name="action" value="update"/>
	</table>
</form>
</center>
</body>
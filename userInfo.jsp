<%@page isELIgnored ="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3 align="center">USER DATABASE</h3>
<center>
		<c:choose>
			<c:when test="${userList ne null}">
				<table border="1" width="100%">
		                <tr style="bgcolor:blue"><th>First Name</th><th>Last Name</th><th>Email</th><th>Phone No.</th><th>Location</th></tr>
							<c:forEach var="u" items="${userList}">
								<tr align="justify">
								<td>${u.firstName}</td>
								<td>${u.lastName}</td>
								<td>${u.email}</td>
								<td>${u.phoneNo}</td>
								<td>${u.location}</td>
								<td><a href="edit_user.jsp?username=${u.userName}&first_name=
								${u.firstName}&last_name=${u.lastName}&email=${u.email}&
								phone_no=${u.phoneNo}&location=${u.location}">EDIT</a> &nbsp&nbsp
								<a href="register?action=delete&username=${u.userName}">DELETE</a></td>
								</tr>
							</c:forEach>
			</c:when>
			
		</c:choose>
</table>
</center>
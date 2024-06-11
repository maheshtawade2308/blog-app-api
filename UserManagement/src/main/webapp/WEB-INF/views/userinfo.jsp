<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
</head>
<body bgcolor="lightblue">
<div align="center">
<font color="green" >${SUCCESS}</font>
<font color="red" >${saveFail}</font>
</div>
<form:form action="saveUser?userId=${user.userId}" modelAttribute="user" method="POST">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<marquee>Realtime Task Demo</marquee>
<table align="center" >
<tr>
<td>UserName</td>
<td><form:input path="userName" /></td>
</tr>
<tr>
<td>UserEmail</td>
<td><form:input path="userEmail" /></td>
</tr>
<tr>
<td>UserPhone</td>
<td><form:input path="userPhone" /></td>
</tr>
<tr>
<td><input type="submit" value="Save"></td>
</tr>
</table>
<div align="center">
<a href="viewAllUser">View All User</a></div>
</form:form>
</body>
</html>
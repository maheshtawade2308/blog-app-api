<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Email</title>
</head>
<body bgcolor="lightblue">
<div align="center">
<font color="green" >${SUCCESS}</font>
<font color="red" >${saveFailed}</font>
</div>
<form:form action="email" modelAttribute="mail" method="POST">
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
<td>TO</td>
<td><form:input path="to" /></td>
</tr>
<tr>
<td>FROM</td>
<td><form:input path="from" /></td>
</tr>
<tr>
<td>SUBJECT</td>
<td><form:input path="subject" /></td>
</tr>
<tr>
<td>YOUR MESSAGE</td>
<td><form:input path="text" /></td>
</tr>
<tr>
<td><input type="submit" value="Send"></td>
</tr>
</table>
<div align="center">
<a href="viewAllUser">View All User</a></div>
</form:form>
</body>
</html>
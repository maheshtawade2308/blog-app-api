<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All User</title>
<script type="text/javascript">
function confirmDelete(){
	return confirm("Are you sure you want to delete?");
}
</script>
</head>
<body>
<table align="center">
<tr>
<th>UserName</th>
<th>UserEmail</th>
<th>UserPhone</th>
</tr>
<tbody>
<c:forEach items="${contact}" var="cot" >
<tr>
<td>${cot.userName}</td>
<td>${cot.userEmail}</td>
<td>${cot.userPhone}</td>
<td><a href="edit?userId=${cot.userId}">Edit</a> </td>
<td><a href="delete?userId=${cot.userId}" onclick="confirmDelete()">Delete</a> </td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
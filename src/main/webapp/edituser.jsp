<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/edit-user" method="post">
<input type="hidden" name="id" value="${user.id}">
Email : <input type="text" name="email" value="${user.email}"><br>
Password : <input type="password" name="pass" value="${user.pass}"> <br>
<button type="submit">Update Completed</button>


</form>
</body>
</html>
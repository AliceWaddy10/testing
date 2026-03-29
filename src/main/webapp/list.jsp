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
<h3>To do list</h3>
<table>
	<tr>
		<th>No</th>
		<th>Title tuaoijofaefmamm</th>
		<th>Description</th>
		<th>Status</th>
	</tr>
	
	<c:forEach var="task" items="${taskList}" varStatus="st">
		<tr>
			<td>${st.count}</td>
			<td>${task.title}</td>
			<td>${task.description}</td>
			<td>${task.status}</td>
		</tr>
	</c:forEach>
	
</table>
<br>

<a href="addList.jsp">Add List</a>

</body>
</html>
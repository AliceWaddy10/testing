<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="task" method="post">
	<label for="title">Title</label><br>
	<input type="text" name="title" id="title" required="required"><br>
	
	<label for="description">Description ddddddddd</label>
	<input type="text" name="description" id="description">
	
	<input type="hidden" name="action" value="Add">
	<input type="submit" value="Add Task">
</form>
<a href="task?action=List">To do List</a>

</body>
</html>
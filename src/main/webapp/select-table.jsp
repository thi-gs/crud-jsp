<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<title>User Management Table</title>
	<style>
		div{
			text-align: center;
		}
		
		#usersTable{
			margin: auto;
		}
	</style>
	<script>
        function confirmDelete() {
            return confirm("Are you sure you want to delete this user?");
        }
    </script>
</head>

<body>

	<% 
		// Only shows the content if the user has a session
		String user = (String) session.getAttribute("user");
		if(user == null){
			response.sendRedirect("index.jsp");
		} 
	%>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

	<c:if test="${sessionScope.role eq 'admin'}">
	<div>
		<h2>Users table</h2>
		<br/>
		<a href="insert-user.jsp">
			<button type="button" class="btn btn-dark">Create account</button>
		</a>
		<a href="login-success.jsp">
			<button type="button" class="btn btn-primary">Homepage</button>
		</a>
		<br/>
		<br/>
	</div>
	
	<table class="table" id="usersTable">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Username</th>
				<th scope="col">Password</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
			
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.login}" /></td>
					<td><c:out value="${user.password}" /></td>
					<td>
						<a href="edit-user.jsp?login=${user.login}&id=${user.id}">
							<button type="button" class="btn btn-success">Edit</button>
						</a>
						<a href="DeleteServlet?id=${user.id}" onclick="return confirmDelete()">
							<button type="button" class="btn btn-danger">Delete</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
</body>
</html>
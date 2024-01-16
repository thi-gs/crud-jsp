<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<title>Insert title here</title>
		<style>
			.center-div {
		 		text-align: center;
		 	}
		 	.right-div{
		 		text-align: right;
		 	}
		 </style>
	</head>
	<body>
	
		<% 
			// Only shows the content if the user has a session
			String user = (String) session.getAttribute("user");
			if(user == null){
				response.sendRedirect("index.jsp");
			} 
		%>
	
		<div class="right-div">
			<a href="sign-out.jsp">Sign Out</a>
		</div>
		<div class="center-div">
			<h2>Welcome!</h2>
			<c:if test="${sessionScope.role eq 'admin'}">
				<a href="SelectServlet">Users Management</a>
			</c:if>
		</div>
		
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert user</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<style>
			.center-div {
				text-align: center;
			 }
		</style>
	
		<script>
    		function validateForm() {
		    	var user = document.getElementById("login").value.trim();
    	    	var password = document.getElementById("password").value.trim();
        		var repeatPassword = document.getElementById("repeatPassword").value.trim();
	
    	    	if (password !== repeatPassword) {
	    	        alert("'Password' and 'Repeat Password' fields do not match!");
    	    	    return false;
		        }
        
    		    if(user === "" || password === "" || repeatPassword === ""){
        			alert("'Username' or 'Password' or 'Repeat Password' fields are blank!");
            		return false;
	        	}

    	    	return true;
    		}
		</script>
	</head>
	<body>
	<div class="center-div">
		<h2>Account Creation</h2>
		<form action="InsertServlet" method="post" onsubmit="return validateForm()">
			<table class="mx-auto">
				<tr>
					<td>Username:</td>
					<td><input type="text" id="login" name="login"></td>
				</tr>
			
				<tr>
					<td>Password:</td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
			
				<tr>
					<td>Repeat Password:</td>
					<td><input type="password" id="repeatPassword" name="repeatPassword"></td>
				</tr>
			</table>
			<input type="submit" value="Create Account" class="btn btn-success">
			
			<c:choose>
				<c:when test="${sessionScope.role eq 'admin'}">
					<a href="SelectServlet">
						<button type="button" class="btn btn-danger">Cancel</button>
					</a>
				</c:when>
				<c:otherwise>
					<a href="index.jsp">
						<button type="button" class="btn btn-danger">Cancel</button>
					</a>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
	</body>
</html>
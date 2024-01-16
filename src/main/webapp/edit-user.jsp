<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Edit user page</title>

<style>
	.center-div{
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
        	alert("'Password' or 'Repeat Password' fields are blank!");
            return false;
        }

        return true;
    }
</script>

</head>
<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	
	<div class="center-div">
		<h2>User Edit</h2>
	</div>
	<br/>
	<form action="UpdateServlet" method="post" onsubmit="return validateForm()">
	<table class="mx-auto">
		<tr>
			<td>ID:</td>
			<td><input type="text" id="id" name="id" value="${param.id}" readonly style="background-color: #cce5ff;"></td>
		</tr>
	
		<tr>
			<td>Username:</td>
			<td><input type="text" id="login" name="login" value="${param.login}"></td>
		</tr>
		
		<tr>
			<td>Set a new Password:</td>
			<td><input type="password" id="password" name="password"></td>
		</tr>
			
		<tr>
			<td>Repeat the new Password:</td>
			<td><input type="password" id="repeatPassword" name="repeatPassword"></td>
		</tr>
	</table>
	<br/>
	<div class="center-div">
		<input type="submit" value="Update User" class="btn btn-success">
		<a href="SelectServlet">
				<button type="button" class="btn btn-danger">Cancel</button>
		</a>
	</div>
</form>
</body>
</html>
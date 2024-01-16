<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Login Page</title>
		 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		 <style>
		 	.center-div {
		 		text-align: center;
		 	}
		 </style>
	</head>
	<body>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		<div class="center-div">
			<h2>Login Page</h2>
		</div>
		
		<div class="center-div">
			<form action="LoginServlet" method="post">
				<table class="mx-auto">
					<tr>
						<td>Username:</td>
						<td> <input type="text" name="login"></td>
					</tr>
				
					<tr>
						<td>Password:</td>
						<td> <input type="password" name="password"></td>
					</tr>
				</table>			
				<input type="submit" value="Login" class="btn btn-primary">
			</form>
			<br/>
			<a href="insert-user.jsp">Create account</a>
		</div>
	</body>
</html>

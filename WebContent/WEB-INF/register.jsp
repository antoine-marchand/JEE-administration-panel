<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">

<title>Registration</title>
</head>
<body>
	<div id="login-container">
		<h1>Registration</h1>
		<form action="register" method="POST">
			<input type="text" name="firstName" placeholder="First Name" /> <br />
			<input type="text" name="lastName" placeholder="Last Name" /> <br />
			<input type="submit" class="btn" value="Register" />
		</form>
	</div>
</body>
</html>
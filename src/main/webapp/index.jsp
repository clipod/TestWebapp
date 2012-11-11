
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>

<!-- This session attribute "false" helps not to create a session when someone calls this page. If this is not 
provided then a session is created by default -->
<%@ page session="false" %>
</head>
<body>
	<form action="index" method="post">
		<table>
			<tr>
				<td><b>Login</b>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
				<td></td>
			</tr>
		</table>

	</form>
</body>
</html>

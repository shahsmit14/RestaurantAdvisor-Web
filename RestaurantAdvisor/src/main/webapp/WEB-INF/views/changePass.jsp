<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="changePassword">
		<table>
			<tr>
				<th>Password Change Form</th>
			</tr>

			<tr>
				<td>Old password:</td>
				<td><input type="password" name="oldPassword" placeholder="Enter your Current Password" 
				required="required"/></td>
			</tr>
			<tr>
				<td>New password:</td>
				<td><input type="password" name="newPassword" placeholder="Enter your New Password" 
				required="required" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" ></td>
			</tr>
			<tr>
				<td>Re-Enter New password:</td>
				<td><input type="password" name="againPassword" placeholder="Re-Enter your new Password" 
				required="required" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" ></td>
			</tr>

		</table>
		<input type="submit" name="submit" value="Change Password" />
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User2</title>
</head>
<body>
	<h1>PART 2 REGIISTRATION!!!</h1>

	<form action="newUserRegistration3">
		<table>
			<tr>
				<td>FIRSTNAME:</td>
				<td><input type="text" name="firstName" placeholder="Enter your First Name" required="required" 
				pattern=".{4,25}" title="Please enter 4 - 25 characters" ></td>
			</tr>
			<tr>
				<td>LASTNAME:</td>
				<td><input type="text" name="lastName" placeholder="Enter your Last Name" required="required" 
				pattern=".{4,25}" title="Please enter 4 - 25 characters" ></td>
			</tr>
			<tr>
				<td>CONTACT DETAILS:</td>
			</tr>
			<tr>
				<td>MOBILE:</td>
				<td><input type="tel" name="contactNumber" placeholder="Enter your Contact Number" 
				required="required" pattern="[0-9]{10,10}" title="10 digit contact number"></td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td><input type="email" name="email" placeholder="Enter your Email-ID" required="required" ></td>
			</tr>
			<tr>
				<td>DATE OF BIRTH (MM/dd/yyyy):</td>
				<td><input type="text" name="dateOfBirth" placeholder="Birth date" required="required" 
				pattern="\d{1,2}/\d{1,2}/\d{4}" title="Date in format MM/dd/yyy"></td>
			</tr>
			<tr>
				<td>GENDER:</td>
				<td><input type="radio" name="gender" value="MALE" checked>MALE</td>
				<td><input type="radio" name="gender" value="FEMALE">FEMALE</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="NEXT PAGE"></td>
			</tr>
		</table>
	</form>
</body>
</html>
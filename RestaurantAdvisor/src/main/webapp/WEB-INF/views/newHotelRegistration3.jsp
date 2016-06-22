<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel3</title>
</head>
<body>
	<h1>PART 3 REGIISTRATION!!!</h1>

	<form action="newHotelRegistration4">
		<table>
			<tr>
				<td>ADDRESS DETAILS:</td>
			</tr>
			<tr>
				<td>BLOCK NUMBER:</td>
				<td><input type="text" name="blockNumber" placeholder="Your Block Number" required="required" 
				pattern="[0-9]{1,4}" title="Please enter 1 - 4 numeric characters" ></td>
			</tr>
			<tr>
				<td>STREET NAME:</td>
				<td><input type="text" name="street" placeholder="Your Street Name" required="required" 
				pattern=".{4,25}" title="Please enter 4 - 25 characters" ></td>
			</tr>
			<tr>
				<td>CITY NAME:</td>
				<td><input type="text" name="city" placeholder="Your City Name" required="required" 
				pattern=".{4,25}" title="Please enter 4 - 25 characters" ></td>
			</tr>
			<tr>
				<td>STATE NAME:</td>
				<td><input type="text" name="state" placeholder="Your State Name" required="required" 
				pattern=".{2,2}" title="Please enter 2 characters" ></td>
			</tr>
			<tr>
				<td>ZIP CODE:</td>
				<td><input type="text" name="zipCode" placeholder="Your Zip Code" required="required" 
				pattern="[0-9]{5,5}" title="Please enter 5 digit" ></td>
			</tr>
			<tr>
				<td>COUNTRY:</td>
				<td>UNITED STATES OF AMERICA (USA)</td>
				<td><input type="hidden" name="country" value="USA">
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="NEXT PAGE"></td>
			</tr>
		</table>
	</form>
</body>
</html>
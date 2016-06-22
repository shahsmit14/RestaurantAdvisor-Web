<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User4</title>
</head>
<body>
	<h1>LAST PART OF REGIISTRATION!!!</h1>

	<form action="newUserRegistration5">
		<table>
			<tr>
				<td>PAYMENT DETAILS:</td>
			</tr>
			<tr>
				<td>CARD TYPE:</td>
				<td><input type="radio" name="cardType" value="DEBIT" checked>DEBIT</td>
				<td><input type="radio" name="cardType" value="CREDIT">CREDIT</td>
			</tr>
			<tr>
				<td>CARD NUMBER:</td>
				<td><input type="text" name="cardNumber" placeholder="Number of you Card" required="required" 
				pattern="[0-9]{16,16}" title="Please enter 16 digit" ></td>
			</tr>
			<tr>
				<td>CCV NUMBER:</td>
				<td><input type="text" name="ccvNumber" placeholder="CCV Number" required="required" 
				pattern="[0-9]{3,3}" title="Please enter 3 digit number mentioned on back of your card" ></td>
			</tr>
			<tr>
				<td>EXPIRY DATE:</td>
				<td><input type="text" name="expiryDate" placeholder="Expiry date" required="required" 
				pattern="\d{1,2}/\d{1,2}/\d{4}" title="Date in format MM/dd/yyy"></td>
			</tr>
			<tr>
				<td>NAME ON THE CARD:</td>
				<td><input type="text" name="cardName" placeholder="Card Holder Name" required="required" 
				pattern=".{6,25}" title="Please enter 6-25 characters" ></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="REGISTER"></td>
			</tr>
		</table>
	</form>
</body>
</html>
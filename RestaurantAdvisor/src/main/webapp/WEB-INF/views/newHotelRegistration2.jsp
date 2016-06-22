<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel2</title>
</head>
<body>
	<h1>PART 2 REGIISTRATION!!!</h1>

	<form action="newHotelRegistration3">
		<table>
			<tr>
				<td>HOTEL NAME:</td>
				<td><input type="text" name="hotelName" placeholder="Enter your Hotel Name" required="required" 
				pattern=".{4,25}" title="Please enter 4 - 25 characters" ></td>
			</tr>
			<tr>
				<td>TAG LINE:</td>
				<td><input type="text" name="tagLine" placeholder="Enter your Tag Line" required="required" 
				pattern=".{4,25}" title="Please enter 4 - 25 characters"></td>
			</tr>
			<tr>
				<td>DESCRIPTION OF THE HOTEL:</td>
				<td><input type="text" name="description" placeholder="Enter your Tag Line" required="required" 
				pattern=".{10,254}" title="Please enter 10 - 254 characters"></td>
			</tr>
			<tr>
				<td>HOTEL TYPE:</td>
				<td><input type="radio" name="hotelType" value="MULTI-CUISINE" checked>MULTI-CUISINE</td>
				<td><input type="radio" name="hotelType" value="FAST FOOD">FAST FOOD</td>
				<td><input type="radio" name="hotelType" value="RESTO-BAR">RESTO-BAR</td>
			</tr>
			<tr>
				<td>CONTACT DETAILS:</td>
			</tr>
			<tr>
				<td>MOBILE:</td>
				<td><input type="tel" name="hotelMobileContact" placeholder="Enter your Contact Number" required="required" 
				pattern="[0-9]{10,10}" title="10 digit contact number"></td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td><input type="email" name="hotelEmailContact" placeholder="Enter your Email-ID" required="required" ></td>
			</tr>
			<tr>
				<td>AVERAGE COST FOR 2 PERSON:</td>
				<td><input type="text" name="costFor2" placeholder="Average amount for 2 person" required="required" 
				pattern="[0-9]{1,4}" title="Amount should be max 4 digit" ></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="NEXT PAGE"></td>
				
			</tr>
		</table>
	</form>
</body>
</html>
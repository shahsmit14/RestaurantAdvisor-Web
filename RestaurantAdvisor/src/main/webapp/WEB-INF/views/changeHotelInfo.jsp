<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateHotelValue">
		<table>
			<tr>
				<td><b>HOTEL INFORMATION CONTACT:</b></td>
			</tr>

			<tr>
				<td>MOBILE NUMBER:</td>
				<td><input type="text" name="hotelMobileContact"
					value="${hotel.hotelDetails.hotelMobileContact}" required="required" 
				pattern="[0-9]{10,10}" placeholder="10 digit contact number"></td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td><input type="email" name="hotelEmailContact"
					value="${hotel.hotelDetails.hotelEmailContact}" placeholder="Enter your Email-ID" 
					required="required" ></td>
			</tr>

			<tr>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="UPDATE"></td>
			</tr>
		</table>
	</form>
</body>
</html>
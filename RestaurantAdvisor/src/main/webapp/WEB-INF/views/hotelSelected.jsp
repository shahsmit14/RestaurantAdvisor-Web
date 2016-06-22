<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details of ${hotel.hotelDetails.hotelName}</title>
</head>
<body>
	<form method="GET" action="hotelactdeactback">
		<table>
			<tr>
				<td><b>HOTEL INFORMATION:</b></td>
			</tr>
			<tr>
				<td>HOTEL NAME:</td>
				<td>${hotel.hotelDetails.hotelName}</td>
			</tr>
			<tr>
				<td>TAG LINE:</td>
				<td>${hotel.hotelDetails.tagLine}</td>
			</tr>
			<tr>
				<td>DESCRIPTION:</td>
				<td>${hotel.hotelDetails.description}</td>
			</tr>
			<tr>
				<td>HOTEL TYPE:</td>
				<td>${hotel.hotelDetails.hotelType}</td>
			</tr>
			<tr>
				<td>COST FOR 2:</td>
				<td>${hotel.hotelDetails.costFor2}</td>
			</tr>
			<tr>
				<td>AVERAGE RATING:</td>
				<td>${hotel.hotelDetails.averageRating}</td>
			</tr>
			<tr>
				<td>MOBILE NUMBER:</td>
				<td>${hotel.hotelDetails.hotelMobileContact}</td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td>${hotel.hotelDetails.hotelEmailContact}</td>
			</tr>

			<tr>
			</tr>

			<tr>
				<td><b>SITE DETAILS:</b></td>
			</tr>
			<tr>
				<td>USERNAME:</td>
				<td>${hotel.userName}</td>
			</tr>
			<tr>
				<td>STATUS:</td>
				<td>${hotel.status}</td>
			</tr>

			<tr>
			</tr>

			<tr>
				<td><b>ADDRESS INFORMATION:</b></td>
			</tr>
			<tr>
				<td>BLOCK NO.:</td>
				<td>${hotel.addressDetails.blockNumber}</td>
				<td>STREET:</td>
				<td>${hotel.addressDetails.street}</td>
			</tr>
			<tr>
				<td>CITY:</td>
				<td>${hotel.addressDetails.city}</td>
				<td>ZIP CODE:</td>
				<td>${hotel.addressDetails.zipCode}</td>
			</tr>
			<tr>
				<td>STATE:</td>
				<td>${hotel.addressDetails.state}</td>
				<td>COUNTRY:</td>
				<td>${hotel.addressDetails.country}</td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" name="HotelStatusChange"
					value="ACTIVE"></td>
				<td><input type="submit" name="HotelStatusChange"
					value="DE-ACTIVE"></td>
				<td><input type="submit" name="HotelStatusChange" value="BACK"></td>
			</tr>
		</table>
	</form>
</body>
</html>

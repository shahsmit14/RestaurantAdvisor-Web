<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details of ${user.userDetails.firstName}</title>
</head>
<body>
	<form method="GET" action="useractdeactback">
		<table>
			<tr>
				<td><b>USER INFORMATION:</b></td>
			</tr>
			<tr>
				<td>FIRST NAME:</td>
				<td>${user.userDetails.firstName}</td>
			</tr>
			<tr>
				<td>LAST NAME:</td>
				<td>${user.userDetails.lastName}</td>
			</tr>
			<tr>
				<td>GENDER:</td>
				<td>${user.userDetails.gender}</td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td>${user.userDetails.dateOfBirth}</td>
			</tr>
			<tr>
				<td>MOBILE NUMBER:</td>
				<td>${user.userDetails.contactNumber}</td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td>${user.userDetails.email}</td>
			</tr>

			<tr>
			</tr>

			<tr>
				<td><b>SITE DETAILS:</b></td>
			</tr>
			<tr>
				<td>USERNAME:</td>
				<td>${user.userName}</td>
			</tr>
			<tr>
				<td>STATUS:</td>
				<td>${user.status}</td>
			</tr>

			<tr>
			</tr>

			<tr>
				<td><b>ADDRESS INFORMATION:</b></td>
			</tr>
			<tr>
				<td>BLOCK NO.:</td>
				<td>${user.addressDetails.blockNumber}</td>
				<td>STREET:</td>
				<td>${user.addressDetails.street}</td>
			</tr>
			<tr>
				<td>CITY:</td>
				<td>${user.addressDetails.city}</td>
				<td>ZIP CODE:</td>
				<td>${user.addressDetails.zipCode}</td>
			</tr>
			<tr>
				<td>STATE:</td>
				<td>${user.addressDetails.state}</td>
				<td>COUNTRY:</td>
				<td>${user.addressDetails.country}</td>
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
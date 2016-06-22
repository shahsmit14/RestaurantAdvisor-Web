<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="searchByHotelname" method="get">
		<table>
			<tr>
				<td>ENTER THE NAME OF THE HOTEL YOU WANT TO LOOKUP:</td>
			</tr>
			<tr>
				<td><input type="text" name="searchByName" required="required" pattern="[a-zA-Z0-9 ]{1,25}" 
					placeholder="Enter name to search" title="Please enter character and numbers only"></td>
			</tr>
			<tr>
				<td><input type="submit" name="SEARCH BY NAME"
					value="SEARCH BY NAME"></td>
			</tr>
		</table>
	</form>


	<form action="searchByHoteltype" method="get">
		<table>
			<tr>
				<td>CHOOSE THE TYPE OF HOTEL:</td>
			</tr>
			<tr>
				<td><input type="radio" name="hotelType" value="MULTI-CUISINE">MULTI-CUISINE</td>
				<td><input type="radio" name="hotelType" value="FAST FOOD">FAST
					FOOD</td>
				<td><input type="radio" name="hotelType" value="RESTO-BAR"
					checked>RESTO-BAR</td>
			</tr>
			<tr>
				<td><input type="submit" name="SEARCH BY TYPE"
					value="SEARCH BY TYPE"></td>
			</tr>
		</table>
	</form>

</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FOUND ${hListSize} HOTELS.</h1>

	<form>
		<table>
			<tr>
				<th>HOTEL NAME</th>
				<th>TAG LINE</th>
				<th>DESCRIPTION</th>
				<th>TYPE</th>
				<th>COST FOR 2</th>
				<th>AVERAGE RATING</th>
				<th>MOBILE</th>
				<th>EMAIL</th>
				<th>MENU LIST</th>
				<th>REVIEWS</th>
			</tr>
			<c:forEach var="row" items="${requestScope.hList}">
				<tr>
					<td><input type="text" readonly="readonly" name="hotelName"
						value="${row.hotelName}" /></td>

					<td><input type="text" readonly="readonly" name="tagLine"
						value="${row.tagLine}" /></td>

					<td><input type="text" readonly="readonly" name="description"
						value="${row.description}" /></td>

					<td><input type="text" readonly="readonly" name="hotelType"
						value="${row.hotelType}" /></td>

					<td><input type="text" readonly="readonly" name="costFor2"
						value="${row.costFor2}" /></td>

					<td><input type="text" readonly="readonly"
						name="averageRating" value="${row.averageRating}" /></td>

					<td><input type="text" readonly="readonly"
						name="hotelMobileContact" value="${row.hotelMobileContact}" /></td>

					<td><input type="text" readonly="readonly"
						name="hotelEmailContact" value="${row.hotelEmailContact}" /></td>

					<td><a
						href="hotelSelectedMenuItem?selectedHotelMenu=${row.userID}">Menu
							Items</a></td>

					<td><a
						href="hotelSelectedReview?selectedHotelReview=${row.userID}">View
							All Reviews</a></td>

					<td><a href="hotelAddReview?selectedHotelReview=${row.userID}">Add
							a Review</a></td>

					<td><a href="GoogleMaps?selectedHotel=${row.userID}"> Check on Google Maps </a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>
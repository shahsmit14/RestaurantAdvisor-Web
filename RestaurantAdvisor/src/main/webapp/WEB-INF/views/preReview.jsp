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
	<h1>THERE ARE A TOTAL OF ${reviewListSize} GIVEN BY YOU!!!</h1>
	<table>
		<tr>
			<th>HOTEL</th>
			<th>HEADLINE</th>
			<th>DESCRIPTION</th>
			<th>RATING</th>
			<th>DATE-TIME</th>
		</tr>

		<c:forEach var="row" items="${requestScope.reviewList}">
			<tr>
				<td><input type="text" readonly="readonly" name="REVIEWER"
					value="${row.reviewedLoginDetails.hotelDetails.hotelName} " /></td>

				<td><input type="text" readonly="readonly" name="HEADLINE"
					value="${row.reviewHeadline}" /></td>

				<td><input type="text" readonly="readonly" name="DESCRIPTION"
					value="${row.reviewDescription}" /></td>

				<td><input type="text" readonly="readonly" name="RATING"
					value="${row.rating}" /></td>

				<td><input type="text" readonly="readonly" name="DATE-TIME"
					value="${row.ratingTimeStamp}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
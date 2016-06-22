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
	<h1>THERE ARE A TOTAL OF ${reviewListSize} REVIEW'S FOR THIS HOTEL</h1>

	<table>
		<tr>
			<th>HEADLINE</th>
			<th>DESCRIPTION</th>
			<th>RATINGS</th>
		</tr>
		<c:forEach var="row" items="${requestScope.ReviewList}">
			<tr>
				<td><input type="text" readonly="readonly"
					name="reviewHeadline" value="${row.reviewHeadline}" /></td>

				<td><input type="text" readonly="readonly"
					name="reviewDescription" value="${row.reviewDescription}" /></td>

				<td><input type="text" readonly="readonly" name="rating"
					value="${row.rating}" /></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
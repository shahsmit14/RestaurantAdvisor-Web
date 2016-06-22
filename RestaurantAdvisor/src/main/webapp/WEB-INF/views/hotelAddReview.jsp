<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Review Page. 


	<form action="submitHotelReview">

		<input type="hidden" name="selectedHotelReview"
			value="${requestScope.hotelID}">
		<table>

			<tr>
				<td>Review Headline:</td>
				<td><input type="text" name="reviewHeadline" required="required" pattern=".{6,25}" 
					placeholder="Enter a review title" title="Please enter minimum 6 characters"></td>
			</tr>

			<tr>
				<td>Review Description:</td>
				<td><input type="text" name="reviewDescription" required="required" pattern=".{15,254}" 
					placeholder="Enter review description" title="Please enter 15 - 254 characters"></td>
			</tr>

			<tr>
				<td>Rating:</td>
				<td><input type="text" name="rating" required="required" pattern="[1-5]{1}" 
					placeholder="Rating for the hotel" title="Please enter rating in a scale of 1 to 5 only. e.g 4"></td>
			</tr>

			<tr>
				<td><input type="submit" name="Submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
package com.restaurantadvisor.website.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.restaurantadvisor.website.model.AddressDetails;
import com.restaurantadvisor.website.model.HotelDetails;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.MenuDetails;
import com.restaurantadvisor.website.model.OrderDetails;
import com.restaurantadvisor.website.model.OrderTransaction;
import com.restaurantadvisor.website.model.UserReviews;

public class CustomerFunctionalityDAO extends DAO {

	public void updateCustomerInfo(LoginDetails loginDetails) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.update(loginDetails);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			throw new Exception("Could not get user " + e.getMessage());
		}
	}

	public List<UserReviews> fetchHotelReviewByMe(String uID) throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from UserReviews where reviewerLoginDetails = :userID");
			q.setString("userID", uID);
			List<UserReviews> userReviews = q.list();
			session.close();
			return userReviews;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public List<OrderTransaction> fetchPreviousOrdersCust(String uID)
			throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from OrderTransaction where CustomerUserID = :custuserID");
			q.setString("custuserID", uID);
			List<OrderTransaction> orderTransactions = q.list();
			session.close();
			return orderTransactions;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public List<OrderDetails> fetchOrderDetailsCust(String orderID)
			throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from OrderDetails where OrderId = :orderID");
			q.setString("orderID", orderID);
			List<OrderDetails> orderDetails = q.list();
			session.close();
			return orderDetails;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}

	}

	public List<HotelDetails> searchByNameHotel(String hotelName)
			throws Exception {
		try {

			Session session = getSession();

			String query = "from HotelDetails hd where hd.hotelName like '%"
					+ hotelName + "%'";
			Query q = session.createQuery(query);

			List<HotelDetails> hotelDetails = q.list();

			session.close();
			return hotelDetails;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public List<HotelDetails> searchHotelByTypeHotel(String name)
			throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from HotelDetails where hotelType = :name");
			q.setParameter("name", name);

			List<HotelDetails> hotelDetails = q.list();
			session.close();
			return hotelDetails;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public List<MenuDetails> findSelectedHotelMenu(String userID)
			throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from MenuDetails where UserID = :userID AND Status= :status");
			q.setString("userID", userID);
			q.setString("status", "AVAILABLE");
			List<MenuDetails> menuDetails = q.list();
			session.close();
			return menuDetails;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public List<UserReviews> findHotelReviews(String userID) throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from UserReviews where reviewedUserId = :userID");
			q.setString("userID", userID);
			List<UserReviews> userReviews = q.list();
			session.close();
			return userReviews;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public LoginDetails hotelOrderDetails(String userID) throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from LoginDetails where UserID = :userID");
			q.setString("userID", userID);
			LoginDetails loginDetails = (LoginDetails) q.uniqueResult();
			session.close();
			return loginDetails;
		} catch (HibernateException he) {
			throw new Exception("Could not find the Hotel Details"
					+ he.getMessage());
		}
	}

	public OrderTransaction addOrderTransaction1(
			OrderTransaction orderTransaction1) throws Exception {

		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(orderTransaction1);
			tx.commit();
			session.close();

			// To fetch the orderid
			Session session1 = getSession();
			Query query = session1
					.createQuery("from OrderTransaction order by orderID DESC");
			query.setMaxResults(1);
			OrderTransaction orderTransaction2 = (OrderTransaction) query
					.uniqueResult();
			session1.close();

			return orderTransaction2;

		} catch (HibernateException e) {
			throw new Exception("Could not save " + e.getMessage());
		}
	}

	public MenuDetails fetchMenuDetails(String menuID) throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from MenuDetails where MenuDetailsId = :menuID");
			q.setString("menuID", menuID);
			MenuDetails menuDetails = (MenuDetails) q.uniqueResult();
			session.close();
			return menuDetails;
		} catch (HibernateException he) {
			throw new Exception("Could not find the Menu Details"
					+ he.getMessage());
		}
	}

	public void addOrderTransaction2(OrderDetails orderDetails)
			throws Exception {

		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(orderDetails);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			throw new Exception("Could not save " + e.getMessage());
		}
	}

	public void addOrderTransaction3(OrderTransaction orderTransaction)
			throws Exception {

		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.update(orderTransaction);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			throw new Exception("Could not save " + e.getMessage());
		}
	}

	public void addHotelReview(HttpSession httpSession, String hotelID,
			UserReviews userReviews) throws Exception {

		LoginDetails loginDetailsReviewer = (LoginDetails) httpSession
				.getAttribute("loginDetails");

		try {
			// Fetch Hotel Login details
			Session session = getSession();
			Query q = session
					.createQuery("from LoginDetails where UserID = :hotelID");
			q.setString("hotelID", hotelID);
			LoginDetails loginDetailsReviewed = (LoginDetails) q.uniqueResult();

			userReviews.setRatingTimeStamp(new Date());
			userReviews.setReviewerLoginDetails(loginDetailsReviewer);
			userReviews.setReviewedLoginDetails(loginDetailsReviewed);

			Transaction tx = null;

			// Session session = getSession();
			tx = session.beginTransaction();
			session.save(userReviews);
			tx.commit();
			session.close();
			
			updateAverageHotelRating(hotelID);

		} catch (HibernateException e) {
			throw new Exception("Could not save " + e.getMessage());
		}
	}
	
	public void updateAverageHotelRating (String hotelID) {
		
		try {
			// Fetch Hotel Login details
			Session session = getSession();
			Query q1 = session
					.createQuery("from HotelDetails where UserID = :hotelID");
			q1.setString("hotelID", hotelID);
			HotelDetails hotelDetails = (HotelDetails) q1.uniqueResult();
			
			
			//Fetch All the Reviews of the hotel
			Query q2 = session
					.createQuery("from UserReviews where ReviewedUserID = :hotelID");
			q2.setString("hotelID", hotelID);
			List<UserReviews> userReviews = q2.list();
			
			int count = userReviews.size();
			float totalRating = 0.0f;
			float finalAverageRating = 0.0f;

			for (UserReviews ur: userReviews) {				
				totalRating = totalRating + ur.getRating();				
			}
			
			finalAverageRating = totalRating/count;			
			hotelDetails.setAverageRating(finalAverageRating);
			
			Transaction tx = null;

			// Session session = getSession();
			tx = session.beginTransaction();
			session.update(hotelDetails);
			tx.commit();
			session.close();
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public AddressDetails hotelAddressMaps(String userID) throws Exception {
		try {
			String hotelID = userID;
			Session session = getSession();
			Query q = session
					.createQuery("from AddressDetails where UserID = :hotelID");
			q.setString("hotelID", hotelID);
			AddressDetails addressDetails = (AddressDetails) q.uniqueResult();
			session.close();
			return addressDetails;
		} catch (HibernateException he) {
			throw new Exception("Could not find the Hotel Details"
					+ he.getMessage());
		}
	}

}

package com.restaurantadvisor.website.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.MenuDetails;
import com.restaurantadvisor.website.model.OrderDetails;
import com.restaurantadvisor.website.model.OrderTransaction;
import com.restaurantadvisor.website.model.UserReviews;

public class HotelFunctilnalityDAO extends DAO {
	public List<MenuDetails> menuListOfHotel(String ID) throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from MenuDetails where UserID = :userID");
			q.setString("userID", ID);
			List<MenuDetails> menuDetails = q.list();
			session.close();
			return menuDetails;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public MenuDetails selectMenuItem(String MID) throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from MenuDetails where MenuDetailsId = :MID");
			q.setString("MID", MID);
			MenuDetails menuDetails = (MenuDetails) q.uniqueResult();
			session.close();
			return menuDetails;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public void updateItemStatus(MenuDetails menuDetails) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.update(menuDetails);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			throw new Exception("Could not get user " + e.getMessage());
		}
	}

	public void addItemToMenu(MenuDetails menuDetails, LoginDetails loginDetails)
			throws Exception {
		try {
			Session session = getSession();

			Transaction tx = null;
			tx = session.beginTransaction();

			menuDetails.setLoginDetails(loginDetails);
			// loginDetails.setMenuDetails(menuDetails);
			System.out.println(menuDetails.getLoginDetails().getUserName());

			session.save(menuDetails);

			tx.commit();
			session.close();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
	}

	public List<OrderTransaction> fetchPreviousOrders(String uID)
			throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from OrderTransaction where HotelUserID = :hoteluserID");
			q.setString("hoteluserID", uID);
			List<OrderTransaction> orderTransactions = q.list();
			session.close();
			return orderTransactions;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public List<OrderDetails> fetchOrderDetails(String orderID)
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

	public List<UserReviews> fetchHotelReview(String uID) throws Exception {
		try {
			Session session = getSession();
			Query q = session
					.createQuery("from UserReviews where reviewedLoginDetails = :userID");
			q.setString("userID", uID);
			List<UserReviews> userReviews = q.list();
			session.close();
			return userReviews;
		} catch (HibernateException he) {
			throw new Exception("Exception" + he.getMessage());
		}
	}

	public void updateHotelInfo(LoginDetails loginDetails) throws Exception {
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
}

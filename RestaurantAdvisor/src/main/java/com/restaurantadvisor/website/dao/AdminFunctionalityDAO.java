package com.restaurantadvisor.website.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.restaurantadvisor.website.model.AddressDetails;
import com.restaurantadvisor.website.model.HotelDetails;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.PaymentDetails;
import com.restaurantadvisor.website.model.UserDetails;
import com.restaurantadvisor.website.model.UserRole;

public class AdminFunctionalityDAO extends DAO {

	public List<HotelDetails> selectAllHotels() {

		try {
			// begin()
			Session session = getSession();
			Query q = session.createQuery("from HotelDetails");
			List<HotelDetails> hDetails = q.list();
			session.close();
			return hDetails;
		} catch (HibernateException he) {
			System.out.println("Exception" + he.getMessage());
		}
		return null;
	}

	public List<LoginDetails> selectAllAdministrator() {

		try {
			// begin()
			Session session = getSession();

			Query q = session.createQuery("from LoginDetails where roleid = 1");
			List<LoginDetails> lDetails = q.list();
			session.close();
			return lDetails;
		} catch (HibernateException he) {
			System.out.println("Exception" + he.getMessage());
		}
		return null;
	}

	public void updateStatus(LoginDetails ld) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.update(ld);
			tx.commit();
			session.close();
		} catch (HibernateException he) {
			throw new Exception("Could not find the User Details"
					+ he.getMessage());
		}
	}

	// To add new Admin
	public Boolean registerAdminDetails(HttpSession sessionPassed) {

		UserRole userRole = null;

		try {

			Session session = getSession();

			Query q1 = session
					.createQuery("from UserRole where RoleType = :RoleType");
			q1.setString("RoleType", "ADMIN");

			userRole = (UserRole) q1.uniqueResult();

			if (userRole == null) {

				Transaction tx = session.beginTransaction();
				UserRole userRoleAdd = new UserRole();
				userRoleAdd.setRoleType("ADMIN");
				session.save(userRoleAdd);
				tx.commit();

				Query q2 = session
						.createQuery("from UserRole where RoleType = :RoleType");
				q2.setString("RoleType", "ADMIN");
				userRole = (UserRole) q2.uniqueResult();
			}

			session.beginTransaction();

			LoginDetails loginDetails = (LoginDetails) sessionPassed
					.getAttribute("loginDetails");
			UserDetails userDetails = (UserDetails) sessionPassed
					.getAttribute("userDetails");

			loginDetails.setUserRole(userRole);

			loginDetails.setUserDetails(userDetails);

			userDetails.setLoginDetails(loginDetails);

			session.save(loginDetails);

			session.getTransaction().commit();
			session.close();

			return true;

		} catch (HibernateException exe) {

			exe.printStackTrace();
			return false;
		}
	}

	public List<LoginDetails> selectAllUsers() throws Exception {

		try {
			// begin()
			Session session = getSession();
			Query q = session.createQuery(
					"from LoginDetails where RoleID = 2");
			List<LoginDetails> lDetails = q.list();
			session.close();
			return lDetails;
		} catch (HibernateException he) {
			throw new Exception("Could not find the UserList" + he.getMessage());
		}
	}

	public LoginDetails selectedHotel(String userID) throws Exception {
		try {
			Session session = getSession();
			Query q = session.createQuery(
					"from LoginDetails where UserID = :userID");
			q.setString("userID", userID);
			LoginDetails loginDetails = (LoginDetails) q.uniqueResult();
			session.close();
			return loginDetails;
		} catch (HibernateException he) {
			throw new Exception("Could not find the Hotel Details"
					+ he.getMessage());
		}
	}

	public LoginDetails selectedUser(String userID) throws Exception {
		try {
			Session session = getSession();
			Query q = session.createQuery(
					"from LoginDetails where UserID = :userID");
			q.setString("userID", userID);
			LoginDetails loginDetails = (LoginDetails) q.uniqueResult();
			session.close();
			return loginDetails;
		} catch (HibernateException he) {
			throw new Exception("Could not find the Hotel Details"
					+ he.getMessage());
		}
	}

	public void updatePasswordForUserName(LoginDetails loginDetails)
			throws Exception {
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

package com.restaurantadvisor.website.dao;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.restaurantadvisor.website.model.AddressDetails;
import com.restaurantadvisor.website.model.HotelDetails;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.PaymentDetails;
import com.restaurantadvisor.website.model.UserRole;

public class HotelRegisterationDAO extends DAO {

	// To save user infromation
	public Boolean registerHotelDetails(HttpSession sessionPassed) {

		UserRole userRole = null;

		try {

			Session session = getSession();

			Query q1 = session.createQuery(
					"from UserRole where RoleType = :RoleType");
			q1.setString("RoleType", "HOTEL");

			userRole = (UserRole) q1.uniqueResult();

			if (userRole == null) {

				Transaction tx = session.beginTransaction();
				UserRole userRoleAdd = new UserRole();
				userRoleAdd.setRoleType("HOTEL");
				session.save(userRoleAdd);
				tx.commit();

				Query q2 = session.createQuery(
						"from UserRole where RoleType = :RoleType");
				q2.setString("RoleType", "HOTEL");
				userRole = (UserRole) q2.uniqueResult();
			}

			session.beginTransaction();

			LoginDetails loginDetails = (LoginDetails) sessionPassed
					.getAttribute("loginDetails");
			
			HotelDetails hotelDetails = (HotelDetails) sessionPassed
					.getAttribute("hotelDetails");			
			AddressDetails addressDetails = (AddressDetails) sessionPassed
					.getAttribute("addressDetails");
			PaymentDetails paymentDetails = (PaymentDetails) sessionPassed
					.getAttribute("paymentDetails");

			loginDetails.setUserRole(userRole);

			loginDetails.setHotelDetails(hotelDetails);
			loginDetails.setAddressDetails(addressDetails);
			loginDetails.setPaymentDetails(paymentDetails);

			hotelDetails.setLoginDetails(loginDetails);
			addressDetails.setLoginDetails(loginDetails);
			paymentDetails.setLoginDetails(loginDetails);

			session.save(loginDetails);

			session.getTransaction().commit();
			session.close();

			return true;

		} catch (HibernateException exe) {

			exe.printStackTrace();
			return false;
		}
	}
}

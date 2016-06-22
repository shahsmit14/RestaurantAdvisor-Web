package com.restaurantadvisor.website.dao;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.restaurantadvisor.website.model.AddressDetails;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.PaymentDetails;
import com.restaurantadvisor.website.model.UserDetails;
import com.restaurantadvisor.website.model.UserRole;

public class UserRegisterationDAO extends DAO {

	// To check username exists
	public Boolean searchUserByUserName(String userName) throws Exception {

		try {

			Session session = getSession();
			Query q = session.createQuery(
					"from LoginDetails where UserName = :username");
			q.setString("username", userName);

			LoginDetails loginDetail = (LoginDetails) q.uniqueResult();

			if (loginDetail != null) {
				return true;
			}
			
			session.close();
			
			return false;
		} catch (HibernateException exe) {
			throw new Exception("Coould not get the user " + userName, exe);
		}
	}

	// To save user infromation
	public Boolean registerUserDetails(HttpSession sessionPassed) {

		UserRole userRole = null;

		try {

			Session session = getSession();

			Query q1 = session.createQuery(
					"from UserRole where RoleType = :RoleType");
			q1.setString("RoleType", "CUSTOMER");

			userRole = (UserRole) q1.uniqueResult();

			if (userRole == null) {

				Transaction tx = session.beginTransaction();
				UserRole userRoleAdd = new UserRole();
				userRoleAdd.setRoleType("CUSTOMER");
				session.save(userRoleAdd);
				tx.commit();

				Query q2 = session.createQuery(
						"from UserRole where RoleType = :RoleType");
				q2.setString("RoleType", "CUSTOMER");
				userRole = (UserRole) q2.uniqueResult();
			}

			session.beginTransaction();

			LoginDetails loginDetails = (LoginDetails) sessionPassed
					.getAttribute("loginDetails");			
			UserDetails userDetails = (UserDetails) sessionPassed
					.getAttribute("userDetails");
			AddressDetails addressDetails = (AddressDetails) sessionPassed
					.getAttribute("addressDetails");
			PaymentDetails paymentDetails = (PaymentDetails) sessionPassed
					.getAttribute("paymentDetails");

			loginDetails.setUserRole(userRole);

			loginDetails.setUserDetails(userDetails);
			loginDetails.setAddressDetails(addressDetails);
			loginDetails.setPaymentDetails(paymentDetails);

			userDetails.setLoginDetails(loginDetails);
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

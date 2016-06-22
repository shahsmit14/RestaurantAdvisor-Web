package com.restaurantadvisor.website.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.restaurantadvisor.website.model.LoginDetails;

public class LoginDetailsDAO extends DAO {

	// To fetch user from DB based on value from cookies
	public LoginDetails selectUserByUserName(String userName) throws Exception {

		try {
			Session session = getSession();
			Query q = session.createQuery(
					"from LoginDetails where UserName = :userName");
			q.setString("userName", userName);
			LoginDetails loginDetails = (LoginDetails) q.uniqueResult();
			session.close();
			return loginDetails;
		} catch (HibernateException exe) {

			throw new Exception("Could not find the user" + exe.getMessage());
		}
	}

	// To fetch user from DB based on value entered in login page
	public LoginDetails selectUserByUserNameAndPassword(String userName,
			String password) throws Exception {
		try {
			// begin();
			Session session = getSession();
			Query q = session
					.createQuery(
							"from LoginDetails where userName = :userName and password = :password");
			q.setString("userName", userName);
			q.setString("password", password);
			LoginDetails loginDetails = (LoginDetails) q.uniqueResult();
			session.close();
			// commit();
			return loginDetails;
		} catch (HibernateException exe) {
			// rollback();
			throw new Exception("Could not get user " + userName, exe);
		}
	}

}

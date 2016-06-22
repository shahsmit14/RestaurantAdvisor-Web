package com.restaurantadvisor.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.restaurantadvisor.website.dao.EmailHelper;
import com.restaurantadvisor.website.dao.Encryption;
import com.restaurantadvisor.website.dao.HibernateUtilDAO;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.OrderTransaction;
import com.restaurantadvisor.website.model.UserDetails;
import com.restaurantadvisor.website.model.UserRole;

public class test {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EmailHelper.sendMail("shahsmit14@gmail.com", "Test 1234");
		
		Session session = HibernateUtilDAO.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		UserRole userRole = new UserRole();
		userRole.setRoleType("ADMIN");

		LoginDetails loginDetails = new LoginDetails();

		loginDetails.setUserName("Admin123");
		//loginDetails.setPassword("Admin123");
		try {
			loginDetails.setPassword(Encryption.encrypt("Admin123"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginDetails.setStatus("ACTIVE");
		loginDetails.setUserRole(userRole);

		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName("Smit");
		userDetails.setLastName("Shah");
		userDetails.setGender("Male");
		userDetails.setEmail("smitshah14@gmail.com");
		userDetails.setDateOfBirth("14-06-1990");
		userDetails.setContactNumber("15975320");

		loginDetails.setUserDetails(userDetails);
		userDetails.setLoginDetails(loginDetails);

		session.save(userRole);
		session.save(userDetails);
		session.save(loginDetails);

		session.getTransaction().commit();
		session.close();
		
	}
}

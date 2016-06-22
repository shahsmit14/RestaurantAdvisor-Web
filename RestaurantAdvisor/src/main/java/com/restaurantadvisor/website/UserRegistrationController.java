package com.restaurantadvisor.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurantadvisor.website.dao.EmailHelper;
import com.restaurantadvisor.website.dao.Encryption;
import com.restaurantadvisor.website.dao.UserRegisterationDAO;
import com.restaurantadvisor.website.model.AddressDetails;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.PaymentDetails;
import com.restaurantadvisor.website.model.UserDetails;

@Controller
public class UserRegistrationController {

	@Autowired
	private UserRegisterationDAO neuUserRegisterationDAO;

	private static final Logger logger = LoggerFactory
			.getLogger(UserRegistrationController.class);

	@RequestMapping(value = "/newUserRegistration1")
	public String newUserRegistration1(Model model, HttpServletRequest request,
			HttpSession session) {

		LoginDetails loginDetails = new LoginDetails();
		model.addAttribute("loginDetails", loginDetails);

		return "newUserRegistration1";
	}

	@RequestMapping(value = "/newUserRegistration2", method = RequestMethod.POST)
	public String newUserRegistration2(Model model, HttpServletRequest request,
			HttpSession session, LoginDetails loginDetails,
			UserDetails userDetails, AddressDetails addressDetails,
			PaymentDetails paymentDetails) {

		Boolean isPresent = false;
		try {
			isPresent = neuUserRegisterationDAO
					.searchUserByUserName(loginDetails.getUserName());
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		if (isPresent) {
			return "newUserRegistration1";
		} else {

			try {
				System.out.println(loginDetails.getPassword());
				String encryptedUserPassword = (String) Encryption.encrypt(loginDetails.getPassword());
				loginDetails.setPassword(encryptedUserPassword);
				System.out.println(loginDetails.getPassword());
				session.setAttribute("loginDetails", loginDetails);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "newUserRegistration2";
		}
	}

	@RequestMapping(value = "/newUserRegistration3")
	public String newUserRegistration3(Model model, HttpServletRequest request,
			HttpSession session, LoginDetails loginDetails,
			UserDetails userDetails, AddressDetails addressDetails,
			PaymentDetails paymentDetails) {

		session.setAttribute("userDetails", userDetails);

		return "newUserRegistration3";
	}

	@RequestMapping(value = "/newUserRegistration4")
	public String newUserRegistration4(Model model, HttpServletRequest request,
			HttpSession session, LoginDetails loginDetails,
			UserDetails userDetails, AddressDetails addressDetails,
			PaymentDetails paymentDetails) {

		session.setAttribute("addressDetails", addressDetails);

		return "newUserRegistration4";
	}

	@RequestMapping(value = "/newUserRegistration5")
	public String newUserRegistration5(Model model, HttpServletRequest request,
			HttpSession session, LoginDetails loginDetails,
			UserDetails userDetails, AddressDetails addressDetails,
			PaymentDetails paymentDetails) {

		session.setAttribute("paymentDetails", paymentDetails);

		Boolean isSuccess = neuUserRegisterationDAO
				.registerUserDetails(session);
		
		//Send Email
		UserDetails userDetailsForEmail = (UserDetails) session.getAttribute("userDetails");
		String userEmailID = userDetailsForEmail.getEmail();
		String message = "Hello " + userDetailsForEmail.getFirstName() + ", \n \n " + 
		"Thank you for registering with Restaurant Advisor. "
		+ "Hope you will enjoy the website and will get usefult information. \n" + 
				"Please reach back to us with any queries. \n \n \n " + 
		"Regards, \n Smit Shah \n CEO Restaurant Adisor.";
		EmailHelper.sendMail(userEmailID, message);
		
		model.addAttribute("userName", userDetailsForEmail.getFirstName());
		
		return "newUserReg5";
	}
}

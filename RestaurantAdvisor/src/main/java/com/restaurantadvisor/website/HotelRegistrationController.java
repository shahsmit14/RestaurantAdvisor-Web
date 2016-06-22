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
import com.restaurantadvisor.website.dao.HotelRegisterationDAO;
import com.restaurantadvisor.website.model.AddressDetails;
import com.restaurantadvisor.website.model.HotelDetails;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.PaymentDetails;
import com.restaurantadvisor.website.model.UserDetails;

@Controller
public class HotelRegistrationController {

	@Autowired
	private UserRegisterationDAO neuUserRegisterationDAO;

	@Autowired
	private HotelRegisterationDAO newHotelRegisterationDAO;

	private static final Logger logger = LoggerFactory
			.getLogger(HotelRegistrationController.class);

	@RequestMapping(value = "/newHotelRegistration1")
	public String newHotelRegisteration1(Model model,
			HttpServletRequest request, HttpSession session) {

		LoginDetails loginDetails = new LoginDetails();
		model.addAttribute("loginDetails", loginDetails);

		return "newHotelRegistration1";
	}

	@RequestMapping(value = "/newHotelRegistration2", method = RequestMethod.POST)
	public String newHotelRegisteration2(Model model,
			HttpServletRequest request, HttpSession session,
			LoginDetails loginDetails, AddressDetails addressDetails,
			PaymentDetails paymentDetails, HotelDetails hotelDetails) {
		// return "newHotelRegistration2";

		Boolean isPresent = false;
		try {
			isPresent = neuUserRegisterationDAO
					.searchUserByUserName(loginDetails.getUserName());
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		if (isPresent) {
			return "newHotelRegistration1";
		} else {

			try {
				System.out.println(loginDetails.getPassword());
				String encryptedUserPassword = (String) Encryption
						.encrypt(loginDetails.getPassword());
				loginDetails.setPassword(encryptedUserPassword);
				System.out.println(loginDetails.getPassword());
				session.setAttribute("loginDetails", loginDetails);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "newHotelRegistration2";
		}
	}

	@RequestMapping(value = "/newHotelRegistration3")
	public String newHotelRegisteration3(Model model,
			HttpServletRequest request, HttpSession session,
			LoginDetails loginDetails, AddressDetails addressDetails,
			PaymentDetails paymentDetails, HotelDetails hotelDetails) {

		session.setAttribute("hotelDetails", hotelDetails);
		return "newHotelRegistration3";
	}

	@RequestMapping(value = "/newHotelRegistration4")
	public String newHotelRegisteration4(Model model,
			HttpServletRequest request, HttpSession session,
			LoginDetails loginDetails, AddressDetails addressDetails,
			PaymentDetails paymentDetails, HotelDetails hotelDetails) {

		session.setAttribute("addressDetails", addressDetails);
		return "newHotelRegistration4";
	}

	@RequestMapping(value = "/newHotelRegistration5")
	public String newHotelRegisteration5(Model model,
			HttpServletRequest request, HttpSession session,
			LoginDetails loginDetails, AddressDetails addressDetails,
			PaymentDetails paymentDetails, HotelDetails hotelDetails) {

		session.setAttribute("paymentDetails", paymentDetails);

		Boolean isSuccess = newHotelRegisterationDAO
				.registerHotelDetails(session);

		// Send Email
		HotelDetails hotelDetailsForEmail = (HotelDetails) session
				.getAttribute("hotelDetails");
		String userEmailID = hotelDetailsForEmail.getHotelEmailContact();
		String message = "Hello "
				+ hotelDetailsForEmail.getHotelName()
				+ ", \n \n "
				+ "Thank you for registering you business with Restaurant Advisor. \n "
				+ "Please give us 2 business days to review your information and "
				+ "approve your request. \n\n"
				+ "Hope you will enjoy the website and will get positive response. \n\n"
				+ "Please reach back to us with any queries. \n\n\n "
				+ "Regards, \n Smit Shah \n CEO Restaurant Adisor.";
		EmailHelper.sendMail(userEmailID, message);

		model.addAttribute("hotelName", hotelDetailsForEmail.getHotelName());
		
		return "newHotelReg5";
	}

}

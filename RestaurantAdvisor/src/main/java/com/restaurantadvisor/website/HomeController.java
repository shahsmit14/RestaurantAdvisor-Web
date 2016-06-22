package com.restaurantadvisor.website;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.restaurantadvisor.website.dao.AdminFunctionalityDAO;
import com.restaurantadvisor.website.dao.Encryption;
import com.restaurantadvisor.website.dao.LoginDetailsDAO;
import com.restaurantadvisor.website.dao.UserRegisterationDAO;
import com.restaurantadvisor.website.model.AddressDetails;
import com.restaurantadvisor.website.model.HotelDetails;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.PaymentDetails;
import com.restaurantadvisor.website.model.UserDetails;
import com.restaurantadvisor.website.model.UserRole;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private LoginDetailsDAO loginDetailsDAO;

	@Autowired
	private AdminFunctionalityDAO adminWorkingDAO;

	@Autowired
	private UserRegisterationDAO neuUserRegisterationDAO;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String userLoginForm(Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		Cookie[] cookies = request.getCookies();
		LoginDetails loginDetails = null;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loginDetails3")) {

					String userName = cookie.getValue();

					try {
						loginDetails = loginDetailsDAO
								.selectUserByUserName(userName);
					} catch (Exception exe) {
						exe.printStackTrace();
					}

					if (loginDetails != null) {
						session.setAttribute("loginDetails", loginDetails);
								
						if (loginDetails.getStatus().equalsIgnoreCase("ACTIVE")) {

							String roleType = loginDetails.getUserRole().getRoleType();
							
							if (roleType.equalsIgnoreCase("ADMIN"))
								return "userHomePage";
							else if (roleType.equalsIgnoreCase("CUSTOMER"))
								return "CustomerHome";
							else if (roleType.equalsIgnoreCase("HOTEL"))
								return "hotelHome";
							else
								return "home";
						} else {
							return "home";
						}
					}
				}
			}
		}

		loginDetails = new LoginDetails();
		model.addAttribute("loginDetails", loginDetails);

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitForm(Model model, @Validated LoginDetails loginDetails,
			BindingResult result, HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {

		model.addAttribute("loginDetails", loginDetails);
		String returnVal = "userHomePage";

		if (result.hasErrors()) {
			return "home";
		} else {
			try {
				
				String encryptedUserPassword = (String) Encryption.encrypt(loginDetails.getPassword());
				loginDetails.setPassword(encryptedUserPassword);
				
				LoginDetails ld = loginDetailsDAO.selectUserByUserNameAndPassword(
						loginDetails.getUserName(), loginDetails.getPassword());
				if (ld != null) {
					UserRole ur = ld.getUserRole();
					System.out.println(ur.getRoleType());
					if (ld.getStatus().equalsIgnoreCase("ACTIVE")) {

						model.addAttribute("loginDetails", ld);
						session.setAttribute("loginDetails", ld);

						Cookie cookie = new Cookie("loginDetails3",
								ld.getUserName());
						cookie.setMaxAge(60);
						response.addCookie(cookie);

						// check return value for home page
						if (ur.getRoleType().equalsIgnoreCase("ADMIN")) {
							return returnVal;
						} else if (ur.getRoleType()
								.equalsIgnoreCase("CUSTOMER")) {
							return "CustomerHome";
						} else if (ur.getRoleType().equalsIgnoreCase("HOTEL")) {
							return "hotelHome";
						}

					} else {
						return "home";
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "home";
	}

	@RequestMapping(value = "/adminMenu")
	public String leftFrame() {
		return "adminMenu";
	}

	@RequestMapping(value = "/hotelList")
	public String AdminHL(Model model, HttpSession session) {
		List<HotelDetails> hotelDetails;
		try {
			hotelDetails = adminWorkingDAO.selectAllHotels();

			model.addAttribute("allhotels", hotelDetails);
			model.addAttribute("hotelListSize", hotelDetails.size());
			return "hotelList";
		} catch (Exception exe) {
			System.out.println("Exception" + exe.getMessage());
		}

		return "hotelList";
	}

	@RequestMapping(value = "/userList")
	public String AdminUserList(Model model, HttpSession session) {
		List<LoginDetails> loginDetails;
		try {
			loginDetails = adminWorkingDAO.selectAllUsers();

			model.addAttribute("allUsers", loginDetails);
			model.addAttribute("userListSize", loginDetails.size());
			return "userList";
		} catch (Exception exe) {
			System.out.println("Exception" + exe.getMessage());
		}

		return "userList";
	}

	@RequestMapping(value = "/hotelSelected")
	public String hotelSelected(Model model, HttpSession session,
			HttpServletRequest request) {

		LoginDetails loginDetails;
		String userID = (String) request.getParameter("selectedHotel");

		try {
			loginDetails = adminWorkingDAO.selectedHotel(userID);
			model.addAttribute("hotel", loginDetails);
			session.setAttribute("logininfo", loginDetails);
			return "hotelSelected";
		} catch (Exception exe) {
			System.out.println("Excepetion" + exe.getMessage());
		}
		return "hotelSelected";
	}

	@RequestMapping(value = "/userSelected")
	public String userSelected(Model model, HttpSession session,
			HttpServletRequest request) {
		LoginDetails loginDetails;
		String userID = (String) request.getParameter("selectedUser");

		try {
			loginDetails = adminWorkingDAO.selectedUser(userID);
			model.addAttribute("user", loginDetails);
			session.setAttribute("logininfo", loginDetails);
			return "userSelected";
		} catch (Exception exe) {
			System.out.println("Excepetion" + exe.getMessage());
		}
		return "userSelected";
	}

	@RequestMapping(value = "/hotelactdeactback", method = RequestMethod.GET)
	public String actDeactBack(@RequestParam("HotelStatusChange") String val,
			Model model, HttpSession session) throws Exception {
		if (val.equalsIgnoreCase("ACTIVE") || val.equalsIgnoreCase("DE-ACTIVE")) {
			LoginDetails loginDetails = (LoginDetails) session
					.getAttribute("logininfo");
			loginDetails.setStatus(val);
			try {
				adminWorkingDAO.updateStatus(loginDetails);
			} catch (Exception exe) {
				System.out.println("Excepetion" + exe.getMessage());
			}
		}
		List<HotelDetails> hotelDetails;
		try {
			hotelDetails = adminWorkingDAO.selectAllHotels();

			model.addAttribute("allhotels", hotelDetails);
			model.addAttribute("hotelListSize", hotelDetails.size());
			return "hotelList";
		} catch (Exception exe) {
			System.out.println("Exception" + exe.getMessage());
		}

		return "hotelList";
	}

	@RequestMapping(value = "/changePass")
	public String changePassword() {
		return "changePass";
	}

	@RequestMapping(value = "/manageAdministrator")
	public String manageAdministrator1(Model model, HttpSession session) {

		List<LoginDetails> adminLoginDetails = null;
		try {
			adminLoginDetails = adminWorkingDAO.selectAllAdministrator();

			model.addAttribute("adminLoginDetails", adminLoginDetails);
			model.addAttribute("adminLoginDetailsSize",
					adminLoginDetails.size());

			return "manageAdministrator";

		} catch (Exception exe) {
			System.out.println("Exception" + exe.getMessage());
		}

		return "manageAdministrator";
	}

	@RequestMapping(value = "/manageAdministratorSelected")
	public String manageAdministrator2(Model model, HttpServletRequest request,
			HttpSession session) {

		String selectedAdminUserName = (String) request
				.getParameter("selectedAdmin");
		System.out.println(selectedAdminUserName);
		model.addAttribute("selectedAdminUserName", selectedAdminUserName);

		try {
			LoginDetails loginDetails = loginDetailsDAO
					.selectUserByUserName(selectedAdminUserName);
			session.setAttribute("adminSelected", loginDetails);
			model.addAttribute("loginDetails", loginDetails);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "manageAdministratorSelected";
	}

	@RequestMapping(value = "/adminactdeactback", method = RequestMethod.GET)
	public String adminActDeactBack(
			@RequestParam("adminStatusChange") String val, Model model,
			HttpSession session) throws Exception {

		if (val.equalsIgnoreCase("ACTIVE") || val.equalsIgnoreCase("DE-ACTIVE")) {
			LoginDetails loginDetails = (LoginDetails) session
					.getAttribute("adminSelected");
			loginDetails.setStatus(val);
			try {
				adminWorkingDAO.updateStatus(loginDetails);
			} catch (Exception exe) {
				System.out.println("Excepetion" + exe.getMessage());
			}
		}

		List<LoginDetails> adminLoginDetails = null;
		try {
			adminLoginDetails = adminWorkingDAO.selectAllAdministrator();

			model.addAttribute("adminLoginDetails", adminLoginDetails);
			model.addAttribute("adminLoginDetailsSize",
					adminLoginDetails.size());

			return "manageAdministrator";

		} catch (Exception exe) {
			System.out.println("Exception" + exe.getMessage());
		}

		return "manageAdministrator";
	}

	@RequestMapping(value = "/useractdeactback", method = RequestMethod.GET)
	public String userActDeactBack(@RequestParam("HotelStatusChange") String val,
			Model model, HttpSession session) throws Exception {
		if (val.equalsIgnoreCase("ACTIVE") || val.equalsIgnoreCase("DE-ACTIVE")) {
			LoginDetails loginDetails = (LoginDetails) session
					.getAttribute("logininfo");
			loginDetails.setStatus(val);
			try {
				adminWorkingDAO.updateStatus(loginDetails);
			} catch (Exception exe) {
				System.out.println("Excepetion" + exe.getMessage());
			}
		}
		List<LoginDetails> loginDetails;
		try {
			loginDetails = adminWorkingDAO.selectAllUsers();

			model.addAttribute("allUsers", loginDetails);
			model.addAttribute("userListSize", loginDetails.size());
			return "userList";
		} catch (Exception exe) {
			System.out.println("Exception" + exe.getMessage());
		}

		return "userList";
	}

	@RequestMapping(value = "/newAdminRegisteration1")
	public String addAdministrator1(Model model, HttpServletRequest request,
			HttpSession session) {

		LoginDetails loginDetails = new LoginDetails();
		model.addAttribute("loginDetails", loginDetails);

		return "newAdminRegisteration1";
	}

	@RequestMapping(value = "/newAdminRegisteration2")
	public String addAdministrator2(Model model, HttpServletRequest request,
			HttpSession session, LoginDetails loginDetails,
			UserDetails userDetails) {

		Boolean isPresent = false;
		try {
			isPresent = neuUserRegisterationDAO
					.searchUserByUserName(loginDetails.getUserName());
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		if (isPresent) {
			return "newAdminRegisteration1";
		} else {

			session.setAttribute("loginDetails", loginDetails);
			return "newAdminRegisteration2";
		}
	}

	@RequestMapping(value = "/newAdminRegisteration3")
	public String addAdministrator4(Model model, HttpServletRequest request,
			HttpSession session, LoginDetails loginDetails,
			UserDetails userDetails) {

		session.setAttribute("userDetails", userDetails);

		Boolean isSuccess = adminWorkingDAO.registerAdminDetails(session);

		List<LoginDetails> adminLoginDetails = null;
		try {
			adminLoginDetails = adminWorkingDAO.selectAllAdministrator();

			model.addAttribute("adminLoginDetails", adminLoginDetails);
			model.addAttribute("adminLoginDetailsSize",
					adminLoginDetails.size());

			return "manageAdministrator";

		} catch (Exception exe) {
			System.out.println("Exception" + exe.getMessage());
		}

		return "manageAdministrator";
	}

	@RequestMapping(value = "/logoutA")
	public String logoutAdmin(Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		Cookie cookieArray[] = request.getCookies();
		for (Cookie cookie : cookieArray) {
			if (cookie.getName().equals("loginDetails3")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				break;
			}
		}

		LoginDetails loginDetails = new LoginDetails();
		model.addAttribute("loginDetails", loginDetails);
		session.invalidate();

		return "home";

	}

	@RequestMapping(value = "/changePassword")
	public String changePassword(Model model, HttpServletRequest request,
			HttpSession session) {

		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String rePassword = request.getParameter("againPassword");

		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		String actualPassword = loginDetails.getPassword();

		if (oldPassword.isEmpty() || newPassword.isEmpty()
				|| rePassword.isEmpty()) {
			model.addAttribute("error", "Enter values");
			return "changePass";
		}

		// check if the old password entered is correct
		if (!oldPassword.equals(actualPassword)) {
			model.addAttribute("error", "Enter correct old password");
			return "changePass";
		}

		// if new and rentered are same
		if (!newPassword.equals(rePassword)) {
			model.addAttribute("error",
					"Reentered password and new password should be same");
			return "changePass";
		}

		// if old and new are same
		if (newPassword.equals(oldPassword)) {
			model.addAttribute("error", "Old and new password are same");
			return "changePass";
		}

		loginDetails.setPassword(newPassword);

		try {
			adminWorkingDAO.updatePasswordForUserName(loginDetails);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "changePass";
	}

	@RequestMapping(value = "/addAdmin")
	public String addAdmin() {
		return "addAdmin";
	}
	
}

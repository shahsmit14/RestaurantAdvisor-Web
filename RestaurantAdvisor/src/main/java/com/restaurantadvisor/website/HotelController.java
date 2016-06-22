package com.restaurantadvisor.website;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restaurantadvisor.website.dao.HotelFunctilnalityDAO;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.MenuDetails;
import com.restaurantadvisor.website.model.OrderDetails;
import com.restaurantadvisor.website.model.OrderTransaction;
import com.restaurantadvisor.website.model.UserReviews;

@Controller
public class HotelController {

	@Autowired
	private HotelFunctilnalityDAO hotelWorkingDAO;

	private static final Logger logger = LoggerFactory
			.getLogger(HotelController.class);

	@RequestMapping(value = "/hotelAdminMenu")
	public String hotelLeftFrame() {
		return "hotelAdminMenu";
	}

	@RequestMapping(value = "/hotelMenuList")
	public String hotelRightFrame(HttpSession session, Model model) {
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		Long userID = loginDetails.getUserID();
		String uID = String.valueOf(userID);
		List<MenuDetails> menuDetailsList;
		try {
			menuDetailsList = hotelWorkingDAO.menuListOfHotel(uID);
			model.addAttribute("menuList", menuDetailsList);
			model.addAttribute("menuListSize", menuDetailsList.size());
			return "hotelMenuList";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "hotelMenuList";
	}

	@RequestMapping(value = "/toggleStatus")
	public String toggleItemStatus(HttpServletRequest request,
			HttpSession session, Model model) {
		String menuID = (String) request.getParameter("selectedItem");
		try {
			MenuDetails menuDetails = hotelWorkingDAO.selectMenuItem(menuID);
			if (menuDetails.getStatus().equalsIgnoreCase("AVAILABLE")) {
				menuDetails.setStatus("NOT-AVAILABLE");
			} else {
				menuDetails.setStatus("AVAILABLE");
			}
			hotelWorkingDAO.updateItemStatus(menuDetails);
		} catch (Exception exe) {
			System.out.println("Excepetion" + exe.getMessage());
		}

		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		Long userID = loginDetails.getUserID();
		String uID = String.valueOf(userID);
		List<MenuDetails> menuDetailsList;
		try {
			menuDetailsList = hotelWorkingDAO.menuListOfHotel(uID);
			model.addAttribute("menuList", menuDetailsList);
			model.addAttribute("menuListSize", menuDetailsList.size());
			return "hotelMenuList";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "hotelMenuList";
	}

	@RequestMapping(value = "/addNewMenuItem")
	public String addNewMenuItem(Model model) {
		MenuDetails menuDetails = new MenuDetails();
		model.addAttribute("menuItem", menuDetails);
		return "addNewMenuItem";
	}

	@RequestMapping(value = "/addTheItemToMenu")
	public String addTheItemToMenu(Model model, HttpServletRequest request,
			HttpSession session, MenuDetails menuDetails) {
		try {
			session.setAttribute("addmenuD", menuDetails);

			LoginDetails loginDetails = (LoginDetails) session
					.getAttribute("loginDetails");

			hotelWorkingDAO.addItemToMenu(menuDetails, loginDetails);
			Long userID = loginDetails.getUserID();
			String uID = String.valueOf(userID);
			List<MenuDetails> menuDetailsList;

			menuDetailsList = hotelWorkingDAO.menuListOfHotel(uID);
			model.addAttribute("menuList", menuDetailsList);
			model.addAttribute("menuListSize", menuDetailsList.size());
			return "hotelMenuList";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "hotelMenuList";
	}

	@RequestMapping(value = "/viewHotelOrders")
	public String viewHotelOrders(HttpSession session, Model model) {
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		Long uID = loginDetails.getUserID();
		String userID = String.valueOf(uID);
		List<OrderTransaction> orderTransactionsList;
		try {
			orderTransactionsList = hotelWorkingDAO.fetchPreviousOrders(userID);
			model.addAttribute("OrderList", orderTransactionsList);
			model.addAttribute("OrderListSize", orderTransactionsList.size());
			return "viewHotelOrders";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "viewHotelOrders";
	}

	@RequestMapping(value = "/viewCompleteOrder")
	public String orderInfoHotel(HttpServletRequest request, Model model) {
		String orderID = (String) request.getParameter("SelectedOrder");
		try {
			List<OrderDetails> orderDetailsList = hotelWorkingDAO
					.fetchOrderDetails(orderID);
			model.addAttribute("OrderDetail", orderDetailsList);
			model.addAttribute("OrderdetailSize", orderDetailsList.size());
			return "viewCompleteOrder";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "viewCompleteOrder";
	}

	@RequestMapping(value = "/viewHotelReviews")
	public String viewHotelReviews(HttpSession session, Model model) {
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		Long uID = loginDetails.getUserID();
		String userID = String.valueOf(uID);
		List<UserReviews> userReviews;
		try {
			userReviews = hotelWorkingDAO.fetchHotelReview(userID);
			model.addAttribute("reviewList", userReviews);
			model.addAttribute("reviewListSize", userReviews.size());
			return "viewHotelReviews";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "viewHotelReviews";
	}

	@RequestMapping(value = "/changeHotelInfo")
	public String changeHotelInfo(HttpSession session, Model model) {
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		model.addAttribute("hotel", loginDetails);
		return "changeHotelInfo";
	}

	@RequestMapping(value = "/updateHotelValue")
	public String updateHotelInfo(HttpServletRequest request,
			HttpSession session, Model model) {
		String email = request.getParameter("hotelEmailContact");
		String ph = request.getParameter("hotelMobileContact");
		//Double phone = Double.parseDouble(ph);
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		loginDetails.getHotelDetails().setHotelEmailContact(email);
		loginDetails.getHotelDetails().setHotelMobileContact(ph);
		try {
			hotelWorkingDAO.updateHotelInfo(loginDetails);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		LoginDetails loginDetails1 = (LoginDetails) session
				.getAttribute("loginDetails");
		model.addAttribute("hotel", loginDetails1);
		return "changeHotelInfo";
	}
	
}

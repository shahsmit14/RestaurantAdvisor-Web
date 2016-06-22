package com.restaurantadvisor.website;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.restaurantadvisor.website.dao.CustomerFunctionalityDAO;
import com.restaurantadvisor.website.helper.PdfCreator;
import com.restaurantadvisor.website.model.AddressDetails;
import com.restaurantadvisor.website.model.HotelDetails;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.MenuDetails;
import com.restaurantadvisor.website.model.OrderDetails;
import com.restaurantadvisor.website.model.OrderTransaction;
import com.restaurantadvisor.website.model.UserDetails;
import com.restaurantadvisor.website.model.UserReviews;

@Controller
public class CustomerController {

	@Autowired
	private CustomerFunctionalityDAO customerWorkingDAO;

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	@RequestMapping(value = "/customerAdminMenu")
	public String leftFrameCustomer() {
		return "customerAdminMenu";
	}

	@RequestMapping(value = "/searchOrderReview")
	public String rightFrameCustomerSearch() {
		return "searchOrderReview";
	}

	@RequestMapping(value = "/preOrder")
	public String previousCustomerOrder(HttpSession session, Model model) {
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		Long uID = loginDetails.getUserID();
		String userID = String.valueOf(uID);
		System.out.println("--------------->" + userID);

		List<OrderTransaction> orderTransactionsList;
		try {
			orderTransactionsList = customerWorkingDAO
					.fetchPreviousOrdersCust(userID);
			model.addAttribute("OrderList", orderTransactionsList);
			model.addAttribute("OrderListSize", orderTransactionsList.size());
			return "preOrder";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "preOrder";
	}

	@RequestMapping(value = "/preReview")
	public String hotelReviewByCustomer(HttpSession session, Model model) {
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		Long uID = loginDetails.getUserID();
		String userID = String.valueOf(uID);
		List<UserReviews> userReviews;
		try {
			userReviews = customerWorkingDAO.fetchHotelReviewByMe(userID);
			model.addAttribute("reviewList", userReviews);
			model.addAttribute("reviewListSize", userReviews.size());
			return "preReview";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "preReview";
	}

	@RequestMapping(value = "/updateProfileCust")
	public String updateCustomerProfile(HttpSession session, Model model) {
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		model.addAttribute("hotel", loginDetails);
		return "updateProfileCust";
	}

	@RequestMapping(value = "/updateCustValue")
	public String updateCustomerInfo(HttpServletRequest request,
			HttpSession session, Model model) {
		String phone = request.getParameter("contactNumber");
		String emai = request.getParameter("email");
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		loginDetails.getUserDetails().setContactNumber(phone);
		loginDetails.getUserDetails().setEmail(emai);
		try {
			customerWorkingDAO.updateCustomerInfo(loginDetails);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		LoginDetails loginDetails1 = (LoginDetails) session
				.getAttribute("loginDetails");
		model.addAttribute("hotel", loginDetails1);
		return "updateProfileCust";
	}

	@RequestMapping(value = "/viewCompleteOrderCust")
	public String viewCompleteCustomerOrder(HttpServletRequest request, 
			HttpSession session, Model model) {
		String orderID = (String) request.getParameter("SelectedOrder");
		try {
			List<OrderDetails> orderDetailsList = customerWorkingDAO
					.fetchOrderDetailsCust(orderID);
			model.addAttribute("OrderDetail", orderDetailsList);
			session.setAttribute("orderDetailsList", orderDetailsList);
			model.addAttribute("OrderdetailSize", orderDetailsList.size());
			return "viewCompleteOrderCust";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "viewCompleteOrderCust";
	}

	@RequestMapping(value = "/searchByHotelname", method = RequestMethod.GET)
	public String searchHotelByHotelName(HttpServletRequest request, Model model, HttpSession session) {
		
		String name = (String) session.getAttribute("searchByName");
		
		List<HotelDetails> hotelDetails;
		try {
			hotelDetails = customerWorkingDAO.searchByNameHotel(name);
			model.addAttribute("hList", hotelDetails);
			model.addAttribute("hListSize", hotelDetails.size());
			return "searchResult";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "searchResult";
	}

	@RequestMapping(value = "/searchByHoteltype", method = RequestMethod.GET)
	public String searchHotelByHotelType(HttpServletRequest request, Model model) {
		String name = request.getParameter("hotelType");
		List<HotelDetails> hotelDetails;
		try {
			hotelDetails = customerWorkingDAO.searchHotelByTypeHotel(name);
			model.addAttribute("hList", hotelDetails);
			model.addAttribute("hListSize", hotelDetails.size());
			return "searchResult";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "searchResult";
	}

	@RequestMapping(value = "/hotelSelectedMenuItem")
	public String selectedHotelMenuItem(HttpServletRequest request, Model model) {
		String hotelID = (String) request.getParameter("selectedHotelMenu");
		try {
			List<MenuDetails> menuDetails = customerWorkingDAO
					.findSelectedHotelMenu(hotelID);

			model.addAttribute("hotelID", hotelID);
			model.addAttribute("MenuList", menuDetails);
			model.addAttribute("MenuListSize", menuDetails.size());
			return "hotelSelectedMenuItem";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "hotelSelectedMenuItem";
	}

	@RequestMapping(value = "/hotelSelectedReview")
	public String selectedHotelReview(HttpServletRequest request, Model model) {
		String hotelID = (String) request.getParameter("selectedHotelReview");
		try {
			List<UserReviews> userReviews = customerWorkingDAO
					.findHotelReviews(hotelID);
			model.addAttribute("ReviewList", userReviews);
			model.addAttribute("reviewListSize", userReviews.size());
			return "hotelSelectedReview";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "hotelSelectedReview";
	}

	@RequestMapping(value = "/hotelAddReview")
	public String addHotelReview(HttpServletRequest request,
			HttpSession session, Model model) {

		String hotelID = (String) request.getParameter("selectedHotelReview");

		model.addAttribute("hotelID", hotelID);
		return "hotelAddReview";
	}

	@RequestMapping(value = "/submitHotelReview")
	public String submitHotelReview(HttpServletRequest request,
			HttpSession session, Model model, UserReviews userReviews) {

		String hotelID = (String) request.getParameter("selectedHotelReview");

		try {
			customerWorkingDAO.addHotelReview(session, hotelID, userReviews);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "searchOrderReview";
	}

	@RequestMapping(value = "/placeOrder")
	public String placeOrder(HttpServletRequest request, HttpSession session,
			Model model) {

		String hotelID = (String) request.getParameter("hotelID");

		String menuId[] = request.getParameterValues("menuDetailsId");
		String qty[] = request.getParameterValues("orderQuantity");

		try {
			OrderTransaction orderTransaction = new OrderTransaction();
			orderTransaction.setOrderStatus("In-PROGRESS");
			orderTransaction.setOrderTimeStamp(new Date());

			LoginDetails hotelLoginDetails = (LoginDetails) customerWorkingDAO
					.hotelOrderDetails(hotelID);
			orderTransaction.setHotelLoginDetails(hotelLoginDetails);
			orderTransaction.setCustomerLoginDetails((LoginDetails) session
					.getAttribute("loginDetails"));

			OrderTransaction newOrderTransaction = (OrderTransaction) customerWorkingDAO
					.addOrderTransaction1(orderTransaction);
			System.out.println("------->" + newOrderTransaction.getOrderId());

			float totalCost = 0.0f;

			for (int i = 0; i < qty.length; i++) {

				if (!qty[i].equals("0")) {

					MenuDetails menuDetails = (MenuDetails) customerWorkingDAO
							.fetchMenuDetails(menuId[i]);

					totalCost = totalCost
							+ (Integer.valueOf(qty[i]) * menuDetails.getPrice());

					OrderDetails orderDetails = new OrderDetails();
					orderDetails.setQuantity(Integer.valueOf(qty[i]));
					orderDetails.setOrderTransaction(newOrderTransaction);
					orderDetails.setMenuDetails(menuDetails);

					customerWorkingDAO.addOrderTransaction2(orderDetails);

				}
			}

			newOrderTransaction.setTotalCost(totalCost);
			newOrderTransaction.setOrderStatus("ORDERED");
			customerWorkingDAO.addOrderTransaction3(newOrderTransaction);

		} catch (Exception e) {

		}

		// To display order history
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		Long uID = loginDetails.getUserID();
		String userID = String.valueOf(uID);
		List<OrderTransaction> orderTransactionsList;
		try {
			orderTransactionsList = customerWorkingDAO
					.fetchPreviousOrdersCust(userID);
			model.addAttribute("OrderList", orderTransactionsList);
			model.addAttribute("OrderListSize", orderTransactionsList.size());
			return "preOrder";
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return "preOrder";

	}

	@RequestMapping(value = "/GoogleMaps")
	public String viewMaps(HttpSession session, Model model,
			HttpServletRequest request) {

		String hotelID = (String) request.getParameter("selectedHotel");
		System.out.println(hotelID);
		try {

			AddressDetails addressDetails = customerWorkingDAO
					.hotelAddressMaps(hotelID);

			String addressString = addressDetails.getBlockNumber() + ", "
					+ addressDetails.getStreet() + ", "
					+ addressDetails.getCity() + ", "
					+ addressDetails.getState();

			System.out.println("Google Search Address -->" + addressString);

			model.addAttribute("addressString", addressString);

			return "GoogleMaps";

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}

		return "searchOrderReview";
	}

	@RequestMapping(value = "/downlaodOrderPdf")
	public void downloadOrderPdf(HttpSession session,
			HttpServletResponse response, Model model,
			HttpServletRequest request) {
		
		System.out.println("<------reached--------->");
		
		List<OrderDetails> orderDetails = (List<OrderDetails>) session.getAttribute("orderDetailsList");
		
		System.out.println("--------------->" + orderDetails.size());
		
		LoginDetails loginDetails = (LoginDetails) session
				.getAttribute("loginDetails");
		
		System.out.println("--------------->" + loginDetails.getUserName());
		
		PdfCreator.createPdf(orderDetails, loginDetails, response);
	}

}

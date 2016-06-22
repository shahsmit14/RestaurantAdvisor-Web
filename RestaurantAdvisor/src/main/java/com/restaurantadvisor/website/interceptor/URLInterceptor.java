package com.restaurantadvisor.website.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.restaurantadvisor.website.model.LoginDetails;

public class URLInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		/*
		String uri = request.getRequestURI();
		LoginDetails loginDetails = (LoginDetails) request.getSession()
				.getAttribute("loginDetails");

	
		if (loginDetails != null) {
			if (loginDetails.getUserRole().getRoleType()
					.equalsIgnoreCase("ADMIN")) {
				// Administrator
				if (uri.equals("/RestaurantAdvisor/adminMenu")
						|| uri.equals("/RestaurantAdvisor/hotelList")
						|| uri.equals("/RestaurantAdvisor/userList")
						|| uri.equals("/RestaurantAdvisor/hotelSelected")
						|| uri.equals("/RestaurantAdvisor/userSelected")
						|| uri.equals("/RestaurantAdvisor/manageAdministrator")
						|| uri.equals("/RestaurantAdvisor/manageAdministratorSelected")
						
						|| uri.equals("/RestaurantAdvisor/newAdminRegisteration1")
						|| uri.equals("/RestaurantAdvisor/newAdminRegisteration2")
						|| uri.equals("/RestaurantAdvisor/newAdminRegisteration3")
						|| uri.equals("/RestaurantAdvisor/addAdmin")) {
					return true;
				}
			}
		}
		response.sendRedirect("/RestaurantAdvisor");
		return false;
		
		*/
		
		return true;
	}
}

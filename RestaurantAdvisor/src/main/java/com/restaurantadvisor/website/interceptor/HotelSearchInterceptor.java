package com.restaurantadvisor.website.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HotelSearchInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("-------------------------------");
		String name = request.getParameter("searchByName");
		
		if (name != null) {
			name = name.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
			name = name.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
			name = name.replaceAll("'", "");
			name = name.replaceAll("eval\\((.*)\\)", "");
			name = name.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
					"\"\"");
			name = name.replaceAll("script", "");			
			request.getSession().setAttribute("searchByName", name);
			
			System.out.println("-------------------------------");
		}		
		return true;
	}
}
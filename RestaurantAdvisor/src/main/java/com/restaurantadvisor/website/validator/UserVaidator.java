package com.restaurantadvisor.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.restaurantadvisor.website.model.LoginDetails;


public class UserVaidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return LoginDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		LoginDetails loginDetails = (LoginDetails)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "validate.userName", "Your Name Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.Password", "Your password Is Incorrenct");
	}
}

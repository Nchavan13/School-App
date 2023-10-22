package com.niltech.ShivajiSchool.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionController {

	@ExceptionHandler({ Exception.class })
	public ModelAndView exceptionHandler(Exception exception) {
		String errorMsg = null;
		ModelAndView errorPage = new ModelAndView();
		errorPage.setViewName("error");
		if (exception.getMessage() != null) {
			errorMsg = exception.getMessage();
		} else if (exception.getCause() != null) {
			errorMsg = exception.getCause().toString();
		} else if (exception != null) {
			errorMsg = exception.toString();
		}
		errorPage.addObject("errormsg", errorMsg);
		return errorPage;
	}

}

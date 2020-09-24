package com.climate.summary.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is error controller, and it will be used to handle server side errors
 * Example shown is for error 404 and error 500
 * 
 * Error 404 - Bad URL
 * Error 500 - Internal server error
 * 
 * @author KhatriZ
 *
 */
@Controller
public class ClimateSummaryErrorController implements ErrorController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ClimateSummaryErrorController.class);


	@Override
	public String getErrorPath() {
		return "/errors";
	}
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		String errorPage = "error";
		String pageTitle = "Error";
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				pageTitle = "Page not found";
				errorPage = getErrorPath()+"/404-error";
				LOGGER.error("Error 404");
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				pageTitle = "Internal Server Error";
				errorPage = getErrorPath()+"/500-error";
				LOGGER.error("Error 500");
			}
		}
		
		model.addAttribute("pageTitle", pageTitle);
		
		
		
		return errorPage;
	}

}

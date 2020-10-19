package com.climate.summary.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.climate.summary.constants.ClimateSummaryConstants;
import com.climate.summary.constants.ClimateSummaryConstants.ModelAttributes;
import com.climate.summary.models.ClimateSummary;
import com.climate.summary.models.ClimateSummaryBean;
import com.climate.summary.service.ClimateSummaryService;

/**
 * This is the main controller which will call service implementation class and bring the necessary data
 * to present it on the user interface
 * 
 * @author KhatriZ
 *
 */
@Controller
public class ClimateSummaryController extends AbstractController {
	
	/**
	 * Injection of climateSummaryService implementation
	 */
	@Autowired
	private ClimateSummaryService climateSummaryService;	
	
	/**
	 * Logger class to log application logs
	 */
	private static final Logger LOGGER=LoggerFactory.getLogger(ClimateSummaryController.class);

	/**
	 * This is the main start point of the application, or home page
	 * 
	 * @param csummary - instance of ClimateSummaryBean
	 * @param model - model
	 * @return climatesummary
	 */
	@GetMapping(value="/climatesummary")
	public String showClimateSummary(@ModelAttribute("csummary") ClimateSummaryBean csummary, Model model) {
		
		List<ClimateSummary> rowList = climateSummaryService.getAllClimateSummary();
		
		Date minDate = climateSummaryService.getMinDate(rowList);
		LOGGER.info("Min date = " + minDate);
		csummary.setMinDate(new SimpleDateFormat(ClimateSummaryConstants.DATE_FORMAT).format(minDate));
		
		csummary = new ClimateSummaryBean();
		//Add the maximum date user can select, which cannot be newer than todays date
		csummary.setMaxDate(new SimpleDateFormat(ClimateSummaryConstants.DATE_FORMAT).format(new Date()));
		
		model.addAttribute(ModelAttributes.CLIMATE_HISTORY_LIST, rowList);
		model.addAttribute(ModelAttributes.CLIMATE_SUMMARY_BEAN, csummary);

		return "climatesummary";
	}
	
	/**
	 * This method will use to filter the results by providing start and end date to the result set
	 * 
	 * @param csummary - instance of ClimateSummaryBean
	 * @param bindingResult - binding result instance
	 * @param model - model
	 * @return climatefilter
	 */
	@GetMapping(value="/climatefilter")
	public String filerClimateSummary(@ModelAttribute("csummary") @Valid ClimateSummaryBean csummary, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			LOGGER.info("There is an error");
			return "climatesummary";
		} else {
			
			Date startDate = csummary.getStartDate();
			Date endDate = csummary.getEndDate();
			
			List<ClimateSummary> rowList = climateSummaryService.getAllByDateRange(startDate, endDate);
			

			model.addAttribute(ModelAttributes.CLIMATE_HISTORY_LIST, rowList);
			model.addAttribute(ModelAttributes.CLIMATE_SUMMARY_BEAN, csummary);				
		}	
		
		return "climatesummary";
	}
	
	/**
	 * This method will be used to retrieve a single row from the CLIMATESUMMARY table
	 * and display it on the web page
	 * 
	 * @param id - primary key identifier supplied
	 * @param model - model
	 * @return climatedetails
	 */
	@GetMapping(value="climatedetails/{id}") 
	public String showClimateDetails(@PathVariable("id") String id, Model model) {
		
		ClimateSummary climateSummary = climateSummaryService.getClimateSummaryById(Long.valueOf(id));
		model.addAttribute("single", climateSummary);
		
		return "climatedetail";
		
	}

}

package com.climate.summary.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.PostMapping;

import com.climate.summary.constants.ClimateSummaryConstants.ModelAttributes;
import com.climate.summary.models.ClimateSummary;
import com.climate.summary.repository.ClimateSummaryRepository;

@Controller
public class ClimateSummaryController extends AbstractController {
	
	@Autowired
	private ClimateSummaryRepository climateSummaryRepository;
	
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ClimateSummaryController.class);

	
	@GetMapping(value="/climatesummary")
	public String showClimateSummary(@ModelAttribute("csummary") ClimateSummary csummary, Model model) {
		
		List<ClimateSummary> rowList = climateSummaryRepository.findAll();
		
		model.addAttribute(ModelAttributes.CLIMATE_HISTORY_LIST, rowList);
		model.addAttribute("csummary", csummary);

		
		return "climatesummary";
	}
	
	@PostMapping(value="/climatefilter")
	public String filerClimateSummary(@Valid ClimateSummary csummary, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			LOGGER.info("There is an error");
		}
		
		if(csummary.getStartDate() == null || csummary.getEndDate() == null) {			

			model.addAttribute("csummary", csummary);
			return "redirect:climatesummary";
		} else if(csummary.getStartDate() != null && csummary.getEndDate() != null) {
			
			Date startDate = csummary.getStartDate();
			Date endDate = csummary.getEndDate();
			
			List<ClimateSummary> rowList = climateSummaryRepository.findAll();
			
			if(rowList != null && !rowList.isEmpty()) {
				List<ClimateSummary> newList = new ArrayList<ClimateSummary>();
				
				for(ClimateSummary single : rowList) {
					
					if(single.getTempTaken().getTime() >= startDate.getTime() &&
							single.getTempTaken().getTime() <= endDate.getTime() ) {
						newList.add(single);
					}
				}
				model.addAttribute(ModelAttributes.CLIMATE_HISTORY_LIST, newList);
				model.addAttribute("csummary", csummary);				
			}			
		}
		
		
		
		return "climatesummary";
		
	}
	
	@GetMapping(value="climatedetails/{id}") 
	public String showClimateDetails(@PathVariable("id") String id, Model model) {
		
		Optional<ClimateSummary> single = climateSummaryRepository.findById(Long.valueOf(id));
		if(single.isPresent()) {
			model.addAttribute("single", single.get());
		}
		
		return "climatedetail";
		
	}

}

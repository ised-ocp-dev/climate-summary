package com.climate.summary.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * This class represent the object which is passed to the thymeleaf template
 * to read the date filter (startDate and endDate)
 * 
 * 
 * 
 * @author KhatriZ
 *
 */
public class ClimateSummaryBean {
	
	/**
	 * This is start date form the one calendar input
	 */
	@NotNull(message = "Start date cannot be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	/**
	 * This is the end date from the second calendar input
	 */
	@NotNull(message = "End date cannot be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	/**
	 * String representation of minimum date available for calendar
	 */
	private String minDate;

	/** String reprsentation of maximum date available for calendar
	 * 
	 */
	private String maxDate;

	/**
	 * get startDate
	 * 
	 * @return - startDate Date instance
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * startDate to set
	 * 
	 * @param startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * get endDate
	 * 
	 * @return endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * endDate to set
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/** 
	 * get minimum Date as a string
	 * @return
	 */
	public String getMinDate() {
		return minDate;
	}
	
	/** 
	 * set minimum date as a string
	 * 
	 * @param minDate
	 */
	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}
	
	/**
	 * get maximum date as a string
	 * 
	 * @return
	 */
	public String getMaxDate() {
		return maxDate;
	}
	
	/**
	 * set maximum date as a string
	 * @param maxDate
	 */
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

}

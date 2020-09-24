package com.climate.summary.service;

import java.util.Date;
import java.util.List;

import com.climate.summary.models.ClimateSummary;

public interface ClimateSummaryService {
	/**
	 * This method will return all the records from CLIMATESUMMARY database table
	 * 
	 * This method is used to display all the records of CLIMATESUMMARY table on the Climate Summary
	 * web page
	 * 
	 * @return List of ClimateSummary
	 */
	List<ClimateSummary> getAllClimateSummary();
	
	/**
	 * This method will filter out all the records from CLIMATESUMMARY table based on the
	 * search criteria of minimum and maximum date in the form of startDate and endDate 
	 * respectively from respective calendar date from the UI
	 * 
	 * @param startDate - search criteria for date range
	 * @param endDate - search criteria end date
	 * @return List of ClimateSummary
	 */
	List<ClimateSummary> getAllByDateRange(Date startDate, Date endDate);
	
	/**
	 * This method will bring the single row from CLIMATESUMMARY table, by passing the identifier,
	 * which is primary key of the table. This will bring one and only one record.
	 * 
	 * This method is used to populate climate summary detail on the web page
	 * 
	 * @param id
	 * @return instance of ClimateSummary
	 */
	ClimateSummary getClimateSummaryById(long id);
	
	/**
	 * This method will bring the minimum date from tempTaken property of the ClimateSummary list passed
	 * 
	 * This method is used to configure the min attribute for the calendar
	 * 
	 * @param list - list of ClimateSummary instance supplied
	 * @return - Date - lowest value of temptaken property, comparing all the list items which is supplied
	 */
	Date getMinDate(List<ClimateSummary> list);
}

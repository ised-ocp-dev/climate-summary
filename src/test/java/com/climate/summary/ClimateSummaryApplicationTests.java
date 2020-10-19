package com.climate.summary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.climate.summary.models.ClimateSummary;
import com.climate.summary.service.ClimateSummaryService;

/**
 * This class represents unit test for the application
 * Scenarios covered 
 * @author KhatriZ
 *
 */
@SpringBootTest
class ClimateSummaryApplicationTests {
	
	/**
	 * Injection of climateSummaryService implementation
	 */
	@Autowired
	private ClimateSummaryService climateSummaryService;
	
	/**
	 * LOGGER class to display test logs
	 */
	private static final Logger LOGGER=LoggerFactory.getLogger(ClimateSummaryApplicationTests.class);
	
	/**
	 * List of ClimateSummary instances
	 */
	private List<ClimateSummary> list = new ArrayList<ClimateSummary>();
	
	/**
	 * Read the record from the database successfully
	 * and verify the size of the rows in CLIMATESUMMARY table
	 */
	@Test	
	void readDataFromDatabase() {
		list = climateSummaryService.getAllClimateSummary();
		LOGGER.info("<<<<<<<<<<<Inside readCSVFile() test>>>>>>>>>>>>>>>>>");
		assertNotNull(list);
		LOGGER.info("List size = " + list.size());
		assertEquals(1135, list.size(), "Size is equal");
	}
	
	/**
	 * Read the records from the database by providing a specific date range
	 * start date and end date
	 */
	@Test	
	void readFilteredDataFromDatabase() {
		list = climateSummaryService.getAllClimateSummary();
		Calendar start = new GregorianCalendar(2018,01,04);
		Calendar end  = new GregorianCalendar(2018,01,06);
		
		Date startDate = start.getTime();
		Date endDate = end.getTime();
		List<ClimateSummary> newList = climateSummaryService.getAllByDateRange(startDate, endDate);
	
		
		assertNotNull(newList);
		LOGGER.info("List size = " + newList.size());
		
		assertEquals(6, newList.size(), "Size is equal");
	}	
	
	/**
	 * Read the records from the database by providing a specific date range
	 * Records do not exist for that specific date range
	 * 
	 */
	@Test	
	void invalidSearchCriteriaTest() {
		list = climateSummaryService.getAllClimateSummary();
		
		//Following dates are way out of range
		Calendar start = new GregorianCalendar(2020,01,04);
		Calendar end  = new GregorianCalendar(2020,01,06);
		
		Date startDate = start.getTime();
		Date endDate = end.getTime();
		List<ClimateSummary> newList = climateSummaryService.getAllByDateRange(startDate, endDate);
		
		assertNotNull(newList);
		LOGGER.info("List size = " + newList.size());
		
		assertEquals(0, newList.size(), "Size is equal");
	}
	
	/**
	 * Invalid start and end date provided for the date range filter
	 * Start date is newer than the end date
	 */
	@Test
	void invalidStartAndEndDateSearchCriteriaTest() {
		
		list = climateSummaryService.getAllClimateSummary();
		
		//Following dates are way out of range
		Calendar start = new GregorianCalendar(2020,01,06);
		Calendar end  = new GregorianCalendar(2020,01,04);
		
		Date startDate = start.getTime();
		Date endDate = end.getTime();
		
		if(startDate.getTime() > endDate.getTime()) {
			LOGGER.error("Start date cannot be newer than end date");
		}
		
		assertTrue(startDate.getTime() > endDate.getTime());
	}

}

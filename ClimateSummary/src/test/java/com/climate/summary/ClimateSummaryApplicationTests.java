package com.climate.summary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import com.climate.summary.repository.ClimateSummaryRepository;

@SpringBootTest
class ClimateSummaryApplicationTests {
	
	@Autowired
	private ClimateSummaryRepository climateSummaryRepository;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ClimateSummaryApplicationTests.class);
	
	private List<ClimateSummary> list = new ArrayList<ClimateSummary>();


	@Test
	void contextLoads() {
		list = climateSummaryRepository.findAll();
	}
	
	
	@Test	
	void readDataFromDatabase() {
		list = climateSummaryRepository.findAll();
		LOGGER.info("<<<<<<<<<<<Inside readCSVFile() test>>>>>>>>>>>>>>>>>");
		assertNotNull(list);
		LOGGER.info("List size = " + list.size());
		assertEquals(1135, list.size(), "Size is equal");
	}
	
	@Test	
	void readFilteredDataFromDatabase() {
		list = climateSummaryRepository.findAll();
		Calendar start = new GregorianCalendar(2018,01,04);
		Calendar end  = new GregorianCalendar(2018,01,06);
		
		Date startDate = start.getTime();
		Date endDate = end.getTime();
		List<ClimateSummary> newList = new ArrayList<ClimateSummary>();

		
		for(ClimateSummary single : list) {
			
			if(single.getTempTaken().getTime() >= startDate.getTime() &&
					single.getTempTaken().getTime() <= endDate.getTime() ) {
				newList.add(single);
			}
		}
		
		
		assertNotNull(newList);
		LOGGER.info("List size = " + newList.size());
		
		assertEquals(6, newList.size(), "Size is equal");
	}	
	
	@Test	
	void invalidSearchCriteraTest() {
		list = climateSummaryRepository.findAll();
		Calendar start = new GregorianCalendar(2020,01,04);
		Calendar end  = new GregorianCalendar(2020,01,06);
		
		Date startDate = start.getTime();
		Date endDate = end.getTime();
		List<ClimateSummary> newList = new ArrayList<ClimateSummary>();

		
		for(ClimateSummary single : list) {
			
			if(single.getTempTaken().getTime() >= startDate.getTime() &&
					single.getTempTaken().getTime() <= endDate.getTime() ) {
				newList.add(single);
			}
		}
		
		
		assertNotNull(newList);
		LOGGER.info("List size = " + newList.size());
		
		assertEquals(0, newList.size(), "Size is equal");
	}

}

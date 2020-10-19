package com.climate.summary.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.climate.summary.models.ClimateSummary;

/**
 * This is a generic file parser utility class. This class is used to process the data from 
 * provided .csv file
 * 
 * @author KhatriZ
 *
 */
public class FileParser {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FileParser.class);

	/**
	 * This method will take a single row from the csv file which is comma separted
	 * This method will split that string with "," as a delimiter and assign each elements
	 * to the properties of ClimateSummary bean
	 * @param singleRow
	 * @return
	 */
	public static ClimateSummary convertToClimateSummaryBean(String singleRow) {
		
		String array [] = singleRow.split(",",-1);
		
		ClimateSummary bean = new ClimateSummary();
		
		bean.setStationName(array[0].toString());
		bean.setProvinceCode(array[1].toString());
		
		try {
			Date df = new SimpleDateFormat("dd/MM/yyyy").parse(array[2].toString());
			bean.setTempTaken(df);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		bean.setMeanTemp(array[3].toString());
		bean.setMonthlyMaxTemp(array[4].toString());
		bean.setMonthlyMinTemp(array[5].toString());
		
		return bean;
		
	}

}

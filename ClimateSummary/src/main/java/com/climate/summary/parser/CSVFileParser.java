package com.climate.summary.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.climate.summary.models.ClimateSummary;

public class CSVFileParser {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CSVFileParser.class);

	
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

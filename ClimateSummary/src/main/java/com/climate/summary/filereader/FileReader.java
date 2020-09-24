package com.climate.summary.filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * This class is a generic file reader from file system
 * 
 * @author KhatriZ
 *
 */
public class FileReader {
	
	public static List<String> readCSVFile(String file) {
		List<String> list = new ArrayList<String>();
		
		Resource resource = new ClassPathResource(file);
        String csvRecord = null;
				
		BufferedReader csvReader = null;
		
		try {
			InputStream is = resource.getInputStream();
			csvReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while((csvRecord = csvReader.readLine()) != null) {
				list.add(csvRecord);
			}		

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

}

package com.climate.summary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.climate.summary.constants.ClimateSummaryConstants.FileConstants;
import com.climate.summary.filereader.FileReader;
import com.climate.summary.models.ClimateSummary;
import com.climate.summary.parser.FileParser;
import com.climate.summary.repository.ClimateSummaryRepository;

@SpringBootApplication
@EnableWebMvc
public class ClimateSummaryApplication {

	@Autowired
	private ClimateSummaryRepository climateSummaryRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ClimateSummaryApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ClimateSummaryApplication.class, args);
		LOGGER.info("<<<<<<<<<<<<<<<<<APPLICAITON STARTED>>>>>>>>>>>>>>>>>>>)");
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {

			List<String> rowList = FileReader.readCSVFile(FileConstants.FILE_NAME);

			// Remove first element for the columns from CSV file
			rowList.remove(0);

			if (rowList != null && !rowList.isEmpty()) {
				for (String aRow : rowList) {
					ClimateSummary cSummary = FileParser.convertToClimateSummaryBean(aRow);
					climateSummaryRepository.save(cSummary);
				}
			}
		};
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	    
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}
	

}

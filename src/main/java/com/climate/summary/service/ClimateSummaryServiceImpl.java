package com.climate.summary.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climate.summary.exception.ResourceNotFoundException;
import com.climate.summary.models.ClimateSummary;
import com.climate.summary.repository.ClimateSummaryRepository;

/**
 * This is implementation class for climateSummaryService, which has injection of climateSummaryRepository
 * JPA repository which is used to perform CRUD (Create, Retrieve, Update and Delete) operations from the database
 * @author KhatriZ
 *
 */
@Service
public class ClimateSummaryServiceImpl implements ClimateSummaryService {
	
	/**
	 * Injection of climateSummaryRepository JPA repository
	 */
	@Autowired
	private ClimateSummaryRepository climateSummaryRepository;

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public List<ClimateSummary> getAllClimateSummary() {
		return climateSummaryRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public ClimateSummary getClimateSummaryById(long id) {
		
		Optional<ClimateSummary> csummary = climateSummaryRepository.findById(id);
		
		if(csummary.isPresent()) {
			return csummary.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id " + id);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public List<ClimateSummary> getAllByDateRange(Date startDate, Date endDate) {
		List<ClimateSummary> newList = new ArrayList<ClimateSummary>();
		
		for(ClimateSummary single : getAllClimateSummary()) {
			
			if(single.getTempTaken().getTime() >= startDate.getTime() &&
					single.getTempTaken().getTime() <= endDate.getTime() ) {
				newList.add(single);
			}
		}
		return newList;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * 
	 */
	@Override
	public Date getMinDate(List<ClimateSummary> list) {
		Date minDate = list.stream().filter(Objects::nonNull).map(u -> u.getTempTaken()).min(Date::compareTo).get();		
		
		return minDate;
	}
}

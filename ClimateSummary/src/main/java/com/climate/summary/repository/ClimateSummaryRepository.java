package com.climate.summary.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.summary.models.ClimateSummary;


public interface ClimateSummaryRepository extends JpaRepository<ClimateSummary, Long> {
	
}




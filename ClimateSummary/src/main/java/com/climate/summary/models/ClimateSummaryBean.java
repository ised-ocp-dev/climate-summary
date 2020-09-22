package com.climate.summary.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ClimateSummaryBean {
	@NotNull(message = "Start date cannot be null")
	private Date startDate;

	@NotNull (message = "End date cannot be null")
	private Date endDate;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}

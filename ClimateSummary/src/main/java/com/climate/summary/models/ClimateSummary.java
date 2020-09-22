package com.climate.summary.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="climatesummary")
public class ClimateSummary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="stationname")
	private String stationName;
	
	@Column(name="provincecode")
	private String provinceCode;	
	
	private Date tempTaken;
	
	@Column(name="meantemp")
	private String meanTemp;
	
	@Column(name="maxtemp")
	private String monthlyMaxTemp;
	
	@Column(name="mintemp")
	private String monthlyMinTemp;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}


	public Date getTempTaken() {
		return tempTaken;
	}

	public void setTempTaken(Date tempTaken) {
		this.tempTaken = tempTaken;
	}

	public String getMeanTemp() {
		return meanTemp;
	}

	public void setMeanTemp(String meanTemp) {
		this.meanTemp = meanTemp;
	}

	public String getMonthlyMaxTemp() {
		return monthlyMaxTemp;
	}

	public void setMonthlyMaxTemp(String monthlyMaxTemp) {
		this.monthlyMaxTemp = monthlyMaxTemp;
	}

	public String getMonthlyMinTemp() {
		return monthlyMinTemp;
	}

	public void setMonthlyMinTemp(String monthlyMinTemp) {
		this.monthlyMinTemp = monthlyMinTemp;
	}

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

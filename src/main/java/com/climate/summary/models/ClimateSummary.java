package com.climate.summary.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is entity bean class for CLIMATESUMMARY database table,
 * it is used to bring the data and also use to filter data.
 * 
 * This class represents single row of CLIMATESUMMARY table
 * 
 * @author KhatriZ
 *
 */
@Entity
@Table(name="climatesummary")
public class ClimateSummary {
	
	/**
	 * This is primary key identifier of CLIMATESUMMARY table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/**
	 * Station Name
	 */
	@Column(name="stationname")
	private String stationName;
	
	/**
	 * Province code
	 */
	@Column(name="provincecode")
	private String provinceCode;	
	
	/**
	 * Temperature taken date
	 */
	private Date tempTaken;
	
	/**
	 * Mean temperature
	 */
	@Column(name="meantemp")
	private String meanTemp;
	
	/**
	 * Highest Monthly Maximum Temperature
	 */
	@Column(name="maxtemp")
	private String monthlyMaxTemp;
	
	/**
	 * Lowest Monthly Minimum Temperature
	 */
	@Column(name="mintemp")
	private String monthlyMinTemp;

	/**
	 * 
	 * @return - id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set id to set
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return stationName
	 */
	public String getStationName() {
		return stationName;
	}
	
	/**
	 * stationName to set
	 * @param stationName
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * @return provinceCode
	 */
	public String getProvinceCode() {
		return provinceCode;
	}
	
	/**
	 * provinceCode to set
	 * @param provinceCode
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	 * @return tempTaken
	 */
	public Date getTempTaken() {
		return tempTaken;
	}
	
	/**
	 * tempTaken to set
	 * 
	 * @param tempTaken
	 */
	public void setTempTaken(Date tempTaken) {
		this.tempTaken = tempTaken;
	}
	
	/**
	 * 
	 * @return meanTemp
	 */
	public String getMeanTemp() {
		return meanTemp;
	}
	
	/**
	 * meanTemp to set
	 * @param meanTemp
	 */
	public void setMeanTemp(String meanTemp) {
		this.meanTemp = meanTemp;
	}
	
	/**
	 * 
	 * @return monthlyMaxTemp
	 */
	public String getMonthlyMaxTemp() {
		return monthlyMaxTemp;
	}

	/**
	 * monthlyMaxTemp to set
	 * 
	 * @param monthlyMaxTemp
	 */
	public void setMonthlyMaxTemp(String monthlyMaxTemp) {
		this.monthlyMaxTemp = monthlyMaxTemp;
	}
	
	/**
	 * 
	 * @return monthlyMinTemp
	 */
	public String getMonthlyMinTemp() {
		return monthlyMinTemp;
	}
	
	/**
	 * monthlyMinTemp to set
	 * @param monthlyMinTemp
	 */
	public void setMonthlyMinTemp(String monthlyMinTemp) {
		this.monthlyMinTemp = monthlyMinTemp;
	}	
	
}

package com.cts.flight.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class AirlineInfo {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto gen key for PK
	private int airlineId;
	private String airlineLogo;
	private String airlineName;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "flightsInformation", 
	joinColumns = { @JoinColumn(name = "airlineId") }, 
	inverseJoinColumns = {@JoinColumn(name = "flightInfoid") })
	private List<FlightInfo> flightsInfo = new ArrayList<>();

	public List<FlightInfo> getFlightsInfo() {
		return flightsInfo;
	}

	public void setFlightsInfo(List<FlightInfo> flightsInfo) {
		this.flightsInfo = flightsInfo;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineLogo() {
		return airlineLogo;
	}

	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

}

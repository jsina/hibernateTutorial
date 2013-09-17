package com.sinaSys.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String city;
	private String plaqe;

	@Column(name = "STREET")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "PLAQE")
	public String getPlaqe() {
		return plaqe;
	}

	public void setPlaqe(String plaqe) {
		this.plaqe = plaqe;
	}

}

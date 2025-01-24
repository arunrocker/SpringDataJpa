package com.learnings.springJpa.componentmapping.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "streetaddress")
	private String streetaddress;
	private String city;
	private String state;
	@Column(name = "zipcode")
	private String zipCode;
	private String country;
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}

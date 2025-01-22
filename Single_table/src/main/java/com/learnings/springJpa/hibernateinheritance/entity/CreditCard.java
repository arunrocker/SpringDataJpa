package com.learnings.springJpa.hibernateinheritance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
public class CreditCard extends Payment{
	@Column(name = "cardnumber")
	private String creditnumber;

	public String getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}
	
}

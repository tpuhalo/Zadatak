package com.zadatak.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Size(max = 50, message = "* Max 50 letters")
	@NotEmpty(message = "* Cannot be empty")
	private String street;

	@Size(max = 5, message = "* Max 5 letters.")
	@NotEmpty(message = "* Cannot be empty")
	private String streetNumber;

	@ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private City city;

	public Address() {
	}

	public Address(int id, String street, String streetNumber, City city) {
		this.id = id;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", streetNumber=" + streetNumber + ", city=" + city + "]";
	}



}

package com.zadatak.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50, message = "* Max 50 letters")
	@NotEmpty(message = "* Cannot be empty")
	@Column(name = "street")
	private String street;

	@Size(max = 5, message = "* Max 5 letters.")
	@NotEmpty(message = "* Cannot be empty")
	@Column(name = "street_no")
	private String streetNumber;

	@ManyToOne()
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	@Column(name = "city_id", insertable = false, updatable = false)
	private long cityID;

	public Address() {
	}

	public Address(Long id, String street, String streetNumber, City city) {
		this.id = id;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public long getCityID() {
		return cityID;
	}

	public void setCityID(long cityID) {
		this.cityID = cityID;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", streetNumber=" + streetNumber + ", city=" + city + "]";
	}

}

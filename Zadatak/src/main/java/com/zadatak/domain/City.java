package com.zadatak.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Size(max = 50, message = "* Max 50 letters.")
	@NotEmpty(message = "* Cannot be empty")
	@Column(name="name")
	private String name;
	
	@Size(max = 10, message = "* Max 10 letters.")
	@NotEmpty(message = "* Cannot be empty")
	@Column(name = "zip_code")
	private String zipCode;
	
	@Valid
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="country_id", nullable = false) 
	private Country country;

	public City() {}

	public City(Long id, String name, String zipCode, Country country) {
		this.id = id;
		this.name = name;
		this.zipCode = zipCode;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", zipCode=" + zipCode + ", country=" + country + "]";
	}

	

}

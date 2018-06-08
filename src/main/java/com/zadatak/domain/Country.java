package com.zadatak.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Size(max = 50, message = "* Max 50 letters.")
	@NotEmpty(message = "* Cannot be empty")
	private String name;

	@Size(max = 2, message = "* Max 2 letters.")
	@NotEmpty(message = "* Cannot be empty")
	private String alpha2;

	@Size(max = 3, message = "* Max 3 letters.")
	@NotEmpty(message = "* Cannot be empty")
	private String alpha3;

	public Country() {
	}

	public Country(int id, String name, String alpha2, String alpha3) {
		this.id = id;
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlpha2() {
		return alpha2;
	}

	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}

	public String getAlpha3() {
		return alpha3;
	}

	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", alpha2=" + alpha2 + ", alpha3=" + alpha3 + "]";
	}



}

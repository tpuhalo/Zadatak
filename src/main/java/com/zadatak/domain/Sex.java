package com.zadatak.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "sex")
public class Sex {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	private String name;

	public Sex(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Sex [id=" + id + ", name=" + name + "]";
	}

}

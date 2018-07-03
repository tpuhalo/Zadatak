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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 20, message = "* Max 20 letters.")
	@NotEmpty(message = "* Cannot be empty")
	@Column(name = "first_name")
	private String firstName;

	@Size(max = 50, message = "* Max 50 letters.")
	@NotEmpty(message = "* Cannot be empty")
	@Column(name = "last_name")
	private String lastName;

	@Size(max = 13, message = "* Max 13 characters.")
	@NotEmpty(message = "* Cannot be empty")
	private String phone;

	@Email
	@Size(max = 50, message = "* Max 50 letters.")
	@NotEmpty(message = "* Cannot be empty")
	private String email;

	@ManyToOne()
	@JoinColumn(name = "sex_id", nullable = false)
	private Sex sex;

	@ManyToOne()
	@JoinColumn(name = "address_id", nullable = false)
	private Address addresses;

	public Contact() {
	}

	public Contact(Long id, String firstName, String lastName, String phone, String email, Sex sex, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.sex = sex;
		this.addresses = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Address getAddresses() {
		return addresses;
	}

	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", sex=" + sex + ", addresses=" + addresses + "]";
	}

}

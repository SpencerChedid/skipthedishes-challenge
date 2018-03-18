package com.skipthedishes.challenge.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order orderCustomer;

	@Column(name = "email")
	private String email;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "creation")
	private Date creation;

	@Column(name = "password")
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Order getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(Order orderCustomer) {
		this.orderCustomer = orderCustomer;
	}

}

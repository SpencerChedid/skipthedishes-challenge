package com.skipthedishes.challenge.model.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "date")
	private Date date;

	@Column(name = "delivery_address")
	private String deliveryAddress;

	@Column(name = "contact")
	private String contact;

	@Column(name = "store_id")
	private Integer storeId;

	@OneToMany(mappedBy = "orderTest")
	private Set<OrderItem> orderItems;
	
	@OneToMany(mappedBy = "orderCustomer")
	private Set<Customer> customer;

	@Column(name = "total")
	private Double total;

	@Column(name = "status")
	private String status;

	@Column(name = "last_update")
	private Date lastUpdate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

}

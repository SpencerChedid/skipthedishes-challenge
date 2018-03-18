package com.skipthedishes.challenge.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Double price;

	@OneToMany(mappedBy = "orderTest")
	private Set<OrderItem> orderItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}

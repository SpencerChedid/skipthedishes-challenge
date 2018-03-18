package com.skipthedishes.challenge.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order orderTest;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(name = "price")
	private Double price;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "total")
	private Double total;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrderTest() {
		return orderTest;
	}

	public void setOrderTest(Order orderTest) {
		this.orderTest = orderTest;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}

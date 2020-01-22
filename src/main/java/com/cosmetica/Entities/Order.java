package com.cosmetica.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private int quantity;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="product_id",nullable = false)
	private Product order_product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="cart_id",nullable = false)
	private Cart order_cart;
	

	public Order(int quantity, Product order_product, Cart order_cart) {
		super();
		this.quantity = quantity;
		this.order_product = order_product;
		this.order_cart = order_cart;
		this.inserted_at = new Date();
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getInserted_at() {
		return inserted_at;
	}

	public void setInserted_at(Date inserted_at) {
		this.inserted_at = inserted_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Product getOrder_product() {
		return order_product;
	}

	public void setOrder_product(Product order_product) {
		this.order_product = order_product;
	}

	public Cart getOrder_cart() {
		return order_cart;
	}

	public void setOrder_cart(Cart order_cart) {
		this.order_cart = order_cart;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", quantity=" + quantity
				+ ", inserted_at=" + inserted_at + ", updated_at=" + updated_at + ", order_product=" + order_product
				+ ", order_cart=" + order_cart + "]";
	}
	
	
	
	

}

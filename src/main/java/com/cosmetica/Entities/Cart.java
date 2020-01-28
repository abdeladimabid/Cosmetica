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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="carts")

public class Cart {@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	private int status;
	private String hash;

	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="client_id",nullable = false)
	private Client cart_user;
	
	@OneToMany(mappedBy = "order_cart",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@OneToOne(mappedBy = "body_cart")
	private InvoiceBody cart_body;


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cart(Client cart_user, List<Order> orders) {
		super();
		this.cart_user = cart_user;
		this.orders = orders;
		this.inserted_at = new Date();
		this.status=0;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", status=" + status + ", hash=" + hash + ", inserted_at=" + inserted_at
				+ ", updated_at=" + updated_at + ", cart_user=" + cart_user + ", orders=" + orders + ", cart_body="
				+ cart_body + "]";
	}

	public InvoiceBody getCart_body() {
		return cart_body;
	}

	public void setCart_body(InvoiceBody cart_body) {
		this.cart_body = cart_body;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public User getCart_user() {
		return cart_user;
	}

	public void setCart_user(Client cart_user) {
		this.cart_user = cart_user;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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
	
	
	
	
}

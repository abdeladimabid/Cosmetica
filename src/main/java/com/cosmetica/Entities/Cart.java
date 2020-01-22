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

@Entity
@Table(name="carts")
public class Cart {@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	private int status;
	private String hash;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="user_id",nullable = false)
	private User cart_user;
	
	@OneToMany(mappedBy = "order_cart",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@OneToMany(mappedBy = "head_cart",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<InvoiceHead> heads;

	public List<InvoiceHead> getHeads() {
		return heads;
	}

	public void setHeads(List<InvoiceHead> heads) {
		this.heads = heads;
	}

	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Cart(User cart_user, List<Order> orders) {
		super();
		this.cart_user = cart_user;
		this.orders = orders;
		this.inserted_at = new Date();
		this.status=0;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", status=" + status + ", hash=" + hash + ", cart_user=" + cart_user + ", orders="
				+ orders + ", inserted_at=" + inserted_at + ", updated_at=" + updated_at + "]";
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

	public void setCart_user(User cart_user) {
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

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
	private int cartId;
	private int status;
	private String hash;

	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date insertedAt;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="clientId",nullable = false)
	private Client cartUser;
	
	@OneToMany(mappedBy = "orderCart",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@OneToOne(mappedBy = "bodyCart")
	private InvoiceBody cartBody;


	public Cart() {
		super();
	}
	
	public Cart(Client cart_user, List<Order> orders) {
		super();
		this.cartUser = cart_user;
		this.orders = orders;
		this.insertedAt = new Date();
		this.status=0;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cartId + ", status=" + status + ", hash=" + hash + ", inserted_at=" + insertedAt
				+ ", updated_at=" + updatedAt + ", cart_user=" + cartUser + ", orders=" + orders + ", cart_body="
				+ cartBody + "]";
	}

	public InvoiceBody getCartBody() {
		return cartBody;
	}

	public void setCartBody(InvoiceBody cart_body) {
		this.cartBody = cart_body;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cart_id) {
		this.cartId = cart_id;
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

	public User getCartUser() {
		return cartUser;
	}

	public void setCartUser(Client cart_user) {
		this.cartUser = cart_user;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Date getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(Date inserted_at) {
		this.insertedAt = inserted_at;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updated_at) {
		this.updatedAt = updated_at;
	}
	
	
	
	
}

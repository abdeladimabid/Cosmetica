package com.cosmetica.dto;

import java.util.Date;
import java.util.List;

public class CartDTO {
	
	private int cartId;
	private int status;
	private String hash;
	private Date insertedAt;
	private Date updatedAt;
	private ClientDTO cartUser;
	private List<OrderDTO> orders;
	private InvoiceBodyDTO cartBody;

	public InvoiceBodyDTO getCartBody() {
		return cartBody;
	}

	public void setCartBody(InvoiceBodyDTO cartBody) {
		this.cartBody = cartBody;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public UserDTO getCartUser() {
		return cartUser;
	}

	public void setCartUser(ClientDTO cartUser) {
		this.cartUser = cartUser;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

	public Date getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
}

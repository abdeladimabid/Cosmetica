package com.cosmetica.dto;

import java.util.Date;

public class OrderDTO {

	private int orderId;
	private int quantity;
	private Date insertedAt;
	private Date updatedAt;
	private ProductDTO orderProduct;
	private CartDTO orderCart;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public ProductDTO getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(ProductDTO orderProduct) {
		this.orderProduct = orderProduct;
	}

	public CartDTO getOrderCart() {
		return orderCart;
	}

	public void setOrderCart(CartDTO orderCart) {
		this.orderCart = orderCart;
	}


}

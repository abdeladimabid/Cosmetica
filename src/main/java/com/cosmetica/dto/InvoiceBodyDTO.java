package com.cosmetica.dto;

import java.util.Date;
import java.util.List;

public class InvoiceBodyDTO {

	private int invoiceBodyId;
	private Date recievingDate;
	private String recipientFname;
	private String recipientLname;
	private String recipientPhone;
	private String recipientAdress;
	private Date insertedAt;
	private Date updatedAt;
	private CartDTO bodyCart;
	private List<InvoiceHeadDTO> bodyHeads;

	public int getInvoiceBodyId() {
		return invoiceBodyId;
	}

	public void setInvoiceBodyId(int invoiceBodyId) {
		this.invoiceBodyId = invoiceBodyId;
	}

	public Date getRecievingDate() {
		return recievingDate;
	}

	public void setRecievingDate(Date recievingDate) {
		this.recievingDate = recievingDate;
	}

	public String getRecipientFname() {
		return recipientFname;
	}

	public void setRecipientFname(String recipientFname) {
		this.recipientFname = recipientFname;
	}

	public String getRecipientLname() {
		return recipientLname;
	}

	public void setRecipientLname(String recipientLname) {
		this.recipientLname = recipientLname;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	public String getRecipientAdress() {
		return recipientAdress;
	}

	public void setRecipientAdress(String recipientAdress) {
		this.recipientAdress = recipientAdress;
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

	public CartDTO getBodyCart() {
		return bodyCart;
	}

	public void setBodyCart(CartDTO bodyCart) {
		this.bodyCart = bodyCart;
	}

	public List<InvoiceHeadDTO> getBodyHeads() {
		return bodyHeads;
	}

	public void setBodyHeads(List<InvoiceHeadDTO> bodyHeads) {
		this.bodyHeads = bodyHeads;
	}
	
}

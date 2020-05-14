package com.cosmetica.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="invoiceBody")
@JsonIgnoreProperties(ignoreUnknown = true , value = {"hibernateLazyInitializer", "handler", "bodyHeads", "bodyCart"})
public class InvoiceBody {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceBodyId;
	private Date recievingDate;
	private String recipientFname;
	private String recipientLname;
	private String recipientPhone;
	private String recipientAdress;
	@CreationTimestamp
	private Date insertedAt;
	@UpdateTimestamp
	private Date updatedAt;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
	private Cart bodyCart;
	
	@OneToMany(mappedBy = "headBody",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<InvoiceHead> bodyHeads;

	public InvoiceBody() {
		super();
	}

	public InvoiceBody(Date recievingDate, String recipientFname, String recipientLname, String recipientPhone,
			String recipientAdress, Cart bodyCart) {
		super();
		this.recievingDate = recievingDate;
		this.recipientFname = recipientFname;
		this.recipientLname = recipientLname;
		this.recipientPhone = recipientPhone;
		this.recipientAdress = recipientAdress;
		this.bodyCart = bodyCart;
		this.insertedAt = new Date();
	}

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

	public Cart getBodyCart() {
		return bodyCart;
	}

	public void setBodyCart(Cart bodyCart) {
		this.bodyCart = bodyCart;
	}

	public List<InvoiceHead> getBodyHeads() {
		return bodyHeads;
	}

	public void setBodyHeads(List<InvoiceHead> bodyHeads) {
		this.bodyHeads = bodyHeads;
	}

	@Override
	public String toString() {
		return "InvoiceBody [invoiceBodyId=" + invoiceBodyId + ", recievingDate=" + recievingDate + ", recipientFname="
				+ recipientFname + ", recipientLname=" + recipientLname + ", recipientPhone=" + recipientPhone
				+ ", recipientAdress=" + recipientAdress + ", insertedAt=" + insertedAt + ", updatedAt=" + updatedAt
				+ ", bodyCart=" + bodyCart + ", bodyHeads=" + bodyHeads + "]";
	}

	
}

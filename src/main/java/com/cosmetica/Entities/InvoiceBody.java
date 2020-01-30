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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date insertedAt;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updatedAt;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
	private Cart bodyCart;
	
	@OneToMany(mappedBy = "headBody",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<InvoiceHead> bodyHeads;

	public InvoiceBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceBody(Date recieving_date, String recipient_fname, String recipient_lname, String recipient_phone,
			String recipient_adress, Cart body_cart) {
		super();
		this.recievingDate = recieving_date;
		this.recipientFname = recipient_fname;
		this.recipientLname = recipient_lname;
		this.recipientPhone = recipient_phone;
		this.recipientAdress = recipient_adress;
		this.bodyCart = body_cart;
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

package com.cosmetica.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="invoiceHead")
public class InvoiceHead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceHeadId;
	private int ref;
	private String hash;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date insertedAt;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="invoiceTypeId",nullable = false)
	private InvoiceType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="invoiceBodyId",nullable = false)
	private InvoiceBody headBody;

	public InvoiceHead(InvoiceType type, InvoiceBody head_body) {
		super();
		this.type = type;
		this.headBody = head_body;
		this.insertedAt = new Date();
	}

	public InvoiceHead() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getInvoiceHeadId() {
		return invoiceHeadId;
	}

	public void setInvoiceHeadId(int invoiceHeadId) {
		this.invoiceHeadId = invoiceHeadId;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
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

	public InvoiceType getType() {
		return type;
	}

	public void setType(InvoiceType type) {
		this.type = type;
	}

	public InvoiceBody getHeadBody() {
		return headBody;
	}

	public void setHeadBody(InvoiceBody headBody) {
		this.headBody = headBody;
	}

	@Override
	public String toString() {
		return "InvoiceHead [invoiceHeadId=" + invoiceHeadId + ", ref=" + ref + ", hash=" + hash + ", insertedAt="
				+ insertedAt + ", updatedAt=" + updatedAt + ", type=" + type + ", headBody=" + headBody + "]";
	}
	
	
}

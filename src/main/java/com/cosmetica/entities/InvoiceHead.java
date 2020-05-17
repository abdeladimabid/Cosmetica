package com.cosmetica.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="invoiceHead")
public class InvoiceHead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceHeadId;
	private int ref;
	private String hash;
	@CreationTimestamp
	private Date insertedAt;
	@UpdateTimestamp
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="invoiceTypeId",nullable = false)
	private InvoiceType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="invoiceBodyId",nullable = false)
	private InvoiceBody headBody;

	public InvoiceHead(InvoiceType type, InvoiceBody headBody) {
		super();
		this.type = type;
		this.headBody = headBody;
		this.insertedAt = new Date();
	}

	public InvoiceHead() {
		super();
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

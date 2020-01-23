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
@Table(name="invoice_head")
public class InvoiceHead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_head_id;
	private int ref;
	private String hash;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="invoice_type_id",nullable = false)
	private InvoiceType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="invoice_body_id",nullable = false)
	private InvoiceBody head_body;

	public InvoiceHead(int ref, InvoiceType type, Cart head_cart, InvoiceBody head_body) {
		super();
		this.ref = ref;
		this.type = type;
		this.head_body = head_body;
		this.inserted_at = new Date();
	}

	public InvoiceHead() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getInvoice_head_id() {
		return invoice_head_id;
	}

	public void setInvoice_head_id(int invoice_head_id) {
		this.invoice_head_id = invoice_head_id;
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

	public InvoiceType getType() {
		return type;
	}

	public void setType(InvoiceType type) {
		this.type = type;
	}

	public InvoiceBody getHead_body() {
		return head_body;
	}

	public void setHead_body(InvoiceBody head_body) {
		this.head_body = head_body;
	}

	@Override
	public String toString() {
		return "InvoiceHead [invoice_head_id=" + invoice_head_id + ", ref=" + ref + ", hash=" + hash + ", inserted_at="
				+ inserted_at + ", updated_at=" + updated_at + ", type=" + type + ", head_cart="+ ", head_body=" + head_body + "]";
	}

}

package com.cosmetica.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="invoice_type")
public class InvoiceType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_type_id;
	private int label;

	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;

	@OneToMany(mappedBy = "type",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<InvoiceHead> heads;
	
	
	public InvoiceType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public InvoiceType(int label) {
		super();
		this.label = label;
		this.inserted_at = new Date();
	}


	public int getInvoice_type_id() {
		return invoice_type_id;
	}

	public void setInvoice_type_id(int invoice_type_id) {
		this.invoice_type_id = invoice_type_id;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
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

	public List<InvoiceHead> getHeads() {
		return heads;
	}

	public void setHeads(List<InvoiceHead> heads) {
		this.heads = heads;
	}

	@Override
	public String toString() {
		return "InvoiceType [invoice_type_id=" + invoice_type_id + ", label=" + label + ", inserted_at=" + inserted_at
				+ ", updated_at=" + updated_at + ", heads=" + heads + "]";
	}
	

	
}

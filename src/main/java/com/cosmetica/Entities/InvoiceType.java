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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="invoiceType")
@JsonIgnoreProperties(ignoreUnknown = true , value = {"hibernateLazyInitializer", "handler", "heads"})
public class InvoiceType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceTypeId;
	private String label;

	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date insertedAt;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updatedAt;

	@OneToMany(mappedBy = "type",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<InvoiceHead> heads;
	
	
	public InvoiceType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InvoiceType(String label) {
		super();
		this.label = label;
		this.insertedAt = new Date();
	}


	public int getInvoiceTypeId() {
		return invoiceTypeId;
	}


	public void setInvoiceTypeId(int invoiceTypeId) {
		this.invoiceTypeId = invoiceTypeId;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
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


	public List<InvoiceHead> getHeads() {
		return heads;
	}


	public void setHeads(List<InvoiceHead> heads) {
		this.heads = heads;
	}


	@Override
	public String toString() {
		return "InvoiceType [invoiceTypeId=" + invoiceTypeId + ", label=" + label + ", insertedAt=" + insertedAt
				+ ", updatedAt=" + updatedAt + ", heads=" + heads + "]";
	}
	

	
}

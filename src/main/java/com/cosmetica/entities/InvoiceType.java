package com.cosmetica.entities;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="invoiceType")
@JsonIgnoreProperties(ignoreUnknown = true , value = {"hibernateLazyInitializer", "handler", "heads"})
public class InvoiceType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceTypeId;
	private String label;
	@CreationTimestamp
	private Date insertedAt;
	@UpdateTimestamp
	private Date updatedAt;

	@OneToMany(mappedBy = "type",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<InvoiceHead> heads;
	
	
	public InvoiceType() {
		super();
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

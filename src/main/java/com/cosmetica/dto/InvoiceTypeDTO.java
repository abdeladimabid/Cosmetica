package com.cosmetica.dto;

import java.util.Date;
import java.util.List;

public class InvoiceTypeDTO {
	
	private int invoiceTypeId;
	private String label;
	private Date insertedAt;
	private Date updatedAt;
	private List<InvoiceHeadDTO> heads;

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


	public List<InvoiceHeadDTO> getHeads() {
		return heads;
	}


	public void setHeads(List<InvoiceHeadDTO> heads) {
		this.heads = heads;
	}


	
}

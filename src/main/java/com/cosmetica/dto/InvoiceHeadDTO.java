package com.cosmetica.dto;

import java.util.Date;

public class InvoiceHeadDTO {

	private int invoiceHeadId;
	private int ref;
	private String hash;
	private Date insertedAt;
	private Date updatedAt;
	private InvoiceTypeDTO type;
	private InvoiceBodyDTO headBody;


	public InvoiceHeadDTO() {
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

	public InvoiceTypeDTO getType() {
		return type;
	}

	public void setType(InvoiceTypeDTO type) {
		this.type = type;
	}

	public InvoiceBodyDTO getHeadBody() {
		return headBody;
	}

	public void setHeadBody(InvoiceBodyDTO headBody) {
		this.headBody = headBody;
	}
	
	
}

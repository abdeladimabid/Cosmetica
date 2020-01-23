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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="invoice_body")
public class InvoiceBody {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_body_id;
	private Date recieving_date;
	private String recipient_fname;
	private String recipient_lname;
	private String recipient_phone;
	private String recipient_adress;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	
	@OneToMany(mappedBy = "head_body",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<InvoiceHead> body_heads;

	public InvoiceBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceBody(Date recieving_date, String recipient_fname, String recipient_lname, String recipient_phone,
			String recipient_adress) {
		super();
		this.recieving_date = recieving_date;
		this.recipient_fname = recipient_fname;
		this.recipient_lname = recipient_lname;
		this.recipient_phone = recipient_phone;
		this.recipient_adress = recipient_adress;
		this.inserted_at = new Date();
	}

	public int getInvoice_body_id() {
		return invoice_body_id;
	}

	public void setInvoice_body_id(int invoice_body_id) {
		this.invoice_body_id = invoice_body_id;
	}

	public Date getRecieving_date() {
		return recieving_date;
	}

	public void setRecieving_date(Date recieving_date) {
		this.recieving_date = recieving_date;
	}

	public String getRecipient_fname() {
		return recipient_fname;
	}

	public void setRecipient_fname(String recipient_fname) {
		this.recipient_fname = recipient_fname;
	}

	public String getRecipient_lname() {
		return recipient_lname;
	}

	public void setRecipient_lname(String recipient_lname) {
		this.recipient_lname = recipient_lname;
	}

	public String getRecipient_phone() {
		return recipient_phone;
	}

	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}

	public String getRecipient_adress() {
		return recipient_adress;
	}

	public void setRecipient_adress(String recipient_adress) {
		this.recipient_adress = recipient_adress;
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

	public List<InvoiceHead> getBody_heads() {
		return body_heads;
	}

	public void setBody_heads(List<InvoiceHead> body_heads) {
		this.body_heads = body_heads;
	}

	@Override
	public String toString() {
		return "InvoiceBody [invoice_body_id=" + invoice_body_id + ", recieving_date=" + recieving_date
				+ ", recipient_fname=" + recipient_fname + ", recipient_lname=" + recipient_lname + ", recipient_phone="
				+ recipient_phone + ", recipient_adress=" + recipient_adress + ", inserted_at=" + inserted_at
				+ ", updated_at=" + updated_at + ", body_heads=" + body_heads + "]";
	}


	
	
	
}

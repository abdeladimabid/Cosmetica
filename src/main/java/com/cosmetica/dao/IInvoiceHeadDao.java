package com.cosmetica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.InvoiceHead;

@Repository
public interface IInvoiceHeadDao extends JpaRepository<InvoiceHead, Integer>{
	
	@Query( value = "SELECT * FROM invoice_type t, invoice_head h WHERE t.invoice_type_id = h.invoice_type_id AND label='facture' ORDER BY h.ref DESC LIMIT 1",
			nativeQuery = true)
	InvoiceHead getLastInsertedFac();
	@Query( value = "SELECT * FROM invoice_type t, invoice_head h WHERE t.invoice_type_id = h.invoice_type_id AND label='devis' ORDER BY h.ref DESC LIMIT 1",
			nativeQuery = true)
	InvoiceHead getLastInsertedDev();
	@Query( value = "SELECT * FROM invoice_type t, invoice_head h WHERE t.invoice_type_id = h.invoice_type_id AND label='bon' ORDER BY h.ref DESC LIMIT 1",
			nativeQuery = true)
	InvoiceHead getLastInsertedBon();
}
package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.InvoiceHead;

public interface IInvoiceHeadService {
	
	public List<InvoiceHead> getAll();

	public Optional<InvoiceHead> getOneById(int id);

	public void saveOrUpdate(InvoiceHead invoiceHead);

	public void delete(InvoiceHead invoiceHead);

}

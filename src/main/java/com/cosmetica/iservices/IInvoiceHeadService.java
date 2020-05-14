package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.InvoiceBody;
import com.cosmetica.entities.InvoiceHead;

public interface IInvoiceHeadService {
	
	public List<InvoiceHead> getAll();

	public Optional<InvoiceHead> getOneById(int id);

	public void saveOrUpdate(InvoiceHead invoiceHead);

	public void delete(InvoiceHead invoiceHead);
	
	public InvoiceBody getBody(InvoiceHead invoiceHead);

	public InvoiceHead getLastFac();

	public InvoiceHead getLastBon();

	public InvoiceHead getLastDev();

}

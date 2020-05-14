package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.InvoiceType;

public interface IInvoiceTypeService {
	
	public List<InvoiceType> getAll();

	public Optional<InvoiceType> getOneById(int id);

	public void saveOrUpdate(InvoiceType invoiceType);

	public void delete(InvoiceType invoiceType);

}

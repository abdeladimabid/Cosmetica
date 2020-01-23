package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.InvoiceBody;

public interface IInvoiceBodyService {
	
	public List<InvoiceBody> getAll();

	public Optional<InvoiceBody> getOneById(int id);

	public void saveOrUpdate(InvoiceBody invoiceBody);

	public void delete(InvoiceBody invoiceBody);
	
	public Cart getBodyCart(InvoiceBody InvoiceBody);
	
	
}

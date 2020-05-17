package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Cart;
import com.cosmetica.entities.InvoiceBody;
import com.cosmetica.entities.InvoiceHead;

public interface IInvoiceBodyService {
	
	public List<InvoiceBody> getAll();

	public Optional<InvoiceBody> getOneById(int id);

	public void saveOrUpdate(InvoiceBody invoiceBody);

	public void delete(InvoiceBody invoiceBody);
	
	public Cart getBodyCart(InvoiceBody invoiceBody);

	public List<InvoiceHead> getBodyHeads(InvoiceBody invoiceBody);
	
	
}

package com.cosmetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IInvoiceBodyDao;
import com.cosmetica.entities.Cart;
import com.cosmetica.entities.InvoiceBody;
import com.cosmetica.entities.InvoiceHead;
import com.cosmetica.iservices.IInvoiceBodyService;

@Service
public class InvoiceBodyService implements IInvoiceBodyService{

	@Autowired
	IInvoiceBodyDao dao;

	@Override
	public List<InvoiceBody> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<InvoiceBody> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(InvoiceBody invoiceBody) {
		dao.save(invoiceBody);
	}

	@Override
	public void delete(InvoiceBody invoiceBody) {
		dao.delete(invoiceBody);
	}
	
	@Override
	public Cart getBodyCart(InvoiceBody invoiceBody){
		return invoiceBody.getBodyCart();
	}
	
	@Override
	public List<InvoiceHead> getBodyHeads(InvoiceBody invoiceBody){
		return invoiceBody.getBodyHeads();
	}
	
	
}

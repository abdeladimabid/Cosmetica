package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.IInvoiceBodyDao;
import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.InvoiceBody;
import com.cosmetica.Entities.InvoiceHead;
import com.cosmetica.IServices.IInvoiceBodyService;

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
	public void saveOrUpdate(InvoiceBody InvoiceBody) {
		dao.save(InvoiceBody);
	}

	@Override
	public void delete(InvoiceBody InvoiceBody) {
		dao.delete(InvoiceBody);
	}
	
	@Override
	public Cart getBodyCart(InvoiceBody InvoiceBody){
		return InvoiceBody.getBodyCart();
	}
	
	@Override
	public List<InvoiceHead> getBodyHeads(InvoiceBody InvoiceBody){
		return InvoiceBody.getBodyHeads();
	}
	
	
}

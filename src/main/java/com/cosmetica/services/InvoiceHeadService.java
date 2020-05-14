package com.cosmetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IInvoiceHeadDao;
import com.cosmetica.entities.InvoiceBody;
import com.cosmetica.entities.InvoiceHead;
import com.cosmetica.iservices.IInvoiceHeadService;

@Service
public class InvoiceHeadService implements IInvoiceHeadService{

	@Autowired
	IInvoiceHeadDao dao;

	@Override
	public List<InvoiceHead> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<InvoiceHead> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(InvoiceHead invoiceHead) {
		dao.save(invoiceHead);
	}

	@Override
	public void delete(InvoiceHead invoiceHead) {
		dao.delete(invoiceHead);
	}
	
	@Override
	public InvoiceBody getBody(InvoiceHead invoiceHead) {
		return invoiceHead.getHeadBody();
	}
	
	@Override
	public InvoiceHead getLastFac() {
		return dao.getLastInsertedFac();
	}
	
	@Override
	public InvoiceHead getLastBon() {
		return dao.getLastInsertedBon();
	}
	
	@Override
	public InvoiceHead getLastDev() {
		return dao.getLastInsertedDev();
	}
}

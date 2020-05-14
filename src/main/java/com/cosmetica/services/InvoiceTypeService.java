package com.cosmetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IInvoiceTypeDao;
import com.cosmetica.entities.InvoiceType;
import com.cosmetica.iservices.IInvoiceTypeService;

@Service
public class InvoiceTypeService implements IInvoiceTypeService{

	@Autowired
	IInvoiceTypeDao dao;

	@Override
	public List<InvoiceType> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<InvoiceType> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(InvoiceType invoiceType) {
		dao.save(invoiceType);
	}

	@Override
	public void delete(InvoiceType invoiceType) {
		dao.delete(invoiceType);
	}
	
}

package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.IInvoiceTypeDao;
import com.cosmetica.Entities.InvoiceType;
import com.cosmetica.IServices.IInvoiceTypeService;

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
	public void saveOrUpdate(InvoiceType InvoiceType) {
		dao.save(InvoiceType);
	}

	@Override
	public void delete(InvoiceType InvoiceType) {
		dao.delete(InvoiceType);
	}
	
}

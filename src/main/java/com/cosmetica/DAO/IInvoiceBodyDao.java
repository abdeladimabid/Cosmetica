package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.InvoiceBody;

public interface IInvoiceBodyDao extends JpaRepository<InvoiceBody, Integer>{

}

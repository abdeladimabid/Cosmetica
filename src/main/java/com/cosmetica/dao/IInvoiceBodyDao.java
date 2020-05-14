package com.cosmetica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.InvoiceBody;
@Repository
public interface IInvoiceBodyDao extends JpaRepository<InvoiceBody, Integer>{

}

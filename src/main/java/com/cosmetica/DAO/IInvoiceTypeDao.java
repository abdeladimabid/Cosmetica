package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.InvoiceType;

public interface IInvoiceTypeDao extends JpaRepository<InvoiceType, Integer>{

}

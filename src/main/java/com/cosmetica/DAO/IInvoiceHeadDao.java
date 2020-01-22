package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.InvoiceHead;

public interface IInvoiceHeadDao extends JpaRepository<InvoiceHead, Integer>{

}

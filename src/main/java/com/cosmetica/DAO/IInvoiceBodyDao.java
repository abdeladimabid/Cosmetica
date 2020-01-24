package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.InvoiceBody;
@Repository
public interface IInvoiceBodyDao extends JpaRepository<InvoiceBody, Integer>{

}

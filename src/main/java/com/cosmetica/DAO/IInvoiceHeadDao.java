package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.InvoiceHead;
@Repository
public interface IInvoiceHeadDao extends JpaRepository<InvoiceHead, Integer>{

}

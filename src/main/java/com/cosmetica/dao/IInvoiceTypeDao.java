package com.cosmetica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.InvoiceType;
@Repository
public interface IInvoiceTypeDao extends JpaRepository<InvoiceType, Integer>{

}

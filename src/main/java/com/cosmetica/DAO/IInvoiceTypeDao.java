package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.InvoiceType;
@Repository
public interface IInvoiceTypeDao extends JpaRepository<InvoiceType, Integer>{

}

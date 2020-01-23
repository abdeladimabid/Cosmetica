package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.IOrederDao;
import com.cosmetica.Entities.Order;
import com.cosmetica.IServices.IOrderService;

public class OrderService implements IOrderService{

	@Autowired
	IOrederDao dao;

	@Override
	public List<Order> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<Order> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Order Order) {
		dao.save(Order);
	}

	@Override
	public void delete(Order Order) {
		dao.delete(Order);
	}
	

}

package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Order;

public interface IOrderService {
	
	public List<Order> getAll();

	public Optional<Order> getOneById(int id);

	public void saveOrUpdate(Order order);

	public void delete(Order order);


}

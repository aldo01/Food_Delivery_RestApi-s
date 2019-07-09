package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.Domain.Order;
import com.example.Domain.OrderStatus;

public interface OrderService {
	public Order findById(String id);
	public void save(Order order);
	public String createOrder(Map<Object, Object> map);
	public List<Order> getOrderActiveStatus();
	public OrderStatus getOrderStatus(String id);
	public String updateStatus(Long id,OrderStatus currentStatus, OrderStatus newStatus);
	
}

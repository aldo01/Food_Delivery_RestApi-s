package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import com.example.Domain.Order;

import com.example.Domain.OrderRepository;
import com.example.Domain.OrderStatus;


@Repository
@Component
public class OrderServiceImpl implements OrderService  {
	
   @Autowired
    private OrderRepository orderRepository;
    
   @Autowired
   public OrderServiceImpl(OrderRepository orderRepository) {
       
       this.orderRepository = orderRepository;
   }
    
    public OrderStatus findStatusById(String id) {
        return orderRepository.findStatusById(id);
    }
   
    public Order findById(String id) {
        return orderRepository.findById(id);
    }
    public void save(Order order) {
        this.orderRepository.save(order);
    }
    
    public String createOrder(Map<Object, Object> map) {
    	UUID uuid = UUID.randomUUID();
    	String id=uuid.toString();
    	Order or= null;
    	or.setId(id);
    	or.setCustomerName((String) map.get("customerName"));
    	or.setAddress((String) map.get("address"));
    	or.setContent((String) map.get("content"));
    	or.setStatus(OrderStatus.ACCEPTED) ;
    	or.setTotal((double) map.get("total"));
    	or.setInstruction((String) map.get("instruction"));
    	or.setOrderTimeMinute(System.currentTimeMillis());
        this.orderRepository.save(or);
        return or.getId();
    }

 
	public List<Order> getOrderActiveStatus() {
		List<Order> orderList = orderRepository.findAll();
		
		return orderList;
	}


	public OrderStatus getOrderStatus(String id) {
		
		return this.orderRepository.findStatusById(id);
	
	}

	public String updateStatus(Long id,OrderStatus currentStatus, OrderStatus newStatus) {
		String sccess ="Status is updated";
		String error ="Status value is same";
		if (currentStatus.equals(newStatus)) {
			return error;
		}
		orderRepository.updateStatusByorder(id,newStatus);
		return sccess;
		
	}


}
package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import com.example.Domain.Order;

import com.example.Domain.OrderRepository;
import com.example.Domain.Status;

@Service
public class OrderServiceImpl  {
   
    private OrderRepository orderRepository;
    
    
   
  
    public OrderServiceImpl(OrderRepository repository) {
        this.orderRepository = repository;
    }

   
    public String findById(String id) {
        return orderRepository.findStatusById(id);
    }
   
    public void save(Order order) {
        this.orderRepository.save(order);
    }
    
    public Long createOrder(Map<Object, Object> map) {
    	Order or=null;
    	or.setId((Long) map.get("id"));
    	or.setCustomerName((String) map.get("customerName"));
    	or.setAddress((String) map.get("address"));
    	or.setContent((String) map.get("content"));
    	or.setStatus(Status.ACCEPTED) ;
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


	public String getOrderStatus(String id) {
		
		return this.orderRepository.findStatusById(id);
	
	}


	


	public String updateStatus(Long id,Status currentStatus, Status newStatus) {
		String sccess ="Status is updated";
		String error ="Status value is same";
		if (currentStatus.equals(newStatus)) {
			return error;
		}
		orderRepository.updateStatusByorder(id,newStatus);
		return sccess;
		
	}


   

}
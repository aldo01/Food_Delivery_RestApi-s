package com.example.service;

import java.util.List;

import com.example.Domain.Order;

public interface DeliveryService {
	
	public List<String> getActivedeliveryPerson();
	public String delegateDeliveryPersomal(Order oder);
	
	

}

package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.Domain.DeliveryPerson;
import com.example.Domain.DeliveryPersonRepository;
import com.example.Domain.DeliveryStatus;
import com.example.Domain.Order;


@Repository

public class DeliveryServiceImpl implements DeliveryService {
	
	
	DeliveryPersonRepository deliverypersonrepository;
	
	
	@Autowired(required=false)
	   public DeliveryServiceImpl(DeliveryPersonRepository deliverypersonrepository) {
	       
	       this.deliverypersonrepository = deliverypersonrepository;
	   }
	

	
	
	public List<String> getActivedeliveryPerson(){
		List<DeliveryPerson> list=deliverypersonrepository.getDeliverypPerson();
		List<String>mylist=new ArrayList<String>();
		for(DeliveryPerson l: list){
			if(l.getStatus()==DeliveryStatus.ONWAY){
				mylist.add(l.getPersonName());
			}
		}
		return mylist;
	}
	
	public String delegateDeliveryPersomal(Order order){
		DeliveryPerson dp= deliverypersonrepository.findFreeDeliveryPersons();
		dp.setDelivertAddressPhoneNumber(order.getPhoneNumber());
		dp.setDeliveryAddress(order.getAddress());
		dp.setdeliveryPersonId(order.getId());
		dp.setStatus(DeliveryStatus.ONWAY);
		
		return "ON_WAY";
		
	}
   
}

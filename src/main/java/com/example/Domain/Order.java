package com.example.Domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="orders")
@SequenceGenerator(name="sequence", initialValue=1,allocationSize=1)
public class Order {
   
    @javax.persistence.Id
    private String id;

    //Name of the customer
    private String customerName;
    //ID used to find the restaurant, if there are multiple restaurants with the same name
    private String providerId;
    //Special Instructions
    private String instruction;
    //Delivery Address;
    private String address;
    //Total value of this order;
    private double total;
    // Status of this order
    private OrderStatus status;
    //Content of this order
    private String content;
    public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getTotal() {
		return total;
	}


	public String getContent() {
		return content;
	}

	private Long phoneNumber;
    //estimated delivery time in minutes
    private double orderTimeMinute;
   

	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus b) {
		this.status = b;
	}

	

	public void setContent(String string) {
		this.content = string;
	}

	public double getOrderTimeMinute() {
		return orderTimeMinute;
	}

	public void setOrderTimeMinute(double deliveryTimeMinute) {
		this.orderTimeMinute = orderTimeMinute;
	}

	public void setId(String id2) {
		this.id = id2;
	}

	public void setTotal(double total) {
		this.total = total;
	}



	

}
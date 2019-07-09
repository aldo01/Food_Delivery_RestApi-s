package com.example.Domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "delivery")
public class DeliveryPerson {
	@javax.persistence.Id
	private String Id;
    @SuppressWarnings("unused")
	private int  count;
    private String personName;
    private String deliveryPersonId;
    private  DeliveryStatus status;
    private double deliverytime;
    private double timeDuration;
    private String deliveryAddress;
    private Long delivertAddressPhoneNumber;
    
   public String getdeliveryPersonId() {
		return deliveryPersonId;
	}
	public void setdeliveryPersonId(String order_id) {
		deliveryPersonId = order_id;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public Long getDelivertAddressPhoneNumber() {
		return delivertAddressPhoneNumber;
	}
	public void setDelivertAddressPhoneNumber(Long delivertAddressPhoneNumber) {
		this.delivertAddressPhoneNumber = delivertAddressPhoneNumber;
	}

public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPersonName() {
		return personName;
	}

	public double getTimeDuration() {
		return timeDuration;
	}
	public void setTimeDuration(double timeDuration) {
		this.timeDuration = timeDuration;
	}

   
   
	public double getDeliverytime() {
	return deliverytime;
    }
   public void setDeliverytime(double deliverytime) {
	this.deliverytime = deliverytime;
    }
	public int getCount() {
		return count;
	}
	public void setCount(int number) {
		this.count = count;
	}
	public DeliveryStatus getStatus() {
		return status;
	}
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

   
}
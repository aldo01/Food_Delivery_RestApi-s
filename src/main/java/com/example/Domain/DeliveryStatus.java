package com.example.Domain;

public enum DeliveryStatus {
	FREE(0),ONWAY(1),ORDER_PICKED(2);
	
	private int val;

	DeliveryStatus(int val){
		this.val=val;
	}

}

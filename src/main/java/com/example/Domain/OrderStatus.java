package com.example.Domain;

public enum OrderStatus {
	ACTIVE(0),ACCEPTED(1),PROCESSING(2),DELIVERED(3);
	
	private int val;

	OrderStatus(int val){
		this.val=val;
	}

}

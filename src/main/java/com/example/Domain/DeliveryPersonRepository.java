package com.example.Domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Serializable> {
	@Query(value="select * from DeliveryPerson",nativeQuery=true)
	public List<DeliveryPerson>getDeliverypPerson();
	@Query(value="select * from DeliveryPerson where status=?0",nativeQuery=true)
	public DeliveryPerson findFreeDeliveryPersons();
	

}

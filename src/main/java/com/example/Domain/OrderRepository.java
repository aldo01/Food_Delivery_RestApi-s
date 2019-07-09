package com.example.Domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepository extends JpaRepository<Order,Serializable> {
  @Query(value="select Status s from Order o where o.id=id",nativeQuery=true)
  OrderStatus findStatusById(String id);
  
  @Query(value="select * from Order where id=:Order_id",nativeQuery=true)
	Order findById(String order_id);

	
    
	@Query(value="update Status s from Orders o set s.Status=newStatus ",nativeQuery=true)
	void updateStatusByorder(Long id,OrderStatus newStatus);
	
	@Query(value="select  from Order where Status=?0",nativeQuery=true)
	List<Order> findOrderStatusActive();
}
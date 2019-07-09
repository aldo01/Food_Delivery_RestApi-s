  package com.example;


import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;



import com.example.Domain.Order;
import com.example.Domain.OrderStatus;
import com.example.service.DeliveryServiceImpl;
import com.example.service.OrderService;


@RestController
@ComponentScan("com.example.service")
  public class OrderServiceRestController {
    
      
      private OrderService orderService;
      
      private Order order;
     
     DeliveryServiceImpl deliveryservice;
     
     @Autowired(required=false)
     public OrderServiceRestController(OrderService orderService) {
         
         this.orderService = orderService;
     }
     
     @Autowired(required=false)
     public OrderServiceRestController(DeliveryServiceImpl deliveryservice) {
         
         this.deliveryservice = deliveryservice;
     }
     
//Rest Api to get status of the order by id

      @RequestMapping(value = "/orderStatus/{id}", method = RequestMethod.GET)
      String getStatusOrder(@RequestParam("id")String id) {
           orderService.getOrderStatus(id);
           return "fjhndjfhjd";
      }

      // Rest Api to create the order

      @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
      
      String CreateOrder(@RequestBody Map<Object, Object> map) {
    	   
             orderService.createOrder(map);
              return order.getId();
      }

    // Rest Api to update the status of the order

      @RequestMapping(value = "/update/orderStatus", method = RequestMethod.POST)
       public String updateDeliveryStatus(@RequestBody Map<String, Object> data) {
    	  
    	  Long orderId=(Long) data.get("orderId");
    	  OrderStatus currentStatus=(OrderStatus) data.get("currentStatus");
    	  OrderStatus newStatus=(OrderStatus) data.get("newStatus");
    	  String response=orderService.updateStatus(orderId,currentStatus,newStatus);
    	  
         return"response";
          
      }
      
      //Rest Api to get  delivery person which is On_Way (Active)
      
      @RequestMapping(value = "/deliveryperson/active", method = RequestMethod.GET)
           List<String> getActiveDeliveryPersons(){
    	  List<String> mylist=deliveryservice.getActivedeliveryPerson();
    	    
    	  return mylist;
      }
      
      // Rest Api to Delegate an order to the delivery person used by restutant person
      @RequestMapping(value = "/delegate/order/{id}", method = RequestMethod.POST)
      public String delegateDeliveryPersonel(@RequestParam("id")String id){
    	   Order order= orderService.findById(id);
    	  String response= deliveryservice.delegateDeliveryPersomal(order);
    	   return response;
    	  
      }
      }
  
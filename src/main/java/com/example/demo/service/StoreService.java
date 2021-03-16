package com.example.demo.service;

import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.exception.PetNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.storage.OrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class StoreService {
    @Autowired
    OrderRepository orderRepository;

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getById(long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        return order;
    }

    public void deleteById(long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new OrderNotFoundException(id);
        }
    }
    public List<Order> getAllOrders(){
        List<Order> orders=orderRepository.findAll();
        if(orders!=null){
            return orders;
        }else {
            throw new OrderNotFoundException("Orders not found");
        }
    }

}

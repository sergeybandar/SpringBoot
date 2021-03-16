package com.example.demo.resource;


import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.model.Pet;
import com.example.demo.model.PetStatus;
import com.example.demo.service.PetService;
import org.apache.catalina.util.ParameterMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.StoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/store")
public class StoreResource {

    @Autowired
    StoreService storeService;
    @Autowired
    PetService petService;

    @PostMapping(path = "/order")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        storeService.createOrder(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(path = "/order/{orderId}")
    public ResponseEntity<Order> getById(@PathVariable(name = "orderId") long id) {
        Order order = storeService.getById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping(path = "/order/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable(name = "orderId") long id) {
        storeService.deleteById(id);
        return new ResponseEntity<>("Order deleted", HttpStatus.OK);
    }

    @GetMapping(path = "/inventory")
    public ResponseEntity<Map<PetStatus, Integer>> petsWithStatus() {
        List<Pet> pets = petService.getAllPets();
        Map<PetStatus, Integer> petsWithStatus = new ParameterMap<>();
        petsWithStatus.put(PetStatus.AVAILABLE, 0);
        petsWithStatus.put(PetStatus.PENDING, 0);
        petsWithStatus.put(PetStatus.SOLD, 0);
        for (Pet pet : pets) {
            petsWithStatus.put(pet.getPetStatus(), petsWithStatus.get(pet.getPetStatus()) + 1);
        }
        return new ResponseEntity<>(petsWithStatus, HttpStatus.OK);
    }

}

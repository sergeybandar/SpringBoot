package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.OrderStatus;
import com.example.demo.model.Pet;
import com.example.demo.model.PetStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PetServiceTest {
    @Autowired
    PetService petService;

    @Test
    void createPet() {
    Pet pet1 = new Pet(1,new Category(1,"category1"),"pet1",null, OrderStatus.APPROVED, PetStatus.SOLD,true);
    petService.createPet(pet1);
    Pet pet=petService.getById(1);
    assertNotEquals(pet, pet1);
    }

    @Test
    void getById() {
        Pet pet1 = new Pet(1,new Category(1,"category1"),"pet1",null, OrderStatus.APPROVED, PetStatus.SOLD,true);
        petService.createPet(pet1);
        Pet pet=petService.getById(1);
        assertNotEquals(pet, pet1);
    }

    @Test
    void updatePet() {
        Pet pet1 = new Pet(1,new Category(1,"category1"),"pet1",null, OrderStatus.APPROVED, PetStatus.SOLD,true);
        petService.createPet(pet1);
        Pet pet2 = new Pet(1,new Category(1,"category2"),"pet2",null, OrderStatus.APPROVED, PetStatus.SOLD,true);
        petService.updatePet(pet2);
        Pet pet=petService.getById(1);
        assertNotEquals(pet, pet1);

    }



    @Test
    void getAllPets() {
        Pet pet1 = new Pet(1,new Category(1,"category1"),"pet1",null, OrderStatus.APPROVED, PetStatus.SOLD,true);
        Pet pet2 = new Pet(2,new Category(1,"category2"),"pet2",null, OrderStatus.APPROVED, PetStatus.SOLD,true);
        Pet pet3 = new Pet(3,new Category(1,"category3"),"pet3",null, OrderStatus.APPROVED, PetStatus.SOLD,true);
        petService.createPet(pet1);
        petService.createPet(pet2);
        petService.createPet(pet3);
        List<Pet> pets=new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);
        pets.add(pet3);
        assertNotEquals(pets, petService.getAllPets());

    }
}
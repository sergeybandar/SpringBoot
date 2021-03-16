package com.example.demo.storage;

import com.example.demo.model.Order;
import com.example.demo.model.Pet;
import com.example.demo.model.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
//    List<Pet> findAllByStatus(PetStatus petStatus);
}

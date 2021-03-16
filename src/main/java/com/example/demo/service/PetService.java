package com.example.demo.service;

import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.exception.PetNotFoundException;
import com.example.demo.model.Pet;
import com.example.demo.model.PetStatus;
import com.example.demo.storage.PetRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    public Pet getById(long id) {
//        if(petRepository.existsById(id)){
//            return petRepository.findById(id).get();
//        }
//        throw new PetNotFoundException(id);
        Pet pet = petRepository.findById(id).orElseThrow(() -> new PetNotFoundException(id));
        return pet;
    }

    public void updatePet(Pet pet) {
        if (petRepository.existsById(pet.getId())) {
            petRepository.save(pet);
        } else {
            throw new PetNotFoundException(pet.getId());
        }
    }
//
//    public List<Pet> findByStatus(PetStatus petStatus) {
//        return petRepository.findAllByStatus(petStatus);
//    }

    public void updateForm(long id, Pet pet) {
        Pet updatePet = petRepository.findById(id).orElseThrow(() -> new PetNotFoundException(id));
        updatePet.setName(pet.getName());
        updatePet.setPetStatus(pet.getPetStatus());
        petRepository.save(updatePet);
//        if (petRepository.existsById(id)) {
//            Pet updatePet = petRepository.findById(id).get();
//            updatePet.setName(pet.getName());
//            updatePet.setPetStatus(pet.getPetStatus());
//            petRepository.save(updatePet);
//        } else {
//            throw new PetNotFoundException(pet.getId());
//        }
    }

    public void deletePet(long id) {
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
        } else {
            throw new PetNotFoundException(id);
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        if (pets != null) {
            return pets;
        } else {
            throw new PetNotFoundException("Pets not found");
        }
    }

}

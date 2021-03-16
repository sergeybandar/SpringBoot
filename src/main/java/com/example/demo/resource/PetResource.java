package com.example.demo.resource;

import com.example.demo.model.Pet;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/pet")
public class PetResource {

    @Autowired
    public PetService petService;

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        petService.createPet(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<Pet> updatePetForm(@RequestBody Pet pet, @PathVariable(name = "id") long id) {
        petService.updateForm(id, pet);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Pet> findById(@PathVariable(name = "id") long id) {
        Pet pet = petService.getById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet) {
        petService.updatePet(pet);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePet(@PathVariable(name = "id") long id) {
        petService.deletePet(id);
        return new ResponseEntity<>("Pet with id " + id + " was deleted", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> pets=petService.getAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
//    @GetMapping(path = "/{petStatus}")
//    public ResponseEntity<List<Pet>> getPetByStatus(@PathVariable(name = "petStatus") PetStatus petStatus) {
//        List<Pet> petList = petService.getByStatus(petStatus);
//        return new ResponseEntity<>(petList, HttpStatus.OK);
//    }

}

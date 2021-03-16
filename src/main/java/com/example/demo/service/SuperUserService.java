package com.example.demo.service;

import com.example.demo.model.SuperUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.storage.SuperUserRepository;

@Data
@Service
public class SuperUserService {
    @Autowired
    SuperUserRepository superUserRepository;

    public void createPet(SuperUser superUser) {
        superUserRepository.save(superUser);
    }

    public SuperUser getById(long id) {
        return superUserRepository.findById(id).get();
    }
}

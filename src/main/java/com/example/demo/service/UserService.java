package com.example.demo.service;



import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.storage.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void creatUser(User user) {
        userRepository.save(user);
    }

//    public void creatWithArray(List<User> users) {
//        userRepository.creatWithArray(users);
//    }

    public User getByName(String userName) {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new UserNotFoundException(userName));
        return user;
    }

    public void updateUser(User user, String userName) {
        if(userRepository.existsByUserName(userName)){
            userRepository.save(user);
        }else {
            throw new UserNotFoundException(userName);
        }
    }

    public User getById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return user;
    }

    public void deleteUser(String userName) {
        userRepository.deleteByUserName(userName);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}

package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Key;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.storage.KeyRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class KeyService {

    @Autowired
    KeyRepository keyRepository;

    public Key getById(long id) {
        Key key = keyRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return key;
    }

    public Key getByUserName(String userName) {
        Key key = keyRepository.findByUserName(userName).orElseThrow(() -> new UserNotFoundException(userName));//ex
        return key;
    }

    public void creatKey(Key key) {
        keyRepository.save(key);
    }

    public List<Key> getAllKey() {
        return keyRepository.findAll();
    }

    public boolean isUser(String key) {
        Optional<Key> optionalKey = keyRepository.findByKey(key);
        return optionalKey.isPresent();
    }

    public boolean isAdmin(String key) {
        Optional<Key> optionalKey = keyRepository.findByKey(key);
        if (optionalKey.isPresent()) {
            if (optionalKey.get().getUserRole().equals(UserRole.ADMIN)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteKey(String key) {
        if (keyRepository.existsByKey(key)) {
            keyRepository.deleteByKey(key);
            return true;
        } else {
            return false;
        }
    }

    public boolean existByUserName(String userName) {
        return keyRepository.existsByUserName(userName);
    }
}

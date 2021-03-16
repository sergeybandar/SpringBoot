package com.example.demo.storage;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
//        void creatWithArray(List<User> users);
        Optional<User> findByUserName(String userName);
        boolean existsByUserName(String userName);
        void deleteByUserName(String userName);
}

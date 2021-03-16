package com.example.demo.storage;

import com.example.demo.model.Key;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KeyRepository extends JpaRepository<Key, Long> {
    Optional<Key> findByKey(String key);
    Optional<Key> findByUserName(String userName);
    boolean existsByKey(String key);
    boolean existsByUserName(String userName);
    void deleteByKey(String key);

}

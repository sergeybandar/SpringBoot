package com.example.demo.storage;

import com.example.demo.model.Category;
import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
//свои методы в h2
//необходимость проверки на наличие элемента
//необходимость побработки все эксепшенов
//связь юзера и апикей
//информация по интерсепторам
//робота id
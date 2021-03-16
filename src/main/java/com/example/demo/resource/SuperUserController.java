package com.example.demo.resource;

import com.example.demo.model.SuperUser;
import com.example.demo.service.SuperUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/superuser")
public class SuperUserController {
    @Autowired
    SuperUserService superUserService;

    @PostMapping
    public ResponseEntity<SuperUser> createSuperUser(@RequestBody SuperUser superUser) {
        superUserService.createPet(superUser);
        return new ResponseEntity<>(superUser, HttpStatus.CREATED);
        //Возвращаем только для того, чтобы увидеть, что объект Order order создан и добавлен в List<Order) в OrderService
    }

    // Спросить у Семена насчет того, можно ли в path указать несколько переменных
    //    "/{id}/{num}/{num2}"
    @GetMapping(path = "/{id}")
    public ResponseEntity<SuperUser> findById(@PathVariable(name = "id") long id) {
        SuperUser superUser  = superUserService.getById(id);
        return new ResponseEntity<>(superUser, HttpStatus.OK);
    }
}

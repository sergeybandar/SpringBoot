package com.example.demo.resource;


import com.example.demo.model.Key;
import com.example.demo.model.User;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserRole;
import com.example.demo.service.KeyService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserResource {
    @Autowired
    UserService userService;

    @Autowired
    KeyService keyService;

    //	public static void main(String[] args) {
//		User user=new User();
//		user.setUserName("Vasy");
//		user.setUserRole(UserRole.ADMIN);
//		userSe
//	}
    @GetMapping
    public ResponseEntity<User> creatAdmin() {
        User user = new User(5, "admin", "admin", "admin", "admin@gmail.com", "admin", "+3333333333", 777, UserRole.ADMIN);
        user.setUserRole(UserRole.ADMIN);
        userService.creatUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> creatUser(@Valid @RequestBody User user) {
        userService.creatUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @PostMapping(path = "/createWithArray", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> createWithArray(@RequestBody List<User> users) {
//        userService.creatWithArray(users);
//        return new ResponseEntity<>("Successful operation", HttpStatus.OK);
//    }

    @PostMapping(path = "/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable(name = "userName") String userName) {
        User user = userService.getByName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/{userName}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable(name = "userName") String userName) {
        userService.updateUser(user, userName);
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "userName") String userName) {
        userService.deleteUser(userName);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @PostMapping(path = "/login")//get???????
    public ResponseEntity<String> auth(@RequestBody UserModel userModel) {
        User user = userService.getByName(userModel.getUserName());
        if (user.getPassword().equals(userModel.getPassword())) {
            if (keyService.existByUserName(userModel.getUserName())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                UUID uuid = UUID.randomUUID();
                String s = uuid.toString();
                Key key = new Key();
                key.setKey(s);
                key.setUserRole(user.getUserRole());
                key.setUserName(userModel.getUserName());
                keyService.creatKey(key);
                return new ResponseEntity<>(s, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("Invalid username/password supplied", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String key = request.getHeader("X-Token");
        if (keyService.deleteKey(key)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}

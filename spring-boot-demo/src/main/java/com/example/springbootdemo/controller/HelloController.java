package com.example.springbootdemo.controller;

import com.example.springbootdemo.UserService;
import com.example.springbootdemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class HelloController {


    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id, @RequestParam("client") String clientName) {
        System.out.println("clientName: "+clientName);
        return userService.getById(id);
    }

    @PostMapping
    public User save(@Valid @RequestBody User user) {
        userService.save(user);
        return user;
    }
}

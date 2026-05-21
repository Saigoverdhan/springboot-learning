package com.sai.rise.controller;

import com.sai.rise.model.register;
import com.sai.rise.service.register_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class user_input {

    @Autowired
    register_service service;

    // POST API
    @PostMapping("/register")
    public String register(@RequestBody register register) {

        service.addUser(register);
        return "Registered Successfully";
    }

    @DeleteMapping("/delete/{age}")
    public void delete(@PathVariable int age){
        service.delete(age);
    }


    // GET API
    @GetMapping("/age/{age}")
    public List<register> findbyage(@PathVariable int age) {
        return  service.findbyage(age);
    }
}
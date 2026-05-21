package com.sai.rise.service;

import com.sai.rise.model.register;
import com.sai.rise.repository.registerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class register_service {

    @Autowired
private registerrepository repository;

    public void addUser(register register) {
        repository.save(register);
    }


    public List<register> findbyage(int age) {
        return  repository.findByAge(age) ;
    }

    public void delete(int age){
        repository.deleteByAge(age);
    }
}
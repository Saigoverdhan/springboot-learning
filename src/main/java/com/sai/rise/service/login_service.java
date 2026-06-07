package com.sai.rise.service;

import java.util.*;
import com.sai.rise.model.login;
import com.sai.rise.repository.login_repo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class login_service {

    @Autowired
    login_repo logrepo;

    //to show user exist
    public boolean usernameExist(String s){
        return logrepo.existsByUsername(s);
    }



    @Autowired
    PasswordEncoder pe;
    //to register user name & password
    public void add(login user){
        String s=user.getPassword();
        user.setPassword(pe.encode(s));
        user.setRole("user");
        logrepo.save(user);
    }

    @Transactional
    public String delete(String u, String p){

        login user = logrepo.findByUsername(u);

        System.out.println("User found = " + user.getUsername());

        boolean matched = pe.matches(p, user.getPassword());

        System.out.println("Password matched = " + matched);

        if(matched){
            logrepo.delete(user);
            return "Account Deleted";
        }


        return "Account not Deleted";
    }


    public List<login> u(){
        return logrepo.findAll();
    }
}



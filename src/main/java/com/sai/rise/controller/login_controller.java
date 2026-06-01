package com.sai.rise.controller;

import com.sai.rise.model.login;
import com.sai.rise.service.login_service;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController()
@RequestMapping("/home")
public class login_controller {

    @Autowired
    login_service ls;


    @PostMapping("/register")
    public String sign(@RequestBody login user){
//        if(ls.usernameExist(user.setUsername())){
//            return "use another username";
//        }
        if(ls.usernameExist(user.getUsername())) {
            return "use another username";
        }

        ls.add(user);
        return "signing succesfull";
    }




    @DeleteMapping("/deleteAccount/{s}")
    public String deleteAccount(@PathVariable String s,
                                Authentication authentication) {
         //System.out.println("auth"+authentication.getName());
        if(authentication == null){
            return "AUTH NULL";
        }

        return ls.delete(authentication.getName(), s);
    }

    @GetMapping("/users")
    public List<login> users(){
        System.out.println("hitting url");
        return ls.u();
    }
}

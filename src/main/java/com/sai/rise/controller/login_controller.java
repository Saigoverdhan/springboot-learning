package com.sai.rise.controller;

import com.sai.rise.model.login;
import com.sai.rise.service.login_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/home")
public class login_controller {

    @Autowired
    login_service ls;
//    @PostMapping("/login/{s}/{p}")
//    public String log(@PathVariable String s,@PathVariable String p) {
//
//        if(ls.userExist(s,p)){
//            return "login succesfull";
//        }
//        return "Login Failed";
//    }
    //wrote because not known about springsecurity before

//    @GetMapping("/s")
//    public CsrfToken sai(HttpServletRequest request){
//        CsrfToken s= (CsrfToken) request.getAttribute("_csrf");
//        return s;
//    }

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

    @DeleteMapping("/deleteAccount")
    public String del(@RequestBody login u){
        if(ls.delete(u)){
            return "account deleted";
        }
        return "Account Not Deleted";
    }

    @GetMapping("/users")
    public List<login> users(){
        return ls.u();
    }
}

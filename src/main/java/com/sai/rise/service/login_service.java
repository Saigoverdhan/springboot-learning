package com.sai.rise.service;

import java.util.*;
import com.sai.rise.model.login;
import com.sai.rise.model.login;
import com.sai.rise.repository.login_repo;
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

    //to verify that user name , password are valid
//    public boolean userExist(String username, String password) {
//
//        login user = logrepo.findByUsername(username);
//
//        if (user == null) {
//            return false;
//        }
//
//        return user.getPassword().equals(password);
//    }

    @Autowired
    PasswordEncoder pe;
    //to register user name & password
    public void add(login user){
        String s=user.getPassword();
        user.setPassword(pe.encode(s));
        user.setRole("user");
        logrepo.save(user);
    }

    //to delete user account
//    public boolean delete(login u){
//
//        login user =
//                logrepo.findByUsername(u.getUsername());
//
//        if(user == null){
//            return false;
//        }
//
//        if(user.getPassword().equals(u.getPassword())){
//
//            logrepo.deleteByUsername(user.getUsername());
//
//            return true;
//        }
//
//        return false;
//    }
    @Transactional
    public boolean delete(login u){

        System.out.println("Input Username: " + u.getUsername());
        System.out.println("Input Password: " + u.getPassword());

        login user = logrepo.findByUsername(u.getUsername());

        System.out.println("DB User: " + user);

        if(user == null){
            System.out.println("User not found");
            return false;
        }

        System.out.println("DB Password: " + user.getPassword());
        System.out.println("DB Password: " + u.getPassword());

        if(pe.matches(u.getPassword(), user.getPassword())){

            System.out.println("Password matched");

            logrepo.deleteByUsername(user.getUsername());

            return true;
        }

        System.out.println("Password mismatch");

        return false;
    }
//    public boolean delete(login u){
//        login user = logrepo.findByUsername(u.getUsername());
//
//        if (user.getUsername() == null) {
//            return false;
//        }else if(user.getPassword().equals(u.getPassword())){
//            logrepo.deleteById(u.getUsername());
//            return true;
//        }
//
//        return false;
//    }

    public List<login> u(){
        return logrepo.findAll();
    }
}


//package com.sai.rise.service;
//import com.sai.rise.model.login;
//import com.sai.rise.repository.login_repo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class login_service {
//
//    @Autowired
//    login_repo logrepo;
//    public boolean user_exist(String s,String p) {
//     login sai=logrepo.findByUsername(s);
//        if(sai.getPassword() == p){
//            return true;
//        }
//
//        return false;
//    }
//
//}

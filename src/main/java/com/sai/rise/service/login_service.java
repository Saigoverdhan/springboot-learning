package com.sai.rise.service;

import java.util.*;
import com.sai.rise.model.login;
import com.sai.rise.model.login;
import com.sai.rise.repository.login_repo;
import com.sai.rise.repository.login_repo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean userExist(String username, String password) {

        login user = logrepo.findByUsername(username);

        if (user == null) {
            return false;
        }

        return user.getPassword().equals(password);
    }

    //to register user name & password
    public void add(login user){
        logrepo.save(user);
    }

    //to delete user account
    public boolean delete(login u){
        login user = logrepo.findByUsername(u.getUsername());

        if (user.getUsername() == null) {
            return false;
        }else if(user.getPassword().equals(u.getPassword())){
            logrepo.deleteById(u.getUsername());
            return true;
        }

        return false;
    }

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

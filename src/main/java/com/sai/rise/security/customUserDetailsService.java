package com.sai.rise.security;

import com.sai.rise.model.login;
import com.sai.rise.repository.login_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customUserDetailsService implements UserDetailsService {

    @Autowired
    login_repo repo;


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        login user = repo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
//        return new User(
//                user.getUsername(),
//                user.getPassword(),
//                List.of(
//                        new SimpleGrantedAuthority(
//                                "ROLE_" + user.getRole()
//                        )
//                )
//        );
        return new User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("USER"))
        );
    }
}


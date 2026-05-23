package com.sai.rise.repository;

import com.sai.rise.model.login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface login_repo extends JpaRepository<login, String> {

    login findByUsername(String username);

    boolean existsByUsername(String username);

}
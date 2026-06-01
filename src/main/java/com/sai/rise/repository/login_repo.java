package com.sai.rise.repository;

import com.sai.rise.model.login;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface login_repo extends JpaRepository<login, String> {

    login findByUsername(String username);

    boolean existsByUsername(String username);

    //void deleteById(String username);
    @Transactional
    @Modifying
    void deleteByUsername(String username);

}
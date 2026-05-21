package com.sai.rise.repository;

import com.sai.rise.model.register;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface registerrepository
        extends JpaRepository<register, Integer> {

    // Find by name
    List<register> findByName(String name);

    // Find by age
    List<register> findByAge(int age);

    // Find by gender
    List<register> findByGender(register.Gender gender);

    // Find age greater than
    List<register> findByAgeGreaterThan(int age);

    // Find by name and age
    List<register> findByNameAndAge(String name, int age);

    //delete by using id
    @Transactional
    @Modifying
    @Query("DELETE FROM register r WHERE r.age = :age")
    void deleteByAge(int age) ;

}
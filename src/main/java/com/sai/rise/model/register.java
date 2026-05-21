package com.sai.rise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class register{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
    private String userName;
    private String name;
    private int age;
    @Enumerated
    private Gender gender;


    // Enum
    public enum Gender {
        MALE,
        FEMALE
    }

    // Default constructor
    public register() {

    }




    // Parameterized constructor
//    public register(String userName, String name, int age, Gender gender) {
//        this.userName = userName;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//    }

    // Getters and Setters


}
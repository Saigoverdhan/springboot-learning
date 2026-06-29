package com.sai.rise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("home")
public class LuckyWinner {

    @GetMapping("/LuckyNum")
    public int lotterynumber(){
        int num= (int) (Math.random()*10);
        return num;
    }
}

package com.example.security.controller;

import com.example.security.aspect.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("word")
public class WordController {
    @PostMapping
    @Loggable
    public String checkOffensiveWords(@RequestBody String input){
        System.out.println("here");
    return "";
    }
}

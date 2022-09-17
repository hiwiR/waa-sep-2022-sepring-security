package com.example.security.service;

import com.example.security.entity.FireWord;
import com.example.security.repository.FireWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FireWordService {

    @Autowired
    FireWordRepository fireWordRepository;


    public boolean checkOffensiveWord(String input){
        FireWord test = new FireWord(1,"stupid");
        List<FireWord> fireWordList = Arrays.asList(test);
        if(fireWordList.contains(test))
            return true;
        return false;
    }
}

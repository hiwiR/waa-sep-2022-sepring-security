package com.example.security.service;

import com.example.security.entity.FireWordLogger;
import com.example.security.repository.FireWordLoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireWordLoggerService {

    @Autowired
    FireWordLoggerRepository fireWordLoggerRepository;

    public List<FireWordLogger> getListOfUser(int id){
        return fireWordLoggerRepository.findAllByUserId(id);
    }

}

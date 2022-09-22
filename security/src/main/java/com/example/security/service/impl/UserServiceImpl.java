package com.example.security.service.impl;

import com.example.security.entity.User;
import com.example.security.repository.UserRepository;
import com.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveNewUser(User user) {
        userRepository.save(user);
    }
}

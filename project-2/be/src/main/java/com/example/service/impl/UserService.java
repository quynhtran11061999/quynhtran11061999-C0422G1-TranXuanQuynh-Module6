package com.example.service.impl;

import com.example.model.Account;
import com.example.repository.IUserRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Account findByUsername(String username) {
        return this.iUserRepository.findByUsername(username);
    }

    @Override
    public Account findByAppUser_Email(String email) {
        return this.iUserRepository.findByAppUser_Email(email);
    }
}

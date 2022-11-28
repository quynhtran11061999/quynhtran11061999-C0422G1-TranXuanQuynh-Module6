package com.example.service.impl;

import com.example.model.AppUser;
import com.example.repository.IUserRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public AppUser findByUsername(String email) {
        return iUserRepository.findByUsername(email);
    }

    @Override
    public AppUser findByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }
}

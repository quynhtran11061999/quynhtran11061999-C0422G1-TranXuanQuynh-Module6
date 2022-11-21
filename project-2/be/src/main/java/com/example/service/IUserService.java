package com.example.service;

import com.example.model.Account;

public interface IUserService {
    Account findByUsername(String username);

    Account findByAppUser_Email(String email);
}

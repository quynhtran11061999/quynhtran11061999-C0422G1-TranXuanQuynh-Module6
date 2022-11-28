package com.example.service;

import com.example.model.AppUser;

public interface IUserService {
    AppUser findByUsername(String email);

    AppUser findByEmail(String email);
}

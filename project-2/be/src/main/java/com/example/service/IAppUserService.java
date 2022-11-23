package com.example.service;

import com.example.model.Account;
import com.example.model.AppUser;

public interface IAppUserService {
    Account findByUsername(String username);

    void resetPassword(String username, String newPassword);

    AppUser findByEmail(String email);
}

package com.example.service;

import com.example.model.AppRole;

import java.util.List;

public interface IAppRoleService {
    List<AppRole> findByUsername(String username);
}

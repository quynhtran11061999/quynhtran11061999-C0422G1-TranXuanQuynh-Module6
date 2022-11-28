package com.example.service.impl;

import com.example.model.AppRole;
import com.example.repository.IAppRoleRepository;
import com.example.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private IAppRoleRepository iAppRoleRepository;

    @Override
    public List<AppRole> findByRoleName(String username) {
        return this.iAppRoleRepository.findByRoleName(username);
    }
}

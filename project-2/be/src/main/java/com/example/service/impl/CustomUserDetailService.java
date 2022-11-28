package com.example.service.impl;

import com.example.model.AppRole;
import com.example.model.AppUser;
import com.example.repository.IAppRoleRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private IAppRoleRepository iAppRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser account = iUserService.findByUsername(email);
        List<AppRole> roleList = this.iAppRoleRepository.findByRoleName(account.getUsername());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (AppRole role: roleList){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(account.getUsername(),account.getPassword(),grantedAuthorities);
    }
}

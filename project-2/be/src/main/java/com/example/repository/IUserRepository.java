package com.example.repository;

import com.example.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

    Account findByAppUser_Email(String email);

}

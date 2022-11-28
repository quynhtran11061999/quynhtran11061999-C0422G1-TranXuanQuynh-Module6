package com.example.repository;

import com.example.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String name);

    @Query(value = "update  app_user " +
            "set app_user.money = :moneyTotal " +
            "where app_user.id = :idUser ", nativeQuery = true)
    AppUser updateUser(@Param("moneyTotal") Double price, @Param("idUser") Long id);

    AppUser findByEmail(String email);
}

package com.example.repository;

import com.example.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassesRepository extends JpaRepository<Classes,Integer> {
}

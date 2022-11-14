package com.example.service.impl;

import com.example.model.Classes;
import com.example.repository.IClassesRepository;
import com.example.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService implements IClassesService {
    @Autowired
    private IClassesRepository iClassesRepository;

    @Override
    public List<Classes> findAll() {
        return iClassesRepository.findAll();
    }
}

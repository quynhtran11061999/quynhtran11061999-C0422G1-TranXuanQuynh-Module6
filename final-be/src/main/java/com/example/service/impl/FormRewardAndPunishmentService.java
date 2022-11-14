package com.example.service.impl;

import com.example.model.FormRewardAndPunishment;
import com.example.repository.IFormRewardAndPunishmentRepository;
import com.example.service.IFormRewardAndPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormRewardAndPunishmentService implements IFormRewardAndPunishmentService {
    @Autowired
    private IFormRewardAndPunishmentRepository iFormRewardAndPunishmentRepository;

    @Override
    public List<FormRewardAndPunishment> findAll() {
        return iFormRewardAndPunishmentRepository.findAll();
    }
}

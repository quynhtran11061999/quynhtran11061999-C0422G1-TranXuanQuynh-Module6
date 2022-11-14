package com.example.service.impl;

import com.example.model.RewardAndPunishmentReason;
import com.example.repository.IRewardAndPunishmentReasonRepository;
import com.example.service.IRewardAndPunishmentReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardAndPunishmentService implements IRewardAndPunishmentReasonService {
    @Autowired
    private IRewardAndPunishmentReasonRepository iRewardAndPunishmentReasonRepository;

    @Override
    public List<RewardAndPunishmentReason> findAll() {
        return iRewardAndPunishmentReasonRepository.findAll();
    }
}

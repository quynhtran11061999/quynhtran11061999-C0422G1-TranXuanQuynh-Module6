package com.example.service.impl;

import com.example.model.ReasonDetail;
import com.example.repository.IReasonDetailRepository;
import com.example.service.IReasonDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReasonDetailService implements IReasonDetailService {
    @Autowired
    private IReasonDetailRepository iReasonDetailRepository;

    @Override
    public List<ReasonDetail> findAll() {
        return iReasonDetailRepository.findAll();
    }
}

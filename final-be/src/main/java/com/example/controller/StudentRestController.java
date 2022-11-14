package com.example.controller;

import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/studentRest")
public class StudentRestController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassesService iClassesService;

    @Autowired
    private IFormRewardAndPunishmentService iFormRewardAndPunishmentService;

    @Autowired
    private IReasonDetailService iReasonDetailService;

    @Autowired
    private IRewardAndPunishmentReasonService iRewardAndPunishmentReasonService;

    @GetMapping(value = "/listStudent")
    public ResponseEntity<List<Student>> goListStudent() {
        List<Student> studentList = this.iStudentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping(value = "/listClass")
    public ResponseEntity<List<Classes>> goListClass() {
        List<Classes> classesList = this.iClassesService.findAll();
        if (classesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classesList, HttpStatus.OK);
    }

    @GetMapping(value = "/listReasonDetail")
    public ResponseEntity<List<ReasonDetail>> goListReasonDetail() {
        List<ReasonDetail> reasonDetailList = this.iReasonDetailService.findAll();
        if (reasonDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reasonDetailList, HttpStatus.OK);
    }

    @GetMapping(value = "/listFormRewardAndPunishment")
    public ResponseEntity<List<FormRewardAndPunishment>> goListFormRewardAndPunishment() {
        List<FormRewardAndPunishment> formRewardAndPunishmentList = this.iFormRewardAndPunishmentService.findAll();
        if (formRewardAndPunishmentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(formRewardAndPunishmentList, HttpStatus.OK);
    }

    @GetMapping(value = "/listRewardAndPunishmentReason")
    public ResponseEntity<List<RewardAndPunishmentReason>> goListRewardAndPunishmentReason() {
        List<RewardAndPunishmentReason> rewardAndPunishmentReasonList = this.iRewardAndPunishmentReasonService.findAll();
        if (rewardAndPunishmentReasonList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rewardAndPunishmentReasonList, HttpStatus.OK);
    }

    @GetMapping("listStudent/{id}")
    public ResponseEntity<Student> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.iStudentService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Student student) {
        this.iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

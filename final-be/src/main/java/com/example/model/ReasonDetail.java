package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReasonDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateOfOccurrence;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "reason_id")
    private RewardAndPunishmentReason reason;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}

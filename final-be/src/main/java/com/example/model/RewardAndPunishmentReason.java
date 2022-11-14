package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RewardAndPunishmentReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private FormRewardAndPunishment formRewardAndPunishment;

    @OneToMany(mappedBy = "reason")
    @JsonBackReference(value = "reason")
    private List<ReasonDetail> reasonDetail;
}
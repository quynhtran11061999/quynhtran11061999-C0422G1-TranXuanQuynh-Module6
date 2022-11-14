package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private LocalDate dateOfBirth;

    private String phone;

    private String email;

    private String citizenIdentification;

    @ManyToOne
    @JoinColumn(name = "classes_id")
    private Classes classes;

    @OneToMany(mappedBy = "reason")
    @JsonBackReference(value = "reason")
    private List<ReasonDetail> reasonDetail;
}

package com.pawn_shop.model.employee;

import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.model.login.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private Boolean gender;

    private LocalDate dateOfBirth;

    private String email;

    private String phoneNumber;

    private String address;

    private Double salary;

    private String imgUrl;

    private boolean status;

    @OneToOne(mappedBy = "employee")
    private AppUser appUser;
}

package com.pawn_shop.model.login;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pawn_shop.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50)")
    private String username;

    @Column(columnDefinition = "varchar(150)")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;
}

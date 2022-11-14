package com.pawn_shop.model.customer;

import com.pawn_shop.model.address.Address;
import com.pawn_shop.model.contract.Contract;
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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private String phoneNumber;

    private String email;

    private LocalDate dateOfBirth;

    private Boolean gender;

    private String idCard;

    private String imgUrl;

    private Boolean status;

    @OneToOne(mappedBy = "customer")
    private Address address;

    @OneToMany(mappedBy ="customer",cascade = CascadeType.ALL)
    private Set<Contract> contracts;
}

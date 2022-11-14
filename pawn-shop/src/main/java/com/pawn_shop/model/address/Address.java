package com.pawn_shop.model.address;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.model.quick_sign_up.QuickSignUp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    @ManyToOne
    @JoinColumn(name = "district_id",referencedColumnName = "id")
    private District district;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @OneToOne(mappedBy = "address")
    private QuickSignUp quickSignUp;
}

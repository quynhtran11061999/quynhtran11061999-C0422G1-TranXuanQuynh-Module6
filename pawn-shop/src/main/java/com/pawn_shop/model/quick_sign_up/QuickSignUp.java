package com.pawn_shop.model.quick_sign_up;

import com.pawn_shop.model.address.Address;
import com.pawn_shop.model.pawn.PawnType;
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
public class QuickSignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "pawn_type_id",referencedColumnName = "id")
    private PawnType pawnType;
}

package com.pawn_shop.model.contract;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.model.employee.Employee;
import com.pawn_shop.model.pawn.PawnItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Double itemPrice;

    private Double profit;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pawn_item_id",referencedColumnName = "id")
    private PawnItem pawnItem;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    private int status;
}

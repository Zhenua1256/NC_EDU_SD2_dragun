package com.netcracker.dragun.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "billingaccounts")
public class BillingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "cvv")
    private Long cvv;
    @Column(name = "owner")
    private String owner;
    @Column(name = "card_number")
    private Long cardNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @Column(name = "balance")
    private Long balance;
}

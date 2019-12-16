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
    @Column(name = "card_name")
    private String cardName;
    @Column(name = "card_number")
    private Long cardNumber;
    /*@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "company_id")
    private Long companyId;
    @Column(name = "balance")
    private Long balance;
}

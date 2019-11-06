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
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "balance")
    private Long balance;
}

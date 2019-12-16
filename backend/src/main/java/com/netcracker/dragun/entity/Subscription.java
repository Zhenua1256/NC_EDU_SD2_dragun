package com.netcracker.dragun.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    /*@Column(name = "product_id")
    private Long productId;*/
    /*@ManyToOne
    @JoinColumn(name = "user_id")
    private Long userId;*/
    @Column(name = "billing_Account_id")
    private Long billingAccountId;
    @Column(name = "billing_Account_Company_id")
    private Long billingAccountCompanyId;
    @Column(name = "period")
    private Long period;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "user_id")
    private Long userId;
}

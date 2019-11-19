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
    Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product serviceId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "period")
    private Long period;
}

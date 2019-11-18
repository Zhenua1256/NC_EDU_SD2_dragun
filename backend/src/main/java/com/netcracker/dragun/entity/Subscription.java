package com.netcracker.dragun.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product serviceId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @Column(name = "period")
    private Long period;
}

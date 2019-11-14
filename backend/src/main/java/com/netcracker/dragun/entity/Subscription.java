package com.netcracker.dragun.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class Subscription {
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Product serviceId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @Column(name = "period")
    private Long period;
}

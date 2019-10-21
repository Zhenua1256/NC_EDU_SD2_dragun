package com.netcracker.dragun.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "subcriptions")
public class Subcription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Long price;
    @Column(name = "type")
    private String type;
    @Column(name = "period")
    private Long period;
}

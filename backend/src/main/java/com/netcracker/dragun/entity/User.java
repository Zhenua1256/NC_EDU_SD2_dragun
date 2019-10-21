package com.netcracker.dragun.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users" )
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private Long id;
@Column(name = "email")
    private String email;
@Column(name = "role")
    private String role;
@OneToOne
@JoinColumn(name = "login")
    private Login login;
}

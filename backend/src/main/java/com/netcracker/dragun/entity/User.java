package com.netcracker.dragun.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "role")
    private String role;
    @OneToOne
    @JoinColumn(name = "data_user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private DataUser dataUser;
}

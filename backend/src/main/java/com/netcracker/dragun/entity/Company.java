package com.netcracker.dragun.entity;


import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "company" )
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "director")
    private String directorName;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column (name = "legal_addres")
    private String legalAddres;
    @OneToOne
    @JoinColumn(name = "data_user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private DataUser dataUser;

}

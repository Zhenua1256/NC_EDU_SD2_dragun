package com.netcracker.dragun.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private Long contactNumber;
    @Column (name = "legal_addres")
    private String legalAddres;
    @OneToOne
    @JoinColumn(name = "data_user")
    private DataUser dataUser;

}

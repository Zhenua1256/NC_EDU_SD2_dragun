package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class Company {
    private Long id;
    private String name;
    private String directorName;
    private String contactNumber;
    private String legalAddres;
    private String login;
    private String password;
    private String role;
}

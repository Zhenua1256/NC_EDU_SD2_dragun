package com.netcraker.dragun.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Company {
    private Long id;
    private String name;
    private String directorName;
    private String contactNumber;
    private String legalAddress;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    private String role;
}

package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String role;
}

package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class DataUser {
    private Long id;
    private String login;
    private String password;
    private String role;

}

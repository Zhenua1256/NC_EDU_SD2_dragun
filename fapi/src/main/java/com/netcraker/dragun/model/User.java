package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private DataUser dataUser;
}

package com.netcraker.dragun.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataUser {
    private Long id;
    private String login;
    private String password;
}

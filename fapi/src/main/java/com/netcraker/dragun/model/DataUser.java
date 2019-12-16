package com.netcraker.dragun.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class DataUser {
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}

package com.netcraker.dragun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// это юзерДто
public class User {
    private Long id;
    private String name;
    private String lastName;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    private String role;
}

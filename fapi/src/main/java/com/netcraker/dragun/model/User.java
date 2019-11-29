package com.netcraker.dragun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// это юзерДто
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String role;
}

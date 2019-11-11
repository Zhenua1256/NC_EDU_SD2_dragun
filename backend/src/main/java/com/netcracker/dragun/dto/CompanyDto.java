package com.netcracker.dragun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@Builder
@ToString
public class CompanyDto {
    private Long id;
    private String name;
    private String directorName;
    private String contactNumber;
    private String legalAddres;
    private String login;
    private String password;
    private String role;
}

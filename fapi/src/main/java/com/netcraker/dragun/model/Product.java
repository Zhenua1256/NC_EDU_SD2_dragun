package com.netcraker.dragun.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Product {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Long price;
    @NotBlank
    private String section;
    @NotBlank
    private String description;
    private Long companyId;
}

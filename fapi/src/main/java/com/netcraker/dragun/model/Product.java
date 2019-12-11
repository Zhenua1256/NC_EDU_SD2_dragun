package com.netcraker.dragun.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Long id;
    private String name;
    private Long price;
    private String section;
    private String description;
    private Long companyId;
}

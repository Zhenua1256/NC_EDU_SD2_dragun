package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Long price;
    private String section;
}

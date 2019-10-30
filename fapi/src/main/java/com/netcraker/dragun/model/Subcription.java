package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class Subcription {
    private Long id;
    private String name;
    private Long price;
    private String type;
    private Long period;
}

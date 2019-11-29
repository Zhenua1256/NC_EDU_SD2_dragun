package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class BillingAccountDto {
    private Long id;
    private User user;
    private Long balance;
    private Long cardNumber;
    private String owner;
    private Long cvv;
}

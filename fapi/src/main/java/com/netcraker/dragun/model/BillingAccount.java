package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class BillingAccount {
    private Long id;
    private Long userId;
    private Long balance;
    private Long cardNumber;
    private String owner;
    private Long cvv;
}

package com.netcraker.dragun.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BillingAccount {
    private Long id;
    private Long userId;
    private Long companyId;
    private Long balance;
    @NotNull
    private Long cardNumber;
    @NotBlank
    private String cardName;
    @NotNull
    private Long cvv;
}

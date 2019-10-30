package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class BillingAccount {
    private Long id;
    private Long user_id;
    private Long balance;
}

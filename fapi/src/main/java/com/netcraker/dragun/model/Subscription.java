package com.netcraker.dragun.model;

import lombok.Data;

@Data
public class Subscription {
    private Long billingAccountId;
    private Long productId;
    private Long period;
}

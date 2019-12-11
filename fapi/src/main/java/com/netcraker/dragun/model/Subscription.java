package com.netcraker.dragun.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subscription {
    private Long id;
    private Long billingAccountId;
    private Product productId;
    private Long billingAccountCompanyId;
    private Long period;
    private Boolean status;
    private Long userId;
}

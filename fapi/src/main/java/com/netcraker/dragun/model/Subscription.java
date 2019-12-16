package com.netcraker.dragun.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Subscription {
    private Long id;
    @NonNull
    private Long billingAccountId;
    private Product product;
    private Long billingAccountCompanyId;
    private Long period;
    private Boolean status;
    private Long userId;
}

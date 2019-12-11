package com.netcraker.dragun.converter;

import com.netcraker.dragun.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@Builder
@ToString
public class SubscriptionDto {
    private Long id;
    private String nameProduct;
    private Long price;
    private Long period;
    private Long billingAccountId;
    private Long productId;
    private Long billingAccountCompanyId;
    private Boolean status;
    private Long userId;
}

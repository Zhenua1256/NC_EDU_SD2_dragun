package com.netcraker.dragun.converter;

import com.netcraker.dragun.model.Product;
import com.netcraker.dragun.model.Subscription;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionConverter {
    public static List<SubscriptionDto> toListDto(List<Subscription> subscription) {
        List<SubscriptionDto> list = new ArrayList<>();
        for (Subscription i : subscription) {
            list.add(SubscriptionDto.builder()
                    .id(i.getId())
                    .nameProduct(i.getProductId().getName())
                    .price(i.getProductId().getPrice())
                    .period(i.getPeriod())
                    .status(i.getStatus())
                    .build());
        }
        return list;
    }
    public static Subscription fromDto(SubscriptionDto subscriptionDto){
        Product product = Product.builder()
                .id(subscriptionDto.getProductId())
                /*.name(subscriptionDto.getNameProduct())
                .price(subscriptionDto.getPrice())*/
                .build();
        return Subscription.builder()
                .productId(product)
                .period(subscriptionDto.getPeriod())
                .billingAccountId(subscriptionDto.getBillingAccountId())
                .status(subscriptionDto.getStatus())
                .userId(subscriptionDto.getUserId())
                .build();
    }
}

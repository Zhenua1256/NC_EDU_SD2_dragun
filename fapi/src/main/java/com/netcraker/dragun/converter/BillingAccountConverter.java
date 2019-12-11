package com.netcraker.dragun.converter;

import com.netcraker.dragun.model.BillingAccount;
import com.netcraker.dragun.model.BillingAccountDto;
import com.netcraker.dragun.model.User;
import org.springframework.stereotype.Component;
@Component
public class BillingAccountConverter {
    public BillingAccountDto converterBillingAccountToDto(BillingAccount billingAccount) {
    BillingAccountDto convertedObj = new BillingAccountDto();
    convertedObj.setBalance(billingAccount.getBalance());
    convertedObj.setCardNumber(billingAccount.getCardNumber());
    convertedObj.setOwner(billingAccount.getCardName());
    convertedObj.setId(billingAccount.getId());
   /* User user = new User();
    user.setId(billingAccount.getUserId());
    convertedObj.setCvv(billingAccount.getCvv());
    convertedObj.setUser(user);*/
    return convertedObj;
    }
    public BillingAccount converterBillingAccountFromDto (BillingAccountDto billingAccountDto) {
        BillingAccount billingAccount = new BillingAccount();
        billingAccount.setBalance(billingAccountDto.getBalance());
        billingAccount.setCardNumber(billingAccountDto.getCardNumber());
        billingAccount.setCvv(billingAccountDto.getCvv());
        billingAccount.setCardName(billingAccountDto.getOwner());
        billingAccount.setUserId(billingAccountDto.getUser().getId());
        return billingAccount;
    }
}

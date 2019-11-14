import { Component, OnInit } from '@angular/core';
import {BillingAccountService} from '../../service/Billing-Account-Service';
import {CompanyModel} from '../company/model/company.model';
import {BillingAccountModel} from './model/billing-account.model';

@Component({
  selector: 'app-company',
  templateUrl: '',
  styleUrls: ['./company.component.css']
})
export class BillingAccountComponent implements OnInit {
  billingAccount: BillingAccountModel[] = [];
  public  currentBillingAccount: BillingAccountModel = {};
  constructor(private billingAccountService: BillingAccountService) {
  }
  ngOnInit(): void {
  }
  public save(billingAccount?: BillingAccountModel): void {

    console.log(this.currentBillingAccount);
    this.billingAccountService.saveBillingAccount(this.currentBillingAccount)
      .subscribe(savedBillingAccount => {
        this.billingAccount.push(savedBillingAccount);
      });

  }
}

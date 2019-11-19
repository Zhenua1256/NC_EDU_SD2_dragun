import { Component, OnInit } from '@angular/core';
import {BillingAccountService} from '../../service/Billing-Account-Service';
import {BillingAccountModel} from './model/billing-account.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserModel} from '../users/model/user.model';

@Component({
  selector: 'app-company',
  templateUrl: './billing-account.component.html',
  styleUrls: ['./billing-account.component.css']
})
export class BillingAccountComponent implements OnInit {

  newBillingAccountForm: FormGroup;
  newBillingAccount: BillingAccountModel = new BillingAccountModel();

  constructor(private billingAccountService: BillingAccountService, private  formbuilder: FormBuilder) {
  }
  ngOnInit(): void {
    this.newBillingAccountForm = this.formbuilder.group({
      cardNumber: ['', [Validators.required]],
      owner: ['', [Validators.required]],
      cvv: ['', [Validators.required]]
    });
  }
  /*parseFloat(this.newBillingAccountForm.controls.user.value);*/

  send() {
    this.newBillingAccount.cardNumber = this.newBillingAccountForm.controls.cardNumber.value;
    this.newBillingAccount.cvv = this.newBillingAccountForm.controls.cvv.value;
    this.newBillingAccount.owner = this.newBillingAccountForm.controls.owner.value;
    this.newBillingAccount.user = new UserModel();
    this.newBillingAccount.user.id = 1;
    this.newBillingAccount.balance = 0;
    this.billingAccountService.saveBillingAccount(this.newBillingAccount).subscribe();
  }
}

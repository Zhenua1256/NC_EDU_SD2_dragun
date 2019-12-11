import { Component, OnInit, Input } from '@angular/core';
import {BillingAccountService} from '../../service/Billing-Account-Service';
import {BillingAccountModel} from './model/billing-account.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserModel} from '../users/model/user.model';
import {Router} from '@angular/router';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-billing-account',
  templateUrl: './billing-account.component.html',
  styleUrls: ['./billing-account.component.css']
})
export class BillingAccountComponent implements OnInit {

  newBillingAccountForm: FormGroup;
  newBillingAccount: BillingAccountModel = new BillingAccountModel();
  public currentUser: UserModel = {};

  constructor(private billingAccountService: BillingAccountService,
              private  formbuilder: FormBuilder,
              private router: Router) {
  }
  ngOnInit(): void {
    this.newBillingAccountForm = this.formbuilder.group({
      cardNumber: ['', [Validators.required, Validators.pattern("[0-9]")]],
      cardName: ['', [Validators.required,  Validators.pattern("[A-Za-z]")]],
      cvv: ['', [Validators.required, Validators.pattern("[0-9]")]],
    });
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
  }

  send() {
    this.newBillingAccount.cardNumber = this.newBillingAccountForm.controls.cardNumber.value;
    this.newBillingAccount.cvv = this.newBillingAccountForm.controls.cvv.value;
    this.newBillingAccount.cardName = this.newBillingAccountForm.controls.cardName.value;
    this.newBillingAccount.userId = this.currentUser.id;
    this.newBillingAccount.balance = 0;
    this.billingAccountService.saveBillingAccount(this.newBillingAccount).subscribe();
    this.router.navigate(["/wallets"]);
  }
}

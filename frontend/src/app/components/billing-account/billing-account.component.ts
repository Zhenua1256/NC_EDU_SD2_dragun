import { Component, OnInit } from '@angular/core';
import {BillingAccountService} from '../../service/Billing-Account-Service';
import {BillingAccountModel} from './model/billing-account.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserModel} from '../users/model/user.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-billing-account',
  templateUrl: './billing-account.component.html',
  styleUrls: ['./billing-account.component.css']
})
export class BillingAccountComponent implements OnInit {

  newBillingAccountForm: FormGroup;
  newBillingAccount: BillingAccountModel = new BillingAccountModel();
  public currentUser: UserModel = {};
  public billingAccounts: BillingAccountModel[];
/*  private subscriptions: Subscription[] = [];*/

  constructor(private billingAccountService: BillingAccountService,
              private  formbuilder: FormBuilder,
              private router: Router) {
  }
  ngOnInit(): void {
    this.newBillingAccountForm = this.formbuilder.group({
      cardNumber: ['', [Validators.required]],
      owner: ['', [Validators.required]],
      cvv: ['', [Validators.required]],
    });
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
  /*  this.loadBillingAccounts();*/
  }

  send() {
    this.newBillingAccount.cardNumber = this.newBillingAccountForm.controls.cardNumber.value;
    this.newBillingAccount.cvv = this.newBillingAccountForm.controls.cvv.value;
    this.newBillingAccount.owner = this.newBillingAccountForm.controls.owner.value;
    this.newBillingAccount.userId = this.currentUser.id;
    this.newBillingAccount.balance = 0;
    this.billingAccountService.saveBillingAccount(this.newBillingAccount).subscribe();
    this.router.navigate(["/personal"]);
  }
  private loadBillingAccounts(): void {
    // Get data from BillingAccountService
    /*this.subscriptions.push(this.billingAccountService.getBillingAccounts().subscribe(accounts => {
      // Parse json response into local array
      this.billingAccounts = accounts as BillingAccountModel[];
      // Check data in console
      this.loadingService.hide();
    }));*/
  }
}

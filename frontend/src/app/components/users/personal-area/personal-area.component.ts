import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {BillingAccountService} from '../../../service/Billing-Account-Service';
import {UserModel} from '../model/user.model';

@Component({
  selector: 'app-personal-area',
  templateUrl: './personal-area.component.html',
  styleUrls: ['./personal-area.component.css']
})
export class PersonalAreaComponent implements OnInit {

  constructor(private router: Router,
              private billingAccountService: BillingAccountService) {
  }
  public currentUser: UserModel = {};
  billingAccountId: string;

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
  }

  public createBA() {
    this.router.navigate(['/create-ba']);
  }

  public createProduct() {
    this.router.navigate(["/registration-service"]);
  }
}


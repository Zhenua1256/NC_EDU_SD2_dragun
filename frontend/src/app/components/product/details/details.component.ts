import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../../service/Product-service';
import {ProductModel} from '../model/product.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserModel} from '../../users/model/user.model';
import {BillingAccountModel} from '../../billing-account/model/billing-account.model';
import {Subscription} from 'rxjs';
import {BillingAccountService} from '../../../service/Billing-Account-Service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  product: ProductModel = new ProductModel();
  productId: string;
  currentUser: UserModel;
  private subscriptions: Subscription[] = [];
  public billingAccounts: BillingAccountModel[] = [];

  period: string = "100";
  constructor(private productService: ProductService,
              private activateRoute: ActivatedRoute,
              private billingAccountService: BillingAccountService ) {
  }

  ngOnInit() {
    this.productId = this.activateRoute.snapshot.params["id"];
    this.getProduct(this.productId);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    this.loadBillingAccounts();
  }

  public getProduct(id: string) {
    this.productService.getProduct(id).subscribe((products: ProductModel) => {
      this.product = products;
    });
  }
  public subscribeOnProduct() {
    this.productService.createSubcription(this.currentUser.id, this.productId, this.period).subscribe(model => {
      console.log(model);
    });
  }
  private loadBillingAccounts(): void {
    this.subscriptions.push(this.billingAccountService.getBillingAccountUser(this.currentUser.id).subscribe(billingaccount => {
      this.billingAccounts = billingaccount as BillingAccountModel[];
    }));
  }
}

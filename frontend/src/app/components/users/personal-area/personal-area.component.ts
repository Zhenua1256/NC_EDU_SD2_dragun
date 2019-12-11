import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {BillingAccountService} from '../../../service/Billing-Account-Service';
import {UserModel} from '../model/user.model';
import {ProductModel} from '../../product/model/product.model';
import {ProductService} from '../../../service/Product-service';
import {Subscription} from 'rxjs';
import {SubscriptionModel} from '../../subscription/model/subscription.model';

@Component({
  selector: 'app-personal-area',
  templateUrl: './personal-area.component.html',
  styleUrls: ['./personal-area.component.css']
})
export class PersonalAreaComponent implements OnInit {

  constructor(private router: Router,
              private billingAccountService: BillingAccountService,
              private productService: ProductService) {
  }
  public currentUser: UserModel = {};
  billingAccountId: string;
  products: ProductModel[] = [];
  subscriptions: SubscriptionModel[] = [];

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    if (this.currentUser.role === "User") {
    this.getProductsUser();
    } else {this.getProductsCompany();
    }
  }

  public createBA() {
    this.router.navigate(['/create-ba']);
  }
  public getProductsCompany() {
    this.productService.getProductsCompany(this.currentUser.id).subscribe((products: ProductModel[]) => {
      this.products = products;
    });
  }
  public unSubscribe(id: string) {
    window.location.reload()
    this.productService.unSubscribe(id).subscribe();
  }
  public onSubscribe(id: string) {
    window.location.reload()
    this.productService.onSubscribe(id).subscribe();
  }
  public getProductsUser() {
    this.productService.getSubscriptionUser(this.currentUser.id).subscribe((subscriptions: SubscriptionModel[]) => {
      this.subscriptions = subscriptions;
    });
  }
  public createProduct() {
    this.router.navigate(["/registration-service"]);
  }
  public productDetails(id: string) {
    this.router.navigate(["/product/" + id]);
  }
}


import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../../service/Product-service';
import {ProductModel} from '../model/product.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserModel} from '../../users/model/user.model';
import {BillingAccountModel} from '../../billing-account/model/billing-account.model';
import {Subscription} from 'rxjs';
import {BillingAccountService} from '../../../service/Billing-Account-Service';
import { FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  newForm: FormGroup;
  product: ProductModel = new ProductModel();
  productId: string;
  currentUser: UserModel;
  private subscriptions: Subscription[] = [];
  public billingAccounts: BillingAccountModel[] = [];

  period: string = "100";
  constructor(private productService: ProductService,
              private activateRoute: ActivatedRoute,
              private billingAccountService: BillingAccountService,
              private router: Router) {
  }

  ngOnInit() {
    this.productId = this.activateRoute.snapshot.params["id"];
    this.getProduct(this.productId);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    this.loadBillingAccounts();
    this.newForm =  new FormGroup( {
      billingAccount: new FormControl ('', [Validators.required])
    });
  }

  public getProduct(id: string) {
    this.productService.getProduct(id).subscribe((products: ProductModel) => {
      this.product = products;
    }, () => {
      this.router.navigate(["/not-found"]);
    });
  }
  public subscribeOnProduct() {
    this.productService.createSubcription(this.newForm.controls.billingAccount.value,
      this.productId, this.period, this.currentUser.id).subscribe(model => {
      this.router.navigate(["/personal"]);
    },
      error => {
        if (error.status === 400) {
          alert("you are already subscribed to this service");
        }
      });
  }
  private loadBillingAccounts(): void {
    this.subscriptions.push(this.billingAccountService.getBillingAccountUser(this.currentUser.id).subscribe(billingaccount => {
      this.billingAccounts = billingaccount as BillingAccountModel[];
      if (this.billingAccounts && this.billingAccounts.length) {
        this.newForm.controls.billingAccount.setValue(this.billingAccounts[0].id);
      }
    }));
  }
}

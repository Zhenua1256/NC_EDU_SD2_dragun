import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/Product-service';
import {ProductModel} from '../product/model/product.model';
import {Router} from '@angular/router';
import {UserModel} from '../users/model/user.model';
import {BillingAccountModel} from '../billing-account/model/billing-account.model';
import {Subscription} from 'rxjs';
import {BillingAccountService} from '../../service/Billing-Account-Service';

@Component({
  selector: 'app-registration-product',
  templateUrl: './registration-product.component.html',
  styleUrls: ['./registration-product.component.css']
})
export class RegistrationProductComponent implements OnInit {
  newProductForm: FormGroup;
  currentUser: UserModel;
  newProduct: ProductModel = new ProductModel();
  newForm: FormGroup;
  private subscriptions: Subscription[] = [];
  public billingAccounts: BillingAccountModel[] = [];


  constructor(private productService: ProductService,
              private billingAccountService: BillingAccountService,
             /* private  formbuilder: FormBuilder,*/
              private router: Router) {
  }

  ngOnInit(): void {
   /* this.newForm =  new FormGroup( {
      billingAccount: new FormControl ('', [Validators.required])
    });*/
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    this.loadBillingAccounts();
    this.newProductForm = new FormGroup({
      price: new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]),
      name: new FormControl('', [Validators.required]),
      section: new FormControl('', [Validators.required]),
      billingAccount: new FormControl ('', [Validators.required]),
      description: new FormControl('', [Validators.required]),

    });
  }
  send() {
    this.newProduct.price = this.newProductForm.controls.price.value;
    this.newProduct.name = this.newProductForm.controls.name.value;
    this.newProduct.section = this.newProductForm.controls.section.value;
    this.newProduct.description = this.newProductForm.controls.description.value;
    this.newProduct.companyId = this.currentUser.id;
    this.newProduct.billingAccountId = this.newProductForm.controls.billingAccount.value;
    this.productService.addProduct(this.newProduct).subscribe(() => {
      this.router.navigate(["/home"]);
    }, (error) => {
      if (error.status === 400) {
        alert("data field");
      }
    });
  }
  private loadBillingAccounts(): void {
    this.subscriptions.push(this.billingAccountService.getBillingAccountCompany(this.currentUser.id).subscribe(billingaccount => {
      this.billingAccounts = billingaccount as BillingAccountModel[];
      if (this.billingAccounts && this.billingAccounts.length) {
        this.newProductForm.controls.billingAccount.setValue(this.billingAccounts[0].id);
      }
    }));
  }
}

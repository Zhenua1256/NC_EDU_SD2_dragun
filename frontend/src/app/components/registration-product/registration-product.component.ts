import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/Product-service';
import {ProductModel} from '../product/model/product.model';
import {Router} from '@angular/router';
import {UserModel} from '../users/model/user.model';

@Component({
  selector: 'app-registration-product',
  templateUrl: './registration-product.component.html',
  styleUrls: ['./registration-product.component.css']
})
export class RegistrationProductComponent implements OnInit {
  newProductForm: FormGroup;
  currentUser: UserModel;
  newProduct: ProductModel = new ProductModel();

  constructor(private productService: ProductService,
              private  formbuilder: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    this.newProductForm = this.formbuilder.group({
      price: ['', [Validators.required], Validators.pattern(/^[0-9]/)],
      name: ['', [Validators.required]],
      section: ['', [Validators.required]],
      description: ['', [Validators.required]]
    });
  }
  send() {
    this.newProduct.price = this.newProductForm.controls.price.value;
    this.newProduct.name = this.newProductForm.controls.name.value;
    this.newProduct.section = this.newProductForm.controls.section.value;
    this.newProduct.description = this.newProductForm.controls.description.value;
    this.newProduct.companyId = this.currentUser.id;
    this.productService.addProduct(this.newProduct).subscribe();
    this.router.navigate(["/home"]);
  }

}

import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/Product-service';
import {ProductModel} from '../product/model/product.model';

@Component({
  selector: 'app-registration-product',
  templateUrl: './registration-product.component.html',
  styleUrls: ['./registration-product.component.css']
})
export class RegistrationProductComponent implements OnInit {
  newProductForm: FormGroup;
  newProduct: ProductModel = new ProductModel();

  constructor(private productService: ProductService, private  formbuilder: FormBuilder ) {
  }

  ngOnInit(): void {
    this.newProductForm = this.formbuilder.group({
      price: ['', [Validators.required]],
      name: ['', [Validators.required]],
      section: ['', [Validators.required]]
    });
  }
  send() {
    this.newProduct.price = this.newProductForm.controls.price.value;
    this.newProduct.name = this.newProductForm.controls.name.value;
    this.newProduct.section = this.newProductForm.controls.section.value;
    this.newProduct.description = this.newProductForm.controls.description.value;
    this.productService.addProduct(this.newProduct).subscribe();
  }

}

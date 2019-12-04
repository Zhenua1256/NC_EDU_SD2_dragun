import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../../service/Product-service';
import {ProductModel} from '../model/product.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserModel} from '../../users/model/user.model';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  product: ProductModel = new ProductModel();
  productId: string;
  currentUser: UserModel;
  period: string = "100";
  constructor(private productService: ProductService,
              private activateRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.productId = this.activateRoute.snapshot.params["id"];
    this.getProduct(this.productId);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
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
}

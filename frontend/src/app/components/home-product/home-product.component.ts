import { Component, OnInit } from '@angular/core';
import {ProductModel} from '../product/model/product.model';
import {ProductService} from '../../service/Product-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home-product',
  templateUrl: './home-product.component.html',
  styleUrls: ['./home-product.component.css']
})
export class HomeProductComponent implements OnInit {

  products: ProductModel[] = [];
  constructor( private productService: ProductService,
               private router: Router ) {
  }

  ngOnInit() {
    this.getProducts();
  }
  public getProducts() {
    this.productService.getProducts().subscribe((products: ProductModel[]) => {
      this.products = products;
    });
  }
  public productDetails(id: string) {
    this.router.navigate(["/product/" + id]);
  }
}

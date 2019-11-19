import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {ProductModel} from '../components/product/model/product.model';

@Injectable()
export class ProductService {
  constructor(private http: HttpClient) {
  }

  addProduct(product: ProductModel) {
    return this.http.post('/api/v1/products', product);
  }

  getProducts(): Observable<ProductModel[]> {
    return this.http.get<ProductModel[]>('/api/v1/products');
  }
}

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {ProductModel} from "../components/product/model/product.model";
import {SubscriptionModel} from "../components/subscription/model/subscription.model";

@Injectable()
export class ProductService {
  constructor(private http: HttpClient) {
  }

  addProduct(product: ProductModel) {
    return this.http.post("/api/v1/products", product);
  }

  getProducts(): Observable<ProductModel[]> {
    return this.http.get<ProductModel[]>("/api/v1/products");
  }
  getProduct(id: string): Observable<ProductModel> {
    return this.http.get<ProductModel>("/api/v1/products/" + id);
  }
  createSubcription(userId: string, productId: string, period: string): Observable<SubscriptionModel> {
    return this.http.post<SubscriptionModel>("/api/v1/subscriptions", {
      userId: userId,
      productId: productId,
      period: period
    });
  }
}

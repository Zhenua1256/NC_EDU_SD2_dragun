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

  getProductsCompany(id: string): Observable<ProductModel[]> {
    return this.http.get<ProductModel[]>("/api/v1/products/company/" + id);
  }
  getSubscriptionUser(id: string): Observable<SubscriptionModel[]> {
    return this.http.get<SubscriptionModel[]>("/api/v1/subscriptions/user/" + id);
  }
  getProduct(id: string): Observable<ProductModel> {
    return this.http.get<ProductModel>("/api/v1/products/" + id);
  }
  getAllProducts(): Observable<ProductModel[]> {
    return this.http.get<ProductModel[]>("/api/v1/products/");
  }
  unSubscribe(id: string): Observable<SubscriptionModel> {
    return this.http.get<SubscriptionModel>("/api/v1/subscriptions/unsubscribe/" + id);
  }
  onSubscribe(id: string): Observable<SubscriptionModel> {
    return this.http.get<SubscriptionModel>("/api/v1/subscriptions/onsubscribe/" + id);
  }
  createSubcription(billingAccountId: string, productId: string, period: string, userId: string): Observable<SubscriptionModel> {
    return this.http.post<SubscriptionModel>("/api/v1/subscriptions", {
      billingAccountId: billingAccountId,
      productId: productId,
      period: period,
      status: true,
      userId: userId
    });
  }
}

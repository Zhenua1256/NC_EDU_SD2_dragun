import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BillingAccountModel} from '../components/billing-account/model/billing-account.model';


@Injectable()
export class BillingAccountService {

  constructor(private http: HttpClient) {
  }
  getBillingAccounts(): Observable<BillingAccountModel[]> {
    return this.http.get<BillingAccountModel[]>('/api/v1/billingaccount');
  }

  saveBillingAccount(billingAccount: BillingAccountModel): Observable<BillingAccountModel> {
    return this.http.post<BillingAccountModel>('/api/v1/billingaccount', billingAccount);
  }

  deleteBillingAccount(billingAccountId: string): Observable<void> {
    return this.http.delete<void>('/api/v1/billingaccount/' + billingAccountId);
  }

  getBillingAccountById(id: string): Observable<BillingAccountModel> {
    return this.http.get<BillingAccountModel>('/api/v1/billingaccount/' + id);
  }

}

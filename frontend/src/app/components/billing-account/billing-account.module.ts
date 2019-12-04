import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {BillingAccountService} from '../../service/Billing-Account-Service';
import {BillingAccountComponent} from './billing-account.component';



@NgModule({
  declarations: [
    BillingAccountComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],

  providers: [BillingAccountService],
  exports: [BillingAccountComponent]

})
export class BillingAccountModule {
}

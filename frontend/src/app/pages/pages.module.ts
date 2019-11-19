import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HomePageComponent} from './home-page/home-page.component';
import {HomeModule} from '../components/home/home.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTabsModule} from '@angular/material';
import {RegistrationModule} from '../components/registration/registration.module';
import {BillingAccountModule} from '../components/billing-account/billing-account.module';
import {RegistrationProductModule} from '../components/registration-product/registration-product.module';
import {CreateBillingAccountComponent} from './create-billing-account-page/create-billing-account.component';

@NgModule({
  declarations: [
    HomePageComponent,
    CreateBillingAccountComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    BrowserAnimationsModule,
    MatTabsModule,
    HttpClientModule,
    HomeModule,
    RegistrationModule,
    BillingAccountModule,
    RegistrationProductModule,
  ],
  exports: [HomePageComponent, CreateBillingAccountComponent]
})
export class PagesModule {
}

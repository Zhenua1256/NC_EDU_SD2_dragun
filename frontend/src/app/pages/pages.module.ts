import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {RegistrationUserModule} from '../components/user-registration/registrarion-user.module';
import {RegistrationUserPageComponent} from './registration-user-page/registration-user-page.component';
import {HomePageComponent} from './home-page/home-page.component';
import {HomeModule} from '../components/home/home.module';
import {RegistrationCompanyModule} from '../components/company-registration/registration-company.module';
import {RegistrationCompanyPageComponent} from './registration-company-page/registration-company-page.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTabsModule} from '@angular/material';
import {RegistrationModule} from '../registration/registration.module';
import {CreateBillingAccountComponent} from './create-billing-account-page/create-billing-account.component';

@NgModule({
  declarations: [
    RegistrationUserPageComponent,
    HomePageComponent,
    RegistrationCompanyPageComponent,
    CreateBillingAccountComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    BrowserAnimationsModule,
    MatTabsModule,
    HttpClientModule,
    RegistrationUserModule,
    HomeModule,
    RegistrationCompanyModule,
    RegistrationModule,
  ],
  exports: [RegistrationUserPageComponent, RegistrationCompanyPageComponent, HomePageComponent, CreateBillingAccountComponent]
})
export class PagesModule {
}

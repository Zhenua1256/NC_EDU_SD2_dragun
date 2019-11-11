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


@NgModule({
  declarations: [
    RegistrationUserPageComponent,
    HomePageComponent,
    RegistrationCompanyPageComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    RegistrationUserModule,
    HomeModule,
    RegistrationCompanyModule
  ],
  exports: [RegistrationUserPageComponent, RegistrationCompanyPageComponent, HomePageComponent]
})
export class PagesModule {
}

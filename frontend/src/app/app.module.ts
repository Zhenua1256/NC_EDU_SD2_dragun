import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {UserModule} from './components/users/users.module';
import {PagesModule} from './pages/pages.module';
import {CompanyModule} from './components/company/company.module';
import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from './pages/home-page/home-page.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import {RegistrationPageComponent} from './pages/registration-page/registration-page.component';
import {CreateBillingAccountComponent} from './pages/create-billing-account-page/create-billing-account.component';
import {RegistrationModule} from './components/registration/registration.module';
import { RegistrationServicePageComponent } from './pages/registration-service-page/registration-service-page.component';
import {BillingAccountComponent} from './components/billing-account/billing-account.component';
import {BillingAccountModule} from './components/billing-account/billing-account.module';
import { ProductComponent } from './components/product/product.component';
import { RegistrationProductComponent } from './components/registration-product/registration-product.component';
import { RegistrationProductPageComponent } from './pages/registration-product-page/registration-product-page.component';


const routes: Routes = [
  {path: '',  redirectTo: '/home', pathMatch: 'full'},
  {path: 'home' , component: HomePageComponent},
  {path: 'registration', component: RegistrationPageComponent},
  /*{path: 'registration_service', component: RegistrationServiceComponent},*/
  {path: 'create_ba', component: BillingAccountComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    RegistrationPageComponent,
    RegistrationServicePageComponent,
    ProductComponent,
    RegistrationProductComponent,
    RegistrationProductPageComponent
  ],
  imports: [
    UserModule,
    BillingAccountModule,
    CompanyModule,
    BrowserModule,
    PagesModule,
    RouterModule.forRoot(routes),
    RegistrationModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

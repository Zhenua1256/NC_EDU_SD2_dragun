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
import {RegistrationModule} from './components/registration/registration.module';
import {BillingAccountModule} from './components/billing-account/billing-account.module';
import { RegistrationProductPageComponent } from './pages/registration-product-page/registration-product-page.component';
import {RegistrationProductModule} from './components/registration-product/registration-product.module';
import {CreateBillingAccountComponent} from './pages/create-billing-account-page/create-billing-account.component';
import { HomeProductComponent } from './components/home-product/home-product.component';
import { HomeProductPageComponent } from './pages/home-product-page/home-product-page.component';


const routes: Routes = [
  {path: '',  redirectTo: '/home', pathMatch: 'full'},
  {path: 'login' , component: HomePageComponent},
  {path: 'registration', component: RegistrationPageComponent},
  {path: 'create-ba', component: CreateBillingAccountComponent},
  {path: 'registration-service', component: RegistrationProductPageComponent},
  {path: 'home', component: HomeProductPageComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    RegistrationPageComponent,
    RegistrationProductPageComponent,
    HomeProductComponent,
    HomeProductPageComponent
  ],
  imports: [
    UserModule,
    BillingAccountModule,
    CompanyModule,
    BrowserModule,
    PagesModule,
    RouterModule.forRoot(routes),
    RegistrationModule,
    RegistrationProductModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

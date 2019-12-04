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
import { DetailsComponent } from './components/product/details/details.component';
import { DetailsProductPageComponent } from './pages/details-product-page/details-product-page.component';
import { HeaderComponent } from './components/header/header.component';
import { PersonalUserPageComponent } from './pages/personal-user-page/personal-user-page.component';
import { PersonalAreaComponent } from './components/users/personal-area/personal-area.component';
import {ApiInterseptor} from './interseptors/api-interseptor';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {HeaderService} from './service/header.service';
import {SubscriptionModule} from './components/subscription/subscription.module';


const routes: Routes = [
  {path: '',  redirectTo: '/home', pathMatch: 'full'},
  {path: 'login' , component: HomePageComponent},
  {path: 'registration', component: RegistrationPageComponent},
  {path: 'create-ba', component: CreateBillingAccountComponent},
  {path: 'registration-service', component: RegistrationProductPageComponent},
  {path: 'home', component: HomeProductPageComponent},
  {path: 'personal', component: PersonalUserPageComponent},
  {path: 'product/:id', component: DetailsComponent},
  {path: '**', component: NotFoundComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    RegistrationPageComponent,
    RegistrationProductPageComponent,
    HomeProductComponent,
    HomeProductPageComponent,
    DetailsComponent,
    DetailsProductPageComponent,
    HeaderComponent,
    PersonalUserPageComponent,
    PersonalAreaComponent,
  ],
  imports: [
    UserModule,
    SubscriptionModule,
    BillingAccountModule,
    CompanyModule,
    BrowserModule,
    PagesModule,
    RouterModule.forRoot(routes),
    RegistrationModule,
    RegistrationProductModule,
  ],
  providers: [ApiInterseptor, {
    provide: HTTP_INTERCEPTORS,
    useClass: ApiInterseptor,
    multi: true
  },
  HeaderService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
/*import { BillingAccountComponent } from './components/billing-account/table/billing-account.component';*/
import {UserModule} from './components/users/users.module';
import {PagesModule} from './pages/pages.module';
import {CompanyModule} from './components/company/company.module';
import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from './pages/home-page/home-page.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {RegistrationPageComponent} from './pages/registration-page/registration-page.component';
import {CreateBillingAccountComponent} from './pages/create-billing-account-page/create-billing-account.component';
import {RegistrationModule} from './registration/registration.module';
/*
import { RegistrationServicePageComponent } from './pages/registration-service-page/registration-service-page.component';
import {RegistrationServiceComponent} from './components/registration-service/registration-service.component';*/

const routes: Routes = [
  {path: '',  redirectTo: '/home', pathMatch: 'full'},
  {path: 'home' , component: HomePageComponent},
  {path: 'registration', component: RegistrationPageComponent},
  /*{path: 'registration_service', component: RegistrationServiceComponent},*/
  {path: 'create_ba', component: CreateBillingAccountComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
   /* BillingAccountComponent,*/
    NotFoundComponent,
    RegistrationPageComponent
  /*  RegistrationServicePageComponent*/
  ],
  imports: [
    UserModule,
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

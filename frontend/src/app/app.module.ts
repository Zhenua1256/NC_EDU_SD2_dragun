import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BillingAccountComponent } from './components/billing-account/billing-account.component';
import {UserModule} from './components/users/users.module';
import {PagesModule} from './pages/pages.module';
import {CompanyModule} from './components/company/company.module';
import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from './pages/home-page/home-page.component';
import {RegistrationCompanyPageComponent} from './pages/registration-company-page/registration-company-page.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {RegistrationUserPageComponent} from './pages/registration-user-page/registration-user-page.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {path: '',  redirectTo: '/home', pathMatch: 'full'},
  {path: 'home' , component: HomePageComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'registration/company', component: RegistrationCompanyPageComponent},
  {path: 'registration/user', component: RegistrationUserPageComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    BillingAccountComponent,
    NotFoundComponent,
    RegistrationComponent
  ],
  imports: [
    UserModule,
    CompanyModule,
    BrowserModule,
    PagesModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

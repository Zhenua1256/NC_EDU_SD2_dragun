import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {RegistrationCompanyComponent} from './registration-company.component';

@NgModule({
  declarations: [
    RegistrationCompanyComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule
  ],

  providers: [],
  exports: [RegistrationCompanyComponent]
})
export class RegistrationCompanyModule {
}

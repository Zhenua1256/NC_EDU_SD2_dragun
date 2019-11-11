import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {RegistrationUserComponent} from './registration-user.component';

@NgModule({
  declarations: [
    RegistrationUserComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule
  ],

  providers: [],
  exports: [RegistrationUserComponent]
})
export class RegistrationUserModule {
}

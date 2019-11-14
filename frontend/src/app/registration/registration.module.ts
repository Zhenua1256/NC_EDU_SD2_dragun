import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {RegistrationComponent} from './registration.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTabsModule} from '@angular/material';

@NgModule({
  declarations: [
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    MatTabsModule,
    BrowserAnimationsModule
  ],

  providers: [],
  exports: [RegistrationComponent]
})
export class RegistrationModule {
}

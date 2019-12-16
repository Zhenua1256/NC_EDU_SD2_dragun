import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatSelectModule, MatTabsModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RegistrationProductComponent} from './registration-product.component';
import {ProductService} from '../../service/Product-service';

@NgModule({
  declarations: [
    RegistrationProductComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    MatTabsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatSelectModule
  ],

  providers: [ProductService],
  exports: [RegistrationProductComponent]
})
export class RegistrationProductModule {
}

import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HomeComponent} from './home.component';
import {UserService} from '../../service/User-Service';
import {CompanyService} from '../../service/Company-Service';

@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule
  ],

  providers: [UserService, CompanyService],
  exports: [HomeComponent]
})
export class HomeModule {
}

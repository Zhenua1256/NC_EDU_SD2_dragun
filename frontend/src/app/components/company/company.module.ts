import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {CompanyComponent} from './company.component';
import {CompanyService} from '../../service/Company-Service';


@NgModule({
  declarations: [
    CompanyComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule

  ],

  providers: [CompanyService],
  exports: [CompanyComponent]
})
export class CompanyModule {
}

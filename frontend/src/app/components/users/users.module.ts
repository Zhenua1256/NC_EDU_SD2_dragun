import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {UserComponent} from './users.component';
import {UserService} from '../../service/User-Service';


@NgModule({
  declarations: [
    UserComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule
  ],

  providers: [UserService],
  exports: [UserComponent]
})
export class UserModule {
}

import {SubscriptionComponent} from './subscription.component';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';


@NgModule({
  declarations: [
    SubscriptionComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule
  ],

  providers: [],
  exports: [SubscriptionComponent]
})
export class SubscriptionModule {
}

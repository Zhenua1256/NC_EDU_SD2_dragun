import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ProductComponent} from './product.component';
import {ProductService} from '../../service/Product-service';

@NgModule({
  declarations: [
    ProductComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule

  ],

  providers: [ProductService],
  exports: [ProductComponent]
})
 class ProductModule {
}

import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ListArticlesComponent} from './shop/components/list-articles/list-articles.component';
import {AppRoutingModule} from "./app-routing.module";
import {BasketComponent} from './shop/components/basket/basket.component';
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {BasketService} from "./shop/services/basket.service";

@NgModule({
  declarations: [
    AppComponent,
    ListArticlesComponent,
    BasketComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpModule,
    FormsModule
  ],
  providers: [BasketService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

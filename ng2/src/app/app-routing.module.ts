  import {RouterModule, Routes} from '@angular/router';
import {NgModule} from "@angular/core";
import {ListArticlesComponent} from "./shop/components/list-articles/list-articles.component";
import {BasketComponent} from "./shop/components/basket/basket.component";


const appRoutes: Routes = [
  {
    path: 'products', component: ListArticlesComponent
  },
  {
    path: 'basket', component: BasketComponent
  },
  {
    path: '', component: ListArticlesComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}

import {Component, OnInit} from '@angular/core';
import {Http} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {BasketService} from "../../services/basket.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-articles',
  templateUrl: './list-articles.component.html',
  styleUrls: ['./list-articles.component.css']
})
export class ListArticlesComponent implements OnInit {

  products;
  productsForBasket;

  constructor(private httpClient: Http, private basketService: BasketService, private router: Router) {
  }

  ngOnInit() {
    this.httpClient.get("/catalogue-service/articles").toPromise()
      .then(data => {
        this.products = data.json()
        this.products.forEach(product => product.buyNumber = 0)
      })
  }

  buyProducts() {
    this.productsForBasket = this.products.filter(product => product.buyNumber > 0);
    let items = []
    this.productsForBasket.forEach(product => {
      items.push({article: product.uuid, quantity: product.buyNumber})
    })
    let data = {customer: "41440721-19db-4a02-8fd8-b6a0f3427d46", items: items}
    this.httpClient.post("/checkout-service/checkouts",data).toPromise()
      .then(data => {
        console.log(data.json())
        this.basketService.setBasket(data.json().basket, this.productsForBasket)
        this.router.navigate(["basket"])
      })
  }
}

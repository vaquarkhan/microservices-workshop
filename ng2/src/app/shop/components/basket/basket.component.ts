import {Component, OnInit} from '@angular/core';
import {BasketService} from "../../services/basket.service";
import {Http} from "@angular/http";

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {

  products
  basketId

  constructor(private httpClient: Http, private basketService:BasketService) {
  }

  ngOnInit() {
    this.products = this.basketService.getBasketItems()
    this.basketId = this.basketService.getBasketId()
  }

  getSum() {
    let sum = 0
    this.products.forEach(product => sum += product.price * product.buyNumber)
    return sum.toFixed(2);
  }

  buyProducts(){
    let data = {
      method: "CC"
    }
    this.httpClient.post("/payment-service/payments/"+this.basketId, data).toPromise()
      .then(data => {
        alert("Danke für ihren Einkauf!")
        this.products = null
        this.basketId = null
        }
      )
  }
}

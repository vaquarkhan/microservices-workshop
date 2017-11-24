import { Injectable } from '@angular/core';

@Injectable()
export class BasketService {
  private uuid
  private products

  constructor() { }


  setBasket(uuid, productsForBasket){
    this.uuid = uuid
    this.products = productsForBasket
  }

  getBasketId(){
    return this.uuid
  }

  getBasketItems(){
    return this.products
  }
}

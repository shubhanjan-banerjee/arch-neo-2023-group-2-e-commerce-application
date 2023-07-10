import { Injectable } from '@angular/core';
import { Product } from '../models/product.interface';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cartItems: Product[] = [];

  constructor() { }

  addToCart(product: Product): void {
    this.cartItems.push(product);
  }

  removeFromCart(product: Product): void {
    const index = this.cartItems.findIndex(item => item.id === product.id);
    if (index !== -1) {
      this.cartItems.splice(index, 1);
    }
  }

  getCartItems(): Product[] {
    return this.cartItems;
  }

  clearCart(): void {
    this.cartItems = [];
  }
}

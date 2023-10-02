import { Injectable } from '@angular/core';
import { Product } from '../models/product.interface';
import { BehaviorSubject } from 'rxjs';
import { Cart } from '../models/cart.model';
import { LocalStorageService } from './local-storage.service';

@Injectable()
export class CartService {
  private cartItems: Cart[] = [];
  private cartCount$: BehaviorSubject<number>;

  constructor(private store: LocalStorageService) {
    const p = this.getCartItems();
    this.cartCount$ = new BehaviorSubject<number>(p.length);
  }

  getCartCountObservable() {
    return this.cartCount$.asObservable();
  }

  addToCart(product: Product, quantity: number): void {
    this.cartItems.push({ product, quantity });
    this.cartCount$.next(this.cartItems.length);
    this.updateStore();
  }

  updateToCart(product: Product, quantity: number) {
    const item = this.cartItems.find(item => item.product.productId === product.productId);
    if (item) {
      item.quantity = quantity;
      this.updateStore();
    }
  }

  removeFromCart(product: Product): void {
    const index = this.cartItems.findIndex(item => item.product.productId === product.productId);
    if (index !== -1) {
      this.cartItems.splice(index, 1);
      this.cartCount$.next(this.cartItems.length);
      this.updateStore();
    }
  }

  isItemPresentsInCart(id: number): boolean {
    const index = this.cartItems.findIndex(item => item.product.productId === id);
    return index !== -1;
  }

  getCartItems(): Cart[] {
    return this.cartItems = this.getStore();
  }

  clearCart(): void {
    this.cartItems = [];
    this.cartCount$.next(this.cartItems.length);
    this.store.removeItem('cartList');
  }

  getStore() {
    return this.store.getItem('cartList') || [];
  }

  updateStore() {
    this.store.setItem('cartList', this.cartItems);
  }
}

import { Injectable } from '@angular/core';
import { Product } from '../models/product.interface';
import { BehaviorSubject } from 'rxjs';
import { LocalStorageService } from './local-storage.service';

@Injectable()
export class WishService {
  private wishItems: Product[] = [];
  private wishCount$: BehaviorSubject<number>;

  constructor(private store: LocalStorageService) {
    const p = this.getWishItems();
    this.wishCount$ = new BehaviorSubject<number>(p.length);
  }

  getWishCountObservable() {
    return this.wishCount$.asObservable();
  }

  addToWish(product: Product): void {
    this.wishItems.push(product);
    this.wishCount$.next(this.wishItems.length);
    this.updateStore();
  }

  removeFromWish(product: Product): void {
    const index = this.wishItems.findIndex(item => item.productId === product.productId);
    if (index !== -1) {
      this.wishItems.splice(index, 1);
      this.wishCount$.next(this.wishItems.length);
      this.updateStore();
    }
  }

  getWishItems(): Product[] {
    return this.wishItems = this.getStore();
  }

  isItemPresentsInWish(id: number): boolean {
    const index = this.wishItems.findIndex(item => item.productId === id);
    return index !== -1;
  }

  clearWish(): void {
    this.wishItems = [];
    this.wishCount$.next(this.wishItems.length);
    this.store.removeItem('wishList');
  }

  getStore() {
    return this.store.getItem('wishList') || [];
  }

  updateStore() {
    this.store.setItem('wishList', this.wishItems);
  }
}

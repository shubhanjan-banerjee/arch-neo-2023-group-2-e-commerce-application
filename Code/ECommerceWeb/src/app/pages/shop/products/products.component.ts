import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Product } from 'src/app/models/product.interface';
import { ProductService } from 'src/app/services/product.service';
import { CartService } from 'src/app/services/cart.service';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { Observable, map, of } from 'rxjs';

@Component({
  selector: 'ecommerce-products',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent {
  products$: Observable<Product[]> = of([]);

  constructor(
    private productSrvc: ProductService,
    private cartSrvc: CartService,
    private localStorageSrvc: LocalStorageService
  ) { }

  ngOnInit(): void {
    this.products$ = this.productSrvc.getProducts().pipe(map(rsp => rsp.content));
  }
  getPath(fileName: string) {
    return '/assets/img/' + fileName;
  }

  addToCart(product: Product): void {
    this.cartSrvc.addToCart(product);
  }

  removeFromCart(product: Product): void {
    this.cartSrvc.removeFromCart(product);
  }

  saveToLocalStorage(): void {
    const data = { name: 'John Doe', age: 30 };
    this.localStorageSrvc.setItem('userData', data);
  }

  getFromLocalStorage(): void {
    const data = this.localStorageSrvc.getItem('userData');
    console.log(data);
  }

  removeFromLocalStorage(): void {
    this.localStorageSrvc.removeItem('userData');
  }

  clearLocalStorage(): void {
    this.localStorageSrvc.clear();
  }

}


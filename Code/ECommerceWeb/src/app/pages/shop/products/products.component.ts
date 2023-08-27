import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Product } from 'src/app/models/product.interface';
import { ProductService } from 'src/app/services/product.service';
import { CartService } from 'src/app/services/cart.service';
import { LocalStorageService } from 'src/app/services/local-storage.service';

@Component({
  selector: 'ecommerce-products',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent {
  products: Product[] = [];

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private localStorageService: LocalStorageService
  ) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getProducts()
      .subscribe(products => this.products = products);
  }

  addToCart(product: Product): void {
    this.cartService.addToCart(product);
  }

  removeFromCart(product: Product): void {
    this.cartService.removeFromCart(product);
  }

  saveToLocalStorage(): void {
    const data = { name: 'John Doe', age: 30 };
    this.localStorageService.setItem('userData', data);
  }

  getFromLocalStorage(): void {
    const data = this.localStorageService.getItem('userData');
    console.log(data);
  }

  removeFromLocalStorage(): void {
    this.localStorageService.removeItem('userData');
  }

  clearLocalStorage(): void {
    this.localStorageService.clear();
  }

}


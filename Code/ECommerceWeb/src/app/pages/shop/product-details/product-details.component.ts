import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product.interface';

@Component({
  selector: 'ecommerce-product-details',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss'],
})
export class ProductDetailsComponent implements OnInit {

  product$: Observable<Product> | null = null;
  quantity = 1;

  constructor(
    private actRouteSrvc: ActivatedRoute,
    private productSrvc: ProductService,
    private cartSrvc: CartService,
    private localStorageSrvc: LocalStorageService
  ) {

  }
  ngOnInit(): void {
    const id = this.actRouteSrvc.snapshot.params['id'];
    if (id) {
      this.product$ = this.productSrvc.getProductById(id);
    }
  }
  getPath(fileName: string) {
    return '/assets/img/' + fileName;
  }
  slideImage() { }
  isWishReq() { }
  unWishReq() { }
  increaseQuantity(n: number) {
    if (this.quantity < n)
      this.quantity += 1;
  }
  decreaseQuantity(n: number) {
    if (this.quantity > 1)
      this.quantity -= 1;
  }
  addToCart(id: number) {

  }
  isOutOfStock(n: number): boolean {
    return n < this.quantity;
  }
  isStockFull(n: number): boolean {
    return n <= this.quantity;
  }
  isInCart(id: number): boolean {
    return false;
  }
}

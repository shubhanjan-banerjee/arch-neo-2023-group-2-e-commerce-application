import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product.interface';
import { WishService } from 'src/app/services/wish.service';

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
    private wishSrvc: WishService
  ) { }

  ngOnInit(): void {
    const id = this.actRouteSrvc.snapshot.params['id'];
    if (id) {
      this.product$ = this.productSrvc.getProductById(id);
    }
  }

  getPath(fileName: string) {
    return '/assets/img/' + fileName;
  }

  increaseQuantity(item: Product) {
    if (this.quantity < item.stockQuantity && !this.cartSrvc.isItemPresentsInCart(item.productId))
      this.quantity += 1;
  }

  decreaseQuantity(item: Product) {
    if (this.quantity > 1 && !this.cartSrvc.isItemPresentsInCart(item.productId))
      this.quantity -= 1;
  }

  addToCart(item: Product) {
    this.cartSrvc.addToCart(item, this.quantity);
  }

  isOutOfStock(item: Product): boolean {
    return item.stockQuantity < this.quantity;
  }

  isStockFull(item: Product): boolean {
    return item.stockQuantity <= this.quantity;
  }

  isInCart(id: number): boolean {
    return this.cartSrvc.isItemPresentsInCart(id);
  }

  isInWishList(id: number) {
    return this.wishSrvc.isItemPresentsInWish(id);
  }

  addToWishList(item: Product) {
    this.wishSrvc.addToWish(item);
  }

  removeFromWishList(item: Product) {
    this.wishSrvc.removeFromWish(item);
  }
}

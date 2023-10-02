import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartService } from 'src/app/services/cart.service';
import { NotificationService } from 'src/app/services/notification.service';
import { Cart } from 'src/app/models/cart.model';

@Component({
  selector: 'ecommerce-cart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss'],
})
export class CartComponent implements OnInit {
  cartItems: Cart[] = [];
  constructor(
    private notificationService: NotificationService,
    private cartSrvc: CartService
  ) { }

  ngOnInit(): void {
    this.loadCart();
  }

  loadCart() {
    this.cartItems = this.cartSrvc.getCartItems().map(item => {
      item.price = item.product.price * item.quantity
      return item;
    });
  }

  clearCart() {
    this.cartSrvc.clearCart();
    this.loadCart();
  }

  showSuccessNotification(): void {
    this.notificationService.showSuccess('Action was successful!');
  }

  showErrorNotification(): void {
    this.notificationService.showError('An error occurred!');
  }

  showInfoNotification(): void {
    this.notificationService.showInfo('Here is some information.');
  }

  removeFromCart(item: any) {
    this.cartSrvc.removeFromCart(item.product);
    this.loadCart();
  }

  getTotalPrice(): number {
    return this.cartItems.reduce((total, p) => {
      return total += p.price || 0;
    }, 0);
  }

  checkout() {
    console.log('item');
  }

  getPath(fileName: string) {
    return '/assets/img/' + fileName;
  }

  increaseQuantity(item: Cart) {
    if (item.quantity < item.product.stockQuantity)
      item.quantity += 1;
    item.price = item.product.price * item.quantity;
    this.cartSrvc.updateToCart(item.product, item.quantity);
  }

  decreaseQuantity(item: Cart) {
    if (item.quantity > 1)
      item.quantity -= 1;
    item.price = item.product.price * item.quantity;
    this.cartSrvc.updateToCart(item.product, item.quantity);
  }

  isStockFull(item: Cart): boolean {
    return item.product.stockQuantity <= item.quantity;
  }

}

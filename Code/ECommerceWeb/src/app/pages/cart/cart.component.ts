import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Product } from 'src/app/models/product.interface';
import { CartService } from 'src/app/services/cart.service';
import { NotificationService } from 'src/app/services/notification.service';

@Component({
  selector: 'ecommerce-cart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss'],
})
export class CartComponent {
  constructor(private notificationService: NotificationService) { }

  showSuccessNotification(): void {
    this.notificationService.showSuccess('Action was successful!');
  }

  showErrorNotification(): void {
    this.notificationService.showError('An error occurred!');
  }

  showInfoNotification(): void {
    this.notificationService.showInfo('Here is some information.');
  }
}

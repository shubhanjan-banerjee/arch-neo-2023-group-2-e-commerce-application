import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'ecommerce-orders',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss'],
})
export class OrdersComponent {}

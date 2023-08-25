import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardTodayOrderTableComponent } from '../dashboard-today-order-table/dashboard-today-order-table.component';

@Component({
  selector: 'ecommerce-dashboard-today-sell',
  standalone: true,
  imports: [CommonModule, DashboardTodayOrderTableComponent],
  templateUrl: './dashboard-today-sell.component.html',
  styleUrls: ['./dashboard-today-sell.component.scss'],
})
export class DashboardTodaySellComponent { }

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardCardComponent } from 'src/app/components/dashboard-card/dashboard-card.component';
import { DashboardCustomizeComponent } from 'src/app/components/dashboard-customize/dashboard-customize.component';
import { DashboardTodaySellComponent } from 'src/app/components/dashboard-today-sell/dashboard-today-sell.component';
import { DashboardUpdateImageSelectionComponent } from 'src/app/components/dashboard-update-image-selection/dashboard-update-image-selection.component';

@Component({
  selector: 'ecommerce-admin-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    DashboardCardComponent,
    DashboardCustomizeComponent,
    DashboardTodaySellComponent,
    DashboardUpdateImageSelectionComponent
  ],
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss'],
})
export class AdminDashboardComponent { }

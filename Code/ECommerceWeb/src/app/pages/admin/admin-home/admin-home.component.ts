import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminSidebarComponent } from 'src/app/components/admin-sidebar/admin-sidebar.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'ecommerce-admin-home',
  standalone: true,
  imports: [CommonModule, RouterModule, AdminSidebarComponent],
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.scss'],
})
export class AdminHomeComponent { }

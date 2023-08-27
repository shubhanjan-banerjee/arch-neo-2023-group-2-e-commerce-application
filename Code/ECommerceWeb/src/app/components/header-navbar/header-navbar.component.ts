import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  standalone: true,
  selector: 'ecommerce-header-navbar',
  imports: [CommonModule, RouterLink],
  templateUrl: './header-navbar.component.html',
  styleUrls: ['./header-navbar.component.scss'],
})
export class HeaderNavbarComponent {
  showMenu = false;
  toggleNavbar() {
    this.showMenu = !this.showMenu;
  }
}

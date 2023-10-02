import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { Subscription } from 'rxjs';
import { WishService } from 'src/app/services/wish.service';

@Component({
  standalone: true,
  selector: 'ecommerce-header-navbar',
  imports: [CommonModule, RouterLink],
  templateUrl: './header-navbar.component.html',
  styleUrls: ['./header-navbar.component.scss'],
})
export class HeaderNavbarComponent implements OnInit, OnDestroy {
  showMenu = false;
  showSubMenu = false;
  cartCount = 0;
  wishCount = 0;
  cartCountSubscription: Subscription | null = null;
  wishCountSubscription: Subscription | null = null;

  constructor(
    private router: Router,
    private cart: CartService,
    private wish: WishService,
  ) { }

  ngOnInit(): void {
    this.cartCountSubscription = this.cart.getCartCountObservable().subscribe(count => {
      this.cartCount = count;
    });
    this.wishCountSubscription = this.wish.getWishCountObservable().subscribe(count => {
      this.wishCount = count;
    });
  }

  ngOnDestroy(): void {
    this.cartCountSubscription?.unsubscribe();
    this.wishCountSubscription?.unsubscribe();
  }

  toggleNavbar() {
    this.showMenu = !this.showMenu;
  }
  toggleSubMenu() {
    this.showSubMenu = !this.showSubMenu;
  }
  isAuthenticated(): boolean {
    return true;
  }
  goTo(path: string) {
    this.hideAllMenu();
    this.router.navigate([path]);
  }
  hideAllMenu() {
    this.showMenu = false;
    this.showSubMenu = false;
  }
  logout() {
    this.hideAllMenu();
  }
}

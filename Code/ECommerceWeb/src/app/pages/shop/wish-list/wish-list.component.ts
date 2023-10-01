import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Product } from 'src/app/models/product.interface';
import { WishService } from 'src/app/services/wish.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'ecommerce-wish-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './wish-list.component.html',
  styleUrls: ['./wish-list.component.scss'],
})
export class WishListComponent {

  wishItems: Product[] = [];
  constructor(
    private wishSrvc: WishService
  ) { }

  ngOnInit(): void {
    this.loadWish();
  }

  loadWish() {
    this.wishItems = this.wishSrvc.getWishItems();
  }

  clearWish() {
    this.wishSrvc.clearWish();
    this.loadWish();
  }

  removeFromWish(item: any) {
    this.wishSrvc.removeFromWish(item);
    this.loadWish();
  }

  getPath(fileName: string) {
    return '/assets/img/' + fileName;
  }

}

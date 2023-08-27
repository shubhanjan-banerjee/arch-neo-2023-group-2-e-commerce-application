import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'ecommerce-category',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss'],
})
export class CategoryComponent {
  showCategory = false;
  showFilter = false;
  showSearch = false;
  toggleCategory() {
    this.showCategory = !this.showCategory;
  }
  toggleFilter() {
    this.showFilter = !this.showFilter;
  }
  toggleSearch() {
    this.showSearch = !this.showSearch;
  }
}

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable, of, map } from 'rxjs';

import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/models/category.interface';
import { FormsModule } from '@angular/forms';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'ecommerce-category',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss'],
})
export class CategoryComponent implements OnInit {

  showCategory = false;
  showFilter = false;
  showSearch = false;
  priceFilter = 0;
  searchValue: string | null = null;
  categories$: Observable<Category[]> = of([]);

  constructor(
    private catSrvc: CategoryService,
    private productSrvc: ProductService
  ) { }

  toggleCategory() {
    this.showCategory = !this.showCategory;
  }

  toggleFilter() {
    this.showFilter = !this.showFilter;
  }

  toggleSearch() {
    this.showSearch = !this.showSearch;
  }

  ngOnInit(): void {
    this.categories$ = this.catSrvc.getCategories().pipe(map(rsp => rsp.content));
  }

  getPath(fileName: string) {
    return '/assets/img/' + fileName;
  }

  onSearchKeyUp(e: KeyboardEvent) {
    if (e.key === 'Enter') {
      this.productSrvc.updateSearchText(this.searchValue);
    } else if (e.key === 'Escape') {
      this.searchValue = null;
      this.showSearch = false;
      this.productSrvc.updateSearchText(this.searchValue);
    }
  }

  clearSearchFilter() {
    this.searchValue = null;
    this.showSearch = false;
    this.productSrvc.updateSearchText(this.searchValue);
  }

  clearPriceFilter() {
    this.showFilter = false;
    this.priceFilter = 0;
    this.productSrvc.updatePriceFilter(this.priceFilter);
  }

  onPriceChange() {
    this.productSrvc.updatePriceFilter(this.priceFilter);
  }
}

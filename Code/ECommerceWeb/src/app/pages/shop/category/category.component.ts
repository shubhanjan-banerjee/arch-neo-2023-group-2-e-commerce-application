import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable, of, map } from 'rxjs';

import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/models/category.interface';

@Component({
  selector: 'ecommerce-category',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss'],
})
export class CategoryComponent implements OnInit {

  showCategory = false;
  showFilter = false;
  showSearch = false;
  categories$: Observable<Category[]> = of([]);
  constructor(private catSrvc: CategoryService) {

  }
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
}

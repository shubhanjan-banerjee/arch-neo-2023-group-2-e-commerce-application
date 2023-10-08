import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Product } from 'src/app/models/product.interface';
import { ProductService } from 'src/app/services/product.service';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { Observable, Subscription, debounce, debounceTime, interval, map, of, scan, tap } from 'rxjs';
import { WishService } from 'src/app/services/wish.service';
import { PaginationComponent } from 'src/app/components/pagination/pagination.component';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/models/category.interface';

@Component({
  selector: 'ecommerce-products',
  standalone: true,
  imports: [CommonModule, RouterLink, PaginationComponent],
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent implements OnInit, OnDestroy {
  products$: Observable<Product[]> = of([]);

  pageSize: number = 12;
  pageNo: number = 1;
  totalElements: number = 0;
  totalPages: number = 0;
  numberOfElements: number = 10;
  isEmpty: boolean = false;
  isFirst: boolean = true;
  isLast: boolean = false;
  searchText: string | null = null;
  priceFilterVal = 0;
  categoryId: number | null = null;
  category: Category | null = null;

  priceFilterSubscription: Subscription | null = null;
  searchTextSubscription: Subscription | null = null;

  constructor(
    private actRouteSrvc: ActivatedRoute,
    private productSrvc: ProductService,
    private categorySrvc: CategoryService,
    private wishSrvc: WishService,
    private localStorageSrvc: LocalStorageService
  ) { }

  ngOnInit(): void {
    this.categoryId = this.actRouteSrvc.snapshot.params['id'];
    if (this.categoryId) {
      console.log('categoryId', this.categoryId);
    }
    this.loadData(this.categoryId);
    this.priceFilterSubscription = this.productSrvc
      .getPriceFilterObservable()
      .pipe(
        debounceTime(500)
      ).subscribe(val => {
        this.priceFilterVal = val;
        this.loadData();
      });
    this.searchTextSubscription = this.productSrvc.getSearchTextObservable().subscribe(val => {
      this.searchText = val;
      this.loadData();
    });
  }

  ngOnDestroy(): void {
    this.priceFilterSubscription?.unsubscribe();
    this.searchTextSubscription?.unsubscribe();
  }

  loadData(categoryId: number | null = null) {
    const req: any = {
      page: this.pageNo - 1,
      size: this.pageSize,
      search: this.searchText,
      price: this.priceFilterVal
    };
    if (categoryId) {
      req.categoryId = categoryId;
      this.categorySrvc.getCategoryById(categoryId).subscribe(rsp => {
        this.category = rsp;
      });
    }

    this.products$ = this.productSrvc.getProducts(req).pipe(
      tap(rsp => {
        this.totalElements = rsp.totalElements;
        this.totalPages = rsp.totalPages;
        this.numberOfElements = rsp.numberOfElements;
        this.isEmpty = rsp.empty;
        this.isFirst = rsp.first;
        this.isLast = rsp.last;
      }),
      map(rsp => rsp.content)
    );
  }

  getPath(fileName: string) {
    return '/assets/img/' + fileName;
  }

  gotoPage(type: string) {
    switch (type) {
      case 'FIRST':
        if (!this.isFirst) {
          this.pageNo = 1;
          this.loadData();
        }
        break;
      case 'PREV':
        if (!this.isFirst) {
          this.pageNo -= 1;
          this.loadData();
        }
        break;
      case 'NEXT':
        if (!this.isLast) {
          this.pageNo += 1;
          this.loadData();
        }
        break;
      case 'LAST':
        if (!this.isLast) {
          this.pageNo = this.totalPages;
          this.loadData();
        }
        break;
      default:
        break;
    }
  }

  saveToLocalStorage(): void {
    const data = { name: 'John Doe', age: 30 };
    this.localStorageSrvc.setItem('userData', data);
  }

  getFromLocalStorage(): void {
    const data = this.localStorageSrvc.getItem('userData');
    console.log(data);
  }

  removeFromLocalStorage(): void {
    this.localStorageSrvc.removeItem('userData');
  }

  clearLocalStorage(): void {
    this.localStorageSrvc.clear();
  }

  isInWishList(id: number) {
    return this.wishSrvc.isItemPresentsInWish(id);
  }

  addToWishList(e: Event, item: Product) {
    e.stopPropagation();
    this.wishSrvc.addToWish(item);
  }

  removeFromWishList(e: Event, item: Product) {
    e.stopPropagation();
    this.wishSrvc.removeFromWish(item);
  }

}


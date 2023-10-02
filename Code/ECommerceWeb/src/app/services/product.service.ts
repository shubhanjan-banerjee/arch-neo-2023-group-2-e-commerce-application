import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Product } from '../models/product.interface';
import { RestService } from './rest.service';
import { ResponseModel } from '../models/response.model';

@Injectable()
export class ProductService {
  private apiUrl = 'products'; // Replace with your actual API URL
  private _searchText: Subject<string | null> = new Subject<string | null>();
  private _priceFilter: Subject<number> = new Subject<number>();

  constructor(private rest: RestService) { }

  getSearchTextObservable(): Observable<string | null> {
    return this._searchText.asObservable();
  }

  getPriceFilterObservable(): Observable<number> {
    return this._priceFilter.asObservable();
  }

  updateSearchText(val: string | null) {
    this._searchText.next(val);
  }

  updatePriceFilter(val: number) {
    this._priceFilter.next(val);
  }

  getProducts(req: any): Observable<ResponseModel<Product>> {
    if (req.search === null) {
      delete req['search'];
    }
    if (req.price === 0) {
      delete req['price'];
    }
    return this.rest.get<ResponseModel<Product>>(this.apiUrl, req);
  }

  getProductById(productId: string): Observable<Product> {
    const url = `${this.apiUrl}/${productId}`;
    return this.rest.get<Product>(url);
  }

  createProduct(product: Product): Observable<Product> {
    return this.rest.post<Product>(this.apiUrl, product);
  }

  updateProduct(productId: string, product: Product): Observable<Product> {
    const url = `${this.apiUrl}/${productId}`;
    return this.rest.put<Product>(url, product);
  }

  deleteProduct(productId: string): Observable<void> {
    const url = `${this.apiUrl}/${productId}`;
    return this.rest.delete<void>(url);
  }
}

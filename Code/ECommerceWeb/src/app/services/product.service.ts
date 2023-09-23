import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product.interface';
import { RestService } from './rest.service';
import { ResponseModel } from '../models/response.model';

@Injectable()
export class ProductService {
  private apiUrl = 'products'; // Replace with your actual API URL

  constructor(private rest: RestService) { }

  getProducts(): Observable<ResponseModel<Product>> {
    return this.rest.get<ResponseModel<Product>>(this.apiUrl);
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

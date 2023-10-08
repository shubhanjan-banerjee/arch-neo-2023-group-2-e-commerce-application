import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../models/category.interface';
import { RestService } from './rest.service';
import { ResponseModel } from '../models/response.model';

@Injectable()
export class CategoryService {
  private apiUrl = 'categories'; // Replace with your actual API URL

  constructor(private rest: RestService) { }

  getCategories(): Observable<ResponseModel<Category>> {
    return this.rest.get<ResponseModel<Category>>(this.apiUrl);
  }

  getCategoryById(categoryId: number): Observable<Category> {
    const url = `${this.apiUrl}/${categoryId}`;
    return this.rest.get<Category>(url);
  }

  createCategory(product: Category): Observable<Category> {
    return this.rest.post<Category>(this.apiUrl, product);
  }

  updateCategory(categoryId: string, product: Category): Observable<Category> {
    const url = `${this.apiUrl}/${categoryId}`;
    return this.rest.put<Category>(url, product);
  }

  deleteCategory(categoryId: string): Observable<void> {
    const url = `${this.apiUrl}/${categoryId}`;
    return this.rest.delete<void>(url);
  }
}

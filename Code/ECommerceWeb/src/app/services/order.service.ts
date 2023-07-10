import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order.interface';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private apiUrl = 'http://your-api-url/orders'; // Replace with your actual API URL

  constructor(private http: HttpClient) { }

  placeOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(this.apiUrl, order);
  }

  getOrderById(orderId: string): Observable<Order> {
    const url = `${this.apiUrl}/${orderId}`;
    return this.http.get<Order>(url);
  }

  getOrderByUser(userId: string): Observable<Order[]> {
    const url = `${this.apiUrl}?userId=${userId}`;
    return this.http.get<Order[]>(url);
  }

  updateOrderStatus(orderId: string, status: string): Observable<Order> {
    const url = `${this.apiUrl}/${orderId}`;
    return this.http.patch<Order>(url, { status });
  }
}

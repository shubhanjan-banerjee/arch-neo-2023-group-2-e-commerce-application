import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../app.config';

@Injectable()
export class RestService {
  private apiUrl = environment.apiBaseUrl; // Replace with your actual API URL

  constructor(private http: HttpClient) {
  }

  get<T>(url: string, params?: HttpParams): Observable<T> {
    return this.http.get<T>(`${this.apiUrl}/${url}`, { params });
  }

  post<T>(url: string, body: any, headers?: HttpHeaders): Observable<T> {
    return this.http.post<T>(`${this.apiUrl}/${url}`, body, { headers });
  }

  put<T>(url: string, body: any): Observable<T> {
    return this.http.put<T>(`${this.apiUrl}/${url}`, body);
  }

  patch<T>(url: string, body: any): Observable<T> {
    return this.http.patch<T>(`${this.apiUrl}/${url}`, body);
  }

  delete<T>(url: string): Observable<T> {
    return this.http.delete<T>(`${this.apiUrl}/${url}`);
  }
}

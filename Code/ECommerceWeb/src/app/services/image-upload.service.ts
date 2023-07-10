import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageUploadService {
  private apiUrl = 'http://your-api-url'; // Replace with your actual API URL

  constructor(private http: HttpClient) { }

  uploadImage(file: File): Observable<string> {
    const formData: FormData = new FormData();
    formData.append('image', file, file.name);
    return this.http.post<string>(`${this.apiUrl}/upload-image`, formData);
  }
}

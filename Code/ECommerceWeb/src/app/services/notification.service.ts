import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  showSuccess(message: string): void {
    // Implement your logic to display a success notification
    console.log(`Success: ${message}`);
  }

  showError(message: string): void {
    // Implement your logic to display an error notification
    console.error(`Error: ${message}`);
  }

  showInfo(message: string): void {
    // Implement your logic to display an informational notification
    console.log(`Info: ${message}`);
  }
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'ecommerce-login',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  email = '';
  password = '';

  constructor(private authService: AuthService) { }

  login(): void {
    const credentials = { email: this.email, password: this.password };
    this.authService.login(credentials).subscribe(
      () => {
        // Redirect or perform other actions on successful login
      },
      (error) => {
        // Handle login error, display error message, etc.
      }
    );
  }

  logout(): void {
    this.authService.logout().subscribe(
      () => {
        // Redirect or perform other actions on successful logout
      },
      (error) => {
        // Handle logout error, display error message, etc.
      }
    );
  }

  isAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }
}

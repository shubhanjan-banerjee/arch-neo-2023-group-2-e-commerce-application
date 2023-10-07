import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { FormsModule } from '@angular/forms';
import { User } from 'src/app/models/user.interface';

@Component({
  selector: 'ecommerce-login',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  errorMessage: string | null = null;

  protected userModel = new User();

  constructor(private authService: AuthService, private router: Router) { }

  protected onSubmit() {
    this.authService.login(this.userModel).subscribe(
      () => {
        // this.router.navigateByUrl('/products');
      },
      (error) => {
        // Handle login error, display error message, etc.
      }
    );
    console.table(this.userModel);
  }

  protected resetForm(): void {
    this.userModel = new User();
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

  onLoginBtnClicked() {
    // this.login();
    this.router.navigateByUrl('/products');
  }
}

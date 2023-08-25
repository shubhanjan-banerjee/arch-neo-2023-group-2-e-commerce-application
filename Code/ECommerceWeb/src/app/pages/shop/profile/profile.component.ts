import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from 'src/app/models/user.interface';
import { UserService } from 'src/app/services/user.service';
import { ImageUploadService } from 'src/app/services/image-upload.service';

@Component({
  selector: 'ecommerce-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
})
export class ProfileComponent {
  user!: User;

  constructor(private userService: UserService, private imageUploadService: ImageUploadService) { }

  ngOnInit(): void {
    const userId = 'your-user-id'; // Replace with the actual user ID
    this.getUserById(userId);
  }

  getUserById(userId: string): void {
    this.userService.getUserById(userId)
      .subscribe(user => this.user = user);
  }

  updateProfile(): void {
    this.userService.updateUser(this.user.id, this.user)
      .subscribe(updatedUser => {
        this.user = updatedUser;
        // Additional logic or notifications for successful update
      });
  }

  onFileSelected(event: any): void {
    const file: File = event.target.files[0];
    this.uploadImage(file);
  }

  uploadImage(file: File): void {
    this.imageUploadService.uploadImage(file)
      .subscribe(
        imageUrl => {
          // Handle successful upload, e.g., display the uploaded image or store the image URL
          console.log('Image URL:', imageUrl);
        },
        error => {
          // Handle upload error
          console.error('Upload Error:', error);
        }
      );
  }
}

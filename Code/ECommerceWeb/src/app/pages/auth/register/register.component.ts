import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormControl, FormGroup, NonNullableFormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserRegistration } from 'src/app/models/user-registration.model';
import { CustomvalidationService } from 'src/app/services/customvalidation.service';
import { UserNameValidationService } from 'src/app/services/user-name-validation.service';

@Component({
  selector: 'ecommerce-register',
  standalone: true,
  imports: [CommonModule, RouterModule, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  protected registerForm!: FormGroup<UserRegistration>;
  protected submitted = false;

  constructor(
    private readonly formBuilder: NonNullableFormBuilder,
    private readonly customValidator: CustomvalidationService,
    private readonly userNameValidationService: UserNameValidationService
  ) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group(
      {
        fullname: new FormControl("", Validators.required),
        email: new FormControl("", [Validators.required, Validators.email]),
        username: new FormControl("", {
          asyncValidators: [
            this.userNameValidationService.validate.bind(
              this.userNameValidationService
            ),
          ],
          validators: [Validators.required],
        }),
        password: new FormControl("", [
          Validators.required,
          this.customValidator.patternValidator(),
        ]),
        confirmPassword: new FormControl("", [Validators.required]),
      },
      {
        validators: [
          this.customValidator.matchPassword("password", "confirmPassword"),
        ],
      }
    );
  }

  protected get registerFormControl() {
    return this.registerForm.controls;
  }

  protected onSubmit(): void {
    this.submitted = true;

    if (this.registerForm.valid) {
      alert(
        "Form Submitted succesfully!!!\n Check the values in browser console."
      );
      console.table(this.registerForm.value);
    }
  }

  protected resetForm(): void {
    this.registerForm.reset();
  }
}

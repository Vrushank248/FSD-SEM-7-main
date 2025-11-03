import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { passwordMatchValidator } from '../../utils/passwordValidators';
import { CommonModule } from '@angular/common';
import { CONSTANTS } from '../../utils/constant';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, CommonModule, RouterLink],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  banner = CONSTANTS.BANNER;
  user = CONSTANTS.USER;
  registerForm: FormGroup;
  conferences: any[] = [];
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) {
    this.registerForm = this.formBuilder.group(
      {
        full_name: ['', [Validators.required, Validators.minLength(3)]],
        email: ['', [Validators.required, Validators.email]],
        phone_no: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
        affilation: ['', [Validators.required, Validators.minLength(2)]],
        password: ['', [Validators.required, Validators.minLength(6)]],
        confirm_password: ['', [Validators.required, Validators.minLength(6)]],
        conference_id: ['', [Validators.required]], // Ensure this is included
      },
      { validators: passwordMatchValidator }
    );
  }
  ngOnInit(): void {
    this.authService.getAllConferences().subscribe({
      next: (response) => {
        this.conferences = response;
      },
      error: (error) => {
        console.error('Error fetching conferences:', error);
      },
    });
  }

  registerAudience() {
    if (this.registerForm.valid) {
      const formData = { ...this.registerForm.value };
      // Build payload as expected by backend (Audience object with nested conference)
      const payload: any = {
        full_name: formData.full_name,
        email: formData.email,
        password: formData.password,
        affilation: formData.affilation,
        phone_no: formData.phone_no,
        conference: {
          id: parseInt(formData.conference_id, 10),
        },
      };
      this.authService.register(payload).subscribe({
        next: (response) => {
          alert('Registered successfully');
          this.router.navigate(['/']);
        },
        error: (error) => {
          alert('Registration failed. Try again.');
        },
      });
    } else {
      alert('Some fields are invalid!');
    }
  }
}

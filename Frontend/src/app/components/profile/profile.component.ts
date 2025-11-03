import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {
  FormGroup,
  ReactiveFormsModule,
  FormBuilder,
  Validators,
  FormsModule,
} from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent {
  user: any = {};
  interests: any[] = [];
  conferences: any[] = [];
  profileForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.profileForm = this.formBuilder.group({
      full_name: ['', [Validators.minLength(3)]],
      phone_no: ['', [Validators.pattern(/^\d{10}$/)]],
      affilation: ['', [Validators.minLength(3)]],
      bio: [''],
      linkedinUrl: [''],
      twitterHandle: [''],
      website: [''],
      dateOfBirth: [''],
      address: [''],
      city: [''],
      country: [''],
      profilePictureUrl: [''],
      enrollmentId: [''],
      course: [''],
      conferenceId: [''],
      interests: [[]],
    });
  }

  ngOnInit(): void {
    const userLocal = JSON.parse(localStorage.getItem('user') || '{}');
    const userId = userLocal?.audience_id;
    if (!userId) {
      alert('Invalid user ID. Please log in again.');
      return;
    }
    this.authService.getAudienceById(userId).subscribe({
      next: (data) => {
        this.user = data;
        this.interests = data.interests || [];
        // Optionally fetch all conferences for dropdown
        this.authService.getAllConferences().subscribe({
          next: (confs) => {
            this.conferences = confs;
          },
          error: () => {
            this.conferences = [];
          },
        });
        // Patch form values from user and userProfile
        this.profileForm.patchValue({
          full_name: data.full_name || '',
          phone_no: data.phone_no || '',
          affilation: data.affilation || '',
          bio: data.userProfile?.bio || '',
          linkedinUrl: data.userProfile?.linkedinUrl || '',
          twitterHandle: data.userProfile?.twitterHandle || '',
          website: data.userProfile?.website || '',
          dateOfBirth: data.userProfile?.dateOfBirth || '',
          address: data.userProfile?.address || '',
          city: data.userProfile?.city || '',
          country: data.userProfile?.country || '',
          profilePictureUrl: data.userProfile?.profilePictureUrl || '',
          enrollmentId: data.enrollmentId || '',
          course: data.course || '',
          conferenceId: data.conference?.id || '',
          interests: (data.interests || []).map((i: any) => i.interestId),
        });
      },
      error: () => {
        alert('Failed to load profile.');
      },
    });
  }

  profileSubmit() {
    const userId = this.user?.audience_id;
    if (!userId) {
      alert('Invalid user ID. Please log in again.');
      return;
    }
    const form = this.profileForm.value;
    // Prepare payload for backend: basic fields + nested userProfile
    const updatedData: any = {
      full_name: form.full_name,
      phone_no: form.phone_no,
      affilation: form.affilation,
      enrollmentId: form.enrollmentId,
      course: form.course,
      conference: form.conferenceId ? { id: form.conferenceId } : undefined,
      interests: (form.interests || []).map((id: any) => ({ interestId: id })),
      userProfile: {
        bio: form.bio,
        linkedinUrl: form.linkedinUrl,
        twitterHandle: form.twitterHandle,
        website: form.website,
        dateOfBirth: form.dateOfBirth,
        address: form.address,
        city: form.city,
        country: form.country,
        profilePictureUrl: form.profilePictureUrl,
      },
    };
    this.authService.updateProfile(userId, updatedData).subscribe({
      next: (response) => {
        // Save updated user to localStorage for session continuity
        localStorage.setItem('user', JSON.stringify(response));
        alert('Profile updated successfully');
        this.router.navigate(['/dashboard']);
      },
      error: (error) => {
        alert('Failed to update profile. Try again.');
      },
    });
  }
}

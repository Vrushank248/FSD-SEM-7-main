import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent {
  user: any = {};
  conference: any = {};
  dayLeft = 0;
  conferences: any[] = [];
  researchPapers: any[] = [];
  reviewPapers: any[] = [];

  constructor(private authService: AuthService, private router: Router) {
    let user = JSON.parse(localStorage.getItem('user') || '{}');
    this.user = user;
    this.conference = {
      title: user?.conference?.title || '',
      date: user?.conference?.date
        ? new Date(user.conference.date).toLocaleDateString()
        : '',
      location: user?.conference?.location || '',
      time: user?.conference?.time
        ? new Date(`1970-01-01T${user.conference.time}Z`).toLocaleTimeString(
            [],
            { hour: '2-digit', minute: '2-digit' }
          )
        : '',
    };
    if (user?.conference?.date) {
      const currentDate = new Date();
      const conferenceDate = new Date(user?.conference?.date);
      const timeDiff = conferenceDate.getTime() - currentDate.getTime();
      this.dayLeft = Math.ceil(timeDiff / (1000 * 60 * 60 * 24));
    } else {
      this.dayLeft = 0;
    }
  }

  ngOnInit(): void {
    // Optionally fetch all conferences
    this.authService.getAllConferences().subscribe({
      next: (data) => {
        this.conferences = data;
      },
      error: () => {
        this.conferences = [];
      },
    });
    // Optionally fetch research papers
    this.authService.getAllResearchPapers().subscribe({
      next: (data) => {
        this.researchPapers = data;
      },
      error: () => {
        this.researchPapers = [];
      },
    });
    // Optionally fetch review papers
    this.authService.getAllReviewPapers().subscribe({
      next: (data) => {
        this.reviewPapers = data;
      },
      error: () => {
        this.reviewPapers = [];
      },
    });
  }

  viewConferences(): void {
    this.router.navigate(['dashboard/conferences']);
  }

  viewPapers(): void {
    this.router.navigate(['dashboard/papers']);
  }
}

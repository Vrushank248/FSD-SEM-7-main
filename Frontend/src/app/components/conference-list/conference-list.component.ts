import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { DatePipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-conference-list',
  standalone: true,
  imports: [CommonModule, DatePipe],
  templateUrl: './conference-list.component.html',
  styleUrls: ['./conference-list.component.css'],
})
export class ConferenceListComponent implements OnInit {
  conferences: any[] = [];
  selectedConference: any = null;
  loading = true;
  error = '';

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.authService.getAllConferences().subscribe({
      next: (data) => {
        this.conferences = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Failed to load conferences.';
        this.loading = false;
      },
    });
  }

  selectConference(conf: any) {
    this.selectedConference = conf;
  }
}

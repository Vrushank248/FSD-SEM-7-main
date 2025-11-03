import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-paper-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './paper-list.component.html',
  styleUrls: ['./paper-list.component.css'],
})
export class PaperListComponent implements OnInit {
  researchPapers: any[] = [];
  reviewPapers: any[] = [];
  selectedPaper: any = null;
  loading = true;
  error = '';
  paperType: 'research' | 'review' = 'research';

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.loadPapers();
  }

  loadPapers() {
    this.loading = true;
    if (this.paperType === 'research') {
      this.authService.getAllResearchPapers().subscribe({
        next: (data) => {
          this.researchPapers = data;
          this.loading = false;
        },
        error: () => {
          this.error = 'Failed to load research papers.';
          this.loading = false;
        },
      });
    } else {
      this.authService.getAllReviewPapers().subscribe({
        next: (data) => {
          this.reviewPapers = data;
          this.loading = false;
        },
        error: () => {
          this.error = 'Failed to load review papers.';
          this.loading = false;
        },
      });
    }
  }

  selectPaper(paper: any) {
    this.selectedPaper = paper;
  }

  setPaperType(type: 'research' | 'review') {
    this.paperType = type;
    this.selectedPaper = null;
    this.loadPapers();
  }
}

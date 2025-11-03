import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = '/Audience-3.4.4';
  private audienceUrl = `${this.baseUrl}/api/audience`;
  private conferenceUrl = `${this.baseUrl}/api/conferences`;
  private paperUrl = `${this.baseUrl}/api/papers`;
  // private audienceUrl = 'http://localhost:8080/api/audience';
  // private conferenceUrl = 'http://localhost:8080/api/conferences';
  // private paperUrl = 'http://localhost:8080/api/papers';

  constructor(private http: HttpClient, private router: Router) {}

  // Audience endpoints
  login(email: string, password: string): Observable<any> {
    // Backend expects login via POST with email and password as request params
    return this.http.post(
      `${this.audienceUrl}/login?email=${email}&password=${password}`,
      {}
    );
  }

  register(userData: any): Observable<any> {
    // Register expects Audience object as per backend
    return this.http.post(`${this.audienceUrl}/register`, userData);
  }

  updateProfile(userId: number, updatedData: any): Observable<any> {
    return this.http.put(
      `${this.audienceUrl}/update-profile/${userId}`,
      updatedData
    );
  }

  getAudienceById(id: number): Observable<any> {
    return this.http.get(`${this.audienceUrl}/${id}`);
  }

  deleteAudience(id: number): Observable<any> {
    return this.http.delete(`${this.audienceUrl}/${id}`);
  }

  getAllStudents(): Observable<any> {
    return this.http.get(`${this.audienceUrl}/students`);
  }

  getAllProfessors(): Observable<any> {
    return this.http.get(`${this.audienceUrl}/professors`);
  }

  // Conference endpoints
  getAllConferences(): Observable<any> {
    return this.http.get(`${this.conferenceUrl}`);
  }

  getOnlineConferences(): Observable<any> {
    return this.http.get(`${this.conferenceUrl}/online`);
  }

  getOfflineConferences(): Observable<any> {
    return this.http.get(`${this.conferenceUrl}/offline`);
  }

  getConferenceById(id: number): Observable<any> {
    return this.http.get(`${this.conferenceUrl}/${id}`);
  }

  // Paper endpoints
  getAllResearchPapers(): Observable<any> {
    return this.http.get(`${this.paperUrl}/research`);
  }

  getAllReviewPapers(): Observable<any> {
    return this.http.get(`${this.paperUrl}/review`);
  }

  // Auth helpers
  logout() {
    localStorage.removeItem('user');
    this.router.navigate(['/']);
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem('user');
  }
}

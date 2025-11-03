import { Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { MainLayoutComponent } from './layouts/main-layout/main-layout.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { ConferenceListComponent } from './components/conference-list/conference-list.component';
import { PaperListComponent } from './components/paper-list/paper-list.component';

export const routes: Routes = [
  {
    path: 'dashboard',
    component: MainLayoutComponent,
    children: [
      { path: '', component: DashboardComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'conferences', component: ConferenceListComponent },
      { path: 'papers', component: PaperListComponent },
    ],
  },
  {
    path: '',
    component: AuthLayoutComponent,
    children: [
      { path: '', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
    ],
  },
];

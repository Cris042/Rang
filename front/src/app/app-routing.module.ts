import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ConsultationComponent } from './components/consultation/consultation.component';
import { CreateConsultationComponent } from './components/create-consultation/create-consultation.component'; 
import { AuthGuard } from './services/auth.guard';

const routes: Routes = 
[
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'cadastro', component: SignupComponent },
  { 
    path: 'consulta', 
    component: ConsultationComponent, 
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'create-consulta',
    component: CreateConsultationComponent,
  },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

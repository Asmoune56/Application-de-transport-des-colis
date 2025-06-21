import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import {DashboardComponent} from "./admin/dashboard/dashboard.component";
import {TripsComponent} from "./trips/trips.component";
import {RequestHistoryComponent} from "./trips/request-history/request-history.component";
import {SendRequestComponent} from "./requests/send-request/send-request.component";



const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'trips', component: TripsComponent },
  { path: 'historique-demandes', component: RequestHistoryComponent },
  { path: 'send-request', component: SendRequestComponent },
  { path: 'request-history', component: RequestHistoryComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

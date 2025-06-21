import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { NgChartsModule } from 'ng2-charts';
import { TripsComponent } from './trips/trips.component';
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatDialogModule} from "@angular/material/dialog";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import { TripDialogComponent } from './trips/trip-dialog/trip-dialog.component';
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { TripSearchComponent } from './trips/trip-search/trip-search.component';
import { TripRequestDialogComponent } from './trips/trip-request-dialog/trip-request-dialog.component';
import { RequestHistoryComponent } from './trips/request-history/request-history.component';
import {RouterModule} from "@angular/router";
import { SendRequestComponent } from './requests/send-request/send-request.component';
import {MatSelectModule} from "@angular/material/select";




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    DashboardComponent,
    TripsComponent,
    TripDialogComponent,
    TripSearchComponent,
    TripRequestDialogComponent,
    RequestHistoryComponent,
    SendRequestComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    NgChartsModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    ReactiveFormsModule,
    ReactiveFormsModule,
    MatSnackBarModule,
    NgChartsModule,
    FormsModule,
    RouterModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

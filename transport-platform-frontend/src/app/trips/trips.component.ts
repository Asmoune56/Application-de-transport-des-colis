import { Component, OnInit } from '@angular/core';
import { TripsService, Trip } from '../services/trips.service';
import {MatDialog} from "@angular/material/dialog";
import {TripDialogComponent} from "./trip-dialog/trip-dialog.component";
import {MatSnackBar} from "@angular/material/snack-bar";
import { Router } from '@angular/router';

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.css']
})

export class TripsComponent implements OnInit {
  displayedColumns: string[] = [
    'departure',
    'destination',
    'stops',
    'cargoType',
    'maxDimensions',
    'availableCapacity',
    'driverId',
    'actions'
  ];

  trips: Trip[] = [];
  filteredTrips: Trip[] = [];
  filterDestination: string = '';  // فقط تعريف واحد

  loading = false;
  error = '';

  constructor(
    private tripsService: TripsService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router

  ) {}
  ngOnInit(): void {
    this.loadTrips();
  }

  loadTrips() {
    this.loading = true;
    this.error = '';
    this.tripsService.getTrips().subscribe({
      next: (data) => {
        this.trips = data;
        this.filteredTrips = data;  // عرض كل الرحلات قبل الفلترة
        this.loading = false;
      },
      error: (err) => {
        console.error('Erreur API:', err);
        this.error = 'Erreur lors du chargement des trajets.';
        this.loading = false;
      }
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(TripDialogComponent, {
      width: '500px',
      data: null
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.tripsService.addTrip(result).subscribe(() => this.loadTrips())
        this.snackBar.open('Trajet ajouté avec succès', 'Fermer', {
          duration: 3000
        });
      }
    });
  }

  openEditDialog(trip: Trip) {
    const dialogRef = this.dialog.open(TripDialogComponent, {
      width: '500px',
      data: trip
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.tripsService.updateTrip(result.id, result).subscribe(() =>
          this.loadTrips());
        this.snackBar.open('Trajet modifié avec succès ', 'Fermer', {
          duration: 3000,
          panelClass: ['snackbar-success']
        });
      }
    });
  }

  deleteTrip(id: number) {
    if (confirm('Confirmer la suppression de ce trajet ?')) {
      this.tripsService.deleteTrip(id).subscribe(() => {
        this.loadTrips();
        this.snackBar.open('Trajet supprimé', 'Fermer', {
          duration: 3000,
          panelClass: ['snackbar-error']
        });
      });
    }
  }

  openRequestDialog(trip: Trip) {
    // يمكنك فتح Dialog أو تنقل المستخدم إلى صفحة إرسال الطلب
    this.router.navigate(['/send-request'], { queryParams: { tripId: trip.id } });
  }

  goToRequestHistory() {
    this.router.navigate(['/request-history']);
  }

  onSearchChange() {
    this.applyFilter();
  }

  applyFilter() {
    if (!this.filterDestination || this.filterDestination.trim() === '') {
      this.filteredTrips = this.trips;
    } else {
      const filter = this.filterDestination.toLowerCase().trim();
      this.filteredTrips = this.trips.filter(trip =>
        trip.destination.toLowerCase().includes(filter)
      );
    }
  }


}

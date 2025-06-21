import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { TripsService } from '../../services/trips.service';
import { Trip } from '../../services/trips.service';

@Component({
  selector: 'app-trip-search',
  templateUrl: './trip-search.component.html',
  styleUrls: ['./trip-search.component.css']
})
export class TripSearchComponent {
  searchForm: FormGroup;
  trips: Trip[] = [];
  loading = false;
  error = '';

  constructor(private fb: FormBuilder, private tripsService: TripsService) {
    this.searchForm = this.fb.group({
      destination: [''],
      cargoType: [''],
      driverId: ['']
    });
  }

  search() {
    const { destination, cargoType, driverId } = this.searchForm.value;
    this.loading = true;
    this.error = '';

    this.tripsService.searchTrips(destination).subscribe({
      next: (data) => {
        this.trips = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erreur lors de la recherche.';
        this.loading = false;
      }
    });
  }

  clear() {
    this.searchForm.reset();
    this.trips = [];
  }
}

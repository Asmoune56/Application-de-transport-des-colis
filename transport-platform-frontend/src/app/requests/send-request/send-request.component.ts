import { Component, OnInit } from '@angular/core';
import { RequestService, RequestDTO } from '../../services/request.service';
import { TripsService, Trip } from '../../services/trips.service';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-send-request',
  templateUrl: './send-request.component.html',
  styleUrls: ['./send-request.component.css']
})
export class SendRequestComponent implements OnInit {
  request: RequestDTO = {
    userId: 0,
    tripId: 0,
    parcel: {
      description: '',
      weight: 0,
      height: 0,
      width: 0,
      length: 0,
    }
  };


  trips: Trip[] = [];
  successMessage = '';
  errorMessage = '';

  constructor(
    private requestService: RequestService,
    private tripsService: TripsService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // 1. Récupérer les trips
    this.tripsService.getTrips().subscribe({
      next: (data: Trip[]) => (this.trips = data),
      error: (err) => console.error('Erreur de chargement des trajets', err)
    });

    // 2. Lire tripId depuis l'URL
    const tripIdFromUrl = this.route.snapshot.queryParamMap.get('tripId');
    if (tripIdFromUrl) {
      this.request.tripId = +tripIdFromUrl;
    }
  }

  onSubmit() {
    this.requestService.sendRequest(this.request).subscribe({
      next: () => {
        this.successMessage = 'Demande envoyée avec succès !';
        this.errorMessage = '';
      },
      error: (error) => {
        console.error('Erreur lors de l’envoi de la demande', error);
        this.errorMessage = 'Erreur lors de l’envoi de la demande';
        this.successMessage = '';
      }
    });
  }

}

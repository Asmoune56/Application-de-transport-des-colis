import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Trip {  // <--- تأكد من وجود هذا السطر مع export
  id: number;
  departure: string;
  destination: string;
  stops: string;
  cargoType: string;
  maxDimensions: number;
  availableCapacity: number;
  driverId: number;
}

@Injectable({
  providedIn: 'root'
})
export class TripsService {
  private apiUrl = 'http://localhost:8080/api/trips';

  constructor(private http: HttpClient) {}

  getTrips(): Observable<Trip[]> {
    return this.http.get<Trip[]>(this.apiUrl);
  }

  addTrip(trip: Trip): Observable<Trip> {
    return this.http.post<Trip>(this.apiUrl, trip);
  }

  updateTrip(id: number, trip: Trip): Observable<Trip> {
    return this.http.put<Trip>(`${this.apiUrl}/${id}`, trip);
  }

  deleteTrip(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  searchTrips(destination: string): Observable<Trip[]> {
    const params = destination ? `?destination=${destination}` : '';
    return this.http.get<Trip[]>(`${this.apiUrl}${params}`);
  }

}

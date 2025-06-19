import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface DashboardStatsDTO {
  usersCount: number;
  tripsCount: number;
  parcelsCount: number;
  requestsCount: number;
}

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private apiUrl = 'http://localhost:8080/api/dashboard/stats';

  constructor(private http: HttpClient) {}

  getStats(): Observable<DashboardStatsDTO> {
    return this.http.get<DashboardStatsDTO>(this.apiUrl);
  }
}

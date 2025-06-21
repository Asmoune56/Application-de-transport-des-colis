import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Parcel {
  description: string;
  weight: number;
  height: number;
  width: number;
  length: number;
}

export interface RequestDTO {
  id?: number;
  tripId: number;
  userId: number;
  parcel: Parcel;
  status?: string;
}



@Injectable({
  providedIn: 'root'
})
export class RequestService {
  private api = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getRequestsByUser(userId: number): Observable<RequestDTO[]> {
    return this.http.get<RequestDTO[]>(`${this.api}/requests/user/${userId}`);
  }


  //
  sendRequest(request: RequestDTO) {
    return this.http.post<RequestDTO>(`${this.api}/requests`, request);
  }


}

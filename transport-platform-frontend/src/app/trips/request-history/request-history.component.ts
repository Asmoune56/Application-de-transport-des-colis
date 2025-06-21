import { Component, OnInit } from '@angular/core';
import { RequestService, RequestDTO } from '../../services/request.service';

@Component({
  selector: 'app-request-history',
  templateUrl: './request-history.component.html',
  styleUrls: ['./request-history.component.css']
})
export class RequestHistoryComponent implements OnInit {
  requests: RequestDTO[] = [];
  loading = true;
  error = '';
  userId = 1; // Remplacer par ID utilisateur connecté dynamiquement

  displayedColumns: string[] = ['volume', 'weight', 'description', 'status', 'tripId'];

  constructor(private requestService: RequestService) {}

  ngOnInit(): void {
    this.requestService.getRequestsByUser(this.userId).subscribe({
      next: (data) => {
        this.requests = data;
        this.loading = false;
      },
      error: () => {
        this.error = 'Erreur lors du chargement des demandes.';
        this.loading = false;
      }
    });
  }
}

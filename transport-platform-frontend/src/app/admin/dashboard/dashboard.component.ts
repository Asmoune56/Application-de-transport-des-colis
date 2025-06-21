import { Component, OnInit } from '@angular/core';
import { DashboardService, DashboardStatsDTO } from '../../services/dashboard.service';
import { ChartConfiguration, ChartOptions } from 'chart.js';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  stats: DashboardStatsDTO = {
    usersCount: 0,
    tripsCount: 0,
    parcelsCount: 0,
    requestsCount: 0
  };

  loading = true;
  error = '';

  // Chart config
  chartData: ChartConfiguration<'bar'>['data'] = {
    labels: ['Users', 'Trips', 'Parcels', 'Requests'],
    datasets: [
      { data: [0, 0, 0, 0], label: 'Platform Stats' }
    ]
  };
  chartOptions: ChartOptions<'bar'> = {
    responsive: true,
  };

  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    this.dashboardService.getStats().subscribe({
      next: (data) => {
        this.stats = data;
        this.updateChartData(data);
        this.loading = false;
      },
      error: () => {
        this.error = 'Error loading dashboard stats';
        this.loading = false;
      }
    });
  }

  updateChartData(data: DashboardStatsDTO) {
    this.chartData = {
      labels: ['Users', 'Trips', 'Parcels', 'Requests'],
      datasets: [
        {
          label: 'Platform Stats',
          data: [
            data.usersCount,
            data.tripsCount,
            data.parcelsCount,
            data.requestsCount
          ],
          backgroundColor: [
            'rgba(54, 162, 235, 0.7)',   // Blue
            'rgba(255, 206, 86, 0.7)',   // Yellow
            'rgba(75, 192, 192, 0.7)',   // Green
            'rgba(255, 99, 132, 0.7)'    // Red
          ],
          borderColor: [
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(255, 99, 132, 1)'
          ],
          borderWidth: 1,
          hoverBackgroundColor: [
            'rgba(54, 162, 235, 0.9)',
            'rgba(255, 206, 86, 0.9)',
            'rgba(75, 192, 192, 0.9)',
            'rgba(255, 99, 132, 0.9)'
          ],
          hoverBorderColor: '#000'
        }
      ]
    };



  }
}

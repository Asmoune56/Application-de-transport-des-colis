import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent {
  user = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    verified: true,
    roleIds: [1] // Assigner automatiquement le rôle "USER"
  };

  message = '';

  constructor(private http: HttpClient) {}

  onSubmit() {
    this.http.post('http://localhost:8080/api/users', this.user).subscribe({
      next: () => {
        this.message = "Inscription réussie !";
      },
      error: err => {
        this.message = "Erreur lors de l'inscription.";
        console.error(err);
      }
    });
  }
}

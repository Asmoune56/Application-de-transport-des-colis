import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Trip } from '../../services/trips.service';

@Component({
  selector: 'app-trip-request-dialog',
  templateUrl: './trip-request-dialog.component.html'
})
export class TripRequestDialogComponent {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<TripRequestDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public trip: Trip
  ) {
    this.form = this.fb.group({
      dimensions: ['', Validators.required],
      weight: ['', Validators.required],
      type: ['', Validators.required],
    });
  }

  submit() {
    if (this.form.valid) {
      const request = {
        ...this.form.value,
        tripId: this.trip.id,
        senderId: 1 // Remplacer par l'utilisateur connecté
      };
      // envoyer via RequestService (à créer)
      console.log('Request sent:', request);
      this.dialogRef.close();
    }
  }

  close() {
    this.dialogRef.close();
  }
}

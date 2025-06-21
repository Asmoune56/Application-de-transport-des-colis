import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Trip } from '../../services/trips.service';

@Component({
  selector: 'app-trip-dialog',
  templateUrl: './trip-dialog.component.html',
  styleUrls: ['./trip-dialog.component.css']
})
export class TripDialogComponent {
  form: FormGroup;
  isEditMode: boolean;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<TripDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Trip | null
  ) {
    this.isEditMode = !!data;

    this.form = this.fb.group({
      departure: [data?.departure || '', Validators.required],
      destination: [data?.destination || '', Validators.required],
      stops: [data?.stops || ''],
      cargoType: [data?.cargoType || '', Validators.required],
      maxDimensions: [data?.maxDimensions || 0, Validators.required],
      availableCapacity: [data?.availableCapacity || 0, Validators.required],
      driverId: [data?.driverId || '', Validators.required],
    });
  }

  save() {
    if (this.form.valid) {
      const trip: Trip = { ...this.data, ...this.form.value };
      this.dialogRef.close(trip);
    }
  }

  close() {
    this.dialogRef.close();
  }
}

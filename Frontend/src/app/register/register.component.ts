import { Component, OnInit } from '@angular/core';
import { RegisterUserService } from '../services/register-user.service';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(
    // Injecting the RegisterUserService for user registration
    private _registerService:RegisterUserService,
    // Reference to the dialog for the current component
    private _dialogRef:MatDialogRef<RegisterComponent>,
    // Injecting the MatDialog service for opening dialogs
    private _dialog:MatDialog
  ){}
   // Variable to store success message for user 
  successMsg='';
  // Variable to store error message for user registration
  errorMsg=''
  registrationForm = new FormGroup({
    'email': new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
    'first_name': new FormControl('',[Validators.required, Validators.pattern('[a-zA-Z ]*')]),
    'last_name':new FormControl('', Validators.pattern('[a-zA-Z ]*')),
    'password':new FormControl('', Validators.required)
  });

  register(){
    //console.log(this.registrationForm.value);
    if(this.registrationForm.valid){
    this._registerService.register(this.registrationForm.value).subscribe((res) => {
      // Successful response from the register service
      this.successMsg = "User registered..";
      this.errorMsg = '';
    },
      (err) => {
        // Error response from the register service
        this.errorMsg = "Cannot register user, try again!";
        this.successMsg = '';
    });
  }
  }
  openLoginForm(){
    // Close the current registration dialog
    this._dialogRef.close();
    // Open the login dialog
    this._dialog.open(LoginComponent);
 
  }

}


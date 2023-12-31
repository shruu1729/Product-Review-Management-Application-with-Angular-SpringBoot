import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { LoginServiceService } from '../services/login-service.service';
import { UserServiceService } from '../services/user-service.service';

import { DialogRef } from '@angular/cdk/dialog';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private _loginService:LoginServiceService,
    private _userService:UserServiceService,
    private _router:Router,
    private _dialogRef:DialogRef<LoginComponent>,
    private _dialog:MatDialog
  ){}
  ngOnInit(): void {
  }
  err:any;
   // Define the login form with form controls and validators
  loginForm = new FormGroup({
    'username': new FormControl('', Validators.required),
    'userPassword':new FormControl('', Validators.required)
  });

   // Method to handle login functionality
  login(){
    this._loginService.login(this.loginForm.value).subscribe((res)=>{
        // Set current user information in user service
      this._userService.setCurrentUser(res.user.first_name);
      this._userService.setRoles(res.user.roles[0]["name"]);
      this._userService.setToken(res.jwtToken);
      const role = res.user.roles[0]["name"];

       // Redirect user based on their role
      if(role === 'USER' && this._userService.getCurrentUser != null){
        this._userService.setCurrentRole("USER");
        this._dialogRef.close();
        this._router.navigate(['userDashboard']);
      }
      else{
        //set current role and navigate to admin dashboard
        this._userService.setCurrentRole("ADMIN");
        this._dialogRef.close();
        this._router.navigate(['adminDashboard']);
      }
    },
    (err)=>{
      this.err = "Invalid credentials, Try again!!";
    });

    this.err = '';

  }
// Method to open login form
  openLoginForm(){
    this._dialogRef.close();
    this._dialog.open(LoginComponent);
    
  }
// Method to open registration form
  openRegistrationForm(){
    this._dialogRef.close();
    this._dialog.open(RegisterComponent);
    
  }

}

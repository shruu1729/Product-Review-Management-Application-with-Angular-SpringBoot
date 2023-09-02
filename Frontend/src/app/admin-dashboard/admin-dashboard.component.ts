import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
//AdminDashboardComponent class is an Angular component that represents the admin dashboard. It implements the OnInit interface, 
//which allows initialization tasks to be performed when the component is created.
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  // Inject the UserServiceService and Router dependencies
  constructor(
    private _userService:UserServiceService,
    private _router:Router
  ){}
  // Define a variable to store the products
  products:any;
  ngOnInit(): void {
      // Call the getAllProducts() method from UserServiceService
    // to retrieve the products
    this._userService.getAllProducts().subscribe((res)=>{
      this.products = res;
      console.log(this.products);
    })
  }
 // Get the current user from the UserServiceService
  currentUser = this._userService.getCurrentUser();
  // Handle the logout action
  logout(){
     // Clear user storage
    this._userService.clearStorage();
     // Navigate to the 'home' route
    this._router.navigate(['home']);
  }

}

import { Component, OnInit } from '@angular/core';
import { UserServiceService } from './services/user-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(
    private _userService:UserServiceService
  ){}

  usersCount:any; // Variable to store the count of users
  productCount:any;// Variable to store the count of products
  reviewsCount:any;// Variable to store the count of reviews
  ngOnInit(): void {
// Retrieve the count of users
    this._userService.countUsers().subscribe((res)=>{
       // Set the count of users
      this.usersCount = res;
      console.log(this.usersCount);
    });
   // Retrieve the count of products
    this._userService.countProducts().subscribe((res)=>{
      // Set the count of products
      this.productCount = res;
      console.log(this.productCount);
    });
 // Retrieve the count of reviews
    this._userService.countReviews().subscribe((res)=>{
      // Set the count of reviews
      this.reviewsCount = res;
      console.log(this.reviewsCount);
    })
  }
  title = 'Product Community Application';
}

import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AddReviewComponent } from '../add-review/add-review.component';
import { UserServiceService } from '../services/user-service.service';
import { ViewReviewComponent } from '../view-review/view-review.component';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor(
    private _userService:UserServiceService,
    private _router:Router,
    private _dialog:MatDialog
  ){}
  ngOnInit(): void {
     // Check if a user is logged in otherwise redirected to forbidden page
    if(this._userService.getCurrentUser()===null){
      // If no user is logged in, navigate to the forbidden page
      this._router.navigate(['forbidden']);
    }
    //output user's token on console
    console.log(this._userService.getToken());
  }
  // Variables
  searchQuery:any;// variable to store search query entered by the user
  message:any;//variable to store message
  productData:any;// variable to store the retrieve product data
  currentUser = this._userService.getCurrentUser();// variable to store current user's info

  logout(){
     // Clear user storage and navigate to the home page
    this._userService.clearStorage();
    this._router.navigate(['home']);
  }

  searchProduct(){
    // Perform a search for a product using the provided search query
    this._userService.searchProduct(this.searchQuery).subscribe((res)=>{
      console.log(res);
      
      if(res.length == 0){
          // If no data is found, display a message
        this.message = "No data found..."
        this.productData ='';
      }
      else{
          // If data is found, display the product data
        this.productData = res;
        this.message= '';
      }
    });
  }

  addReview(data:any){
    // Open the add review dialog and pass the data
    this._dialog.open(AddReviewComponent,{
      data
    });

  }
  calculateAvgRating(reviews:any[]):number{
    if(reviews && reviews.length > 0){
      const totalRatings = reviews.length;
      const sum = reviews.reduce((total, review) => total + review.rating, 0);
      return sum/totalRatings;
    }
    else{
      return 0;
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminServiceService } from '../services/admin-service.service';
import { UserServiceService } from '../services/user-service.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-approve-reviews',
  templateUrl: './approve-reviews.component.html',
  styleUrls: ['./approve-reviews.component.css']
})
export class ApproveReviewsComponent implements OnInit {

  constructor(
    private _userService:UserServiceService,
    private _router:ActivatedRoute,
    private _adminService:AdminServiceService,
    private _location: Location
  ){  }

  msg:any;
  res:any;
  currentUser:any
  ngOnInit(): void {
     // Retrieve the product by its ID from the route parameter
    this._userService.getProductById(this._router.snapshot.params['productId']).subscribe((data)=>{
      // Check if there are any reviews for the product
      if(data.review.length==0){
        this.msg="no reviews yet..";
        this.res = '';
      }
      this.res = data;
      this.msg='';
  });
 // Get the current user
  this.currentUser = this._userService.getCurrentUser();
  }

  approveRequest(reviewId:any){
     // Approve the review by updating its state
    this._adminService.updateState(reviewId, true).subscribe((res)=>{
      // Reload the page to reflect the updated state
      window.location.reload();
    });
  }

  rejectRequest(reviewId:any){
        // Reject the review by updating its state
    this._adminService.updateState(reviewId, false).subscribe((res)=>{
       // Reload the page to reflect the updated state
      window.location.reload();
    });
  }

  back(){
    // Navigate back to the previous page using the Angular 'Location' service
    this._location.back();
  }


}

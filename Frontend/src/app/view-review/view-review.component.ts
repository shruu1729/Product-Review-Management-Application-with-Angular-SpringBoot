import { DialogRef } from '@angular/cdk/dialog';
import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-view-review',
  templateUrl: './view-review.component.html',
  styleUrls: ['./view-review.component.css']
})
export class ViewReviewComponent implements OnInit {
  constructor(
    private _userService:UserServiceService,
    private _router:ActivatedRoute,
    private _location:Location
  ){}
// Variable to store the response data
  res: any;
   // Variable to store the current user
  currentUser:any;
   // Variable to store additional message
  msg:any;
  ngOnInit(): void {
    console.log(this._router.snapshot.params['productId']);// Log the 'productId' parameter value from the current route
    // Retrieve the product data by its ID
    this._userService.getProductById(this._router.snapshot.params['productId']).subscribe((data)=>{
      if(data.review.length==0){
        // Set the message when there are no reviews
        this.msg="no reviews yet..";
        this.res = '';
      }
      this.res = data;
      this.msg='';
  });
// Retrieve the current user
  this.currentUser = this._userService.getCurrentUser();
    
  }

  back(){
    this._location.back();// Navigate back to the previous location
  }


  
}

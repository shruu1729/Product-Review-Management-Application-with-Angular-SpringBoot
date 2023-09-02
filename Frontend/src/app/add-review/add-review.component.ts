import { DialogRef } from '@angular/cdk/dialog';
import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { UserServiceService } from '../services/user-service.service';
//AddReviewComponent class, which represents a dialog for adding a review. 
//It implements the OnInit interface, allowing initialization tasks to be performed when the component is created.
@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.css']
})
export class AddReviewComponent implements OnInit {

  constructor(
    private _fb:FormBuilder,
    private _userService:UserServiceService,
    @Inject(MAT_DIALOG_DATA) private _data:any,
    private _dialogRef:DialogRef
  ){}
  reviewForm = new FormGroup({
    'review': new FormControl('', [Validators.required, Validators.maxLength(400), Validators.minLength(20)]),
    'rating':new FormControl('', [Validators.required, Validators.max(5)])
  });
  review:any;
  productName:any;
  productId:any;
  msg:any;
  succMsg:any;
  ngOnInit(): void {
     // Patch the form values with the data received from the dialog
   
    this.productId = this._data.productId;
    this.productName = this._data.productName;

  }

  addReview(){
    // Check the length of the review and validate its length
    //console.log(this.review);
    if(this.reviewForm.valid){
       // Call the addReview() method from the UserServiceService to add the review
    this._userService.addReview(this.reviewForm.value, this.productId).subscribe((res)=>{
      // this._dialogRef.close();
       // Set success message and clear the error message
      this.succMsg = "Review added successfully";
      this.msg = '';
      
    });
  }
  else{
     // Set error message if the review length is not within the specified range
    this.succMsg = '';
    this.msg = "Review should be more than 20 characters and less than 400 characters";

  }
  }

  close(){
      // Close the dialog
    this._dialogRef.close();
  }

}

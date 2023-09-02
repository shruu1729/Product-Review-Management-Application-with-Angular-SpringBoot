import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserServiceService } from './user-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  constructor(
    private _httpClient:HttpClient,
    private _userService: UserServiceService
  ) { }
 // API URL for admin operations
  ADMIN_URL = "http://localhost:9090/api/admin";
// Method to update the state of a review
  // Parameters:
  //   - reviewId: The ID of the review to update
  //   - state: The new state value for the review
  // Returns an Observable containing the response data
  updateState(reviewId:any, state:any):Observable<any>{
    // Get the token from the user service
    let t= this._userService.getToken();
    // Create HttpHeaders with the authorization token
    var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    // HTTP options including the headers
    const httpOption = {
      headers: headerObject
    };
 // Send a POST request to update the state of the review
    return this._httpClient.post(`${this.ADMIN_URL}/update/${reviewId}`, state, httpOption );

  }
}

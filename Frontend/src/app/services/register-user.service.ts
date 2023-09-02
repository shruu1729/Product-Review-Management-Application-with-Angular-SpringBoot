import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterUserService {
  constructor(
    private _httpClient:HttpClient
  ) { }
 // API URL for user registration
  API_URL = "http://localhost:9090/api";
  // Method to register a new user
  // Parameters:
  //   - userData: Object containing user registration data
  // Returns an Observable containing the response data
  register(userData:any):Observable<any>{
     // Send a POST request to the user registration API endpoint
    return this._httpClient.post(this.API_URL + '/user', userData);
  }
}

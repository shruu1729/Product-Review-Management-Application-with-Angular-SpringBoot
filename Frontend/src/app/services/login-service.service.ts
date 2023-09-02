import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
 // API URL for authentication
  API_URL = "http://localhost:9090/api";
   // Request header specifying no authentication
  requestHeader = new HttpHeaders({
    'No-Auth':'True'
  });
  
  constructor(
    private _httpClient:HttpClient
  ) { }
// Method to perform user login
  // Parameters:
  //   - loginData: Object containing login credentials
  // Returns an Observable containing the response data
  login(loginData:any):Observable<any>{
     // Send a POST request to the authentication API endpoint
    return this._httpClient.post(this.API_URL + '/authenticate', loginData);
  }
}

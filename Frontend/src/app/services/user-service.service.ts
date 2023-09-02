import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  BASE_URL = "http://localhost:9090/api";
  constructor(private _httpClient:HttpClient) { }
 // Set roles in local storage
  public setRoles(roles:[]){
    localStorage.setItem('roles', JSON.stringify(roles));
  }
 // Get roles from local storage
  public getRoles():[]{
    return JSON.parse(localStorage.getItem('roles')!);
  }
 // Set JWT token in local storage
  public setToken(jwtToken:string){
    localStorage.setItem("jwtToken", jwtToken);
  }
  // Get JWT token from local storage
  public getToken():string{
    return localStorage.getItem('jwtToken')!;
  }
 // Set current role in local storage
  public setCurrentRole(role:string){
    localStorage.setItem('currentRole', role);
  }
  // Get current role from local storage
  public getCurrentRole():string{
    return localStorage.getItem('currentRole')!;
  }

 // Clear local storage
  public clearStorage(){
    localStorage.clear();
  }
   // Set current user in local storage
  public setCurrentUser(username:string){
    localStorage.setItem('currentUser', username);
  }
  // Get current user from local storage
  public getCurrentUser():string{
    return localStorage.getItem('currentUser')!;
  }
// Search for a product using a keyword
  searchProduct(keyword:any):Observable<any>{
    // let t= this.getToken();
    // var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    // const httpOptions = {
    //   headers: headerObject
    // };
    return this._httpClient.get(`${this.BASE_URL}/products/${keyword}`);
  }
 // Get product by ID
  getProductById(productId:any):Observable<any>{
    let t= this.getToken();
    var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    const httpOption = {
      headers: headerObject
    };
    return this._httpClient.post(`${this.BASE_URL}/products/${productId}`, productId, httpOption);
  }
 // Add a review for a product
  addReview(review:any, productId:any):Observable<any>{
    let t= this.getToken();
    var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    const httpOption = {
      headers: headerObject
    };
  
    return this._httpClient.post(`${this.BASE_URL}/add-review/${productId}`, review, httpOption);
  }
  // Get all products
  getAllProducts():Observable<any>{
    let t= this.getToken();
    var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    const httpOption = {
      headers: headerObject
    };
    return this._httpClient.get(`${this.BASE_URL}/products`, httpOption);

  }
  // Count the number of users
  public countUsers():Observable<any>{
    return this._httpClient.get(`${this.BASE_URL}/user/count`);
  }
 // Count the number of products
  public countProducts():Observable<any>{
    return this._httpClient.get(`${this.BASE_URL}/products/count`);
  }
  // Count the number of reviews
  public countReviews():Observable<any>{
    return this._httpClient.get(`${this.BASE_URL}/productReviews/count`);
  }

  
}

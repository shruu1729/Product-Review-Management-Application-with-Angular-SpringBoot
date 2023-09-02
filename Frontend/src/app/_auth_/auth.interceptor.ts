import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { catchError, Observable, throwError } from "rxjs";
import { UserServiceService } from "../services/user-service.service";
//the AuthInterceptor class implements the HttpInterceptor interface, 
//which allows it to intercept outgoing HTTP requests and modify them before they are sent.
@Injectable({
    providedIn: 'root'
  })
  
export class AuthInterceptor implements HttpInterceptor{
    constructor(
        private _userService:UserServiceService
    ){}
  // The intercept method is implemented from the HttpInterceptor interface
    // It intercepts outgoing HTTP requests and adds authorization headers
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const token = this._userService.getToken();
        const auth = 'Bearer '+token;
        let tokenizedReq = req;
          // Check if a token is available
        if(token!=null){
             // Clone the request and add the authorization header
            tokenizedReq = req.clone({
                headers: req.headers.set('Authorization',auth)
            })
        }
            // Continue the request with the modified tokenized request
        return next.handle(tokenizedReq);
    }
}

// Export the authInterceptorProviders array
// It provides the AuthInterceptor to the Angular HTTP_INTERCEPTORS multi-provider
export const authInterceptorProviders = [
    {
        provide:HTTP_INTERCEPTORS,
        useClass:AuthInterceptor,
        multi:true
    }
];
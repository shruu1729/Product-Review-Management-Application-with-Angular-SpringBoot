import { ActivatedRouteSnapshot, CanActivate, CanActivateChildFn, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import {Injectable} from '@angular/core'
import { Observable } from 'rxjs';
//AuthGuard class implements the CanActivate interface, which allows it to control access to routes in Angular. 
//The canActivate method is the main method of the interface and is responsible for determining whether a user can activate (access) a particular route.
@Injectable({
    providedIn: 'root'
})

export class AuthGuard implements CanActivate{
    constructor(
        private _userService:UserServiceService,
        private _router:Router
    ){}
    // The canActivate method is implemented from the CanActivate interface
    // It is responsible for determining whether a user can access a particular route or not
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
         // Check if the user has a valid token and is an ADMIN
        if(this._userService.getToken() && this._userService.getCurrentRole() === "ADMIN"){
            return true;
        }
        // if(this._userService.getToken() && this._userService.getCurrentRole() === "USER"){
        //     return true;
        // }
        else{
             // User does not have a valid token or is not an ADMIN
            // Redirect them to the 'forbidden' route
            this._router.navigate(['forbidden']);
             // Clear any stored user data
            this._userService.clearStorage();
            // Deny access to the route
            return false;
        }
    }    
}

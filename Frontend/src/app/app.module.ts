import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddReviewComponent } from './add-review/add-review.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ViewReviewComponent } from './view-review/view-review.component';
import { ApproveReviewsComponent } from './approve-reviews/approve-reviews.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import { MatDialogModule } from '@angular/material/dialog';
import {MatButtonModule } from '@angular/material/button';
import {MatFormFieldModule } from '@angular/material/form-field';
import {MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {ReactiveFormsModule} from '@angular/forms';
import {FormsModule} from '@angular/forms';
import { authInterceptorProviders } from './_auth_/auth.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    AddReviewComponent,
    AdminDashboardComponent,
    ForbiddenComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    UserDashboardComponent,
    ViewReviewComponent,
    ViewReviewComponent,
    ApproveReviewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    HttpClientModule,
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatTableModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }

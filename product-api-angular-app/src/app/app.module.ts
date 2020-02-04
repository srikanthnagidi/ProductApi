import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { ProductComponent } from './product/product.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ProductService } from './product.service';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { BasicAuthHttpInterceptorServiceService } from './basic-auth-http-interceptor-service.service';
import { HeaderComponent } from './header/header.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { MatConfirmDialogComponent } from './mat-confirm-dialog/mat-confirm-dialog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule, MatIconModule} from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ProductComponent,
    LoginComponent,
    HeaderComponent,
    SignUpComponent,
    CreateProductComponent,
    UpdateProductComponent,
    MatConfirmDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatIconModule
  ],
  providers: [
      ProductService,
      {
        provide:HTTP_INTERCEPTORS,
        useClass:BasicAuthHttpInterceptorServiceService,
        multi:true
    }
  ],
  bootstrap: [AppComponent],
  entryComponents:[MatConfirmDialogComponent, ProductComponent]
})
export class AppModule { }

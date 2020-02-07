
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthHttpInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(req:HttpRequest<any>, next:HttpHandler){
      if (sessionStorage.getItem('username') && sessionStorage.getItem('token')){
          //console.log(sessionStorage.getItem('token'));
        req = req.clone({
            setHeaders : {
                'Content-Type' : 'application/json; charset=utf-8',
                'Accept'       : 'application/json',
                'Authorization': `Bearer ` + sessionStorage.getItem('token')
            }
        })
      }
      return next.handle(req);
  }  
}

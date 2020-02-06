
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User } from "../user/user";
import { shareReplay, map, tap } from "rxjs/operators";
import { HttpHeaders } from '@angular/common/http';
import { SignUp } from '../sign-up/sign-up-model';



@Injectable({
  providedIn: "root"
})
export class AuthService {
  constructor(private http: HttpClient) {}

  authenticate(username:string, password:string) {
      let httpHeaders = new HttpHeaders().set('Content-Type', 'application/json'); 
      return this.http.post("http://localhost:8080/login", {"username": username, "password":password}, {
        headers: httpHeaders,
        observe: 'response',
        responseType: 'text'
      });
  }
  signUp(signUp:SignUp){
    let httpHeaders = new HttpHeaders().set('Content-Type', 'application/json'); 
    //console.log(signUp);
    return this.http.post("http://localhost:8080/users/sign-up", signUp, {
      headers: httpHeaders,
      observe: 'response',
      responseType: 'text'
    });
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("username");
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("token");
  }
}

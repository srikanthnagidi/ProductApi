import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	username = ''
    password = ''
	invalidLogin = false
	
	constructor(private router: Router,
    private loginservice: AuthService) { }

  ngOnInit() {
	}
	
	login(){
		this.loginservice.authenticate(this.username, this.password).pipe(first()).subscribe(response=> { 
        //console.log("before response");
        //console.log(response.body);
        sessionStorage.setItem("token", response.body);
        sessionStorage.setItem("username", this.username);
        this.router.navigate(['/getProducts']);
        this.invalidLogin = false;
	}, error =>{
        this.invalidLogin = true;
    });
	}
}

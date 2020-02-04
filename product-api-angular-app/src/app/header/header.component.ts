import { Component, OnInit } from '@angular/core';
import { AuthService } from '../login/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

	isLoggedIn = false;

  collapsed = true;

  constructor(public authService:AuthService) { }

  ngOnInit() {
		if (sessionStorage.getItem("token")){
			this.isLoggedIn = true;
			//console.log("in init " + this.isLoggedIn);
		}else{
			this.isLoggedIn = false;
		}
	}
	logout(){
		this.authService.logOut();
	}
	
}

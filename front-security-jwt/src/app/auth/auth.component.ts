import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SigninRequest } from '../classes/signin-request/signin-request';
import { SigninRequestService } from '../services/signin-request/signin-request.service';
import { Router } from '@angular/router';
import { SigninResponse } from '../classes/signin-response/signin-response';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit{

  signinRequest: SigninRequest;
  signinResponse: SigninResponse;

  constructor(
    private signinRequestService: SigninRequestService,
    private router: Router
    ) {
    this.signinRequest = new SigninRequest("","");
    this.signinResponse = new SigninResponse("","");
  }

  ngOnInit(): void {
      
  }

  signin(signinRequest: SigninRequest) {
    this.signinRequestService.signin(signinRequest).subscribe(
      {
        next: resp => {
          this.signinResponse = resp;
          if(this.signinResponse.token == "" && this.signinResponse.refreshToken == "") {
            alert("Erreur");
          } else {
            console.log(this.signinResponse.token);
            this.router.navigate(['/home'])
          }
        }
      }
    )
  }

  onSubmit() {
    this.signin(this.signinRequest);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SigninRequest } from '../../classes/signin-request/signin-request';
import { Observable } from 'rxjs';
import { SigninResponse } from 'src/app/classes/signin-response/signin-response';

@Injectable({
  providedIn: 'root'
})
export class SigninRequestService {

  private baseUrl: string;

  constructor(private httpClient: HttpClient) {
    this.baseUrl = "http://localhost:8080/api/v1/auth";
  }

  signin(signinRequest: SigninRequest): Observable<SigninResponse> {
    return this.httpClient.post<SigninResponse>(`${this.baseUrl}/signin`, signinRequest);
  }

}

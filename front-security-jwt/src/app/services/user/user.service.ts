import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/classes/user/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl: string;

  constructor(private httpClient: HttpClient) {
    this.baseUrl = "http://localhost:8080/api/v1/auth";
  }

  getUserInformationFromCookie(): Observable<User> {
    return this.httpClient.get<User>(`${this.baseUrl}/userInfo`);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url: string = "http://localhost:8080/Project1/login"

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Promise<AuthToken> {
    let body = new HttpParams()
      .set("email", email)
      .set("password", password);
    
    return this.http.post<AuthToken>(
        this.url,
        body.toString(),
        {
          headers: new HttpHeaders()
          .set("Content-Type", "application/x-www-form-urlencoded")
          .set("Access-Control-Allow-Origin", "*")
        }
      ).toPromise<AuthToken>();
  }
}

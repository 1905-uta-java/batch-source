import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = 'https://jsonplaceholder.typicode.com/users';

  constructor(private http: HttpClient){ }

  getPosts(): Observable<User[]>{
      return this.http.get<User[]>(this.url);
  }
}

import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) {
  }

  getLogin(loginRequest) {
    console.log(loginRequest);
    return this.httpClient.post<any>('http://localhost:8080/api/public/login', {
      email: loginRequest.email,
      password: loginRequest.password
    });

  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('email');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('email');
  }
}

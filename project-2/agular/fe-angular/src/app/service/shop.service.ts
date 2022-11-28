import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {TokenService} from "./token.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ShopService {
  tokenRequest: string;
  httpOption: any;

  constructor(private httpClient: HttpClient, private tokenService: TokenService) {
    this.tokenRequest = this.tokenService.getToken();
    this.httpOption = {
      headers: new HttpHeaders({
        'Content_Type': 'application/json',
        Authorization: 'Bearer ' + this.tokenRequest
      })
    };
  }

  getShop(title: string, author: string, page: number): Observable<any> {
    return this.httpClient.get('http://localhost:8080/api/public/shop?title=' + title + '&author=' + author + '&page=' + page);
  }

  getDetailBook(id: number): Observable<any> {
    return this.httpClient.get('http://localhost:8080/api/user/book/' + id, this.httpOption);
  }
}

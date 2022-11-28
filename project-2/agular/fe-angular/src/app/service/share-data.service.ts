import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ShareDataService {

  private isLogin = new BehaviorSubject(false);

  currentLoginStatus = this.isLogin.asObservable();


  constructor() {
  }

  changeLoginStatus(status: boolean){
    this.isLogin.next(status)
  }

}

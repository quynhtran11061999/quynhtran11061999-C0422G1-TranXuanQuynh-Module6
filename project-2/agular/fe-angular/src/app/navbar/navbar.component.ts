import { Component, OnInit } from '@angular/core';
import {TokenService} from "../service/token.service";
import {Router} from "@angular/router";
import {ShareDataService} from "../service/share-data.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  check = false;
  avatar: string;
  isLogin: boolean;

  // @ts-ignore
  constructor(
    private tokenService: TokenService, private router: Router,
    private shareData: ShareDataService) {
    if (tokenService.getToken()!= undefined){
      shareData.changeLoginStatus(true)
    }
    shareData.currentLoginStatus.subscribe(status => {
      this.isLogin = status
    })

  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.check = true;
      this.avatar = this.tokenService.getAvatar();
    }
  }

  getLogout() {
    this.shareData.changeLoginStatus(false)
    this.tokenService.getLogout();
  }

}

import { Component, OnInit } from '@angular/core';
import {LoginRequest} from "../model/login-request";
import {LoginService} from "../service/login.service";
import { Router } from '@angular/router';
import {TokenService} from "../service/token.service";
import {ToastrService} from "ngx-toastr";
import {ShareDataService} from "../service/share-data.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  token: string = '';

  account: LoginRequest = new class implements LoginRequest {
    email: string;
    password: string;
  };

  constructor(private loginService: LoginService,
              private router: Router,
              private tokenStorageService: TokenService,
              private toastr: ToastrService,
              private shareData: ShareDataService) { }

  ngOnInit(): void {
  }

  userLogin() {
    this.loginService.getLogin(this.account).subscribe(n => {
      if (n.token != undefined) {
        this.tokenStorageService.setToken(n.token);
        this.tokenStorageService.setName(n.username);
        this.tokenStorageService.setRole(n.roles);
        this.tokenStorageService.setAvatar(n.avatar);
          this.toastr.success('Đăng nhập thành công!', 'Thông báo!');
          this.shareData.changeLoginStatus(true);
      }
    }, error => {
      this.toastr.error('Sai tài khoản hoặc mật khẩu!', 'Đăng nhập thất bại!');
    }, () => {
      this.router.navigateByUrl('/');
    });
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }
}
